//package dominio;
import java.util.*;

public class ExpBool {
	private String s;
	private ArrayList<Element> elements = new ArrayList<Element>();
	private ArrayList<Element> post = new ArrayList<Element>();
	private Nodo raiz = new Nodo();
	
	//constructora
	public ExpBool(String s) {
		this.s = s;
		separaElements();
		infijaApostfija();
		buildTree();
	}
	
	//getters
	public String getExpresio() {
		return this.s;
	}
	
	public ArrayList<Element> getElements() {
		return elements;
	}
	public Nodo getTree() {
		return raiz;
	}
	public ArrayList<Element> getPostfija() {
		return post;
	}
	
	//setters
	public void setExpresio(String s) {
		this.s = s;
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
					(this.s.charAt(i) == 209)) {
				
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
	public void buildTree() {
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
	}
	
	// transforma un arrayList de Elementos que representa una expresion booleana en notacion infija a notacion postfija
	public void infijaApostfija() {
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
		if (error) System.out.println("La Expresion esta mal escrita");
	}
	
	//dados dos elementos retorna true si el primero tiene prioridad sobre el segundo
	private boolean o1_prioritario_sobre_o2(Element e1, Element e2) { 
		if (e1.getElement().equals("not") && e2.getElement().equals("and")) return true;
		else if (e1.getElement().equals("and") && e2.getElement().equals("or")) return true;
		else if (e1.getElement().equals("not") && e2.getElement().equals("or")) return true;
		else if (e1.getElement().equals(e2.getElement())) return true;
		else return false;
	}
	
	//imprime el recorrido en preorden dado un Nodo de un �rbol
	public void preorden(Nodo a) {
		if (a != null) {
			System.out.print(a.getInfo().getElement()+ " ");
			preorden(a.getfe());
			preorden(a.getfd());
		}
	}
	
	//imprime el recorrido en inorden dado un Nodo de un �rbol
	public void inorden(Nodo a) {
		if (a != null) {
			inorden(a.getfe());
			System.out.print(a.getInfo().getElement()+ " ");
			inorden(a.getfd());
		}
	}
	
	//imprime el recorrido en postorden dado un Nodo de un �rbol
	public void postorden(Nodo a) {
		if (a != null) {
			postorden(a.getfe());
			postorden(a.getfd());
			System.out.print(a.getInfo().getElement()+ " ");
		}
	}
	
////////////////////////////////////////CLASE NODO///////////////////////////////////////////
	public class Nodo {
		private Element info = null;
		private boolean operador;
		private boolean operando;
		private Nodo esq;	
		private Nodo dret;
		
		//constructoras
		public Nodo(Element info) {
			this.info = info;
			esq = null;
			dret = null;
			if (info.isOperador()){
				operador = true;
				operando = false;
				esq=null;
				dret=null;
			}
			else {
				operador = false;
				operando = true;
				esq=null;
				dret=null;
			}
		}

		public Nodo(){
			esq = null;
			dret = null;
			operador = false;
			operando = false;
		}
		
		
		//getters
		public Element getInfo() {
			return info;
		}
		public Nodo getfe() {
			return this.esq;
		}
		public Nodo getfd() {
			return this.dret;
		}
		
		//setters
		public void setfe(Nodo esq) {
			this.esq = esq;
		}
		public void setfd(Nodo dret) {
			this.dret = dret;
		}
		public void setOperador(Element e) {
			operador = true;
			operando = false;
			info = e;
		}
		public void setOperando(Element e) {
			operando = true;
			operador = false;
			info = e;
			esq = null;
			dret = null;
		}
		
		//consultoras
		//retorna true si el nodo guarda un operador
		public boolean isOperador() {
			return operador;
		}
		//retorna true si el nodo guarda un operando
		public boolean isOperando() {
			return operando;
		}
		//retorna true si el nodo est� vac�o
		public boolean empty() {
			return info==null;
		}
		//insercion
		public void insertLeft(Nodo n) {
			esq = n;
		}
		public void insertRight(Nodo n) {
			dret = n;
		}
		//borrado
		public void removeLeft(Nodo n) {
			esq = null;
		}
		public void removeRight(Nodo n) {
			dret = null;
		}
	}
/////////////////////////////////////FIN CLASE NODO///////////////////////////////////////////////
}
