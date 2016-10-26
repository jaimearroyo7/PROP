package Domini;
import java.util.List;
import java.util.ArrayList;

public class Documentos {
	private ArrayList<Documento> docs;
	private ArrayList<String> autores; //??
	private map<String, vector<*Documento> > autorstitols; //map autors, titols de l'autor
	private map<Pair<String, String>, *Documento> contenidodoc; // map contenido documento dado su titulo y su autor
	private map<String, vector<*Documento> > mapfecha;
	
	//metodos
	public Documentos() {
		docs = new ArrayList<>();
		autores = new ArrayList<>();
		autorstitols = new map<>();
		contenidodoc = new map<>();
		mapfecha = new map<>();
	}
	
	public Documentos(ArrayList<Documento> docs, ArrayList<String> autores, ap<String, 
			vector<*Documento> > autorstitols, map<Pair<String, String>, *Documento> contenidodoc, map<String, vector<*Documento> > mapfecha) {
		this.docs = docs;
		this.autores = autores;
		this.autorstitols = autorstitols;
		this.contenidodoc = contenidodoc;
		this.mapfecha = mapfecha;
	}
	
	public void addDoc (Documento d) {
		docs.add(d);
		string autor = d.getAutor();
		
	}
	
	public ArrayList<String> GetTitolsAutor
}
