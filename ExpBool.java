package dominio;

import java.util.*;

public class ExpBool {
	private String s = null;
	private ArrayList<Element> elements = new ArrayList<Element>();
	private ArrayList<Element> post = new ArrayList<Element>(); //post guarda la expresion en notacion postfija (sin parentesis)
	private Nodo raiz = new Nodo();
	// estos tres vectores guardan los tres recorridos posibles del arbol de expresion:
	private ArrayList<Element> recorrido_pre = new ArrayList<Element>();	
	private ArrayList<Element> recorrido_post = new ArrayList<Element>();
	private ArrayList<Element> recorrido_in = new ArrayList<Element>();
	
	//constructora
	public ExpBool() {
	}
	
	//getters
	public ArrayList<Element> getPost() {
		return post;
	}
	public Element get(int i) {
		return elements.get(i);
	}
	public String getExpresio() {
		return this.s;
	}
	public ArrayList<Element> getElements() {
		return elements;
	}
	public Nodo getTree() {
		return raiz;
	}
	public ArrayList<Element> getPreorden() {
		return recorrido_pre;
	}
	public ArrayList<Element> getPostorden() {
		return recorrido_post;
	}
	public ArrayList<Element> getInorden() {
		return recorrido_in;
	}
	
	//setter
	public int setExpresio(String s) {
		this.s = s;
		int error1, error2;
		separaElements();
		error1 = infijaApostfija();
		error2 = buildTree();
		if (error1==-1 || error2 == -1) return -1;
		else if (error1 == 0 && error2 == 0) {
			preorden(raiz);
			postorden(raiz);
			inorden(raiz);
			return 0;
		}
		else return -1;
	}
	
	public int size() {
		return post.size();
	}
	
	//Crea un arrayList de Elementos a partir de un String expresion booleana
	//El arrayList guarda en cada una de sus posiciones un Elemento de la expresion, por orden de aparicion
	private void separaElements() { 
		String s = new String();
		boolean dinsdecomilles=false;
		boolean dinsdeclaus=false;
		for (int i=0; i<this.s.length(); ++i) {
			//si em trobo lletres:
			if ((this.s.charAt(i) >= 65 && this.s.charAt(i) <= 90) || (this.s.charAt(i) >= 97 && this.s.charAt(i) <= 122) || 
					(this.s.charAt(i) == 129) || (this.s.charAt(i) == 130) || 
					(this.s.charAt(i) == 144) || (this.s.charAt(i) == 181) || 
					(this.s.charAt(i) == 214) || (this.s.charAt(i) == 224) || 
					(this.s.charAt(i) == 233) || (this.s.charAt(i) == 160) || // a cerrada
					(this.s.charAt(i) == 181) || (this.s.charAt(i) == 233) || // A cerrada, e cerrada
					(this.s.charAt(i) == 201) || (this.s.charAt(i) == 237) || // E cerrada, i cerrada
					(this.s.charAt(i) == 205) || (this.s.charAt(i) == 243) || // I cerrada, o cerrada
					(this.s.charAt(i) == 211) || (this.s.charAt(i) == 250) || // O cerrada, u cerrada
					(this.s.charAt(i) == 218) || (this.s.charAt(i) == 241) || // U cerrada, enye minuscula
					(this.s.charAt(i) == 209)) { //enye mayuscula
				
				if (i == this.s.length()-1) {
					s = s + this.s.charAt(i);
					Element x = new Element(s);
					elements.add(x);
				}
				else {
					s = s + this.s.charAt(i);
				}
			}
			else if (!dinsdeclaus && this.s.charAt(i) == '{') {
				dinsdeclaus = true;
				s="(";
				Element x = new Element(s);
				elements.add(x);
				s="";
				
			}
			else if (dinsdeclaus && this.s.charAt(i) == ' ') {
				Element x = new Element(s);
				elements.add(x);
				s = "and";
				Element y = new Element(s);
				elements.add(y);
				s = "";
			}
			else if (dinsdeclaus && this.s.charAt(i) == '}') {
				Element x = new Element(s);
				elements.add(x);
				s = "";
				dinsdeclaus = false;
				s=")";
				Element y = new Element(s);
				elements.add(y);
				s="";
			}
			
			else if (this.s.charAt(i) == ' ' && !dinsdecomilles) {
				Element x = new Element(s);
				elements.add(x);
				s="";
			}
			else if (this.s.charAt(i) == ' ' && dinsdecomilles) {
				s = s + this.s.charAt(i);
			}
			else if (this.s.charAt(i) == '"' && !dinsdecomilles) {
				dinsdecomilles = true;
			}
			else if (this.s.charAt(i) == '"' && dinsdecomilles && i==this.s.length()-1) {
				dinsdecomilles = false;
				Element x = new Element(s);
				elements.add(x);
			}
			else if (this.s.charAt(i) == '"' && dinsdecomilles) {
				dinsdecomilles = false;
			}
			
			else if (this.s.charAt(i) == '(') {
				s="(";
				Element x = new Element(s);
				elements.add(x);
				s="";
			}
			else if (this.s.charAt(i) == ')') {
				Element x = new Element(s);
				elements.add(x);
				s=")";
				Element y = new Element(s);
				elements.add(y);
				s="";
			}
			else if (this.s.charAt(i) == '\n') {
				Element x = new Element(s);
				elements.add(x);
				s="";
			}
		}
		//eliminar espacios en blanco sobrantes del arrayList
		for (int i=0; i<elements.size(); ++i) {
			if (elements.get(i).getElement().equals("")) {
				elements.remove(i);
			}
		}
	}
	
