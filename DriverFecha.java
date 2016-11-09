//package dominio;
import java.text.ParseException;

public class DriverFecha {
	
	public static void comparar(Fecha f, Fecha f2) {
		if(f2.greater(f)) System.out.println("La fecha2 es más reciente que la fecha1");
		else if(f.greater(f2)) System.out.println("La fecha1 es más reciente que la fecha2");
		else System.out.println("Mismas fechas");
	}
	public static void main(String[] args)throws ParseException {
		
		Fecha f = new Fecha();
		Fecha f2 = new Fecha();
		System.out.println("fecha1:" + f.getDay() + "/" + f.getMonth() + "/" + f.getYear());
		System.out.println("fecha2:" + f2.getDay() + "/" + f2.getMonth() + "/" + f2.getYear());
		comparar(f,f2);
		System.out.print("Fecha2 modificada: ");
		f2.setFechaManual(2,11,2016);
		System.out.println(f2.getDay() + "/" + f2.getMonth() + "/" + f2.getYear());
		comparar(f,f2);
		System.out.print("Fecha2 modificada: ");
		f2.setFechaManual(9,12,2016);
		System.out.println(f2.getDay() + "/" + f2.getMonth() + "/" + f2.getYear());
		comparar(f,f2);
		System.out.print("Fecha2 modificada: ");
		f2.setFechaManual(2,12,2016);
		System.out.println(f2.getDay() + "/" + f2.getMonth() + "/" + f2.getYear());
		comparar(f,f2);
		System.out.print("Fecha2 modificada: ");
		f2.setFechaManual(2,12,2014);
		System.out.println(f2.getDay() + "/" + f2.getMonth() + "/" + f2.getYear());
		comparar(f,f2);
	}
}
		
