package dominio;

// La clase Palabra representa la palabra y las veces que aparece en el texto

public class Palabra { 
	
	// atributos
	
	private String pal = ""; //representa la palabra
	private int freq = 0; // representa el numero de aparaciones de palabra
	
	//constructoras
	
	public Palabra() {}; // constructora por defecto
	
	public Palabra(String palabra){ // constructora por defecto con palabra
		pal=palabra;
		freq = 1;
	}
	
	//modificadoras
	
	public void setPalabra(String valorpalabra) { // modifica la palabra y inicializa con frecuencia 1;
		pal = valorpalabra;
		freq = 1;
	}
	
	public void sumfreq() { // augmenta la frecuencia en uno
		if(!pal.isEmpty()) ++freq;
	}
	
	public void resfreq(int i){ // resta la frecuencia de la palabra i veces
		freq -=i;
		if(freq <0) freq = 0;
	}
	
	//consultoras
	
	public int freq() { //devuelve la frecuencia de la palabra en forma de entero
		return freq;
	}
	
	public String getPalabra() { //devuelve la palabra en forma de String
		return pal;
	}
	
}
