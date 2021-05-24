package alex;

public class UnidadLexicaMultivaluada extends UnidadLexica {
	
	private String lexema;
	
	public UnidadLexicaMultivaluada(int fila, int columna, ClaseLexica clase, String lexema) {
		super(fila, columna, clase);
		this.lexema = lexema;
	}

	@Override
	public String lexema() {return lexema;}
	
	public String toString() {
		return "[clase: " + clase() + ", fila: " + fila() + ", columna: " + columna() + ", lexema: " + lexema() + "]";
	}

}
