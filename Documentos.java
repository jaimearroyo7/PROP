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
	//private ArrayList<String> autores; //??
	private Map<String, ArrayList<Documento> > autortitulos; //map autors, titols de l'autor
	//private map<dominio.Pair<String, String>, *dominio.Documento> contenidodoc; // map contenido documento dado su titulo y su autor*/
	private Map<Fecha, ArrayList<Documento> > mapfecha;
	Diccionario diccionario = new Diccionario();
	
	//metodos
	public Documentos() {
		docs = new ArrayList<Documento>();
		archivo = null;
		fr = null;
		br = null;
		mapfecha = new HashMap<Fecha, ArrayList<Documento> >();
		autortitulos = new HashMap<String, ArrayList<Documento> >();
		
		/*autores = new ArrayList<>();
		contenidodoc = new map<>(); */
	}
	
	
	public void addDoc(Documento d) throws ParseException, IOException {
		
		
		docs.add(d);
		setMapFechaDoc(d);
		setMapAutorTitulos(d);
		diccionario.addTextoDocumento(d);
		
		
		/*nombreMap.put(K clave, V valor); // Añade un elemento al Map
		nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro o 'null' si la clave no existe
		nombreMap.clear(); // Borra todos los componentes del Map
		nombreMap.remove(K clave); // Borra el par clave/valor de la clave que se le pasa como parámetro
		nombreMap.containsKey(K clave); // Devuelve true si en el map hay una clave que coincide con K
		nombreMap.containsValue(V valor); // Devuelve true si en el map hay un Valor que coincide con V
		nombreMap.values(); // Devuelve una "Collection" con los valores del Map */

		
	}
	public void borrardoc(Documento d) {
		docs.remove(d);
		//actualizar MapFechaDoc
		//actualizar MapAutorTitulos (Borrar autor si se queda sin titulos
		diccionario.deleteTextoDocumento(d);
		
	}
	
	public void modificardoc(String titulo, String autor, String campo, String value) throws IOException, ParseException {
		Documento nuevo = new Documento();
		for(int i = 0; i < docs.size(); ++i){
			if(docs.get(i).getAutor().equals(autor) || docs.get(i).getTitulo().equals(titulo)){
				nuevo = docs.get(i);
				i = docs.size();
			}
		}
		
		borrardoc(nuevo);
		
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
			Texto actualizado = new Texto("value");
			nuevo.setTexto(actualizado);
		}
		
		addDoc(nuevo);
		
	}
	public void setMapFechaDoc(Documento d) {
		
		if(mapfecha.containsKey(d.getFecha()) == false) {
			ArrayList<Documento> l = new ArrayList<Documento>();
			l.add(d);
			mapfecha.put(d.getFecha(), l);  // añadimos para una unica fecha un documento
		}
		else {
			ArrayList<Documento> l = mapfecha.get(d.getFecha());
			l.add(d);
			mapfecha.put(d.getFecha(),l );
		}
	}
	
	public void setMapAutorTitulos(Documento d) {
		if(mapfecha.containsKey(d.getAutor()) == false) {
			ArrayList<Documento> l = new ArrayList<Documento>();
			l.add(d);
			autortitulos.put(d.getAutor(), l);  
		}
		else {
			ArrayList<Documento> l = autortitulos.get(d.getAutor());
			l.add(d);
			/*for(int y = 0; y < l.size();++y) {
	        	System.out.println(l.get(y).getTitulo());
	        }*/
			autortitulos.put(d.getAutor(), l);
		}
		
	}
	
	public void consultarTextoDadoTituloAutor(String titulo, String autor){
		
		for(int i = 0; i < docs.size(); ++i){
			if(docs.get(i).getAutor().equals(autor) || docs.get(i).getTitulo().equals(titulo)){
				System.out.println("Titulo: " + titulo);
				System.out.println("Autor: " + autor);
				System.out.println(docs.get(i).getTexto().getTexto());
				return;
			}
		}
	}
	
	
	public void consultarTitulosAutor(String autor) {
			String actual;
		    Iterator<String> autores = autortitulos.keySet().iterator();
		    System.out.println("Hay los siguientes productos:");
		    while(autores.hasNext()){
		        actual = autores.next();
		        if(actual.equals(autor)){
		        System.out.println(autor + ": " );
		        ArrayList<Documento> l = autortitulos.get(autor);
		        for(int y = 0; y < l.size();++y) {
		        	System.out.println(l.get(y).getTitulo());
		        }
		        break;
		        }
		    }        
	}
	
	public void consultarAutoresPrefijo(String prefijo){
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
						System.out.println(actual);
					}
				}
			}
		}
	}
	
	public void consultarDiccionario(){
		
	}
	
	
	
	
	
	
	
	
	
	
	    	
	public void consultarTitulo(int i) {

		System.out.print("Título: ");
		System.out.println(docs.get(i).getTitulo());
	}
	public void consultarAutor(int i) {
		System.out.print("Autor: ");
		System.out.println(docs.get(i).getAutor());
	}
	public void consultarCategoria(int i) {
		System.out.print("Categoria: ");
		System.out.println(docs.get(i).getCategoria());
	}
	public void consultarFecha(int i) {
		Fecha f = new Fecha();
		f = docs.get(i).getFecha();
		System.out.print("Fecha de creación: ");
		System.out.print(f.getDay()+"/");
		System.out.print(f.getMonth()+"/");
		System.out.println(f.getYear());		
	}
	
	public void consultarTexto(int i) {
		System.out.print("Texto: ");
		System.out.println(docs.get(i).getTexto().getTexto());
	}
	
	
	
	
	/*public void addDoc(String s) throws FileNotFoundException {
	
	archivo = new File (s);
    fr = new FileReader (archivo);
    br = new BufferedReader(fr);
    d = new dominio.Documento();
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

}