	// Construye un arbol binario de expresion booleana a partir de su lista de elementos en notacion postfija
	private int buildTree() {
		raiz = null;
		Stack<Nodo> pila = new Stack<Nodo>();
		boolean error = false;
		int i = 0;
		while (i<post.size() && !error) {
			Element act = post.get(i);
			//en la notacion postfija solo hay operadores y operandos
			if (!act.isOperador()) { 
				Nodo x = new Nodo(act);
				pila.push(x);
			}
			else if (act.isOperador()) {
				if (pila.size() >= 2 && act.isOperadorBinari()) {
					Nodo y = new Nodo(act);
					y.setfd(pila.pop());
					y.setfe(pila.pop());
					pila.push(y);

				}
				else if (pila.size()>=1 && act.isaNot()) {
					Nodo z = new Nodo(act);
					z.setfe(pila.pop());
					pila.push(z);
				}
				else error = true;
			}
			else {raiz = null;}
			++i;
		}
		if (pila.empty() || pila.size() >= 2) error = true;
		else raiz = pila.pop();
		if (error) return -1;
		else return 0;
		
	}
	
	// transforma un arrayList de Elementos que representa una expresion booleana en notacion infija a notacion postfija
	private int infijaApostfija() {
		Stack<Element> operatorStack = new Stack<Element>();
		int i = 0;
		boolean error = false;
		while(i<elements.size() && !error) {
			Element current = elements.get(i);
			if (!current.isOperador() && !current.isParenthesis()) { //operando
				post.add(current);
			}
			else if (current.isOperador()) { //operator
				if (operatorStack.empty()) { // la pila d'operadors est� buida
					operatorStack.push(current);
				}
				else { //la pila d'operadors no est� buida
					if (o1_prioritario_sobre_o2(operatorStack.peek(), current)) {
						post.add(operatorStack.pop());
						operatorStack.push(current);
					}
					else {
						operatorStack.push(current);
					}
				}
			}
			else if (current.isOpenedParenthesis()) { // left parenthesis
				operatorStack.push(current);
			}
			else if (current.isClosedParenthesis()) { // right parenthesis
				while (!operatorStack.empty() &&
						!operatorStack.peek().isOpenedParenthesis()) {
					post.add(operatorStack.pop());
				}
				if (operatorStack.empty()) error = true;
				else if (operatorStack.peek().isOpenedParenthesis()) {
					operatorStack.pop(); //remove (
				}
				else error = true;
			}
			++i;
		}
		while(!operatorStack.empty()) {
			if (operatorStack.peek().isParenthesis()) error = true;
			post.add(operatorStack.pop());
		}
		if (error) return -1;
		else return 0;
	}
	
	//dados dos elementos retorna true si el primero tiene prioridad sobre el segundo
	private boolean o1_prioritario_sobre_o2(Element e1, Element e2) { 
		if (e1.getElement().equals("not") && e2.getElement().equals("and")) return true;
		else if (e1.getElement().equals("and") && e2.getElement().equals("or")) return true;
		else if (e1.getElement().equals("not") && e2.getElement().equals("or")) return true;
		else if (e1.getElement().equals(e2.getElement())) return true;
		else return false;
	}
	
	//guarda el recorrido en preorden dado un Nodo de un arbol
	private void preorden(Nodo a) {
		if (a != null) {
			recorrido_pre.add(a.getInfo());
			preorden(a.getfe());
			preorden(a.getfd());
		}
	}
	
	//guarda el recorrido en inorden dado un Nodo de un arbol
	private void inorden(Nodo a) {
		if (a != null) {
			inorden(a.getfe());
			recorrido_in.add(a.getInfo());
			inorden(a.getfd());
		}
	}
	
	//guarda el recorrido en postorden dado un Nodo de un arbol
	private void postorden(Nodo a) {
		if (a != null) {
			postorden(a.getfe());
			postorden(a.getfd());
			recorrido_post.add(a.getInfo());
		}
	}
	

}
