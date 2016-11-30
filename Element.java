package dominio;

public class Element {
	private String e = null;

	public Element(String s) {
		e = s;
	}
	public Element() {
		
	}
	//setter
	public void setElement(String e) {
		this.e=e;
	}
	//getter
	public String getElement() {
		return this.e;
	}
	
	//consultoras
	//retorna true si el elemento es una frase
	public boolean isFrase() {
		return e.contains(" ");
	}
	//retorna true si el elemento es una llave
	public boolean isKey() {
		return (e.equals("{") || e.equals("}"));
	}
	public boolean isOpenedKey() {
		return (e.equals("{"));
	}
	public boolean isClosedKey() {
		return (e.equals("}"));
	}
	//retorna true si el elemento es un parentesis
	public boolean isParenthesis() {
		return (e.equals("(") || e.equals(")"));
	}
	public boolean isOpenedParenthesis() {
		return e.equals("(");
	}
	public boolean isClosedParenthesis() {
		return e.equals(")");
	}
	//retorna true si el elemento es un operador
	public boolean isOperador() {
		return e.equals("and") || e.equals("or") || e.equals("not"); 
	}
	public boolean isOperadorBinari() {
		return e.equals("and") || e.equals("or");
	}
	public boolean isaNot() {
		return e.equals("not");
	}
	public boolean isAnd() {
		return e.equals("and");
	}
	public boolean isOr() {
		return e.equals("or");
	}
	public boolean isPalabra() {
		return (!e.contains(" ") && !isParenthesis() && !isOperador() && !isKey());
	}
}
