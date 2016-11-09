makegenerico: DriverGenerico.class 

	java DriverDocumentos
	java Documentos
	java Documento
	java Texto
	java Frase
	java Palabra
	java Fecha
	java Pair
	java Diccionario
	
makedocumento: DriverDocumento.class

	java DriverDocumento
	java Documento
	java Texto
	java Frase
	java Palabra
	java Fecha
	java Pair
	
makepalabra: DriverPalabra.class 

	java DriverPalabra
	java Palabra
	
makefecha: DriverFecha.class 

	java DriverFecha
	java Fecha	
	
DriverGenerico.class: DriverGenerico.java Documentos.java Documento.java Texto.java

	javac DriverGenerico.java
	
DriverDocumento.class: DriverDocumento.java Documento.java

	javac DriverDocumento.java
	
Documentos.class: Documentos.java Documento.java Diccionario.java

	javac Documentos.java
	
Documento.class: Documento.java Texto.java Fecha.java Pair.java

	javac Documento.java
	
Texto.class: Texto.java Frase.java

	javac Texto.java
	
Frase.class: Frase.java Palabra.java

	javac Frase.java
	
Palabra.class: Palabra.java 

	javac Palabra.java

Fecha.class: Fecha.java 

	javac Fecha.java
	
Pair.class: Pair.java

	javac Pair.java
	
Diccionario.class: Diccionario.java Documento.java

	javac Diccionario.java

	
clean: rm -f *.class 