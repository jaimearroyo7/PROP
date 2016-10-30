package Dominio;

public class Palabra {
	// atributos
	private String pal;
	private int freq = 0;
	
	//constructores
	public Palabra() {};
	
	public Palabra(String palabra) {
		pal=palabra;
		freq = 1;
	}
	
	//setPalabra
	public void setPalabra(String valorpalabra) {
		pal = valorpalabra;
	}
	
	public void sumfreq() {
		++freq;
	}
	public void resfreq() {
		--freq;
	}
	public int freq() {
		return freq;
	}
	public String getPalabra() {
		return pal;
	}
}
