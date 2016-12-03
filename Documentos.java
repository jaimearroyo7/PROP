package dominio;
import java.io.*;
import java.text.ParseException;
import java.util.*;
// Representa un conjunto de Documentos

public class Documentos {
	
	//atributos
	
	private Documento d; 
	private ArrayList<Documento> docs;
	private Map<String, ArrayList<Documento> > autortitulos;
	private Map<String, ArrayList<Documento> > mapfecha;
	private Diccionario diccionario;
	private ConsultaDocumentosParecidos cd;
	private HistoricoDocumentos historial;
	
	//constructora
	
	public Documentos() { //constructora por defecto
		docs = new ArrayList<Documento>();
		mapfecha = new HashMap<String, ArrayList<Documento> >();
		autortitulos = new HashMap<String, ArrayList<Documento> >();
		diccionario = new Diccionario();
		d = new Documento();
		cd = new ConsultaDocumentosParecidos();
		historial = new HistoricoDocumentos();
	}
	
	public Diccionario getDiccionario() {
		return diccionario;
	}
	
	//modificadoras
	
	public ArrayList<Documento> getDocs(){ return docs;}
	public HistoricoDocumentos getHistorial(){ return historial;}
	
	public int addDoc(Documento d) throws ParseException, IOException { // anade el 'Documento' dentro del array docs
		
		for(int i = 0; i < docs.size(); ++i){
			if(docs.get(i).getAutor().equals(d.getAutor()) && docs.get(i).getTitulo().equals(d.getTitulo())){
				System.out.println("igualeeees");
				return -1;
			}	
		}
		if(d.getAutor() != null && d.getTitulo() != null && d.getTexto() != null) {
			docs.add(d);
			setMapFechaDoc(d);
			setMapAutorTitulos(d);
			diccionario.addTextoDocumento(d);
			historial.setHistorial(docs);
		}
		return 0;
	}
	
	public int borrardoc(String titulo, String autor) { // borra el 'Documento' dentro del array docs
		
		int i = 0;
		while (i < docs.size()) {
			if(docs.get(i).getAutor().equals(autor) && docs.get(i).getTitulo().equals(titulo)){
				d = docs.get(i);
				diccionario.deleteTextoDocumento(d);
				borrarMapFechaDoc(d);
				borrarMapAutorTitulos(d);
				docs.remove(i);
				return 1;
			}
			++i;
		}
		historial.setHistorial(docs);
		return -1;
		
	}
	
	
	public void borrarMapFechaDoc(Documento d) { // actuliza el map mapfecha a la hora de borrar 'Documento'
		String s = d.getFechatoString();
		ArrayList<Documento> l = mapfecha.get(s);
		if(l != null){
			for(int i = 0; i < l.size(); ++i){
				if(l.get(i).getAutor().equals(d.getAutor()) && l.get(i).getTitulo().equals(d.getTitulo())){
					l.remove(i);
				}
			}
		}
	}
	public void borrarMapAutorTitulos(Documento d) { //actuliza el map autortitulos a la hora de borrar 'Documento'
		String s = d.getAutor();
		ArrayList<Documento> l = autortitulos.get(s);
		if(l != null) {
			for(int i = 0; i < l.size(); ++i){
				if(l.get(i).getAutor().equals(d.getAutor()) && l.get(i).getTitulo().equals(d.getTitulo())){
					l.remove(i);
				}
			}
		}
	}
		
	public int modificardoc(String titulo, String autor, String campo, String value) throws IOException, ParseException {
		// modifca uno de los campos disponibles de un 'Documento'
		Documento nuevo = new Documento();
		boolean trobat = false;
		for(int i = 0; i < docs.size(); ++i){
			if(docs.get(i).getAutor().equals(autor) && docs.get(i).getTitulo().equals(titulo)){
				nuevo = docs.get(i);
				i = docs.size(); 
				trobat = true;
			}
		}
		if (trobat) {
			
				if(campo.equals("autor")){
					nuevo.setAutor(value);
				}
				else if(campo.equals("titulo")){
					nuevo.setTitulo(value);
				}
				else if(campo.equals("categoria")){
					nuevo.setCategoria(value);
				}
				else if(campo.equals("texto")){
					Texto actualizado = new Texto(value);
					nuevo.setTexto(actualizado);
				}
				if(borrardoc(titulo,autor) == 1) {
					addDoc(nuevo);
					return 1;
				}
				else return -2;	
				
		}
		return -1; 
		
	}
	
