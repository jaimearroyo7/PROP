package dominio;

public class Element {
////////////////////////////////////CLASE ELEMENT////////////////////////////////////////////////
		private String e;

		public Element(String s) {
			e = s;
		}
		//setter
		public void setElement(String e) {
			this.e=e;
		}
		//getter
		public String getElement() {
			return this.e;
		}
		//consultoras
		public boolean isFrase() {
			return e.contains(" ");
		}
		public boolean isKey() {
			return (e.equals("{") || e.equals("}"));
		}
		public boolean isOpenedKey() {
			return (e.equals("{"));
		}
		public boolean isClosedKey() {
			return (e.equals("}"));
		}
		public boolean isParenthesis() {
			return (e.equals("(") || e.equals(")"));
		}
		public boolean isOpenedParenthesis() {
			return e.equals("(");
		}
		public boolean isClosedParenthesis() {
			return e.equals(")");
		}
		public boolean isOperador() {
			return e.equals("and") || e.equals("or") || e.equals("not"); 
		}
		public boolean isOperadorBinari() {
			return e.equals("and") || e.equals("or");
		}
		public boolean isaNot() {
			return e.equals("not");
		}

////////////////////////////////////FIN CLASE ELEMENT/////////////////////////////////////////////
}
