package dominio;


import java.io.BufferedReader;
import java.io.FileReader;
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
	
	//Constructores, vacio y pasandole los parametros
	
	public Documento(){
		
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
	
	
	//retorna un arraylist con las palabras del texto y su frecuencia
	public ArrayList<Pair<String, Integer>> getPalabras() {
		return palabras;
	}

	
	//setters
	public void setTitulo(String valortitulo){
		titulo = valortitulo;
		Fecha ahora = new Fecha();
		fecha = ahora;
	}
	
	public void setFecha(){
		fecha.setFecha();
	}
	
	public void setFechaManual(int day, int month, int year){
		fecha.setFechaManual(day, month, year);
	}
	
	public void setAutor(String valorautor){
		autor = valorautor;
		Fecha ahora = new Fecha();
		fecha = ahora;
	}
	
	public void setCategoria(String valorcategoria){
		categoria = valorcategoria;
		Fecha ahora = new Fecha();
		fecha = ahora;
	}
	
	//dado un string y un arraylist de palabras no funcionales, dice si lo es o no
	boolean esfuncional(String s, ArrayList<String> nf) throws IOException{
		for(int i = 0; i < nf.size(); ++i){
			if(s.equals(nf.get(i))){
				return false;
			}
		}
		return true;
	}
	
	//da valor al campo texto y forma el arraylist de palabras con su frecuencia
	//descartando las no funcionales
	public void setTexto(Texto valorTexto) throws IOException{
		texto = valorTexto;
		palabras.clear();
		ArrayList<Frase> frases = texto.getListaFrases();
		ArrayList<String> nf = new ArrayList<String>();
		String castellano;
	     FileReader f2 = new FileReader("dominio/lista");
	     BufferedReader b2 = new BufferedReader(f2);
	     try {
			while((castellano = b2.readLine())!=null) {
			     nf.add(castellano);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < frases.size(); ++i){
			ArrayList<Palabra> listapalabras = frases.get(i).getListaPalabras();
			for(int j = 0; j < listapalabras.size(); ++j){
				String actual = listapalabras.get(j).getPalabra();
				
				Integer found = 0;
				if(esfuncional(actual, nf)){
                    for(int k = 0; k < palabras.size() && found == 0; ++k){
                        if(actual.equals(palabras.get(k).first())){
                            palabras.get(k).setSecond(palabras.get(k).second() + 1);
                            found = 1;
                            //System.out.println(palabras.get(k).first());
                        }
                    }

                    if(found == 0){
                    Pair<String, Integer> pair = new Pair<String, Integer>();
                    pair.setFirst(actual);
                    pair.setSecond(1);
                    palabras.add(pair);
                    }
			    }
			}
		}
		Fecha ahora = new Fecha();
		fecha = ahora;
	}
	
	//getters
	
	public String getTitulo() { return titulo; }
	
	public String getAutor() { return autor; }
	
	public String getCategoria() { return categoria; }
	
	public Texto getTexto() { return texto; }
	
	public Fecha getFecha() { return fecha; }
	
	public String getFechatoString() { 
		String s;
		s = Integer.toString(fecha.getDay());
		s += Integer.toString(fecha.getMonth());
		s += Integer.toString(fecha.getYear());
		return s;
				
	}
	
	
}