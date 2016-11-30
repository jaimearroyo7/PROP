package dominio;

//import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.Scanner;

/**
 * Created by parallels on 11/9/16.
 */
public class DriverDiccionario {

    public static void main(String[] args) throws IOException, ParseException {

        Scanner sc = new Scanner(System.in);

        Documento d1 = new Documento("d1", "maria", "categoria", "Este texto contiene palabras");
        Documento d2 = new Documento("d2", "maria", "categoria", "Este texto tambien contiene palabras");
        Documento d3 = new Documento("d2", "maria", "categoria", "Este es el ultimo ejemplo");

        Diccionario dic = new Diccionario();
        dic.addTextoDocumento(d1);
        dic.addTextoDocumento(d2);

        System.out.println("Estos son tus documentos por defecto:\n"
                + "Documento 1:\n"
                + "  Titulo: " + d1.getTitulo() + "\n"
                + "  Autor: " + d1.getAutor() + "\n"
                + "  Categoria: " + d1.getCategoria() + "\n"
                + "  Texto: " + d1.getTexto().getTexto() + "\n"
                + "Documento 2:\n"
                + "  Titulo: " + d2.getTitulo() + "\n"
                + "  Autor: " + d2.getAutor() + "\n"
                + "  Categoria: " + d2.getCategoria() + "\n"
                + "  Texto: " + d2.getTexto().getTexto() + "\n"
                + "Documento 3:\n"
                + "  Titulo: " + d3.getTitulo() + "\n"
                + "  Autor: " + d3.getAutor() + "\n"
                + "  Categoria: " + d3.getCategoria() + "\n"
                + "  Texto: " + d3.getTexto().getTexto() + "\n");

        int n;
        ArrayList<Documento> docs = new ArrayList<>();
        String opcion = "0";
        while (opcion != "4") {

            System.out.println("Que quieres consultar en diccionario?\n" +
                    "1) consultar numero de documentos con una palabra p\n" +
                    "2) consultar titulo y autor de documentos con una palabra p\n" +
                    "3) consultar indice en el array de una palabra p\n"+
                    "4) terminar de consultar\n ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("introduce palabra p: ");
                    n = dic.numeroDeDocumentosCon(sc.nextLine());
                    System.out.println("numero de documentos con esta palabra: " + n);
                    break;
                case "2":
                    System.out.println("introduce palabra p: ");
                    docs = dic.getDocumentosConPalabra(sc.nextLine());
                    for (Documento d : docs) {
                        System.out.println(d.getTitulo() + " " + d.getAutor());
                    }
                    break;
                case "3":
                    System.out.println("introduce palabra p: ");
                    n = dic.indicePalabra(sc.nextLine());
                    System.out.println("numero de documentos con esta palabra: " + n);
                    break;
                case "4":
                    opcion = "4";
                    break;
                default:
                    break;

            }
        }
        sc.close();
        System.out.println("GRACIAS POR USAR NUESTRO PROGRAMA");
    }

}
