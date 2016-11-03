package dominio;

public class Nodo {
	private Nodo pare = null;
	private Operador o;
	private ExpBool e;
	private Nodo esq = null;
	private Nodo dret = null;
	
	
	//constructoras
	public Nodo(Operador o) {
		this.o = o;
		this.e = null;
	}
	public Nodo(ExpBool e) {
		this.e = e;
		this.o = null;
	}
	
	//consultoras
	public char typeOfNode() {
		if (o == null) return 'E'; 	//E= Expresi�n Booleana
		else return 'O';			//O= Operador
	}
	
	//getters
	public Operador getOperador() {
		return this.o;
	}
	public ExpBool getExpBool() {
		return this.e;
	}
	public Nodo getfe() {
		return this.esq;
	}
	public Nodo getfd() {
		return this.dret;
	}
	public Nodo getpare() {
		return this.pare;
	}
	
	//setters
	public void setPare(Nodo p) {
		this.pare = p;
	}
	public void setfe(Nodo esq) {
		this.esq = esq;
	}
	public void setfd(Nodo dret) {
		this.dret = dret;
	}
	public void setOperador(Operador o) {
		if (this.o != null) {
			this.o = o;
		}
		else {
			System.out.println("Este nodo no es de tipo Operador!");
		}
	}
	public void setExpBool(ExpBool e) {
		if (this.e != null) {
			this.e = e;
		}
		else {
			System.out.println("Este nodo no es de tipo Expresi�n Booleana!");
		}
	}
}
