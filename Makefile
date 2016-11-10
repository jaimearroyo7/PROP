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
	
maketexto: DriverTexto.class 

	java DriverTexto
	java Frase
	java Texto
	java Palabra
	
makefrase: DriverFrase.class 

	java DriverFrase
	java Frase
	java Texto
	java Palabra
	
makepalabra: DriverPalabra.class 

	java DriverPalabra
	java Palabra
	
makefecha: DriverFecha.class 

	java DriverFecha
	java Fecha	
	
makenodo: DriverNodo.class

	java DriverNodo
	java Nodo
	java Element
	
makeexpbool: DriverExpBool.claas 

	java DriverExpBool
	java ExpBool
	java Nodo
	java Element
	
makehistorico: DriverHistoricoDocumentos.class 

	java DriverHistoricoDocumentos
	java HistoricoDocumentos
	java Documento
	java Pair
	java Fecha
	
makeNodo: DriverNodo.class

	java DriverNodo
	java Nodo
	java Element
	
makeelement: DriverElement.class

	java DriverElement
	java Element
	
makedicionario: DriverDiccionario.class
	
	java DriverDiccionario
	java Diccionario
	java Documento
	java Pair
	java ContenidoDiccionario
	
makecontenidodiccionario: DriverContenidoDiccionario.class

	java DriverContenidoDiccinario
	java ContenidoDiccionario
	
DriverDiccionario.class: DriverDiccionario.java Diccionario.java Documento.java Pair.java ContenidoDiccionario.java
	
	javac DriverDiccionario.java
	
DriverGenerico.class: DriverGenerico.java Documentos.java Documento.java Texto.java

	javac DriverGenerico.java
	
DriverDocumento.class: DriverDocumento.java Documento.java

	javac DriverDocumento.java

DriverTexto.class: DriverTexto.java Texto.java

	javac DriverTexto.java
	
DriverFrase.class: DriverFrase.java Palabra.java

	javac DriverFrase.java
	
DriverPalabra.class: DriverPalabra.java Palabra.java

	javac DriverPalabra.java
	
DriverFecha.class: DriverFecha.java Fecha.java

	javac DriverFecha.java
	
DriverExpBool.class: DriverExpBool.java ExpBool.java

	javac DriverExpBool.java
	
DriverHistoricoDocumentos.class: DriverHistoricoDocumentos.java HistoricoDocumentos.java

	javac DriverHistoricoDocumentos.java
	
DriverNodo.class: DriverNodo.java Nodo.java Element.java

	javac DriverNodo.java
	
DriverElement.class: DriverElement.java Element.java

	javac DriverElement.java
	
Element.class: Element.java

	javac Element.java
	
ExpBool.class: ExpBool.java Nodo.java Element.java

	javac ExpBool.java
	
HistoricoDocumentos.class: HistoricoDocumentos.java Fecha.java Documento.java Pair.java

	javac HistoricoDocumentos.java
	
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
	
Nodo.class: Nodo.java

	javac Nodo.java
	
Diccionario.class: Diccionario.java Documento.java

	javac Diccionario.java
	
ContenidoDiccionario.class: ContenidoDiccionario.java

	javac ContenidoDiccionario.java
	

clean: rm -f *.class 