import java.utils.List;

public class Palabra {
	
	private String pal;
	private int tam;
	
	public Palabra(){};
	
	public void setPalabra(String valorpalabra) {
		pal = valorpalabra;
	}
	
	public String getPalabra() {
		return pal;
	}
	
	public int mida() {
		return pal.length();
	}
	public bool compare(String pal2) {
		return pal.equals(pal2)
	}
}
