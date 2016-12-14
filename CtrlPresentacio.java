package interfaz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;

import dominio.CtrlDominio;
import dominio.Frase;

public class CtrlPresentacio implements Serializable{
	
	private CtrlDominio cd = null;
	private static final long serialVersionUID = 4272754599287642639L;
	
	private Pant1 p1 = null;
	private Pant2 p2 = null;
	private Pant3 p3 = null;
	private Pant4 p4 = null;
	private Pant5 p5 = null;
	
	public CtrlPresentacio(){
		
	}
	
	public void empezar(){
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
	
	public void writeToFile() throws FileNotFoundException, IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"));
		oos.writeObject(this);
	}
	
	public CtrlPresentacio readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"));
		CtrlPresentacio cp = (CtrlPresentacio) ois.readObject();
		return cp;
	}
	
	public void acabar() throws IOException{
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("/home/jaime/workspace/PROP/src/persistencia/datos/data.bin"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oos.writeObject(cd.conjunto());
	}
}
