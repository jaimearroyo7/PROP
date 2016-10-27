package Domini;

public class Palabra {
	// atributos
	private String pal;
	
	//constructores
	public Palabra() {};
	
	public Palabra(String palabra){
		pal=palabra;
	};
	
	//setPalabra
	public void setPalabra(String valorpalabra) {
		pal = valorpalabra;
	}
	//getPalabra
	public String getPalabra() {
		return pal;
	}
}
