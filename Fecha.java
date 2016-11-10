package dominio;

import java.util.*;
 // La clase Fecha representa una fecha dd.mm.yy.

public class Fecha {
	
	// atributos
	
	private Integer year; 
	private Integer month; 
	private Integer day; 
	
	// constructoras
	
	public Fecha() { //constructora por defecto, asigna el day, month y year proporcionado por la clase interna de Calendar
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
	public int bisiesto(int any) { // miramos si el año es de traspaso o no
		  
		if ((any%4 == 0) && ((any%400 == 0) || (any%100 != 0)) )return 1;
		else return -1;
	}
	public void setFechaManual(int valorday, int valormonth, int valoryear){ // modifica la fecha manualmente por los campos pasados por parametro
		day = valorday;
		month = valormonth;
		year = valoryear;
	}
	
	//consultoras
	
	public int comprobar(String h,String q,String p) {
		
		int da = day; 
		int mon = month;
		int ye = year;
		day = Integer.parseInt(h);
		month = Integer.parseInt(q);
		year = Integer.parseInt(p);

			if(year > ye) {
				return -1;
			}
			if(year == ye && month > mon){
				return  -1;
			}
			if(year == ye && month == mon && day > da) {
				return -1;
			}
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(day <= 0 || day >= 32) return -3;
			}
			else if(month == 4 || month == 6 || month == 9 || month == 11) {
				if(day <= 0 || day >= 31) return -3;
			}
			else if(month == 2) {
				if(bisiesto(year) == 1) {
					if(day <= 0 || day >= 30) return -3;
				}
				else if (day <= 0 || day >= 29) return -3;
			}
			else return -2;
		return 1;
	}
	public Integer getDay() { // devuelve el 'day' en forma de entero 
		return day;
	}
		
	public Integer getMonth() { // devuelve el 'month' en forma de entero
		return month;
	}
		
	public Integer getYear() {// devuelve el 'year' en forma de entero
		return year;
	}
	
	public boolean greater(Fecha f2){ // devuelve 'true' si el parametro implicito es mas grande que el parametro explicito
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