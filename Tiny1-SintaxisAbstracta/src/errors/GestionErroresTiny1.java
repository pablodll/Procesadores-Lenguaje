package errors;

import c_ast_ascendente.UnidadLexica;

public class GestionErroresTiny1 {

	public void errorLexico(int fila, int columna, String lexema) {
		System.err.println("ERROR fila " + fila + ", columna " + columna + ": Caracter inesperado: " + lexema);
		System.exit(1);
	}
	
	public void errorSintactico(UnidadLexica ud) {
		System.err.println("ERROR fila " + ud.fila() + ", columna " + ud.columna() + ": Elemento inesperado: " + ud.lexema());
	}
}
