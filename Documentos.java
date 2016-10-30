package Dominio;
import java.io.*;
import java.util.ArrayList;

public class Documentos {
	private File archivo; 
	private Documento d;
    private FileReader fr;
    private BufferedReader br;
	private ArrayList<Documento> docs;
	/*private ArrayList<String> autores; //??
	private map<String, vector<*Documento> > autorstitols; //map autors, titols de l'autor
	private map<Pair<String, String>, *Documento> contenidodoc; // map contenido documento dado su titulo y su autor
	private map<String, vector<*Documento> > mapfecha;*/
	
	//metodos
	public Documentos() {
		docs = new ArrayList<Documento>();
		archivo = null;
		fr = null;
		br = null;
		/*autores = new ArrayList<>();
		autorstitols = new map<>();
		contenidodoc = new map<>();
		mapfecha = new map<>();*/
	}
	
	/*public Documentos(ArrayList<Documento> docs, ArrayList<String> autores, ap<String, 
			vector<*Documento> > autorstitols, map<Pair<String, String>, *Documento> contenidodoc, map<String, vector<*Documento> > mapfecha) {
		this.docs = docs;
		this.autores = autores;
		this.autorstitols = autorstitols;
		this.contenidodoc = contenidodoc;
		this.mapfecha = mapfecha;
	}*/
	
	public void addDoc(String s) throws FileNotFoundException {
		
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
		    		
	        	 }
	    	}
	    	
	    }
	    catch(Exception e){
	         e.printStackTrace();
	    }
	    
	    finally {
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
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
		
	}
	public void consultarTitulo(int i) {
		System.out.println(docs.get(i).getTitulo());
	}
	public void consultarCategoria(int i) {

		System.out.println(docs.get(i).getCategoria());
	}
	
	//public ArrayList<String> GetTitolsAutor;
}