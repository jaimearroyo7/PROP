import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hola");
		Scanner sc = new Scanner(System.in);
		String texto = sc.nextLine();
		Texto prueba = new Texto(texto);
		System.out.println(prueba.getTexto());
		ArrayList<String> lista = prueba.getListaFrases();
		for(int i = 0; i < lista.size(); ++i){
			System.out.println(lista.get(i));
		}
	}

}
