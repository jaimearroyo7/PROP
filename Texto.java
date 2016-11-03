package dominio;

import dominio.Frase;

import java.util.ArrayList;

public class Texto {
	
	private String texto;
	private ArrayList<Frase> listafrases = new ArrayList<>();
	
	public Texto(){
		
	}
	
	public Texto(String valortexto){
		
		setTexto(valortexto);
		//listafrases.add("hola");
	}
	
	public void setTexto(String valortexto){
		texto = valortexto;
		String separador = ".!?";
		//char[] separador = new char[] {'.', '!', '?'};
		int iniciofrase=0;
		
		for(int i = 0; i < texto.length(); ++i){
			String fraseactual;
			if(separador.indexOf(texto.charAt(i)) != -1){
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
	
	public String getTexto() { return texto; }
	public ArrayList<Frase> getListaFrases() { return listafrases;}
	
}
