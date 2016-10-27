import java.util.ArrayList;

public class Documento {
	private String titulo;
	private String autor;
	private String categoria;
	private Texto texto;
	//private ArrayList<Pair<String, Integer>> palabras = new ArrayList<>();
	private ArrayList<Pair<String, Integer>> Palabras = new ArrayList<>();
	
	public Documento(){
		
	}
	
	
	
	public void setTitulo(String valortitulo){
		titulo = valortitulo;
	}
	
	public void setAutor(String valorautor){
		autor = valorautor;
	}
	
	public void setCategoria(String valorcategoria){
		categoria = valorcategoria;
	}
	
	public void setTexto(Texto valorTexto){
		texto = valorTexto;
		ArrayList<String> frases = texto.getListaFrases();
		for(int i = 0; i < frases.size(); ++i){
			ArrayList<String> listapalabras = frases.get(i).getListaPalabras();
			for(int j = 0; j < listapalabras.size(); ++j){
				Pair<String, Integer> pair;
				pair.setFirst(listapalabras.get(i));
				pair.setSecond(1);
				Palabras.add(pair);
			}
		}
	}
	
	public String getTitulo() { return titulo; }
	
	public String getAutor() { return autor; }
	
	public String getCategoria() { return categoria; }
	
	public Texto getTexto() { return texto; }
	
}
