import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainJaime {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.out.println("Hola");
		Scanner sc = new Scanner(System.in);
		String comando = sc.nextLine();
		while(comando.equals("fin") == false){
		
		if(comando.equals("documento")){
		String texto = sc.nextLine();	
		Documento prueba = new Documento("Fib", "Yo", "Futbol", texto);
		
		
		ArrayList<Frase> lista = prueba.getTexto().getListaFrases();
		ArrayList<Pair<String, Integer>> Palabras = prueba.getfrecuencia();
		for(int i = 0; i < Palabras.size(); ++i){
			String result = (Palabras.get(i)).toString();
			System.out.println(result);
		}
			}
		if(comando.equals("funcionales")){
		String cadena;
	     FileReader f = new FileReader("/home/jaime/workspace/PROP/src/PalabrasFuncionales.txt");
	     BufferedReader b = new BufferedReader(f);
	     try {
			while((cadena = b.readLine())!=null) {
			     System.out.println(cadena);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     b.close();}
		if(comando.equals("historial")){
			
			ArrayList<Documento> lista = new ArrayList<>();
			String texto = sc.nextLine();	
			Documento prueba1 = new Documento("1", "Yo", "Futbol", texto);
			lista.add(prueba1);
			texto = sc.nextLine();
			Documento prueba2 = new Documento("2", "Yo", "Futbol", texto);
			lista.add(prueba2);
			texto = sc.nextLine();
			Documento prueba3 = new Documento("3", "Yo", "Futbol", texto);
			lista.add(prueba3);
			texto = sc.nextLine();
			Documento prueba4 = new Documento("4", "Yo", "Futbol", texto);
			lista.add(prueba4);
			
			lista.get(2).setFechaManual(30, 12, 2016);
			lista.get(1).setFechaManual(15, 12, 2016);
			lista.get(0).setFechaManual(20, 12, 2016);
			
			HistoricoDocumentos historial = new HistoricoDocumentos(lista);
			for(int i = 0; i < 4; ++i){
				System.out.print(historial.getHistorial().get(i).getTitulo() + ": ");
				Fecha fecha = historial.getHistorial().get(i).getFecha();
				System.out.println(fecha.getDay() + "/" + fecha.getMonth() + "/" + fecha.getYear());
			}
			
		}
		comando = sc.nextLine();
		}
	}
	
}
