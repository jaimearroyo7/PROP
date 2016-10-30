package Dominio;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
 
public class Fecha {
	
	private Date fecha;
	
	//constructores
	public Fecha() {}
		
	public Fecha(final String f)throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd MMM yyyy"); 
		fecha = sdf.parse(f);
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(String s) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd MMM yyyy"); 
		fecha = sdf.parse(s);
	}
	public int comparar(Date d2) {
	    if(fecha.equals(d2)) return 1;
	    else {
	    	  if(fecha.before(d2)) return 2;
	    	  else return 3;
	    }
	}
	public void imprimirfecha() {
		System.out.println (fecha);
	}
}
