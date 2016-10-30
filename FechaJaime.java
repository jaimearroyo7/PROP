//package Dominio;
import java.util.*;
import java.util.GregorianCalendar;
 
public class Fecha {
	
	private Integer day;
	private Integer month;
	private Integer year;
	
	//constructores
	public Fecha() {
		Calendar fecha = new GregorianCalendar();
		day = fecha.get(Calendar.DAY_OF_MONTH);
		month= fecha.get(Calendar.MONTH);
		++month;
		year = fecha.get(Calendar.YEAR);
	};
	
	
	public Integer getDay() {
		return day;
	}
	
	public Integer getMonth() {
		return month;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setFecha(){
		Calendar fecha = new GregorianCalendar();
		day = fecha.get(Calendar.DAY_OF_MONTH);
		month= fecha.get(Calendar.MONTH);
		++month;
		year = fecha.get(Calendar.YEAR);
	}
	
	public Integer greater(Fecha f2){
		if(year != f2.getYear()){
			if(year < f2.getYear()){
				return 2;
			}
			else return 1;
		}
		if(month != f2.getMonth()){
			if(month < f2.getMonth()){
				return 2;
			}
			else return 1;
		}
		if(day != f2.getDay()){
			if(day < f2.getDay()){
				return 2;
			}
			else return 1;
		}
		return 3;
	}
}
