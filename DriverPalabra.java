//package dominio;
import java.io.*;

public class DriverPalabra {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palabra p = new Palabra("hola");
		Palabra p2 = new Palabra();
		Palabra p3 = new Palabra();
		
		p2.setPalabra("adios");
		p2.sumfreq();
		p2.sumfreq();
		p2.sumfreq();
		p2.sumfreq();
		p2.resfreq(1);
		System.out.println("palabra1: " + p.getPalabra());
		System.out.println("frecuencia: " + p.freq());
		
		System.out.println("palabra2: " + p2.getPalabra());
		System.out.println("frecuencia: " + p2.freq());
		
		System.out.println("palabra3: " + p3.getPalabra());
		System.out.println("frecuencia: " + p3.freq());
		
		p3.sumfreq();
		System.out.println("palabra3: " + p3.getPalabra());
		System.out.println("frecuencia: " + p3.freq()); //no se puede augmentar la frecuencia de un palabra vacia
		
		p3.resfreq(2);
		System.out.println("palabra3: " + p3.getPalabra());
		System.out.println("frecuencia: " + p3.freq()); //no se puede restar la frecuencia de un palabra vacia
		
		p2.setPalabra("hola2");
		System.out.println("palabra2: " + p2.getPalabra());
		System.out.println("frecuencia: " + p2.freq());//se cambia de palabra y inicializamos la frecuencia a 1
	}
}
