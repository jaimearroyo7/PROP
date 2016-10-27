import java.util.ArrayList;

public class Documento {
	private String titulo;
	private String autor;
	private String categoria;
	private Texto texto;
	
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
	}
	
	public String getTitulo() { return titulo; }
	
	public String getAutor() { return autor; }
	
	public String getCategoria() { return categoria; }
	
	public Texto getTexto() { return texto; }
	
}
