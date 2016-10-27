package Domini;
import java.util.ArrayList;
import java.util.Arrays;

public class Frase {
	//atributos
	private ArrayList<Palabra> frase;
	private String[] separador = {" ",".","?", "!", "...",";", ":", "¿","¡"};
	
	//constructoras
	public Frase() {};
	
	public Frase(String frase) {
		Palabra pal = new Palabra();
		int inici = 0, fi = 0;
		int contador = 0;
		for (int i=0; i<frase.length(); ++i) {
			if (Arrays.asList(separador).contains(frase.charAt(i))) {
				pal.setPalabra(frase.substring(inici, fi));
				this.frase.add(contador, pal);
				contador++;
				inici = fi+1;
			}
			else {
				fi++;
			}
		}
	}
	public Palabra getPalabra(int arg) {
		return frase.get(arg);
	}
	public void setPalabra(int arg, Palabra palabra) {
		frase.set(arg, palabra);
	}
}
