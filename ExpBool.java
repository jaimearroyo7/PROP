package Dominio;
import java.util.*;

public class ExpBool {
	private String s;
	private Nodo raiz;	//tree es el nodo raíz del árbol que almacena la expresión booleana.
	
	//constructoras
	public ExpBool() {}
	public ExpBool(String s) {
		this.s = s;
		buildTree(this.s);
	}
	public void buildTree (String s) {
		
	}
}
