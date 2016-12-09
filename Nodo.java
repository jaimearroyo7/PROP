package dominio;

import java.util.*;

public class Nodo {
	private Element info = null;
	private boolean operador;
	private boolean operando;
	private Nodo esq = null;	
	private Nodo dret = null;
	// el arraylist "d" guarda una lista de los documentos con sus identificadores de cada frase que cumplen la expresion booleana
	//del nodo actual y su subarbol
	private ArrayList<Pair<Documento, ArrayList<Integer>>> d = new ArrayList<Pair<Documento, ArrayList<Integer>>>();


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
	public ArrayList<Pair<Documento, ArrayList<Integer>>> getAcumulat() {
		return d;
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
	public void setAcumulat(ArrayList<Pair<Documento, ArrayList<Integer>>> llista) {
		d = llista;
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
	//retorna true si el nodo esta vacio
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

