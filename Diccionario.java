//package dominio;

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

    public Diccionario() {
        arrayPalabras = new ArrayList<>();
        diccionario = new TreeMap<>();
    }

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

    public void deleteTextoDocumento(Documento documento) {
        ArrayList<Pair<String, Integer>> palabras = documento.getPalabras();
        for (Pair<String, Integer> palabra: palabras) {
            if (diccionario.containsKey(palabra.first())) {
                diccionario.get(palabra.first()).decrementarFrecuencia(palabra.second());
                diccionario.get(palabra.first()).getDocumentos().remove(documento);
            }
        }
    }

    public int numeroDeDocumentosCon(String palabra) {
        if(diccionario.get(palabra) == null) return 0;
    	return diccionario.get(palabra).getDocumentos().size();
    }

    public int indicePalabra(String palabra) {
	return diccionario.get(palabra).getIndice();
    }


}
