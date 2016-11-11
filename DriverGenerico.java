package dominio;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class DriverGenerico {
	
	public static void main(String[] args) throws IOException, ParseException {
		Documentos d = new Documentos();
		Scanner sc = new Scanner(System.in);
		Texto t = new Texto();
		String sf,q,h,p,m;
		String opcion,opcion2;
		opcion = opcion2 = "0";
		ArrayList<String> l1 = new ArrayList<String>();
		ArrayList<Pair<String,Fecha>> lp = new ArrayList<Pair<String,Fecha>>();
		ArrayList<Pair<String,String>> lp2 = new ArrayList<Pair<String,String>>();
		int v = 0;
		Fecha f;
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
							System.out.println("Ingrese texto(para acabar escriba: FIN):");
							System.out.println("Si quiere hacer un salto de linea dar 2 veces al enter");
							String j = sc.nextLine();
							String total = "";
							t = new Texto();
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
					    if(d.addDoc(d1) == -1) System.out.println("Ya existe un documento con el mismo titulo y autor.");
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
									if(d.borrardoc(sf,h) == -1) System.out.println("No existe documento a borrar");
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
										System.out.println("Ingrese texto(para acabar escriba: FIN):");
										System.out.println("Si quiere hacer un salto de linea dar 2 veces al enter");
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
									v = d.modificardoc(sf,h,q,p);
									if(v == -1) System.out.println("No se existe el documento a modifficar");
									else if(v == -2) System.out.println("El campo introducido no es valido");
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
					System.out.println("(5) CONSULTAR LISTA DE LOS ULTIMOS 10 DOCUMENTOS:"
							+ " (6) NUMERO DE APARICIONES EN DOCUMENTOS DADA UNA PALABRA"
							+ " (7) CONSULTA LOS K DOCUMENTOS MAS PARECIDOS DADO UN TITULO Y AUTOR");
					opcion2 = sc.nextLine();
					switch(opcion2) {
							 case "1":
									System.out.println("CONSULTAR TITULOS DADO UN AUTOR:");
									System.out.println("Ingrese autor para consulta:");
									sf = sc.nextLine();
									l1 = d.consultarTitulosAutor(sf);
									if(!l1.isEmpty()) {
										for(v = 0; v < l1.size(); ++v) {
											System.out.println(l1.get(v));
										}
									}
									else System.out.println("No tiene titulos de documentos");
									
									break;
							 case "2":
									System.out.println("CONSULTAR LISTA DE AUTORES DE DOCUMENTOS DADO UN PREFIJO:");
									System.out.println("Ingrese prefijo a consultar:");
									sf = sc.nextLine();
									l1 = d.consultarAutoresPrefijo(sf);
									if(!l1.isEmpty()) {
										for(v = 0; v < l1.size(); ++v) {
											System.out.println(l1.get(v));
										}
									}
									else System.out.println("No existen autores con este prefijo");
									break;
							 case "3":
									System.out.println("CONSULTAR LISTA DE TITULOS DE DOCUEMNTOS DADA SU FECHA:");
									System.out.println("Ingrese fecha a consultar (no puede ser más grande que la fecha de hoy i tiene que ser una fecha valida):");
									System.out.println("day:");
									h = sc.nextLine();
									sf = h;
									System.out.println("month:");
									q = sc.nextLine();
									sf +=q;
									System.out.println("year:");
									p = sc.nextLine();
									sf +=p;
									f = new Fecha();
									int b = f.comprobar(h,q,p);
									if(b == -1){
										System.out.println("fecha incorrecta(fecha a consultar mayor que la actual)");
									}
									else if(b == -2) {
										System.out.println("fecha incorrecta(compruebe el month)");
									}
									else if(b== -3){
										System.out.println("fecha incorrecta(compruebe el day)");
									}
									else {
										
										l1 = d.consultarTitulos(sf);
										if(!l1.isEmpty()) {
											for(v = 0; v < l1.size(); ++v) {
												System.out.println(l1.get(v));
											}
										}
										else System.out.println("No tiene titulos de documentos");
									}
								    break;
							 case "4":
									System.out.println("CONSULTAR CONTENIDO DE UN DOCUMENTO DADO SU TITULO Y SU AUTOR:");
									System.out.println("Ingrese titulo:");
									sf = sc.nextLine();
									System.out.println("Ingrese autor:");
									q = sc.nextLine();
									t = d.consultarTextoDadoTituloAutor(sf,q);
									if(t.getTexto() != null) {
										System.out.println("Contenido:");
										System.out.println(t.getTexto());
									}
									else System.out.println("No contiene texto o no existe documento");
									break;
							 case "5":
									System.out.println("CONSULTAR LISTA DE LOS ULTIMOS 10 DOCUMENTOS:");
									
									HistoricoDocumentos hist = new HistoricoDocumentos();
									hist.setHistorial(d.getDocs());
									for(int j = 0; j < hist.getHistorial().size(); ++j){
										System.out.println(hist.getHistorial().get(j).getTitulo());
									}
								    break;
							 case "6":
								 System.out.println("NUMERO DE DOCUMENTOS DONDE APARECE UNA PALABRA(RELEVANTE):");
								 sf = sc.nextLine();
								 v = d.consultarDiccionario(sf);
								 if(v == -1) System.out.println("La palabra no aparece en ningún documento");
								 else System.out.println("La palabra esta contenida en " + v + " documento/s");
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
								 lp2 = d.consultardocumentosparecidos(sf,q,h, mode);
								 if(lp2 != null) {
									    System.out.println("NUMERO DE DOCUMENTOS PARECIDOS: " + lp2.size());
										for(int k = 0; k < lp.size(); ++k) {
											System.out.print(lp2.get(k).first() + "  -  " + lp2.get(k).second());
										}
									}
							     else System.out.println("No existe similitudes con los otros documentos");
								 
								 break;
							 default: break;
					}
					break;
			    case "4": opcion= "4"; break;
				default: break;
			}
	} 
	sc.close();
	System.out.println("GRACIAS POR USAR NUESTRO PROGRAMA");
  }
} 