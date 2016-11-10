//package dominio;
import java.util.Scanner;

public class DriverFrase {

	public static void main(String[] args) {
		Scanner capt = new Scanner(System.in);
		System.out.print("Ingrese la frase: ");
		String frase = capt.nextLine();
		Frase f = new Frase(frase);
		for (int i=0; i<f.size(); ++i) {
			System.out.print(f.getPalabra(i).getPalabra());
			System.out.print("\n");
		}
		capt.close();
	}
}