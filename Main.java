package interfaz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import dominio.Frase;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/*CtrlPresentacio c = new CtrlPresentacio();
		try {
			c = c.readFile();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		c.empezar();*/
		CtrlPresentacio c = new CtrlPresentacio();
		
		c.empezar();
	}

}
