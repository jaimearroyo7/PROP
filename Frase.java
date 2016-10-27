package Dominio;
import java.util.ArrayList;

public class Frase {
	//atributos
	private String f;
	private ArrayList<Palabra> frase = new ArrayList<Palabra>();
	
	//constructoras
	public Frase() {};
	
	public Frase(String frase) {
		f=frase;
		separarPalabras();
	}
	public void separarPalabras() {
		String s = new String();
		for (int i=0; i<f.length(); ++i) {
			//si no son separadors...
			if (f.charAt(i) >= 65 && f.charAt(i) <= 122) {
				s = s + f.charAt(i);
			}
			else if (f.charAt(i) == ' ' || f.charAt(i) == '?' || f.charAt(i) == '!' || f.charAt(i) == '.') {
				Palabra p = new Palabra(s);
				frase.add(p);
				s = "";
			}
		}
	}
	
	public int size() {
		return frase.size();
	}
	
	//get y set
	public Palabra getPalabra(int arg) {
		Palabra p = new Palabra();
		p = frase.get(arg);
		return p;
	}
	
	public String getFrase() {
		return f;
	}
	public void setPalabra(int arg, Palabra palabra) {
		frase.set(arg, palabra);
	}
}
