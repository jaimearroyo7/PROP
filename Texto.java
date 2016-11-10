package dominio;

import java.util.ArrayList;

public class Texto {
	
	private String texto;
	private ArrayList<Frase> listafrases = new ArrayList<>();
	
	//constructores
	public Texto(){
		
	}
	
	public Texto(String valortexto){
		
		setTexto(valortexto);
	}
	
	//se le da valor al string texto y se forma la lista de frases
	public void setTexto(String valortexto){
		texto = valortexto;
		listafrases.clear();
		String separador = ".!?";
		//char[] separador = new char[] {'.', '!', '?'};
		int iniciofrase=0;
		
		for(int i = 0; i < texto.length(); ++i){
			String fraseactual;
			if(separador.contains(String.valueOf(texto.charAt(i)))){
				fraseactual = texto.substring(iniciofrase,i+1);
				
				if(i+1 < texto.length() && texto.charAt(i+1) == '.'){
					++i;
					fraseactual = texto.substring(iniciofrase,i+2);
					iniciofrase = i+3;
					} 
				else iniciofrase = i+2;
				++i;
				Frase frase = new Frase(fraseactual);
				listafrases.add(frase);
			}
		}
	}
	
	//getters
	public String getTexto() { return texto; }
	public ArrayList<Frase> getListaFrases() { return listafrases;}
	
}
