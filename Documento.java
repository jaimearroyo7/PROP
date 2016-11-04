package dominio;

import java.io.IOException;
import java.util.ArrayList;


public class Documento {
	private String titulo;
	private String autor;
	private String categoria;
	private Texto texto;
	private Fecha fecha;
	//private ArrayList<dominio.Pair<String, Integer>> palabras = new ArrayList<>();
	private ArrayList<Pair<String, Integer>> palabras = new ArrayList<Pair<String, Integer>>();
	
	public Documento(){
		
	}

	public ArrayList<Pair<String, Integer>> getPalabras() {
		return palabras;
	}

	public Documento(String valortitulo, String valorautor, String valorcategoria, String valorTexto) throws IOException{
		setTitulo(valortitulo);
		setAutor(valorautor);
		setCategoria(valorcategoria);
		Fecha ahora = new Fecha();
		fecha = ahora;
		Texto texto = new Texto(valorTexto);
		setTexto(texto);
	}
	
	public void setTitulo(String valortitulo){
		titulo = valortitulo;
	}
	
	public void setFecha(){
		fecha.setFecha();
	}
	
	/*public void setFechaManual(int day, int month, int year){
		fecha.setFechaManual(day, month, year);
	}*/
	
	public void setAutor(String valorautor){
		autor = valorautor;
	}
	
	public void setCategoria(String valorcategoria){
		categoria = valorcategoria;
	}
	
	boolean esfuncional(String s) throws IOException{
		PalabrasNoFuncionales p = new PalabrasNoFuncionales();
		ArrayList<String> nf = p.getPalabrasNoFuncionales();
		for(int i = 0; i < nf.size(); ++i){
			if(s.equals(nf.get(i))){
				return false;
			}
		}
		return true;
	}
	
	public void setTexto(Texto valorTexto) throws IOException{
		texto = valorTexto;
		ArrayList<Frase> frases = texto.getListaFrases();
		for(int i = 0; i < frases.size(); ++i){
			ArrayList<Palabra> listapalabras = frases.get(i).getListaPalabras();
			for(int j = 0; j < listapalabras.size(); ++j){
				String actual = listapalabras.get(j).getPalabra();
				
				Integer found = 0;
				if(esfuncional(actual)){
				for(int k = 0; k < palabras.size() && found == 0; ++k){
					if(actual.equals(palabras.get(k).first())){
						palabras.get(k).setSecond(palabras.get(k).second() + 1);
						found = 1;
						//System.out.println(palabras.get(k).first());
					}
				}
				
				if(found == 0){
				Pair<String, Integer> pair = new Pair<>();
				pair.setFirst(actual);
				pair.setSecond(1);
				palabras.add(pair);}
				
			}
			}
		}
	}
	
	public ArrayList<Pair<String, Integer>> getfrecuencia(){ return palabras; }
	
	public String getTitulo() { return titulo; }
	
	public String getAutor() { return autor; }
	
	public String getCategoria() { return categoria; }
	
	public Texto getTexto() { return texto; }
	
	public Fecha getFecha() { return fecha; }
	
	/*public static Comparator<dominio.Documento> comparador = new Comparator <dominio.Documento>(){
		public int compare(dominio.Documento d1, dominio.Documento d2){
			dominio.Fecha f1 = d1.getFecha();
			dominio.Fecha f2 = d2.getFecha();
			if(f1.getYear() != f2.getYear()){
				if(f1.getYear() < f2.getYear()){
					return 1;
				}
				else return 0;
			}
			if(f1.getMonth() != f2.getMonth()){
				if(f1.getMonth() < f2.getMonth()){
					return 1;
				}
				else return 0;
			}
			if(f1.getDay() != f2.getDay()){
				if(f1.getDay() < f2.getDay()){
					return 1;
				}
				else return 0;
			}
			return 0;
		}
		
	};*/
	
}
	

