package Dominio;

public class Operador {
	private String op;
	
	//constructoras
	public Operador () {}
	
	public Operador (String op) {
		if (isOperador(op)) {
			this.op = op;
		}
	}
	
	//get y set
	public void setOperador (String op) {
		if (isOperador(op)) {
			this.op = op;
		}
	}
	public String getOperador () {
		return this.op;
	}
	
	//consultoras
	public boolean isOperador(String x) {
		if (x.equals("and") || x.equals("or") || x.equals("not")) {
			return true;
		}
		return false;
	}
	public boolean isAnd() {
		if (getOperador().equals("and")) return true;
		else return false;
	}
	public boolean isOr() {
		if (getOperador().equals("or")) return true;
		else return false;
	}
	public boolean isNot() {
		if (getOperador().equals("not")) return true;
		else return false;
	}
}
