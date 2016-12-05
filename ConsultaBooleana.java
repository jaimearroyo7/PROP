package dominio;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class ConsultaBooleana {
	Documentos docs = new Documentos();
	private ExpBool exp = new ExpBool();
	
	//constructores
	public ConsultaBooleana() {}
	
	public ConsultaBooleana(Documentos docs, String  s) throws ParseException, IOException {
		exp.setExpresio(s);
		this.docs = docs;
		consulta();
	}
	
	//publics
	//getter
	//retorna el resultat de la consulta booleana en forma de llista de documents
	public ArrayList<Documento> getResult() {
		return exp.getTree().getAcumulat();
	}
	
	//setter
	public void setExpresio (Documentos docs, String s) throws ParseException, IOException {
		this.docs = docs;
		exp.setExpresio(s);
		consulta();
	}
	
	//privats
	
	//fa el NOT dun array: el resultat es un array amb tots els elements de "complet" que no estan en "a".
	private ArrayList<Documento> notDocs(ArrayList<Documento> a) {
		ArrayList<Documento> res = docs.getDocs();
		for (int i=0; i<res.size(); ++i) {
			if (a.contains(res.get(i))) res.remove(res.get(i));
		}
		return res;
	}
	
	//fa la AND de dos arrays: retorna un array amb els elements que estan en "a" i en "b" a la vegada.
	private ArrayList<Documento> andDocs (ArrayList<Documento> a, ArrayList<Documento> b) {
		ArrayList<Documento> res = new ArrayList<Documento>();
		for (int i = 0; i<a.size(); ++i) {
			if (b.contains(a.get(i))) res.add(a.get(i));
		}
		return res;
	}
	
	// fa la OR de dos arrays: el resultat es un array amb els elements de "a" i "b" que estan en "a" o que estan en "b"
	private ArrayList<Documento> orDocs (ArrayList<Documento> a, ArrayList<Documento> b) {
		ArrayList<Documento> res = a;
		for (int i = 0; i<b.size(); ++i) {
			if (!res.contains(b.get(i))) res.add(b.get(i));
		}
		return res;
	}
	
	//retorna true si s'ha trobat una FRASE al document "d" que compleix lexpressio "exp" 
	/*private boolean DocumentCompleixExpEnFrase(Documento d) {
		ArrayList<Element> post = exp.getPost(); // array amb l'expresio booleana en postordre
		boolean compleix = false;
		ArrayList<Frase> frases = d.getTexto().getListaFrases(); //llista amb les frases del text
		ArrayList<Integer> acum = new ArrayList<Integer>();
		ArrayList<Integer> aux = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (j<post.size()) { // per cada element de lexpresio
			Element e = post.get(j); //element actual del recorregut en postordre
			while (i<frases.size()) { // recorrem totes les frases
				Frase act = frases.get(i);
				if (e.isPalabra()) { //si es una paraula
					if (acum.size() == 0 && act.contiene(e)) acum.add(i);
					else if (act.contiene(e)) aux.add(i);
				}
				else if (e.isFrase()) {
					
				}
				else if (e.isOperador()) {
					if (e.isaNot()) { // NOT
						acum = notDocs(acum, aux);
					}
					else if (e.isAnd()) { //AND
						acum = andFrases(acum, aux);
					}
					else { //OR
						acum = orFrases(acum, aux);
					}
				}
				++i;
			}
			++j;
		}

		if (acum.size() > 0) compleix = true;
		return compleix;
	}*/
	
	//retorna la llista de documents que contenen la paraula "e"
	private ArrayList<Documento> filtra(Element e) throws ParseException, IOException {
		String p = e.getElement();
		ArrayList<Documento> res = docs.getDiccionario().getDocumentosConPalabra(p);
		return res;
	}
	
	//avalua larbre dexpressio "exp"
	private void consulta() throws ParseException, IOException {
		Nodo raiz = exp.getTree();
		if (raiz != null) avalua(raiz);
	}
	
	private void avalua(Nodo n) throws ParseException, IOException {
		if (n != null) {
			avalua(n.getfe());
			avalua(n.getfd());
			if (n.getInfo().isPalabra()) { //si estic en una fulla de tipus paraula
				n.setAcumulat(filtra(n.getInfo()));
			}
			else if (n.getInfo().isOperador()) { //si NO estic en una fulla
				if (n.getInfo().isAnd()) {
					n.setAcumulat(andDocs(n.getfe().getAcumulat(), n.getfd().getAcumulat()));
				}
				else if (n.getInfo().isOr()) {
					n.setAcumulat(orDocs(n.getfe().getAcumulat(), n.getfd().getAcumulat()));
				}
				else if (n.getInfo().isaNot()) {
					n.setAcumulat(notDocs(n.getfe().getAcumulat()));
				}
			}
			else { //node fulla de tipus frase
				
			}
		}
	}
}
