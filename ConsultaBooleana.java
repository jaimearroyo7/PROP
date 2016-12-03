package dominio;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class ConsultaBooleana {
	private ArrayList<Documento> llista = new ArrayList<Documento>(); //llista conté tots els documents que compleixen lexpressio exp.
	private ExpBool exp = new ExpBool();
	
	//constructores
	public ConsultaBooleana() {
		
	}
	
	public ConsultaBooleana(Documentos docs, String  s) throws ParseException, IOException {
		exp.setExpresio(s);
		consulta(docs);
	}
	
	//publics
	//getter
	public ArrayList<Documento> getResult() {
		return llista;
	}
	
	//setter
	public void setExpresio (Documentos docs, String s) throws ParseException, IOException {
		exp.setExpresio(s);
		consulta(docs);
	}
	
	//privats
	
	//fa el NOT de un array: el resultat es un array amb tots els elements de complet que no estan en a.
	private ArrayList<Documento> notDocs(ArrayList<Documento> a, ArrayList<Documento> complet) {
		ArrayList<Documento> res = new ArrayList<Documento>();
		for (int i=0; i<a.size(); ++i) {
			if (!a.contains(complet.get(i))) res.add(complet.get(i));
		}
		return res;
	}
	
	//fa la AND de dos arrays: retorna un array amb els elements que estan en a i en b a la vegada.
	private ArrayList<Documento> andDocs (ArrayList<Documento> a, ArrayList<Documento> b) {
		ArrayList<Documento> res = new ArrayList<Documento>();
		for (int i = 0; i<a.size(); ++i) {
			if (b.contains(a.get(i))) res.add(a.get(i));
		}
		return res;
	}
	
	// fa la OR de dos arrays: el resultat es un array amb els elements de a i b que estan en a o que estan en b
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
	private ArrayList<Documento> filtra(ArrayList<Documento> ld, Element e) throws ParseException, IOException {
		Documentos conj = new Documentos();
		for (int i = 0; i<ld.size(); ++i) {
			conj.addDoc(ld.get(i));
		}
		String p = e.getElement();
		ArrayList<Documento> res = conj.getDiccionario().getDocumentosConPalabra(p);
		return res;
	}
	
	//omple latribut "llista" amb els documents que compleixen lexpressio booleana "exp".
	private void consulta(Documentos docs) throws ParseException, IOException {
		ArrayList<Documento> ld = docs.getDocs();
		ArrayList<Documento> act = ld;
		ArrayList<Documento> aux = new ArrayList<Documento>();
		ArrayList<Element> post = exp.getPost();
		boolean primer = true;
		
		for (int i = 0; i<exp.size(); ++i) {
			if (post.get(i).isPalabra()) {
				if (primer) {
					act = filtra(act, exp.get(0));
				}
				else {
					aux = filtra(act, exp.get(0));
				}
			}
			else {
				primer = false;
				if (post.get(i).isAnd()) { //AND --> guarda el resultat a act
					act = andDocs(act, aux);
				}
				else if (post.get(i).isOr()) { //OR --> guarda el resultat a act
					act = orDocs(act, aux);
				}
				else { //NOT --> guarda el resultat a act
					act = notDocs(act, docs.getDocs());
				}
			}
		}
		for (int j =  0; j<act.size(); ++j) {
			llista.add(act.get(j));
		}
	}
}
