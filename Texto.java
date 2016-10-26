import java.util.List;

public class Texto {
	private List<Frase> texto;
	
	public Texto(){
		
	}
	
	public void setTexto(List valortexto){
		texto = valortexto;
	}
	
	public List getTexto() { return texto; }
	
	public void addFrase(int i, Frase frase){
		texto.add(i,frase);
	}
}
