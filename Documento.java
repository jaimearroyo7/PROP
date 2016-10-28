import java.util.ArrayList;

public class Documento {
	private String titulo;
	private String autor;
	private String categoria;
	private Texto texto;
	//private ArrayList<Pair<String, Integer>> palabras = new ArrayList<>();
	private ArrayList<Pair<String, Integer>> Palabras = new ArrayList<Pair<String, Integer>>();
	
	public Documento(){
		
	}
	
	public Documento(String valortitulo, String valorautor, String valorcategoria, String valorTexto){
		setTitulo(valortitulo);
		setAutor(valorautor);
		setCategoria(valorcategoria);
		Texto texto = new Texto(valorTexto);
		setTexto(texto);
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
		ArrayList<Frase> frases = texto.getListaFrases();
		for(int i = 0; i < frases.size(); ++i){
			ArrayList<Palabra> listapalabras = frases.get(i).getlistaPalabras();
			for(int j = 0; j < listapalabras.size(); ++j){
				Pair<String, Integer> pair = new Pair<>();
				pair.setFirst(listapalabras.get(j).getPalabra());
				pair.setSecond(1);
				Palabras.add(pair);
			}
		}
	}
	
	public ArrayList<Pair<String, Integer>> getfrecuencia(){ return Palabras; }
	
	public String getTitulo() { return titulo; }
	
	public String getAutor() { return autor; }
	
	public String getCategoria() { return categoria; }
	
	public Texto getTexto() { return texto; }
	
}
