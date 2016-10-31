package Dominio;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Documentos {
	
	private File archivo; 
	private Documento d;
    private FileReader fr;
    private BufferedReader br;
	private ArrayList<Documento> docs;
	/*private ArrayList<String> autores; //??
	private map<String, vector<*Documento> > autorstitols; //map autors, titols de l'autor
	private map<Pair<String, String>, *Documento> contenidodoc; // map contenido documento dado su titulo y su autor*/
	private Map<Fecha, ArrayList<Documento> > mapfecha;
	
	//metodos
	public Documentos() {
		docs = new ArrayList<Documento>();
		archivo = null;
		fr = null;
		br = null;
		mapfecha = new HashMap<Fecha, ArrayList<Documento> >();
		/*autores = new ArrayList<>();
		autorstitols = new map<>();
		contenidodoc = new map<>(); */
	}
	
	/*public Documentos(ArrayList<Documento> docs, ArrayList<String> autores, ap<String, 
			vector<*Documento> > autorstitols, map<Pair<String, String>, *Documento> contenidodoc, map<String, vector<*Documento> > mapfecha) {
		this.docs = docs;
		this.autores = autores;
		this.autorstitols = autorstitols;
		this.contenidodoc = contenidodoc;
		this.mapfecha = mapfecha;
	}*/
	
	public void addDocvers1() throws ParseException {
		d = new Documento();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el título: ");
		d.setTitulo(sc.nextLine());
		System.out.print("Ingrese el autor: ");
		d.setAutor(sc.nextLine());
		System.out.print("Ingrese la categoria: ");
		d.setCategoria(sc.nextLine());
		setMapFechaDoc(sc.nextLine(),d);
		System.out.print("Ingrese Texto: ");
		Texto t = new Texto();
		d.setTexto(t.setTexto(sc.nextLine()));
		
		/*nombreMap.put(K clave, V valor); // Añade un elemento al Map
		nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro o 'null' si la clave no existe
		nombreMap.clear(); // Borra todos los componentes del Map
		nombreMap.remove(K clave); // Borra el par clave/valor de la clave que se le pasa como parámetro
		nombreMap.containsKey(K clave); // Devuelve true si en el map hay una clave que coincide con K
		nombreMap.containsValue(V valor); // Devuelve true si en el map hay un Valor que coincide con V
		nombreMap.values(); // Devuelve una "Collection" con los valores del Map */

		docs.add(d);
	}
	public void setMapFechaDoc(String s, Documento d) throws ParseException {
		Fecha f = new Fecha();
		ArrayList<Documento> l = new ArrayList<Documento>();
		l.add(d);
		mapfecha.put(f, l);
		System.out.print("Fecha de creación: ");
		System.out.print(f.getDay()+"/");
		System.out.print(f.getMonth()+"/");
		System.out.println(f.getYear());
	}
	/*public void addDoc(String s) throws FileNotFoundException {
		
		archivo = new File (s);
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        d = new Documento();
	    try {
	    	String linea;
	    	String subStr = null;
	    	boolean title,categoria;
	    	title = categoria = false;
	    	while((linea=br.readLine())!=null) {	
	             int h = 0;
	             int t = 0;
	        	 for (int i = 0; i <linea.length(); ++i) {
	        		 if (!title) {
	        			 if(linea.substring(i,i+7).equals("<title>") != false) { //obtenemos titulo
	        				 t = i;
			    			 int pos=linea.indexOf("-");
				        	 subStr=linea.substring((t+1)+8,pos-1);
				        	 title = true;
			        	     //System.out.println(subStr);
	        			 }
		    		 }
	        			 
	        		 /*
	        		 else if(title & !categoria) {
	        			     
	        			    
	        			    //System.out.println(linea.substring(i,i+11));
		    				if(linea.substring(i,i+11).equals("=Categoría:")) {
		    					System.out.println(i);
		    					h = i;
		    				}
		    				if(linea.substring(i,i+4).equals("<")){
		    						int h2 = i;
		    						System.out.println(h2);
			    					subStr2=linea.substring((h+1)+11,h2-2);
			    					categoria = true;
			    					System.out.println(subStr2);
		    					}
			        			
			    			
		    		 }*/	
		    		
	        	/* }
	    	}
	    	
	    }
	    catch(Exception e){
	         e.printStackTrace();
	    }
	    
	    finally {
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         /*try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }
	         catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	    }
	    docs.add(d);
		//string autor = d.getAutor();
		
	}*/
	    	
	public void consultarTitulo(int i) {
		System.out.println(docs.get(i).getTitulo());
	}
	public void consultarAutor(int i) {
		System.out.println(docs.get(i).getAutor());
	}
	public void consultarCategoria(int i) {

		System.out.println(docs.get(i).getCategoria());
	}
	
	//public ArrayList<String> GetTitolsAutor;
}