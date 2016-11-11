package dominio;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.Scanner;

public class DriverConsultaDocumentosParecidos {

    public static void main(String[] args) throws IOException, ParseException {

        Scanner sc = new Scanner(System.in);
        String m, n, d;
        ConsultaDocumentosParecidos.TFIDF_MODE mode;

        Documento d1 = new Documento("d1", "maria", "categoria", "Este texto es un ejemplo");
        Documento d2 = new Documento("d2", "maria", "categoria", "Este texto es un ejemplo también");
        Documento d3 = new Documento("d3", "maria", "categoria", "Este también pero se parece menos a los anteriores");
        Documento d4 = new Documento();

        Documentos docs = new Documentos();
        docs.addDoc(d1);
        docs.addDoc(d2);
        docs.addDoc(d3);

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

        System.out.println("Seleccione que documento (d1, d2 o d3) quiere utilizar para buscar " +
                "los documentos más parecidos a este");
        d = sc.nextLine();
        if (d.equals("d1")) d4 = d1;
        else if (d.equals("d2")) d4 = d2;
        else if (d.equals("d3")) d4 = d3;
        else {
            System.out.println("Documento incorrecto (por defecto se ejecutara d1)");
            d4 = d1;
        }


        System.out.println("Ingrese metodo para calcular tfidf:\n"
                + "  log\n"
                + "  bool");
        m = sc.nextLine();
        if (m.equals("log")) mode = ConsultaDocumentosParecidos.TFIDF_MODE.LOG;
        else if (m.equals("bool")) mode = ConsultaDocumentosParecidos.TFIDF_MODE.BOOLEAN;
        else {
            System.out.println("Modo incorrecto (por defecto se ejecutara logaritmico)");
            mode = ConsultaDocumentosParecidos.TFIDF_MODE.LOG;
        }

        System.out.println("Ingrese cuantos n documentos parecidos quiere obtener:");
        n = sc.nextLine();

        List<Pair<String, String>> lista;
        lista = docs.consultardocumentosparecidos(d4.getTitulo(), d4.getAutor(), n, mode);
        for (Pair<String, String> documento: lista) {
            System.out.println("Título: " + documento.first() + " Autor: " + documento.second());
        }
        System.out.println("consulta terminada");
    }
}

