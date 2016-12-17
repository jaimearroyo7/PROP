package dominio;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

public class ConsultaBooleana implements Serializable{
	private Documentos docs = new Documentos();
	private ExpBool exp = new ExpBool(); //L'arbre de "exp" guarda el resultat de la consulta
	private ArrayList<Pair<Documento, ArrayList<Integer>>> cmp = new ArrayList<Pair<Documento, ArrayList<Integer>>>();
	private ArrayList<String> nf = new ArrayList<String>();//llista de paraules no funcionals
	private ArrayList<Documento> result = new ArrayList<Documento>();
	//constructores
	public ConsultaBooleana() throws FileNotFoundException {
		cargaNF();
	}
	
	public ConsultaBooleana(Documentos docs, String  s) throws ParseException, IOException {
		exp.setExpresio(s);
		this.docs = docs;
		cargaNF();
		creaAcumulatComplet();
		consulta();
		for (int i=0; i<exp.getTree().getAcumulat().size(); ++i) {
			result.add(exp.getTree().getAcumulat().get(i).first());
		}
	}
	
	public ExpBool getExpBool(){
		return exp;
	}
	
	//publics
	//getter
	
	public ArrayList<Documento> getResult() {
		return result;
	}

	//setter
	public void setExpresio (Documentos docs, String s) throws ParseException, IOException {
		this.docs = docs;
		exp.setExpresio(s);
		creaAcumulatComplet();
		consulta();
		for (int i=0; i<exp.getTree().getAcumulat().size(); ++i) {
			result.add(exp.getTree().getAcumulat().get(i).first());
		}
	}
	
	//privats
	private void cargaNF() throws FileNotFoundException {
		String s;
	    FileReader f2 = new FileReader("src/dominio/lista");
	    BufferedReader b2 = new BufferedReader(f2);
	    try {
			while((s = b2.readLine())!=null) {
			     nf.add(s);
			 }
		} 
	    catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//retorna un array amb tots els identificadors de les frases del document "d"
	private ArrayList<Integer> getFrases(Documento d) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Frase> fr = d.getTexto().getListaFrases();
		for (int i = 0; i<fr.size(); ++i) {
			res.add(i);
		}
		return res;
	}
	
	//omple latribut cmp, que es una llista amb tots els documents i els identificadors de cada una de les seves frases
	private void creaAcumulatComplet() {
		for (int i=0; i<docs.getDocs().size(); ++i) {
			Pair<Documento, ArrayList<Integer>> aux = new Pair<Documento, ArrayList<Integer>>();
			aux.setFirst(docs.getDocs().get(i));
			aux.setSecond(getFrases(aux.first()));
			cmp.add(aux);
		}
	}
	
	//fa el NOT dun array: el resultat es un array amb tots els elements de "complet" que no estan en "a".
	// als docs de a, faig el not a les frases
	// afegeixo tots els docs que no hi son, amb totes les frases
	private ArrayList<Pair<Documento, ArrayList<Integer>>> notDocs(ArrayList<Pair<Documento, ArrayList<Integer>>> a) {
		ArrayList<Pair<Documento, ArrayList<Integer>>> res  = new ArrayList<Pair<Documento, ArrayList<Integer>>>();
		for (int k=0; k<cmp.size(); ++k) { //recorro tots els docs
			int contains = containsDoc(a, cmp.get(k).first()); 
			if (contains >= 0) {
				
				Pair<Documento, ArrayList<Integer>> aux = new Pair<Documento, ArrayList<Integer>>();
				aux.setFirst(cmp.get(k).first());
				aux.setSecond(notFrases(cmp.get(k).second(), a.get(contains).second()));
				if (aux.second().size() > 0) res.add(aux); 
			}
			else res.add(cmp.get(k));
		}
		return res;
	}
	
	//retorna un array amb els elements de "a"-"b"
	private ArrayList<Integer> notFrases(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> res = a;
		for (int i=0; i<b.size(); ++i) {
			if (a.contains(b.get(i))) res.remove(i);
		}
		return res;
	}
	
	//fa la AND de dos arrays: retorna un array amb els elements que estan en "a" i en "b" a la vegada.
	private ArrayList<Pair<Documento, ArrayList<Integer>>> andDocs (ArrayList<Pair<Documento, ArrayList<Integer>>> a, ArrayList<Pair<Documento, ArrayList<Integer>>> b) {
		ArrayList<Pair<Documento, ArrayList<Integer>>> res = new ArrayList<Pair<Documento, ArrayList<Integer>>>();
		for (int i = 0; i<a.size(); ++i) { //recorrem vector a
			Pair<Documento, ArrayList<Integer>> pa = a.get(i);
			int j=0;
			boolean trobat = false;
			while (!trobat && j<b.size()) {
				if (b.get(j).first() == pa.first()) {
					Pair<Documento, ArrayList<Integer>> paux = new Pair<Documento, ArrayList<Integer>>();
					paux.setFirst(pa.first());
					paux.setSecond(andFrases(pa.second(), b.get(j).second()));
					if (paux.second().size() != 0) {
						res.add(paux);
					}
				}
				++j;
			}
		}
		return res;
	}
	
