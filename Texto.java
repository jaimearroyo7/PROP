package dominio;

//import dominio.Frase;

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
			
			if(separador.indexOf(texto.charAt(i)) != -1){
				String fraseactual;
				fraseactual = texto.substring(iniciofrase,i+1);
				if(i+1 < texto.length() && texto.charAt(i+1) == 32){
					++i;
				}
				iniciofrase = i+1;
				if((fraseactual.equals(".") == false) && (fraseactual.equals("!") == false) && (fraseactual.equals("?") == false)){
				Frase frase = new Frase(fraseactual);
				listafrases.add(frase);
				}
			}
		}
		if(separador.indexOf(texto.charAt(texto.length()-1)) == -1){
			String ultima = texto.substring(iniciofrase, texto.length());
			Frase f = new Frase(ultima);
			listafrases.add(f);
		}
	}
	
	//getters
	public String getTexto() { return texto; }
	public ArrayList<Frase> getListaFrases() { return listafrases;}
	
}
