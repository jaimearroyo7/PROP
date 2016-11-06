package dominio;
import java.util.Stack;
public class comprobacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            String cadenano = "{hola adios frio}&(fe)";
            System.out.println(verificatodo(cadenano));
	}
	public static boolean verificaParentesis(String cadena)  {
        Stack<String> pila = new Stack<String>();       int i = 0;
            while (i<cadena.length()) {  // Recorremos la expresión carácter a carácter
                if(cadena.charAt(i)=='(') {pila.push("(");} // Si el paréntesis es de apertura apilamos siempre                               
                else if  (cadena.charAt(i)==')') {  // Si el paréntesis es de cierre actuamos según el caso
                            if (!pila.empty()){ pila.pop(); } // Si la pila no está vacía desapilamos
                            else { pila.push(")"); break; } // La pila no puede empezar con un cierre, apilamos y salimos
                }
                i++;
            }
            if(pila.empty()){ return true; } else { return false; }
    }
	public static boolean verificaClaudators(String cadena)  {
        Stack<String> pila = new Stack<String>();       int i = 0;
            while (i<cadena.length()) {  // Recorremos la expresión carácter a carácter
                if(cadena.charAt(i)=='{') {pila.push("{");} // Si el paréntesis es de apertura apilamos siempre                               
                else if  (cadena.charAt(i)=='}') {  // Si el paréntesis es de cierre actuamos según el caso
                            if (!pila.empty()){ pila.pop(); } // Si la pila no está vacía desapilamos
                            else { pila.push("}"); break; } // La pila no puede empezar con un cierre, apilamos y salimos
                }
                i++;
            }
            if(pila.empty()){ return true; } else { return false; }
    }
	public static boolean verificatodo(String cadena)  {
        Stack<String> pila1 = new Stack<String>();   //parentesis    
        Stack<String> pila2 = new Stack<String>();   //claudators
        int i = 0;
            while (i<cadena.length()) {  // Recorremos la expresión carácter a carácter
                if(cadena.charAt(i)=='(') {pila1.push("(");} // Si el paréntesis es de apertura apilamos siempre   
                else if(cadena.charAt(i)=='{') {pila2.push("{");} 
                else if  (cadena.charAt(i)==')') {  // Si el paréntesis es de cierre actuamos según el caso
                            if (!pila1.empty()){ pila1.pop(); } // Si la pila no está vacía desapilamos
                            else { pila1.push(")"); break; } // La pila no puede empezar con un cierre, apilamos y salimos
                }
                else if  (cadena.charAt(i)=='}') {  // Si el paréntesis es de cierre actuamos según el caso
                    if (!pila2.empty()){ pila2.pop(); } // Si la pila no está vacía desapilamos
                    else { pila2.push("}"); break; } // La pila no puede empezar con un cierre, apilamos y salimos
                }
                i++;
            }
            if(pila2.empty() & pila1.empty())return true;
            return false;
    }
}
