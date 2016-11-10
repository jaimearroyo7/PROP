package dominio;
import java.util.Scanner;

public class DriverFrase {

	public static void main(String[] args) {
		Scanner capt = new Scanner(System.in);
		System.out.print("Ingrese la frase: ");
		String frase = capt.nextLine();
		Frase f = new Frase(frase); //constructora
		System.out.print("La frase introducida es: ");
		System.out.println(f.getFrase()); //getFrase
		System.out.print("Las palabras que contiene son: ");
		for (int i=0; i<f.size(); ++i) {
			System.out.print(f.getPalabra(i).getPalabra()); //getPalabra(i)
			System.out.print("\n");
		}
		capt.close();
	}
}