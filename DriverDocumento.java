//package dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverDocumento {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Documento d1 = new Documento();
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese titulo:");
		d1.setTitulo(sc.nextLine());
		System.out.println("Ingrese autor:");
		d1.setAutor(sc.nextLine());
		System.out.println("Ingrese categoria:");
		d1.setCategoria(sc.nextLine());
		System.out.println("Ingrese texto:" + "\n");
		Texto texto = new Texto(sc.nextLine());
		d1.setTexto(texto);
		
		System.out.println("El documento tiene los siguientes campos: ");
		System.out.println("Titulo: " + d1.getTitulo());
		System.out.println("Autor: " + d1.getAutor());
		System.out.println("Categoria: " + d1.getCategoria());
		System.out.println("Texto: " + d1.getTexto().getTexto() + "\n");
		
		System.out.println("Fecha de ultima modificacion: " + d1.getFecha().getDay() + "/" + d1.getFecha().getMonth() + "/" + d1.getFecha().getYear()+ "\n");
		
		System.out.println("El documento tiene las siguientes palabras (Palabra, Frecuencia): ");
		
		ArrayList<Pair<String, Integer>> lista = d1.getPalabras();
		for(int i = 0; i < lista.size(); ++i){
			String result = (lista.get(i)).toString();
			System.out.println(result);
		}
		
		
	}

}