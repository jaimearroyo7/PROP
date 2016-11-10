package dominio;
import java.util.*;

public class DriverExpBool {

	public static void main(String[] args) {
		Scanner capt = new Scanner(System.in);
		System.out.print("Ingrese la expresion: ");
		ExpBool exp = new ExpBool();
		int error;
		error = exp.setExpresio(capt.nextLine()); //llamada a setExpresio
		if (error == 0) {
			ArrayList<Element> a = exp.getElements(); //llamada a getElements
			System.out.print("Expresion en notacion prefija: \n");
			for (int i=0; i<a.size(); ++i) {
				System.out.print(a.get(i).getElement());
				System.out.print("\n");
			}
			System.out.print("Recorrido preorden: ");
			ArrayList<String> pre = exp.getPreorden();
			for (int i = 0; i<pre.size(); ++i) {
				System.out.print(pre.get(i));
				System.out.print("\n");
			}
			System.out.print("Recorrido inorden: ");
			ArrayList<String> in = exp.getInorden();
			for (int i = 0; i<in.size(); ++i) {
				System.out.print(in.get(i));
				System.out.print("\n");
			}
			System.out.print("Recorrido postorden: ");
			ArrayList<String> post = exp.getPostorden();
			for (int i = 0; i<post.size(); ++i) {
				System.out.print(post.get(i));
				System.out.print("\n");
			}
		}
		else {
			System.out.print("Expresion mal escrita");
		}
		capt.close();
	}
}