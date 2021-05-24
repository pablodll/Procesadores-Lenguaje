package errors;

import java.util.List;
import alex.ClaseLexica;

public class GestionErroresTiny0 {
	
	public void errorLexico(int fila, int col, String lexema) {
		System.err.println("ERROR fila " + fila + ", columna " + col + ": Caracter inesperado: " + lexema);
		System.exit(1);
	}
	
	public void errorSintactico(int fila, int col, ClaseLexica encontrada, ClaseLexica ... esperadas) {
		System.err.println("ERROR fila " + fila + ", columna " + col + ": Encontrado " + encontrada + " Se esperaba: ");
		for(ClaseLexica esperada : esperadas) {
			System.err.println(esperada + " ");
		}
		System.err.println();
		System.exit(1);
	}
	
	
	public void errorFatal(Exception e) {
		System.err.println(e);
		e.printStackTrace();
		System.exit(1);
	}
}
