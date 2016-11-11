package dominio;
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

    public List<Documento> consultaDocumentosParecidos(Documento d1, int n, Diccionario diccionario,
                                                       ArrayList<Documento> documentos, TFIDF_MODE mode) {
        this.diccionario = diccionario;
        this.documentos = documentos;
        TreeSet<Pair<Documento, Double>> cosinesDoc = new TreeSet<>(new Comparator<Pair<Documento, Double>>() {
            @Override
            public int compare(Pair<Documento, Double> o1, Pair<Documento, Double> o2) {
                if (o1.second() < o2.second()) return -1;
                if (o1.second() > o2.second()) return 1;
                else return 0;
            }
        });

        for (Documento d2: documentos) {
            cosinesDoc.add(new Pair<>(d2, cosineSimilarity(d1, d2, mode)));
        }
        ArrayList<Documento> resultado = new ArrayList<>(n);
        int m = 0;
        for (Pair<Documento,Double> pairDoc: cosinesDoc) {
            if (pairDoc.first()!=d1) {
                resultado.add(pairDoc.first());
                if (++m == n) break;
            }
        }
         return  resultado;
    }

    private double tfidf(String palabra, Documento documento, TFIDF_MODE mode) {
        return tf(palabra, documento, mode)*idf(palabra, documentos);
    }

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

    private double idf(String palabra, List<Documento> documentos) {
        return Math.log((double)documentos.size()/diccionario.numeroDeDocumentosCon(palabra)); //COMPROVAR QUE HACE DIVISION DOUBLE Y NO INT
    }


    private SparseArray<PalabraPeso> getArrayPesosDe(Documento documento, TFIDF_MODE mode) {
        SparseArray<PalabraPeso> arrayPesos = new SparseArray<>(diccionario.getNumeroDePalabras());
        ArrayList<Pair<String, Integer>> palabras = documento.getPalabras();
        for (Pair<String, Integer> palabra: palabras) {
            PalabraPeso palabraPeso = new PalabraPeso(palabra.first(), tfidf(palabra.first(), documento, mode));
            arrayPesos.put(diccionario.indicePalabra(palabra.first()), palabraPeso);
        }
        return arrayPesos;
    }

    private double cosineSimilarity(Documento d1, Documento d2, TFIDF_MODE mode) {
        SparseArray<PalabraPeso> tf1 = getArrayPesosDe(d1, mode);
        SparseArray<PalabraPeso> tf2 = getArrayPesosDe(d2, mode);
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
