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
			//si no son separadors...
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
			else if ((f.charAt(i) == ' ' || f.charAt(i) == '?' || f.charAt(i) == '!' || f.charAt(i) == '.') && !s.equals("")) {
				Palabra p = new Palabra(s);
				frase.add(p);
				s = "";
			}
			else if (f.charAt(i) == ' ' || f.charAt(i) == '?' || f.charAt(i) == '!' || f.charAt(i) == '.' || f.charAt(i) == ':'
					|| f.charAt(i) == ',' || f.charAt(i) == '"' || f.charAt(i) == '*' || f.charAt(i) == '@' || f.charAt(i) == '#'
					|| f.charAt(i) == '(' || f.charAt(i) == ')' || f.charAt(i) == '&' || f.charAt(i) == '%' || f.charAt(i) == '$'
					|| f.charAt(i) == '=' || f.charAt(i) == '-' || f.charAt(i) == '_' || f.charAt(i) == '/' || f.charAt(i) == '+'
					|| f.charAt(i) == '€' || f.charAt(i) == '>' || f.charAt(i) == '<' || f.charAt(i) == '{' || f.charAt(i) == '}'
					|| f.charAt(i) == '[' || f.charAt(i) == ']' || f.charAt(i) == 'º' || f.charAt(i) == 'ª' || f.charAt(i) == '~') {
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