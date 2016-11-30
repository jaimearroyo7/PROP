package dominio;
import java.util.*;

public class consultaBooleana {
	private ArrayList<Documento> llista = new ArrayList<Documento>();
	private ExpBool exp = new ExpBool();
	
	//constructora
	public consultaBooleana(Documentos docs, String  s) {
		exp.setExpresio(s);
		consulta(docs);
	}
	
	//getter
	public ArrayList<Documento> getResult() {
		return llista;
	}
	
	//setter
	public void setExpresio (Documentos docs, String s) {
		exp.setExpresio(s);
		consulta(docs);
	}
	
	private ArrayList<Integer> frasesComplementaries(ArrayList<Integer> a, ArrayList<Frase> f) {
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i=0; i<a.size()+f.size(); ++i) {
			if (!f.contains(i)) b.add(i);
		}
		return b;
	}
	private ArrayList<Integer> andFrases (ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int sa = a.size();
		int sb = b.size();
		int min = min(sa, sb);
		for (int i = 0; i<min; ++i) {
			if (sa>sb) {
				if (a.contains(b.get(i))) res.add(b.get(i));
			}
			else {
				if (b.contains(a.get(i))) res.add(a.get(i));
			}
		}
		return res;
	}
	
	private ArrayList<Integer> orFrases (ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> res = a;
		for (int i = 0; i<b.size(); ++i) {
			if (!a.contains(b.get(i))) a.add(b.get(i));
		}
		return res;
	}
	
	//privats
	//retorna true si s'ha trobat un o mes documents que compleixin l'expresio en una frase. 
	private boolean busca(Documento d) {
		ArrayList<Element> post = exp.getPost(); // operacions a realitzar
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
						acum = frasesComplementaries(acum, frases);
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
	}
	
	private void consulta(Documentos docs) {
		ArrayList<Documento> ld = docs.getDocs(); //llistat de documents que evaluarem 
		int i = 0;
		while (i<ld.size()) { //para cada documento comprovamos la expresion en una misma frase
			boolean trobat = false;
			Documento d = ld.get(i);
			trobat = busca(d);
			if (trobat) llista.add(d);
			++i;
		}
	}
	private int min (int a, int b) {
		if (a>b) return b;
		else return a;
	}
}
