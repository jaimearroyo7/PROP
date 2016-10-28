import java.util.ArrayList;
import java.util.Scanner;

public class mainJaime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hola");
		Scanner sc = new Scanner(System.in);
		String texto = sc.nextLine();
		
		Documento prueba = new Documento("Fib", "Yo", "Futbol", texto);
		
		
		ArrayList<Frase> lista = prueba.getTexto().getListaFrases();
		ArrayList<Pair<String, Integer>> Palabras = prueba.getfrecuencia();
		for(int i = 0; i < Palabras.size(); ++i){
			System.out.println(Palabras.get(i).first());
			//System.out.println(lista.get(i).getFrase());
		}
	}

}
