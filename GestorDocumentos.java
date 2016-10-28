import java.util.*;

/**
 * Created by mhitz on 27/10/16.
 */
public class GestorDeDocumentos {
    private ArrayList<Document> documentos;

    public List<Document> consultaDocumentosParecidos(Document d1, int n) {
        TreeSet<Pair<Document, Double>> cosinesDoc = new TreeSet<>(new Comparator<Pair<Document, Double>>() {
            @Override
            public int compare(Pair<Document, Double> o1, Pair<Document, Double> o2) {
                if (o1.second < o2.second) return -1;
                if (o1.second > o2.second) return 1;
                else return 0;
            }
        });

        for (Document d2: documentos) {
            cosinesDoc.add(new Pair<>(d2, cosineSimilarity(d1, d2)));
        }
        ArrayList<Document> resultado = new ArrayList<>(n);
        int m = 0;
        for (Pair<Document,Double> pairDoc: cosinesDoc) {
            resultado.add(pairDoc.first);
            if (++m == n) break;
        }
         return  resultado;
    }

    private static double cosineSimilarity(Document d1, Document d2) {
        SparseArray<TermFrequency> tf1 = d1.getTermVector();
        SparseArray<TermFrequency> tf2 = d2.getTermVector();
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < tf1.size(); i++) {
            dotProduct += tf1.get(i).getFrequency() * tf2.get(i).getFrequency();
            normA += Math.pow(tf1.get(i).getFrequency(), 2);
            normB += Math.pow(tf2.get(i).getFrequency(), 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
