package dominio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by mhitz on 3/11/16. feat rvillalba :)
 */

public class Diccionario {
    private static class ContenidoDiccionario {
        private int indice;
        private int freqGlobal;
        private LinkedHashSet<Documento> documentos;

        public ContenidoDiccionario() {
            this.freqGlobal = 0;
            documentos = new LinkedHashSet<>();
        }

        public int getIndice() {
            return indice;
        }

        public void setIndice(int indice) {
            this.indice = indice;
        }

        public int getFreqGlobal() {
            return freqGlobal;
        }

        public void setFreqGlobal(int freqGlobal) {
            this.freqGlobal = freqGlobal;
        }

        public LinkedHashSet<Documento> getDocumentos() {
            return documentos;
        }

        public void setDocumentos(LinkedHashSet<Documento> documentos) {
            this.documentos = documentos;
        }

        public void incrementarFrecuencia(int n) {
            freqGlobal += n;
        }

        public void decrementarFrecuencia(int n) {
            freqGlobal -= n;
        }
    }

    private ArrayList<String> arrayPalabras;
    private TreeMap<String, ContenidoDiccionario> diccionario;

	//inicializa diccionario 
    public Diccionario() {
        arrayPalabras = new ArrayList<>();
        diccionario = new TreeMap<>();
    }

	//añade palabras al array palabras y crea entradas en diccionario con todas las palabras del documento.  
	//si una palabra ya existe en el diccionario, unicamente incrementa la frecuencia de dicha palabra y añade documento al array documentos.
    public void addTextoDocumento(Documento documento) {
        ArrayList<Pair<String, Integer>> palabras = documento.getPalabras();
        for (Pair<String, Integer> palabra: palabras) {
            if (!diccionario.containsKey(palabra.first())) {
                ContenidoDiccionario contenido = new ContenidoDiccionario();
                contenido.setIndice(arrayPalabras.size());
                arrayPalabras.add(palabra.first());
                contenido.setFreqGlobal(palabra.second());
                LinkedHashSet<Documento> arrayDocumentos = new LinkedHashSet<>();
                arrayDocumentos.add(documento);
                contenido.setDocumentos(arrayDocumentos);
                diccionario.put(palabra.first(), contenido);
            }
            else {
                diccionario.get(palabra.first()).getDocumentos().add(documento);
                diccionario.get(palabra.first()).incrementarFrecuencia(palabra.second());
            }
        }
    }

	//"borra" las palabras de un documento del diccionario: decrementa la frecuencia global de la palabra y borra docuemnto del array documentos.
    public void deleteTextoDocumento(Documento documento) {
        ArrayList<Pair<String, Integer>> palabras = documento.getPalabras();
        for (Pair<String, Integer> palabra: palabras) {
            if (diccionario.containsKey(palabra.first())) {
                diccionario.get(palabra.first()).decrementarFrecuencia(palabra.second());
                diccionario.get(palabra.first()).getDocumentos().remove(documento);
            }
        }
    }

	//devuelve el numero de documentos que contienen la palabra que se le pasa
    public int numeroDeDocumentosCon(String palabra) {
        if (diccionario.get(palabra) == null) return 0;
    	return diccionario.get(palabra).getDocumentos().size();
    }

	//devuelve el indice de la palabra que se le pasa
    public int indicePalabra(String palabra) {
	return diccionario.get(palabra).getIndice();
    }


}
