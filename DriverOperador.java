package dominio;
import java.util.Scanner;

public class DriverOperador {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el operador: ");
		String s = sc.nextLine();
		Operador op = new Operador(s);
		op.setOperador(s);
		System.out.print("El operador es: ");
		System.out.println(op.getOperador());
		System.out.println(op.isAnd());
		System.out.println(op.isOr());
		System.out.println(op.isNot());
		sc.close();
	}
}