	public void setMapFechaDoc(Documento d) { // anade el 'Documento' al map mapfecha
		
		String s = d.getFechatoString();
		if(mapfecha.get(s) == null) { 
			ArrayList<Documento> l = new ArrayList<Documento>();
			l.add(d);
			mapfecha.put(s, l); 
		}
		else {
			ArrayList<Documento> l = mapfecha.get(s);
			l.add(d);
			mapfecha.put(s,l );
		}
	}
	
	public void setMapAutorTitulos(Documento d) { // anade el 'Documento' al map autortitulos
		if(autortitulos.containsKey(d.getAutor()) == false) {
			ArrayList<Documento> l = new ArrayList<Documento>();
			l.add(d);
			autortitulos.put(d.getAutor(), l);  
		}
		else {
			ArrayList<Documento> l = autortitulos.get(d.getAutor());
			l.add(d);
			autortitulos.put(d.getAutor(), l);
		}
		
	}
	
	//consultoras
	
	public Texto consultarTextoDadoTituloAutor(String titulo, String autor) { // Devuelve el contenido de un 'Documento' con 'titulo' y 'autor'
		
		Texto t = new Texto();
		for(int i = 0; i < docs.size(); ++i){
			if(docs.get(i).getAutor().equals(autor) && docs.get(i).getTitulo().equals(titulo)){
				t = docs.get(i).getTexto();
				return t;
			}
		}
		return t;
	}
	
	public ArrayList<String> consultarTitulosAutor(String autor) { // devuelve los titulos de los 'Documentos' del parametro explicito('autor')
		String actual;
	    Iterator<String> autores = autortitulos.keySet().iterator();
	    ArrayList<String> p = new ArrayList<String>();
	    while(autores.hasNext()){
	        actual = autores.next();
	        if(actual.equals(autor)){
	        ArrayList<Documento> l = autortitulos.get(autor);
	        for(int y = 0; y < l.size();++y) {
	        	p.add(l.get(y).getTitulo());
	        }
	        break;
	        }
	    }
		return p;   
	}
	
	public  ArrayList<String> consultarAutoresPrefijo(String prefijo) { // devuelve aquellos autores que empiezen o sean el parametro implicito('prefijo')
		
		Set<String> autores = autortitulos.keySet();
		Iterator<String> it = autores.iterator();
		ArrayList<String> p = new ArrayList<String>();
		String actual;
		int mida = prefijo.length();
		while(it.hasNext()){
			actual = it.next(); 
			if(mida == 0){
				p.add(actual);
			}
			else{
				if(actual.length() >= mida){
					if(prefijo.equals(actual.substring(0, mida))){
						ArrayList<Documento> l = autortitulos.get(actual);
						if(!l.isEmpty()) p.add(actual);
					}
				}
			}
		}
		return p;
	}
	
	public int consultarDiccionario(String s) { // devuelve el numero de documentos en la que aparece una palabra 's'
		return diccionario.numeroDeDocumentosCon(s);
	}
	
	
	public ArrayList<String> consultarTitulos(String s) throws ParseException { // devuelve los titulos de 'Documentos' que aparecen en una fecha 's'
		    
		    ArrayList<String> p = new ArrayList<String>();
			ArrayList<Documento> l1 = mapfecha.get(s);
			if(l1 != null) {
				for(int y = 0; y < l1.size();++y) {
					p.add(l1.get(y).getTitulo());
				}  
			}
			return p;
	}
	public ArrayList<Pair<String,String>> consultardocumentosparecidos(String titulo, String autor, String k,
            ConsultaDocumentosParecidos.TFIDF_MODE mode) throws IOException {
		//devuelve el 'titulo' y 'autor' de cada uno de los k documentos semejantes al documento deseado con 'titulo' y 'autor'
		ArrayList<Pair<String,String>> lp = new ArrayList<Pair<String,String>>();
		
		for(int i = 0; i < docs.size(); ++i){
			
			if(docs.get(i).getAutor().equals(autor) && docs.get(i).getTitulo().equals(titulo)){
				
				int n = Integer.parseInt(k);
				List<Documento> l = cd.consultaDocumentosParecidos(docs.get(i), n, diccionario, docs, mode);
				if(l != null) {
					l = cd.consultaDocumentosParecidos(docs.get(i), n, diccionario,docs, mode);
					Iterator<Documento> iter = l.iterator(); 
					while (iter.hasNext()) {
						d = iter.next();
						Pair<String,String> p = new Pair<String,String>(d.getTitulo(),d.getAutor());
						lp.add(p);
					}
				}
			}
			
		}
		return lp;
	}
}