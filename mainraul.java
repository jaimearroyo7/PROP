/*
package PROP;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class mainraul {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Documentos d = new Documentos();
		Scanner sc = new Scanner(System.in);
		Texto t = new Texto();
		int i = 0;
		String sf,q,h,p;
		while(true) {

			System.out.println("INDIQUE QUE QUIERE HACER:");
			System.out.println("(1) A�ADIR DOCUMENTO"
					+ " (2) MODIFICACION"
					+ " (3) CONSULTAS");
			sf = sc.nextLine();
			
			if(sf.equals("1")) {
				    System.out.println("A�ADIR DOCUMENTO:");
					Documento d1 = new Documento();
					System.out.println("Ingrese titulo:");
					d1.setTitulo(sc.nextLine());
					System.out.println("Ingrese autor:");
					d1.setAutor(sc.nextLine());
					System.out.println("Ingrese categoria:");
					d1.setCategoria(sc.nextLine());
					System.out.println("Ingrese texto(acabado en punto):");
					t.setTexto(sc.nextLine());
					d1.setTexto(t);
				    d.addDoc(d1);
			}
			
			else if(sf.equals("2")) { 

					System.out.println("MODIFICACION:");
					System.out.println("INDIQUE QUE QUIERE HACER:");
					System.out.println("(1) Borrar documento"
							+ " (2) Modificar documento");
					sf = sc.nextLine();
					if(sf.equals("1")) {
						System.out.println("BORRAR DOC:");
						System.out.println("Indique que i-�simo documento quiere borrar:");
						h = sc.nextLine();
						d.borrardoc(h);
					}
					else if(sf.equals("2")){
						System.out.println("MODIFICAR DOC:");
	
						System.out.println("Diga el titulo del documento a modificar:");
						sf = sc.nextLine();
						System.out.println("Diga el autor del documento a modificar:");
						h = sc.nextLine();
						System.out.println("Diga el campo que quiera modificar(titulo/autor/categoria/texto:");
						q = sc.nextLine();
						System.out.println("Escriba el valor o contenido del campo a modifcar");
						p = sc.nextLine();
						d.modificardoc(sf,h,q,p);
				}
				
			}
			else if(sf.equals("3")) {
					System.out.println("CONSULTAS:");
					System.out.println("INDIQUE QUE QUIERE HACER:");
					System.out.println("(1) CONSULTAR TITULOS DADO UN AUTOR"
							+ " (2) CONSULTAR LISTA DE AUTORES DE DOCUMENTOS DADO UN PREFIJO");
					System.out.println("(3) CONSULTAR LISTA DE TITULOS DE DOCUEMNTOS DADA SU FECHA"
							+ " (4) CONSULTAR CONTENIDO DE UN DOCUMENTO DADO SU TITULO Y SU AUTOR"
							+ " (5) CONSULTAR LISTA GENERAL DE DOCUMENTOS");
					sf = sc.nextLine();
					if(sf.equals("1")) {
						System.out.println("CONSULTAR TITULOS DADO UN AUTOR:");
						System.out.println("Ingrese autor para consulta:");
						sf = sc.nextLine();
						d.consultarTitulosAutor(sf);
					}
					else if(sf.equals("2")) {
						System.out.println("CONSULTAR LISTA DE AUTORES DE DOCUMENTOS DADO UN PREFIJO:");
						System.out.println("Ingrese prefijo a consultar:");
						sf = sc.nextLine();
						d.consultarAutoresPrefijo(sf);
					}
					else if(sf.equals("3")) {
						System.out.println("CONSULTAR LISTA DE TITULOS DE DOCUEMNTOS DADA SU FECHA:");
						System.out.println("Ingrese fecha a consultar:");
						System.out.println("dia:");
						sf = sc.nextLine();
						System.out.println("mes:");
						sf += sc.nextLine();
						System.out.println("a�o:");
						sf += sc.nextLine();
					    d.consultarTitulos(sf);
					}
					else if(sf.equals("4")) {
						System.out.println("CONSULTAR CONTENIDO DE UN DOCUMENTO DADO SU TITULO Y SU AUTOR:");
						System.out.println("Ingrese titulo:");
						sf = sc.nextLine();
						System.out.println("Ingrese autor:");
						q = sc.nextLine();
						d.consultarTextoDadoTituloAutor(sf,q);
					}
					else if(sf.equals("5")) {
						System.out.println("CONSULTAR LISTA GENERAL DE DOCUMENTOS:");
					    d.listadocs();
					}
			++i;
		}
	} // CERRAMOS WHILE DEL PROGRAMA EN SI
  } // MAIN
} // CODIGO
*/


			/*d.addDoc("C:/Users/JMC/workspace/Gestor de documentos/src/Dominio/prueba");*/
			/*d.consultarTitulo(i);
			d.consultarAutor(i);
			d.consultarCategoria(i);
			d.consultarFecha(i);
			d.consultarTexto(i);*/
			
			
