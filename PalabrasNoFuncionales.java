package PROP;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PalabrasNoFuncionales {

		private ArrayList<String> lista = new ArrayList<>();
		
		public PalabrasNoFuncionales() throws IOException{
		String castellano;
	     FileReader f2 = new FileReader("src/dominio/lista");
	     BufferedReader b2 = new BufferedReader(f2);
	     try {
			while((castellano = b2.readLine())!=null) {
			     lista.add(castellano);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     b2.close();
}
		
		public ArrayList<String> getPalabrasNoFuncionales(){
			return lista;
		}
}

