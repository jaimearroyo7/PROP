package dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverHistoricoDocumentos {
	public static void main(String[] args) throws IOException {
		
		ArrayList<Documento> lista = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Añade 10 documentos: ");
		int N = 10;
		for(int i = 0; i < N; ++i){
			Documento d1 = new Documento();
			String campo;
			System.out.println("Ingrese titulo del Documento " +i + ":");
			campo = sc.nextLine();
			d1.setTitulo(campo);
			System.out.println("Ingrese autor del Documento " +i + ":");
			campo = sc.nextLine();
			d1.setAutor(campo);
			System.out.println("Ingrese categoria del Documento " +i + ":");
			campo = sc.nextLine();
			d1.setCategoria(campo);
			System.out.println("Ingrese texto del Documento " +i + ":");
			campo = sc.nextLine();
			Texto texto = new Texto(campo);
			d1.setTexto(texto);
			lista.add(d1);
		}
		
		
		HistoricoDocumentos historial = new HistoricoDocumentos(lista);
		for(int i = 0; i < 10; ++i){
			System.out.print(historial.getHistorial().get(i).getTitulo() + ": ");
			Fecha fecha = historial.getHistorial().get(i).getFecha();
			System.out.println(fecha.getDay() + "/" + fecha.getMonth() + "/" + fecha.getYear());
		}
		sc.close();
	}
}