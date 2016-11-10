package dominio;

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
	
	// separa el string en palabras y las guarda en un ArrayList de palabras
	public void separarPalabras() {
		f = f.toLowerCase();
		String s = new String();
		for (int i=0; i<f.length(); ++i) {
			//si no son separadors...
			if ((this.f.charAt(i) >= 65 && this.f.charAt(i) <= 90) || (this.f.charAt(i) >= 97 && this.f.charAt(i) <= 122) || 
					(this.f.charAt(i) == 129) || (this.f.charAt(i) == 130) || 
					(this.f.charAt(i) == 144) || (this.f.charAt(i) == 181) || 
					(this.f.charAt(i) == 214) || (this.f.charAt(i) == 224) || 
					(this.f.charAt(i) == 233) || (this.f.charAt(i) == 160) || //a cerrada
					(this.f.charAt(i) == 181) || (this.f.charAt(i) == 233) || // A cerrada, e cerrada
					(this.f.charAt(i) == 201) || (this.f.charAt(i) == 237) || // E cerrada, i cerrada
					(this.f.charAt(i) == 205) || (this.f.charAt(i) == 243) || // I cerrada, o cerrada
					(this.f.charAt(i) == 211) || (this.f.charAt(i) == 250) || // O cerrada, u cerrada
					(this.f.charAt(i) == 218) || (this.f.charAt(i) == 241) || // U cerrada, enye minuscula
					(this.f.charAt(i) == 209)) { // enye mayuscula 

				s = s + f.charAt(i);
			}
			else if (f.charAt(i) == ' ' || f.charAt(i) == '?' || f.charAt(i) == '!' || f.charAt(i) == '.') {
				Palabra p = new Palabra(s);
				frase.add(p);
				s = "";
			}
		}
	}
	
	//retorna la medida de una frase
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
	public ArrayList<Palabra> getListaPalabras() {
		return frase;
	}
}