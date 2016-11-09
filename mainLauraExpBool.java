package dominio;
import java.util.*;

public class mainLauraExpBool {

	public static void main(String[] args) {
		Scanner capt = new Scanner(System.in);
		System.out.print("Ingrese la expresion: ");
		ExpBool exp = new ExpBool(capt.nextLine());
		ArrayList<Element> a = exp.getElements();
		System.out.print("Notacion infija: ");
		for (int i=0; i<a.size(); ++i) {
			System.out.print(a.get(i).getElement());
			System.out.print("\n");
		}
		ArrayList<Element> post = exp.getPostfija();
		System.out.print("Notacion postfija: ");
		for (int i = 0; i<post.size(); ++i) {
			System.out.print(post.get(i).getElement());
			System.out.print("\n");
		}
		capt.close();
	}
}