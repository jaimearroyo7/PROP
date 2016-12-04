package dominio;
import java.io.IOException;
import java.util.*;


/**
 * Created by mhitz on 27/10/16.
 */
public class
ConsultaDocumentosParecidos {
    private ArrayList<Documento> documentos;
    private Diccionario diccionario;

    public enum TFIDF_MODE {
        LOG, BOOLEAN
    }

        //dado un documento d, el diccionario de palabras y la lista entera de documentos, consulta todos los
        // documentos y devuelve los n documentos mas parecidos a d utilizando el modelo de calculo de espacio
        // vectorial
    private List<Documento> obtenerDocumentosParecidos(SparseArray<PalabraPeso> d1, int n, TFIDF_MODE mode) {

        ArrayList<Pair<Documento, Double>> cosinesDoc = new ArrayList<>();

        for (Documento d2: documentos) {
            cosinesDoc.add(new Pair<>(d2, cosineSimilarity(d1, getArrayPesosDe(d2, mode), mode)));
        }

        Collections.sort(cosinesDoc, new Comparator<Pair<Documento, Double>>() {
            @Override
            public int compare(Pair<Documento, Double> o1, Pair<Documento, Double> o2) {
                if (o1.second() < o2.second()) return 1;
                if (o1.second() > o2.second()) return -1;
                else return 0;
            }
        });

        ArrayList<Documento> resultado = new ArrayList<>(n);
        int m = 0;

        for (Pair<Documento,Double> pairDoc: cosinesDoc) {
                resultado.add(pairDoc.first());
                if (++m == n) break;
        }
         return resultado;
    }

    public List<Documento> consultaDocumentosParecidos(Documento d1, int n, Diccionario diccionario,
                                                        ArrayList<Documento> documentos, TFIDF_MODE mode) {
        this.diccionario = diccionario;
        this.documentos = documentos;
        List<Documento> resultado = obtenerDocumentosParecidos(getArrayPesosDe(d1, mode), n, mode);
        if (resultado.contains(d1)) resultado.remove(d1);
        return resultado;
    }

    public List<Documento> consultaDocumentosParecidosAQuery(String query, int n, Diccionario diccionario,
                                                       ArrayList<Documento> documentos, TFIDF_MODE mode) {
        this.diccionario = diccionario;
        this.documentos = documentos;
        try {
            Documento queryDoc = new Documento("","","", query);
            return obtenerDocumentosParecidos(getArrayPesosDe(queryDoc, mode), n, mode);
        } catch (IOException exception) {
            System.err.println("No se ha podido leer el fichero");
        }
        return null;
    }


        //devuelve el valor tfidf de una palabra
    private double tfidf(String palabra, Documento documento, TFIDF_MODE mode) {
        return tf(palabra, documento, mode)*idf(palabra, documentos);
    }
        //devuelve el valor tf de una palabra (el valor se puede calcular utilizando la version logaritmica de tf
        //o la version booleana)
    private double tf(String palabra, Documento documento, TFIDF_MODE mode) {
        if (mode == TFIDF_MODE.LOG) {
            int freq = 0;
            int freqMax = 0;
            for (Pair<String, Integer> aparicion : documento.getPalabras()) {
                if (aparicion.first().equals(palabra)) freq = aparicion.second();
                freqMax = Math.max(freqMax, aparicion.second());
            }
            return (double) freq / freqMax; //COMPROVAR QUE HACE DIVISION DOUBLE Y NO ENTERA
        }
        else if (mode == TFIDF_MODE.BOOLEAN){
            if (diccionario.getDocumentosConPalabra(palabra).contains(documento)) return 1;
            else return 0;
        }
        else return 0;
    }
        //devuelve el valor idf de una palabra
    private double idf(String palabra, List<Documento> documentos) {
        return Math.log((double)documentos.size()/diccionario.numeroDeDocumentosCon(palabra));
    }

    
        //devuelve el array de las palabras de un documento con sus pesos calculados a partir de tfidf
    private SparseArray<PalabraPeso> getArrayPesosDe(Documento documento, TFIDF_MODE mode) {
        SparseArray<PalabraPeso> arrayPesos = new SparseArray<>(diccionario.getNumeroDePalabras());
        ArrayList<Pair<String, Integer>> palabras = documento.getPalabras();
        for (Pair<String, Integer> palabra: palabras) {
            PalabraPeso palabraPeso = new PalabraPeso(palabra.first(), tfidf(palabra.first(), documento, mode));
            arrayPesos.put(diccionario.indicePalabra(palabra.first()), palabraPeso);
        }
        return arrayPesos;
    }

        // calcula la similitud de dos documentos a partir de su array de pesos donde se determina su semejanza a partir
        // de un coseno obtenido por un metodo de calculo de espacio vectorial
    private double cosineSimilarity(SparseArray<PalabraPeso> tf1, SparseArray<PalabraPeso> tf2, TFIDF_MODE mode) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < tf1.size(); i++) {
            if (tf1.get(i)!=null && tf2.get(i)!=null) {
                dotProduct += tf1.get(i).getPeso() * tf2.get(i).getPeso();
                normA += Math.pow(tf1.get(i).getPeso(), 2);
                normB += Math.pow(tf2.get(i).getPeso(), 2);
            }
        }
        if(normA==0||normB==0) return 0;
        else return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
