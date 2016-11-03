package dominio;
import java.util.*;

public class ExpBool {
	private String s;
	private ArrayList<String> elements = new ArrayList<String>();
	private Nodo raiz;	//tree es el nodo ra�z del �rbol que almacena la expresi�n booleana.
	
	//constructoras
	public ExpBool() {}
	public ExpBool(String s) {
		this.s = s;
		//buildTree(this.s);
	}
	
	//getters
	public String getEpresio() {
		return this.s;
	}
	
	public ArrayList<String> getElements() {
		return elements;
	}
	
	//setters
	public void setExpresio(String s) {
		this.s = s;
		//buildTree(this.s);
	}
	
	/*public void buildTree (String s) {
		ArrayList<String> a = separaElements();
		Stack<ExpBool> sexp = new Stack<ExpBool>();
		Stack<Operador> sop = new Stack<Operador>();
		for (int i=0; i<s.length(); ++i) {
		}
	}*/
	public void separaElements() {
		String s = new String();
		boolean dinsdecomilles=false;
		for (int i=0; i<this.s.length(); ++i) {
			//si em trobo lletres:
			if ((this.s.charAt(i) >= 65 && this.s.charAt(i) <= 90) || (this.s.charAt(i) >= 97 && this.s.charAt(i) <= 122) || 
				(this.s.charAt(i) == 129) || (this.s.charAt(i) == 130) || 
				(this.s.charAt(i) == 144) || (this.s.charAt(i) == 181) || 
				(this.s.charAt(i) == 214) || (this.s.charAt(i) == 224) || 
				(this.s.charAt(i) == 233) || (this.s.charAt(i) == '�') ||
				(this.s.charAt(i) == '�') || (this.s.charAt(i) == '�') ||
				(this.s.charAt(i) == '�') || (this.s.charAt(i) == '�') ||
				(this.s.charAt(i) == '�') || (this.s.charAt(i) == '�') ||
				(this.s.charAt(i) == '�') || (this.s.charAt(i) == '�') ||
				(this.s.charAt(i) == '�')) {
				
				if (i == this.s.length()-1) {
					s = s + this.s.charAt(i);
					elements.add(s);
				}
				else {
					s = s + this.s.charAt(i);
				}
			}
			//si em trobo altres car�cters:
			if (this.s.charAt(i) == ' ' && !dinsdecomilles) {
				elements.add(s);
				s="";
			}
			else if (this.s.charAt(i) == ' ' && dinsdecomilles) {
				s = s + this.s.charAt(i);
			}
			else if (this.s.charAt(i) == '"' && !dinsdecomilles) {
				dinsdecomilles = true;
			}
			else if (this.s.charAt(i) == '"' && dinsdecomilles) {
				dinsdecomilles = false;
			}
			else if (this.s.charAt(i) == '(') {
				s="(";
				elements.add(s);
				s="";
			}
			else if (this.s.charAt(i) == ')') {
				elements.add(s);
				s=")";
				elements.add(s);
				s="";
			}
			else if (this.s.charAt(i) == '\n') {
				elements.add(s);
				s="";
			}
		}
		//elimino espais en blanc sobrants
		for (int i=0; i<elements.size(); ++i) {
			if (elements.get(i).equals("")) {
				elements.remove(i);
			}
		}
	}
}
