package dominio;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class DriverConsultaBooleana {

	public static void main(String[] args) throws IOException, ParseException {
		Documentos docs = new Documentos();
		Scanner sc = new Scanner(System.in);
		System.out.println("Tendra que introducir 3 documentos");
		int i = 0;
		while (i<3) {
			Documento d = new Documento();
			System.out.println("Ingrese titulo:");
			d.setTitulo(sc.nextLine());
			System.out.println("Ingrese autor:");
			d.setAutor(sc.nextLine());
			System.out.println("Ingrese categoria:");
			d.setCategoria(sc.nextLine());
			Texto t = new Texto();
			System.out.println("Ingrese el texto:");
			t.setTexto(sc.nextLine());
			d.setTexto(t);
			docs.addDoc(d);
			++i;
		}
		System.out.println("Ingrese la expresion booleana: ");
		String expresio = sc.nextLine();
		consultaBooleana c = new consultaBooleana(docs, expresio);
		System.out.println(c.getResult().size());
		for (int j = 0; j<c.getResult().size(); ++j) {
			System.out.println(c.getResult().get(j).getTitulo());
			System.out.println(c.getResult().get(j).getAutor());
			System.out.println();
		}
		sc.close();
	}

}
