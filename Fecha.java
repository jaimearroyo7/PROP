package dominio;//package Dominio;
import java.util.*;
import java.util.GregorianCalendar;
 
public class Fecha {
	
	private Integer year;
	private Integer month;
	private Integer day;
	
	
	
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
	public void setFechaManual(int valorday, int valormonth, int valoryear){
		day = valorday;
		month = valormonth;
		year = valoryear;
	}
	
	public boolean greater(Fecha f2){
		if(year != f2.getYear()){
			if(year < f2.getYear()){
				return false;
			}
			else return true;
		}
		if(month != f2.getMonth()){
			if(month < f2.getMonth()){
				return false;
			}
			else return true;
		}
		if(day != f2.getDay()){
			if(day < f2.getDay()){
				return false;
			}
			else return true;
		}
		return true;
	}
}
