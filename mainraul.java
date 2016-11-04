package dominio;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class main {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		// TODO Auto-generated method stub
		Documentos d = new Documentos();
		
		while(true) {
		d.addDocvers1();
		/*d.addDoc("C:/Users/JMC/workspace/Gestor de documentos/src/Dominio/prueba");*/
		d.consultarTitulo(0);
		d.consultarAutor(0);
		d.consultarCategoria(0);
		d.consultarFecha(0);
		d.consultarTexto(0);
		d.consultarTitulosAutor();
		}
	}
}