	private ArrayList<Integer> andFrases(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i<a.size(); ++i) {
			if (b.contains(a.get(i))) res.add(a.get(i));
		}
		return res;
	}
	
	// fa la OR de dos arrays: el resultat es un array amb els elements de "a" i "b" que estan en "a" o que estan en "b" o en "a" i "b"
	private ArrayList<Pair<Documento, ArrayList<Integer>>> orDocs(ArrayList<Pair<Documento, ArrayList<Integer>>> a, ArrayList<Pair<Documento, ArrayList<Integer>>> b) {
		ArrayList<Pair<Documento, ArrayList<Integer>>> res = b;
		for (int i=0; i<a.size(); ++i) {
			int contiene = containsDoc(b, a.get(i).first());
			if (contiene >=0) {
				res.get(i).setSecond(orFrases(b.get(contiene).second(), a.get(i).second()));
			}
			else {
				res.add(a.get(i));
			}
		}
		return res;
	}
	
	//retorna un arraylist amb "a" + "b"
	private ArrayList<Integer> orFrases(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> res = a;
		for (int i = 0; i<b.size(); ++i) {
			if (!res.contains(b.get(i))) res.add(b.get(i));
		}
		return res;
	}
	
	// retorna -1 si larray no conte el document "d" i retorna la posicio en cas que larray contingui d
	private int containsDoc(ArrayList<Pair<Documento, ArrayList<Integer>>> b, Documento d) {
		int contiene = -1;
		int i=0;
		while (contiene<0 && i<b.size()) {
			if (b.get(i).first().equals(d)) contiene = i;
			++i;
		}
		return contiene;
	}
	
	//retorna la llista de documents que contenen la paraula "e" i en quina o quines frases la contenen cada un
	private ArrayList<Pair<Documento, ArrayList<Integer>>> filtra(Element e) throws ParseException, IOException {
		ArrayList<Pair<Documento, ArrayList<Integer>>> res = new ArrayList<Pair<Documento, ArrayList<Integer>>>();
		ArrayList<Documento> aux = docs.getDiccionario().getDocumentosConPalabra(e.getElement());
		for (int i=0; i<aux.size(); ++i) {
			Pair<Documento, ArrayList<Integer>> pair = new Pair<Documento, ArrayList<Integer>>();
			pair.setFirst(aux.get(i));
			pair.setSecond(getFrasesAmb(pair.first(), e));
			res.add(pair);
		}
		return res;
	}
	
	private boolean esFuncional(Palabra p) {
		String s = new String(p.getPalabra());
		for (int i=0; i<nf.size(); ++i) {
			if(s.equals(nf.get(i))){
				return false;
			}
		}
		return true;
	}
	
	//retorna una llista amb els documents i els identificadors de frase de on apareix la frase "e"
	private ArrayList<Pair<Documento, ArrayList<Integer>>> filtraFrase(Element e) throws ParseException, IOException {
		Frase f = new Frase();
		f.setFrase(e.getElement());
		ArrayList<Palabra> p = f.getListaPalabras(); //llista de paraules de la frase que busquem
		ArrayList<Palabra> p2 = new ArrayList<Palabra>(); //llista de paraules rellevants de la frase que busquem
		ArrayList<Pair<Documento, ArrayList<Integer>>> aux = new ArrayList<Pair<Documento, ArrayList<Integer>>>();
		ArrayList<Pair<Documento, ArrayList<Integer>>> aux2 = new ArrayList<Pair<Documento, ArrayList<Integer>>>();
		for (int a=0; a<p.size(); ++a) {
			if (esFuncional(p.get(a))) p2.add(p.get(a));
		}
		if (p2.size() >= 1) aux = filtra(p2.get(0).toElement());
		for (int i=1; i<p2.size(); ++i) {
			aux2 = filtra(p2.get(i).toElement());
			aux = andDocs(aux,aux2);
		}
		String buscat = f.getFrase();
		for (int j=0; j<aux.size(); ++j) { //recorre docs
			boolean trobat = false;
			int k=0;
			String text = aux.get(j).first().getTexto().getTexto();
			while (!trobat && k<aux.get(j).second().size()) {
				if (text.contains(buscat)) {
					trobat = true;
				}
				++k;
			}
			if (!trobat) {
				aux.remove(j);
			}
		}
		return aux;
	}
	
	//Donat un document i un element, retorna un array amb els identificados de les frases de "d" que contenen "e"
	private ArrayList<Integer> getFrasesAmb(Documento d, Element e) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Frase> fr = d.getTexto().getListaFrases();
		for (int i=0; i<fr.size(); ++i) {
			if (fr.get(i).contiene(e)) res.add(i);
		}
		return res;
	}
	
	//avalua larbre dexpressio "exp" i deixa el resultat en "acumulat", en cada un dels nodes de larbre. "acumulat" conte, per cada node,
	//una llista amb els documents que compleixen lexpressio booleana, independentment de si es compleixen en una mateixa frase o no.
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
				n.setAcumulat(filtraFrase(n.getInfo()));
			}
		}
	}
}
