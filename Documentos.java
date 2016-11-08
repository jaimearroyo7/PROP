package dominio;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.Map.Entry;

public class Documentos {
	private File archivo; 
	private Documento d;
  	private FileReader fr;
    private BufferedReader br;
	private ArrayList<Documento> docs;
	private Map<String, ArrayList<Documento> > autortitulos;
	private Map<String, ArrayList<Documento> > mapfecha;
	private Diccionario diccionario = new Diccionario();
	
	//metodos
	public Documentos() {
		docs = new ArrayList<Documento>();
		archivo = null;
		fr = null;
		br = null;
		mapfecha = new HashMap<String, ArrayList<Documento> >();
		autortitulos = new HashMap<String, ArrayList<Documento> >();
	}
	
	public void addDoc(Documento d) throws ParseException, IOException {
		
		docs.add(d);
		setMapFechaDoc(d);
		setMapAutorTitulos(d);
		diccionario.addTextoDocumento(d);
		
	}
	
	public void borrardoc(String titulo, String autor) {
		
		Documento d;
		int i;
		for(i = 0; i < docs.size(); ++i){
			if(docs.get(i).getAutor().equals(autor) && docs.get(i).getTitulo().equals(titulo)){
				d = docs.get(i);
				diccionario.deleteTextoDocumento(d);
				borrarMapFechaDoc(d);
				borrarMapAutorTitulos(d);
				docs.remove(i);
			}
		}
		if(i == docs.size()) System.out.println("No existe el documento");
		
	}
	
	public void listadocs() {
		
		int i;
		for(i = 0; i < docs.size(); ++i) {
			System.out.println(docs.get(i).getTitulo());
		}
		if(i == 0) System.out.println("No hay documentos");
	}
	
	public void borrarMapFechaDoc(Documento d) {
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
	public void borrarMapAutorTitulos(Documento d) {
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
		
	public void modificardoc(String titulo, String autor, String campo, String value) throws IOException, ParseException {
		Documento nuevo = new Documento();
		boolean trobat = false;
		for(int i = 0; i < docs.size(); ++i){
			if(docs.get(i).getAutor().equals(autor) && docs.get(i).getTitulo().equals(titulo)){
				nuevo = docs.get(i);
				i = docs.size(); //return
				trobat = true;
			}
		}
		if (!trobat) {
			borrardoc(titulo,autor);
			
			if(campo.equals("autor")){
				nuevo.setAutor(value);
			}
			if(campo.equals("titulo")){
				nuevo.setTitulo(value);
			}
			if(campo.equals("categoria")){
				nuevo.setCategoria(value);
			}
			if(campo.equals("texto")){
				Texto actualizado = new Texto(value);
				nuevo.setTexto(actualizado);
			}
			else {
				System.out.println("El campo introducido no es válido");
				return;
			}
			
			addDoc(nuevo);
		}
		
	}
	
	public void setMapFechaDoc(Documento d) {
		
		String s = d.getFechatoString();
		if(mapfecha.get(s) == null) { 
			ArrayList<Documento> l = new ArrayList<Documento>();
			l.add(d);
			mapfecha.put(s, l);  // aña dimos para una unica fecha un documento
		}
		else {
			ArrayList<Documento> l = mapfecha.get(s);
			l.add(d);
			mapfecha.put(s,l );
		}
	}
	
	public void setMapAutorTitulos(Documento d) {
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
	
	public void consultarTextoDadoTituloAutor(String titulo, String autor) {
		
		for(int i = 0; i < docs.size(); ++i){
			if(docs.get(i).getAutor().equals(autor) && docs.get(i).getTitulo().equals(titulo)){
				System.out.println("Contenido:");
				System.out.println(docs.get(i).getTexto().getTexto());
				return;
			}
		}
	}
	
	public void consultarTitulosAutor(String autor) {
			String actual;
		    Iterator<String> autores = autortitulos.keySet().iterator();
		    boolean is_primer = true;
		    while(autores.hasNext()){
		        actual = autores.next();
		        if(actual.equals(autor)){
		        System.out.println(autor + ": " );
		        ArrayList<Documento> l = autortitulos.get(autor);
		        for(int y = 0; y < l.size();++y) {
		        	if(is_primer) {
		        		System.out.println("El autor tine los siguientes documento/s:");
		        		is_primer = false;
		        	}
		        	System.out.println(l.get(y).getTitulo());
		        }
		        break;
		        }
		    }   
		    if(is_primer) System.out.println("El autor no tiene documentos");
	}
	
	public void consultarAutoresPrefijo(String prefijo) {
		Set<String> autores = autortitulos.keySet();
		Iterator<String> it = autores.iterator();
		String actual;
		int mida = prefijo.length();
		while(it.hasNext()){
			actual = it.next();
			if(mida == 0){
				System.out.println(actual);
			}
			else{
				if(actual.length() >= mida){
					if(prefijo.equals(actual.substring(0, mida))){
						ArrayList<Documento> l = autortitulos.get(actual);
						if(!l.isEmpty()) System.out.println(actual);
					}
				}
			}
		}
	}
	
	public void consultarDiccionario(String s) {
		System.out.println("La palabra esta contenida en " + Integer.toString(diccionario.numeroDeDocumentosCon(s)) + " documentos");
		//System.out.println(numeroDeDocumentosCon(s));
	}
	public void consultarTitulos(String s) throws ParseException { //de aquellos documentos que esten dentro de una fecha
		
			ArrayList<Documento> l1 = mapfecha.get(s);
			if(l1 != null) {
				for(int y = 0; y < l1.size();++y) {
				   System.out.print(l1.get(y).getTitulo());
				   System.out.println(" - " + l1.get(y).getAutor());
				}  
			}
			else {
				System.out.println("No se ha encontrado ningun titulo para esta fecha");
			}
	}
	
}
