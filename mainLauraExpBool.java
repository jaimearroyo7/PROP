package PROP;
import java.util.*;

public class mainLauraExpBool {

	public static void main(String[] args) {
		Scanner capt = new Scanner(System.in);
		System.out.print("Ingrese la expresion: ");
		ExpBool exp = new ExpBool(capt.nextLine());
		exp.separaElements();
		ArrayList<String> a =exp.getElements();
		for (int i=0; i<a.size(); ++i) {
			System.out.print(a.get(i));
			System.out.print("\n");
		}
	}

}