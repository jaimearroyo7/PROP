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
	public void separarPalabras() {
		String s = new String();
		for (int i=0; i<f.length(); ++i) {
			//si no son separadors...
			if ((this.f.charAt(i) >= 65 && this.f.charAt(i) <= 90) || (this.f.charAt(i) >= 97 && this.f.charAt(i) <= 122) || 
					(this.f.charAt(i) == 129) || (this.f.charAt(i) == 130) || 
					(this.f.charAt(i) == 144) || (this.f.charAt(i) == 181) || 
					(this.f.charAt(i) == 214) || (this.f.charAt(i) == 224) || 
					(this.f.charAt(i) == 233) || (this.f.charAt(i) == 'á') ||
					(this.f.charAt(i) == 'Á') || (this.f.charAt(i) == 'é') ||
					(this.f.charAt(i) == 'É') || (this.f.charAt(i) == 'í') ||
					(this.f.charAt(i) == 'Í') || (this.f.charAt(i) == 'ó') ||
					(this.f.charAt(i) == 'Ó') || (this.f.charAt(i) == 'ú') ||
					(this.f.charAt(i) == 'Ú') || (this.f.charAt(i) == 'ñ') ||
					(this.f.charAt(i) == 'Ñ')) {
				
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
	public ArrayList<Palabra> getListaPalabras() {
		return frase;
	}
}