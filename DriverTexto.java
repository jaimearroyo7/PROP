package PROP;

import java.util.Scanner;

public class DriverTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Constructor vacio
		Texto a = new Texto();
		String valortexto = new String();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Escribe el texto a: ");
	    valortexto = sc.nextLine();
	    a.setTexto(valortexto);
	    
	    System.out.println("El texto de a es: " + "\n" + a.getTexto());
	    
	    System.out.println("Las frases de a son:");
	    Frase f;
	    for(int i = 0; i < a.getListaFrases().size(); ++i){
	    	f = a.getListaFrases().get(i);
	    	System.out.println(f.getFrase());
	    }
	    
	    
	    System.out.println("Escribe el texto b: ");
	    valortexto = sc.nextLine();
	    Texto b = new Texto(valortexto);
	    
	    System.out.println("El texto de b es: " + "\n" + a.getTexto());
	    
	    System.out.println("Las frases de b son:");
	    for(int i = 0; i < b.getListaFrases().size(); ++i){
	    	f = b.getListaFrases().get(i);
	    	System.out.println(f.getFrase());
	    }
	}
}
