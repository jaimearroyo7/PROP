package dominio;

import java.util.Scanner;

public class DriverElement {

	public static void main(String[] args) {
		Element e = new Element();
		Scanner capt = new Scanner(System.in);
		System.out.println("Introduzca un elemento y le dire que es: ");
		String s = capt.nextLine();
		e.setElement(s);
		if (e.isOperador()) System.out.println("Es un operador");
		else if (!e.isOperador() && !e.isParenthesis() && !e.isKey() && !e.isFrase()) System.out.println("Es una palabra");
		else if (e.isFrase()) System.out.println("Es una frase");
		else if (e.isKey()) System.out.println("Es una llave");
		else if (e.isParenthesis()) System.out.println("Es un parentesis");
		capt.close();
	}

}