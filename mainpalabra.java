package Dominio;
import java.io.*;

public class mainpalabra {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palabra p = new Palabra("hola");
		Palabra p2 = new Palabra();
		p2.setPalabra("adios");
		p2.sumfreq();
		p2.sumfreq();
		p2.sumfreq();
		p2.sumfreq();
		p2.resfreq(1);
		System.out.println(p.getPalabra());
		System.out.println(p.freq());
		System.out.println(p2.getPalabra());
		System.out.println(p2.freq());
		
		
		
		/*---------------------------------------------------------------------------------
		
		 prueba de escritura de las palabrasfuncionales importadas de  .txt
		
		---------------------------------------------------------------------------------*/
		/*
		File archivo = null; // para abrir archivo
	    FileReader fr = null; // para leer archivos
	    BufferedReader br = null; // lee texto de una entrada de caracteres
	    
	    try {
	         archivo = new File ("C:/Users/JMC/workspace/Gestor de documentos/src/Dominio/PalabrasFuncionales");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null) {	        	
	            System.out.println(linea);
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
	    }*/
	}
}
