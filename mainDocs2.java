package Dominio;
import java.io.FileNotFoundException;

public class mainDocs2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Documentos d = new Documentos();
		d.addDoc("C:/Users/JMC/workspace/Gestor de documentos/src/Dominio/prueba");
		d.consultarTitulo(0);
		d.consultarCategoria(0);
		}
}