package dominio;
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
	
	private void separaElements() { //crea un arrayList d'Elements, que emmagatzema l'expresio booleana
		String s = new String();
		boolean dinsdecomilles=false;
		boolean dinsdeclaus=false;
		for (int i=0; i<this.s.length(); ++i) {
			//si em trobo lletres:
			if ((this.s.charAt(i) >= 65 && this.s.charAt(i) <= 90) || (this.s.charAt(i) >= 97 && this.s.charAt(i) <= 122) || 
				(this.s.charAt(i) == 129) || (this.s.charAt(i) == 130) || 
				(this.s.charAt(i) == 144) || (this.s.charAt(i) == 181) || 
				(this.s.charAt(i) == 214) || (this.s.charAt(i) == 224) || 
				(this.s.charAt(i) == 233) || (this.s.charAt(i) == 'á') ||
				(this.s.charAt(i) == 'Á') || (this.s.charAt(i) == 'é') ||
				(this.s.charAt(i) == 'É') || (this.s.charAt(i) == 'í') ||
				(this.s.charAt(i) == 'Í') || (this.s.charAt(i) == 'ó') ||
				(this.s.charAt(i) == 'Ó') || (this.s.charAt(i) == 'ú') ||
				(this.s.charAt(i) == 'Ú') || (this.s.charAt(i) == 'ñ') ||
				(this.s.charAt(i) == 'Ñ')) {
				
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
		//elimino espais en blanc sobrants
		for (int i=0; i<elements.size(); ++i) {
			if (elements.get(i).getElement().equals("")) {
				elements.remove(i);
			}
		}
	}
	public void buildTree() { // un cop obtinguda la llista d'elements en notacio postfixa
		raiz = new Nodo();
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
			++i;
		}
		if (pila.empty() || pila.size() >= 2) error = true;
		else raiz = pila.pop();
	}
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
				if (operatorStack.empty()) { // la pila d'operadors està buida
					operatorStack.push(current);
				}
				else { //la pila d'operadors no està buida
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
	
	private boolean o1_prioritario_sobre_o2(Element e1, Element e2) {
		if (e1.getElement().equals("not") && e2.getElement().equals("and")) return true;
		else if (e1.getElement().equals("and") && e2.getElement().equals("or")) return true;
		else if (e1.getElement().equals("not") && e2.getElement().equals("or")) return true;
		else if (e1.getElement().equals(e2.getElement())) return true;
		else return false;
	}
	
	public void preorden(Nodo a) {
		if (a != null) {
			System.out.print(a.getInfo().getElement()+ " ");
			preorden(a.getfe());
			preorden(a.getfd());
		}
	}
	public void inorden(Nodo a) {
		if (a != null) {
			inorden(a.getfe());
			System.out.print(a.getInfo().getElement()+ " ");
			inorden(a.getfd());
		}
	}
	public void postorden(Nodo a) {
		if (a != null) {
			postorden(a.getfe());
			postorden(a.getfd());
			System.out.print(a.getInfo().getElement()+ " ");
		}
	}
	public boolean isEmpty() {
		return raiz == null && raiz.getfe() == null && raiz.getfd() == null;
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
		public boolean isOperador() {
			return operador;
		}
		public boolean isOperando() {
			return operando;
		}
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
