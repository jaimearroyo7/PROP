
package PROP;
import java.awt.event.KeyEvent;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class DriverGenerico {
	
	public static void main(String[] args) throws IOException, ParseException {
		Documentos d = new Documentos();
		Scanner sc = new Scanner(System.in);
		Texto t;
		int i = 0;
		String sf,q,h,p, m;
		String opcion,opcion2;
		opcion = opcion2 = "0";
        ConsultaDocumentosParecidos.TFIDF_MODE mode;
		
		while(opcion != "4") {

			System.out.println("INDIQUE QUE QUIERE HACER:");
			System.out.println("(1) ANADIR DOCUMENTO"
					+ " (2) MODIFICACION"
					+ " (3) CONSULTAS"
					+ " (4) SALIR DEL SISTEMA");
			opcion = sc.nextLine();
			switch (opcion) {
            	case "1": 
			            System.out.println("ANADIR DOCUMENTO:");
						Documento d1 = new Documento();
						System.out.println("Ingrese titulo:");
						d1.setTitulo(sc.nextLine());
						System.out.println("Ingrese autor:");
						d1.setAutor(sc.nextLine());
						System.out.println("Ingrese categoria:");
						d1.setCategoria(sc.nextLine());
						try {
							System.out.println("Ingrese texto(acabado en punto,excepto si !/?, para acabar escriba: FIN):");
							t = new Texto();
							String j = sc.nextLine();
							String total = "";
							while(!j.endsWith("FIN")) { 
									
								    if(j.isEmpty()) {
								    	total += System.getProperty("line.separator");
								    	total += System.getProperty("line.separator");
								    }
								    else total += j;
									j = sc.nextLine();
							}
							t.setTexto(total);
						} 
						catch (Exception e) {
						    System.out.println ("El error es: " + e.getMessage());
						    opcion = "1";
						    System.out.println ("Vuelva a anadir el documento en su formato requerido");
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
									if(q.equals("texto")) {
											
										try {
											p ="";
											String j = sc.nextLine();
											while(!j.endsWith("FIN")) { 
													
												    if(j.isEmpty()) {
												    	p += System.getProperty("line.separator");
												    	p += System.getProperty("line.separator");
												    }
												    else p += j;
													j = sc.nextLine();
											}
										}
										 
										catch (Exception e) {
										    System.out.println ("El error es: " + e.getMessage());
										    opcion = "2";
										    System.out.println ("Vuelva a anadir el documento en su formato requerido");
										    break;
										}
									}
									else p = sc.nextLine();
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
					System.out.println("(5) CONSULTAR LISTA GENERAL DE LOS ULTIMOS DOCUMENTOS"
							+ " (6) NUMERO DE APARICIONES EN DOCUMENTOS DADA UNA PALABRA"
							+ " (7) CONSULTA LOS K DOCUMENTOS MAS PARECIDOS DADO UN TITULO Y AUTOR");
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
									System.out.println("day:");
									sf = sc.nextLine();
									System.out.println("month:");
									sf += sc.nextLine();
									System.out.println("year:");
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
									System.out.println("CONSULTAR LISTA GENERAL DE LOS ULTIMOS DOCUMENTOS:");
									System.out.println("Ingrese numero de documentos maximos que desea ver:");
									sf = sc.nextLine();
								    d.listadocs(sf);
								    break;
							 case "6":
								 System.out.println("NUMERO DE DOCUMENTOS DONDE APARECE DADA UNA PALABRA(RELEVANTE):");
								 sf = sc.nextLine();
								 d.consultarDiccionario(sf);
								 break;
							 case "7":
								 System.out.println("CONSULTA LOS K DOCUMENTOS MAS PARECIDOS DADO UN TITULO Y AUTOR");
								 System.out.println("Ingrese titulo:");
								 sf = sc.nextLine();
								 System.out.println("Ingrese autor:");
								 q = sc.nextLine();
                                 System.out.println("Ingrese metodo para calcular tfidf\n"
                                    + "log\n"
                                    + "bool");
                                 m = sc.nextLine();
                                 if (m.equals("log")) mode = ConsultaDocumentosParecidos.TFIDF_MODE.LOG;
                                 else if (m.equals("bool")) mode = ConsultaDocumentosParecidos.TFIDF_MODE.BOOLEAN;
                                 else  {
                                     System.out.println("Modo incorrecto (por defecto se ejecutará logarítmico)");
                                     mode = ConsultaDocumentosParecidos.TFIDF_MODE.LOG;
                                 }
                                 System.out.println("Ingrese cuantos n documentos parecidos quiere obtener:");
								 h = sc.nextLine();
								 d.consultardocumentosparecidos(sf,q,h, mode);
								 break;
							 default: break;
					}
					break;
			    case "4": opcion= "4"; break;
				default: break;
			}
			++i;
	} 
	sc.close();
	System.out.println("GRACIAS POR USAR NUESTRO PROGRAMA");
  }
} 
