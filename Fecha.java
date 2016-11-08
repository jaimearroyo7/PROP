package dominio;
import java.util.*;

 // La clase Fecha representa una fecha dd.mm.yy.

public class Fecha {
	
	// atributos
	
	private Integer year; // año
	private Integer month; // mes
	private Integer day; // dia
	
	// constructoras
	
	public Fecha() { //constructora por defecto, asigna el dia, mes y año proporcionado por la clase interna de Calendar
		Calendar fecha = new GregorianCalendar();
		day = fecha.get(Calendar.DAY_OF_MONTH);
		month= fecha.get(Calendar.MONTH);
		++month;
		year = fecha.get(Calendar.YEAR);
	};
	
	// modificadoras
	
	public void setFecha(){ // modifica la fecha por la proporcionada por el sistema
		Calendar fecha = new GregorianCalendar();
		day = fecha.get(Calendar.DAY_OF_MONTH);
		month= fecha.get(Calendar.MONTH);
		++month;
		year = fecha.get(Calendar.YEAR);
	}
	
	public void setFechaManual(int valorday, int valormonth, int valoryear){ // modifica la fecha manualmente por los campos pasados por parámetro
		day = valorday;
		month = valormonth;
		year = valoryear;
	}
	
	//consultoras
	
	public Integer getDay() { // devuelve el 'dia' en forma de entero 
		return day;
	}
		
	public Integer getMonth() { // devuelve el 'mes' en forma de entero
		return month;
	}
		
	public Integer getYear() {// devuelve el 'año' en forma de entero
		return year;
	}
	
	public boolean greater(Fecha f2){ // devuelve 'true' si el parámetro ímplícito es más grande que el parámetro explícito
		if(!year.equals(f2.getYear())){
			if(year < f2.getYear()){
				return false;
			}
			else return true;
			
		}
		if(!month.equals(f2.getMonth())){
			if(month < f2.getMonth()){
				return false;
			}
			else return true;
		}
		if(!day.equals(f2.getDay())){
			if(day < f2.getDay()){
				return false;
			}
			else return true;
		}
		return false;
	}
	
}
