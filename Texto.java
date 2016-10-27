import java.util.ArrayList;
import java.util.Arrays;

public class Texto {
	
	private String texto;
	private ArrayList<String> listafrases = new ArrayList<>();
	
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
				listafrases.add(fraseactual);
			}
		}
	}
	
	public String getTexto() { return texto; }
	public ArrayList<String> getListaFrases() { return listafrases;}
	
}
