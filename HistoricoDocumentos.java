//package dominio;

import java.util.ArrayList;



public class HistoricoDocumentos {
	private ArrayList<Documento> historial = new ArrayList<>();
	
	//Constructores
	public HistoricoDocumentos(){
		
	}
	
	public HistoricoDocumentos(ArrayList<Documento> lista){
		setHistorial(lista);
	}
	
	//devuelve si la fecha de d1 es mas reciente que la de d2
	boolean greater(Documento d1, Documento d2){
		Fecha f1 = d1.getFecha();
		Fecha f2 = d2.getFecha();
		int suma1 = f1.getYear()*1000 + f1.getMonth()*40 + f1.getDay();
		int suma2 = f2.getYear()*1000 + f2.getMonth()*40 + f2.getDay();
		if(suma1>suma2){
			return true;
		}
		else return false;
	}
	
	//funcion que devuelve el documento con la fecha mas reciente y su posicion en el array
	Pair<Documento, Integer> getMax(ArrayList<Documento> lista){
		Documento max = lista.get(0);
		Integer pos = 0;
		for(int i = 1; i < lista.size(); ++i){
			if(greater(lista.get(i), max)) {
				max = lista.get(i);
				pos = i;
			}
		}
		Pair<Documento, Integer> pair = new Pair<>();
		pair.setFirst(max);
		pair.setSecond(pos);
		return pair;
	}
	
	//A partir de una lista de documentos, coge los 10 mas recientes
	public void setHistorial(ArrayList<Documento> lista){
		//Arrays.sort(ordenado, dominio.Documento.comparador);
		ArrayList<Documento> lista2 = lista;
		int N = 10;
		if(lista.size() < 10) { N = lista.size(); }
		
		for(int j = 0; j < N; ++j){
			Pair<Documento, Integer> pair = getMax(lista2);
			historial.add(pair.first());
			int m = pair.second();
			lista2.remove(m);
			
			//System.out.println("");
		}
		
	}
	
	public ArrayList<Documento> getHistorial() { return historial; }
}
