package dominio;

import interfaz.CtrlPresentacio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import persistencia.CtrlPersistencia;

public class CtrlDominio implements Serializable{
	public CtrlPersistencia CP;
	public Documentos d;
	
	public CtrlDominio() throws IOException, ParseException{
		CP = new CtrlPersistencia();
		d = new Documentos();
		
		File f = new File("/home/jaime/workspace/PROP/src/persistencia/datos");
		File[] ficheros = f.listFiles();
		for (int i = 0; i < ficheros.length ; i++){
			if(ficheros[i].getName().equals("data.bin")){
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/jaime/workspace/PROP/src/persistencia/datos/data.bin"));
				try {
					d = (Documentos) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		/*
		ArrayList<String> docs = CP.datos("/home/jaime/workspace/PROP/src/persistencia/datos");
		for(int i = 0; i < docs.size(); ++i){
			String direccion = "/home/jaime/workspace/PROP/src/persistencia/datos/" + docs.get(i); 
			FileReader f = new FileReader(direccion);
	        BufferedReader b = new BufferedReader(f);
	        Documento d1 = new Documento();
	        d1.setTitulo(b.readLine());
	        d1.setAutor(b.readLine());
	        d1.setCategoria(b.readLine());
	        Texto t = new Texto(b.readLine());
	        d1.setTexto(t);
	        int k = d.addDoc(d1);
		}*/
	}
	public Documentos conjunto(){return d;}
	public CtrlPersistencia	control(){return CP;}
}
