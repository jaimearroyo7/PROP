package dominio;

//import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class CtrlDominioPrueba {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		CtrlDominio c = new CtrlDominio();
		Documentos doc = c.conjunto();
		for(int i = 0; i < doc.getDocs().size(); ++i){
			System.out.println(doc.getDocs().get(i).getTitulo());
			System.out.println(doc.getDocs().get(i).getAutor());
			System.out.println(doc.getDocs().get(i).getCategoria());
			System.out.println(doc.getDocs().get(i).getTexto().getTexto() + "\n");
		
		}
		Documento d1 = new Documento();
		d1.setTitulo("prueba");
		d1.setAutor("Jaime");
		d1.setCategoria("categoria");
		Texto t = new Texto("raul");
		d1.setTexto(t);
		int k = doc.addDoc(d1);
		Documento d2 = new Documento();
		d2.setTitulo("prueba2");
		d2.setAutor("Jaime");
		d2.setCategoria("categoria");
		Texto t2 = new Texto("raul");
		d2.setTexto(t);
		
		
		doc.addDoc(d2);
		
		Documento d3 = new Documento();
		d3.setTitulo("prueba3");
		d3.setAutor("Jaime");
		d3.setCategoria("categoria");
		Texto t3 = new Texto("raul");
		d3.setTexto(t);
		
		
		doc.addDoc(d3);
		
		c.acabar();
	//	File fichero = new File("/home/jaime/workspace/PROP/src/persistencia/datos/documento1.txt");
	//	fichero.delete();
	}

}
