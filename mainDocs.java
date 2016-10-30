package Dominio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class mainDocs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Documentos d = new Documentos();
		d.addDoc("C:/Users/JMC/workspace/Gestor de documentos/src/Dominio/prueba1");*/
		File archivo = null; // para abrir archivo
	    FileReader fr = null; // para leer archivos
	    BufferedReader br = null;// lee texto de una entrada de caracteres
	    
	    try {
	         archivo = new File ("C:/Users/JMC/workspace/Gestor de documentos/src/Dominio/prueba1");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         String subStr2 = null;
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
	 }
   }

