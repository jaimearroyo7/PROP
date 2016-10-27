import java.util.ArrayList;
import java.util.Arrays;

public class Texto {
	
	private String texto;
	private ArrayList<String> listafrases;
	
	public Texto(){
		
	}
	
	public Texto(String valortexto){
		texto = valortexto;
		setTexto(valortexto);
	}
	
	public void setTexto(String valortexto){
		texto = valortexto;
		char[] separador = {'.', '!', '?'};
		String frase;
		int iniciofrase=0;
		for(int i = 0; i < texto.length(); ++i){
			String fraseactual;
			if(Arrays.asList(separador).contains(texto.charAt(i))){
				fraseactual = texto.substring(iniciofrase,i);
				iniciofrase = i+1;
				++i;
				//frase = new Frase(fraseactual);
				listafrases.add(fraseactual);
			}
		}
	}
	
	public String getTexto() { return texto; }
	public ArrayList<String> getListaFrases() { return listafrases;}
	
}
