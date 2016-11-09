package dominio;

import java.util.Scanner;

public class DriverPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String, String> p1 = new Pair<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el primer campo del pair1: ");
		String valorstring = sc.nextLine();
		
		p1.setFirst(valorstring);
		System.out.println("Introduce el segundo campo del pair1: ");
		valorstring = sc.nextLine();
		p1.setSecond(valorstring);
		System.out.println(p1.toString());
		
		System.out.println("Introduce el primer campo del pair2: ");
		String p2first = sc.nextLine();
		System.out.println("Introduce el segundo campo del pair2: ");
		String p2second = sc.nextLine();
		
		Pair<String, String> p2 = new Pair<>(p2first, p2second);

		System.out.println(p2.toString());
		
		if(p1.equals(p2)){
			System.out.println("Son iguales");
		}
		else System.out.println("Son diferentes");
	}

}
