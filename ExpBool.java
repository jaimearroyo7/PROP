package Dominio;
import java.util.*;

public class ExpBool {
	private String s;
	private Nodo raiz;	//tree es el nodo ra�z del �rbol que almacena la expresi�n booleana.
	
	//constructoras
	public ExpBool() {}
	public ExpBool(String s) {
		this.s = s;
		buildTree(this.s);
	}
	public void buildTree (String s) {
		
	}
}
