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
	private void separarPalabras() {
		String f = this.f;
		f = f.toLowerCase();
		String s = new String();
		for (int i=0; i<f.length(); ++i) {
			//Afegim totes les lletres seguides que ens trobem a la nova paraula
			if ((f.charAt(i) >= 65 && this.f.charAt(i) <= 90) || (this.f.charAt(i) >= 97 && this.f.charAt(i) <= 122) || 
					(f.charAt(i) == 129) || (f.charAt(i) == 130) || 
					(f.charAt(i) == 144) || (f.charAt(i) == 181) || 
					(f.charAt(i) == 214) || (f.charAt(i) == 224) || 
					(f.charAt(i) == 233) || (f.charAt(i) == 160) || //a cerrada
					(f.charAt(i) == 181) || (f.charAt(i) == 233) || // A cerrada, e cerrada
					(f.charAt(i) == 201) || (f.charAt(i) == 237) || // E cerrada, i cerrada
					(f.charAt(i) == 205) || (f.charAt(i) == 243) || // I cerrada, o cerrada
					(f.charAt(i) == 211) || (f.charAt(i) == 250) || // O cerrada, u cerrada
					(f.charAt(i) == 218) || (f.charAt(i) == 241) || // U cerrada, enye minuscula
					(f.charAt(i) == 209)) { // enye mayuscula 
				if (i == f.length()-1) {
					s = s + f.charAt(i);
					Palabra p = new Palabra(s);
					frase.add(p);
				}
				s = s + f.charAt(i);
			}
			//Separadors frequents de paraules
			else if ((f.charAt(i) == ' ' || f.charAt(i) == '?' || f.charAt(i) == '!' || f.charAt(i) == '.') && !s.equals("")) {
				Palabra p = new Palabra(s);
				frase.add(p);
				s = "";
			}
			//Tots els separadors possibles per espanyol
			else if (f.charAt(i) == 32 || f.charAt(i) == 33 || f.charAt(i) == 35 || f.charAt(i) == 36 || f.charAt(i) == 37
					|| f.charAt(i) == 38 || f.charAt(i) == 34 || f.charAt(i) == 42 || f.charAt(i) == 64 || f.charAt(i) == 35
					|| f.charAt(i) == 36 || f.charAt(i) == 37 || f.charAt(i) == 38 || f.charAt(i) == 39 || f.charAt(i) == 40
					|| f.charAt(i) == 41 || f.charAt(i) == 43 || f.charAt(i) == 44 || f.charAt(i) == 45 || f.charAt(i) == 46
					|| f.charAt(i) == 47 || f.charAt(i) == 58 || f.charAt(i) == 59 || f.charAt(i) == 60 || f.charAt(i) == 61
					|| f.charAt(i) == 62 || f.charAt(i) == 63 || f.charAt(i) == 92 || f.charAt(i) == 93 || f.charAt(i) == 94
					|| f.charAt(i) == 95 || f.charAt(i) == 123 || f.charAt(i) == 124 || f.charAt(i) == 125 || f.charAt(i) == 126) {
				Palabra p = new Palabra(s);
				frase.add(p);
				s = "";
			}
			for (int j=0; j<frase.size(); ++j) {
				if (frase.get(j).getPalabra().equals("")) {
					frase.remove(j);
				}
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
	public ArrayList<Palabra> getListaPalabras() {
		return frase;
	}
}