package Projecte;
import java.util.ArrayList;

public class Frase {
	private ArrayList<Palabra> frase;
	
	//constructoras
	public Frase() {
	}
	
	public Frase (ArrayList<Palabra> frase) {
		this.frase = frase;
	}
	
	//get y set
	public ArrayList<Palabra> GetFrase () {
		return frase;
	}
	public ArrayList<Palabra> SetFrase (ArrayList<Palabra> frase) {
		this.frase = frase;
	}
}
