package Dominio;
import java.text.ParseException;

public class mainfecha {
	public static void main(String[] args)throws ParseException {
		
		String s1 = "21/11/1995";
		Fecha d1 = new Fecha(s1);
		System.out.println("FECHA1: ");
		d1.imprimirfecha();
		
		String s2 = "21/11/2016";
		Fecha d2 = new Fecha(s2);
		System.out.println("FECHA2: ");
		d2.imprimirfecha();
		
		
		System.out.println("COMPARACION: ");
		int comp = d1.comparar(d2.getFecha());
		if(comp == 1) {
			System.out.println("AMBAS FECHAS IGUALES: ");
			d1.imprimirfecha();
			d2.imprimirfecha();
		}
		else if (comp == 2){ // devolvemos la fecha más antigua
			System.out.println("FECHA1 MÁS ANTIGUA QUE FECHA2: ");
			d1.imprimirfecha();
		}
		else {
			System.out.println("FECHA2 MÁS RECIENTE: ");
			d2.imprimirfecha();
		}
	}
}
		