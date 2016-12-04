package dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import persistencia.CtrlPersistencia;

public class CtrlDominio {
	public CtrlPersistencia CP;
	public Documentos d;
	
	public CtrlDominio() throws IOException, ParseException{
		CP = new CtrlPersistencia();
		d = new Documentos();
		ArrayList<String> docs = CP.datos("/home/jaime/workspace/dominio/src/persistencia/datos");
		for(int i = 0; i < docs.size(); ++i){
			String direccion = "/home/jaime/workspace/dominio/src/persistencia/datos/" + docs.get(i);
			FileReader f = new FileReader(direccion);
	        BufferedReader b = new BufferedReader(f);
	        Documento d1 = new Documento();
	        d1.setTitulo(b.readLine());
	        d1.setAutor(b.readLine());
	        d1.setCategoria(b.readLine());
	        Texto t = new Texto(b.readLine());
	        d1.setTexto(t);
	        int k = d.addDoc(d1);
		}
	}
	public Documentos conjunto(){return d;}
	public void acabar() throws IOException{
		ArrayList<Documento> docs = d.getDocs();
		CP.acabar(docs);
	}
}