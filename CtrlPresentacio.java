package interfaz;

import java.io.IOException;
import java.text.ParseException;

import dominio.CtrlDominio;

public class CtrlPresentacio {
	
	private CtrlDominio cd;
	
	private Pant1 p1;
	private Pant2 p2;
	private Pant3 p3;
	private Pant4 p4;
	private Pant5 p5;
	
	public CtrlPresentacio(){
		
		try {
			cd = new CtrlDominio();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1 = new Pant1(this);
		
	}
	public CtrlDominio cd(){ return cd;}
	
	public void llamarp1(){ p1 = new Pant1(this); }
	public void llamarp2(){ p2 = new Pant2(this); }
	public void llamarp3(){ p3 = new Pant3(this); }
	public void llamarp4(){ p4 = new Pant4(this); }
	public void llamarp5(){ p5 = new Pant5(this); }
}
