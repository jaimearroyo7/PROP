package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dominio.Documento;
import dominio.Documentos;

public class CtrlPersistencia {

	public CtrlPersistencia(){
		
	}
	
	public ArrayList<String> datos(String direccion){
		ArrayList<String> d = new ArrayList<String>();
		//File f = new File("/home/jaime/workspace/dominio/src/persistencia/datos");
		File f = new File(direccion);
		File[] ficheros = f.listFiles();
		for (int i = 0; i < ficheros.length ; i++){
			if(ficheros[i].isFile()){
				if(ficheros[i].getName().endsWith(".txt")){
					d.add(ficheros[i].getName());}
				}
			}
		return d;
	}
	
	public void acabar(ArrayList<Documento> d) throws IOException{
		String direccion = "/home/jaime/workspace/dominio/src/persistencia/datos";
		File f = new File(direccion);
		File[] ficheros = f.listFiles();
		for (int i = 0; i < ficheros.length ; i++){
			ficheros[i].delete();
		}
		File[] files = new File[d.size()];
		BufferedWriter[] bw = new BufferedWriter[d.size()];
		for(int j = 0; j < d.size(); ++j){
			direccion = "/home/jaime/workspace/dominio/src/persistencia/datos/documento" + j + ".txt";
			files[j] = new File(direccion);
			bw[j] = new BufferedWriter(new FileWriter(files[j]));
			bw[j].write(d.get(j).getTitulo() + "\n");
			bw[j].write(d.get(j).getAutor() + "\n");
			bw[j].write(d.get(j).getCategoria() + "\n");
			bw[j].write(d.get(j).getTexto().getTexto() + "\n");
			bw[j].close();
		}
	}
}
