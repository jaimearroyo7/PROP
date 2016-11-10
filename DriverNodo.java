//package dominio;

import java.util.Scanner;

public class DriverNodo {

	public static void main(String[] args) {
		Scanner capt = new Scanner(System.in);
		System.out.print("Ingrese la expresion: ");
		ExpBool exp = new ExpBool(capt.nextLine());
		System.out.println("PREORDEN: ");
		exp.preorden(exp.getTree());
		System.out.println("\n");
		System.out.println("INORDEN: ");
		exp.inorden(exp.getTree());
		System.out.println("\n");
		System.out.println("POSTORDEN: ");
		exp.postorden(exp.getTree());
		capt.close();
	}

}