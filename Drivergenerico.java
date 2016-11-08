package dominio;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Drivergenerico {
	
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException, ParseException {
		Documentos d = new Documentos();
		Scanner sc = new Scanner(System.in);
		Texto t;
		int i = 0;
		String sf,q,h,p;
		String opcion,opcion2;
		opcion = opcion2 = "0";
		
		while(opcion != "4") {

			System.out.println("INDIQUE QUE QUIERE HACER:");
			System.out.println("(1) AÑADIR DOCUMENTO"
					+ " (2) MODIFICACION"
					+ " (3) CONSULTAS"
					+ " (4) SALIR DEL SISTEMA");
			opcion = sc.nextLine();
			switch (opcion) {
            	case "1": 
			            System.out.println("AÑADIR DOCUMENTO:");
						Documento d1 = new Documento();
						System.out.println("Ingrese titulo:");
						d1.setTitulo(sc.nextLine());
						System.out.println("Ingrese autor:");
						d1.setAutor(sc.nextLine());
						System.out.println("Ingrese categoria:");
						d1.setCategoria(sc.nextLine());
						try {
							System.out.println("Ingrese texto(acabado en punto,excepto si !/?):");
							t = new Texto();
							KeyEvent e = null;
							boolean sortir = false;
							while(sc.hasNext() && !sortir) {
								t.setTexto(sc.nextLine());
								if(e.getKeyCode()== KeyEvent.VK_ESCAPE) sortir = true; 
								else sc.skip("\n");
							}
						} 
						catch (Exception e) {
						    System.out.println ("El error es: " + e.getMessage());
						    //e.printStackTrace();
						    opcion = "1";
						    System.out.println ("Vuelva a añadir el documento en su formato requerido");
						    break;
						}
						d1.setTexto(t);
					    d.addDoc(d1);
					    break;
            	case "2": 
		            	System.out.println("MODIFICACION:");
						System.out.println("INDIQUE QUE QUIERE HACER:");
						System.out.println("(1) Borrar documento"
								+ " (2) Modificar documento");
						opcion2 = sc.nextLine();
						switch(opcion2) {
							case "1":
									System.out.println("BORRAR DOC:");
									System.out.println("Diga el titulo del documento a borrar:");
									sf = sc.nextLine();
									System.out.println("Diga el autor del documento a borrar:");
									h = sc.nextLine();
									d.borrardoc(sf,h);
									break;
							case "2":
									System.out.println("MODIFICAR DOC:");
				
									System.out.println("Diga el titulo del documento a modificar:");
									sf = sc.nextLine();
									System.out.println("Diga el autor del documento a modificar:");
									h = sc.nextLine();
									System.out.println("Diga el campo que quiera modificar(titulo/autor/categoria/texto):");
									q = sc.nextLine();
									System.out.println("Escriba el valor o contenido del campo a modifcar");
									p = sc.nextLine();
									d.modificardoc(sf,h,q,p);
									break;
							default: break;
						}
						break;
			case "3":
					System.out.println("CONSULTAS:");
					System.out.println("INDIQUE QUE QUIERE HACER:");
					System.out.println("(1) CONSULTAR TITULOS DADO UN AUTOR"
							+ " (2) CONSULTAR LISTA DE AUTORES DE DOCUMENTOS DADO UN PREFIJO");
					System.out.println("(3) CONSULTAR LISTA DE TITULOS DE DOCUEMNTOS DADA SU FECHA"
							+ " (4) CONSULTAR CONTENIDO DE UN DOCUMENTO DADO SU TITULO Y SU AUTOR");
					System.out.println("(5) CONSULTAR LISTA GENERAL DE DOCUMENTOS"
							+ " (6) NUMERO DE APARICIONES EN DOCUMENTOS DADA UNA PALABRA");
					opcion2 = sc.nextLine();
					switch(opcion2) {
							 case "1":
									System.out.println("CONSULTAR TITULOS DADO UN AUTOR:");
									System.out.println("Ingrese autor para consulta:");
									sf = sc.nextLine();
									d.consultarTitulosAutor(sf);
									break;
							 case "2":
									System.out.println("CONSULTAR LISTA DE AUTORES DE DOCUMENTOS DADO UN PREFIJO:");
									System.out.println("Ingrese prefijo a consultar:");
									sf = sc.nextLine();
									d.consultarAutoresPrefijo(sf);
									break;
							 case "3":
									System.out.println("CONSULTAR LISTA DE TITULOS DE DOCUEMNTOS DADA SU FECHA:");
									System.out.println("Ingrese fecha a consultar:");
									System.out.println("dia:");
									sf = sc.nextLine();
									System.out.println("mes:");
									sf += sc.nextLine();
									System.out.println("año:");
									sf += sc.nextLine();
								    d.consultarTitulos(sf);
								    break;
							 case "4":
									System.out.println("CONSULTAR CONTENIDO DE UN DOCUMENTO DADO SU TITULO Y SU AUTOR:");
									System.out.println("Ingrese titulo:");
									sf = sc.nextLine();
									System.out.println("Ingrese autor:");
									q = sc.nextLine();
									d.consultarTextoDadoTituloAutor(sf,q);
									break;
							 case "5":
									System.out.println("CONSULTAR LISTA GENERAL DE DOCUMENTOS:");
								    d.listadocs();
								    break;
							 case "6":
								 System.out.println("NUMERO DE APARICIONES EN DOCUMENTOS DADA UNA PALABRA:");
								 sf = sc.nextLine();
								 d.consultarDiccionario(sf);
								 break;
							 default: break;
					}
					break;
			    case "4": opcion= "4"; break;
				default: break;
			}
			++i;
	} // CERRAMOS WHILE DEL PROGRAMA EN SI
		System.out.println("GRACIAS POR USAR NUESTRO PROGRAMA");
  } // MAIN
} // CODIGO



			/*d.addDoc("C:/Users/JMC/workspace/Gestor de documentos/src/Dominio/prueba");*/
			/*d.consultarTitulo(i);
			d.consultarAutor(i);
			d.consultarCategoria(i);
			d.consultarFecha(i);
			d.consultarTexto(i);*/
			
			
