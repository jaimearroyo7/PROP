package interficie;

import java.io.IOException;
import java.text.ParseException;

import dominio.CtrlDominio;

public class CtrlPresentacio {
	
	private CtrlDominio cd;
	
	private Principal p1;
	private Ventana2 p2;
	private Ventana3 p3;
	private Ventana4 p4;
	private Ventana5 p5;
	private Ventana6 p6;
	private Ventana7 p7;
	private Ventana8 p8;
	private Ventana9 p9;
	
	public CtrlPresentacio(){
		
		try {
			cd = new CtrlDominio();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1 = new Principal(this);
		
	}
	public CtrlDominio cd(){ return cd;}
	
	public void llamarp1(){ p1 = new Principal(this); }
	public boolean getvolver() { return p1.getVolver(); }
	public void llamarp2(){ p2 = new Ventana2(this); }
	public void llamarp3(){ p3 = new Ventana3(this); }
	public String gettitulo() { return p3.gettitulo(); }
	public String getautor() { return p3.getautor(); }
	public void llamarp4(){ p4 = new Ventana4(this); }
	public void llamarp5(){ p5 = new Ventana5(this); }
	public void llamarp6(){ p6 = new Ventana6(this); }
	public void llamarp7(){ p7 = new Ventana7(this); }
	public void llamarp8(){ p8 = new Ventana8(this); }
	public void llamarp9(){ p9 = new Ventana9(this); }
}
