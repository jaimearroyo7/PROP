

public class Palabra {
	// atributos
	private String pal;
	private int contador = 0;
	
	//constructores
	public Palabra() {};
	
	public Palabra(String palabra){
		pal=palabra;
	};
	
	//setPalabra
	public void setPalabra(String valorpalabra) {
		pal = valorpalabra;
	}
	public void sumcont() {
		++contador;
	}
	public int cont() {
		return contador;
	}
	//getPalabra
	public String getPalabra() {
		return pal;
	}
	//
}