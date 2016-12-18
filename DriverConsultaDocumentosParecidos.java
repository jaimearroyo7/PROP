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


    }


}

