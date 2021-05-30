package c_ast_ascendente;

import asint.Tiny1Asint.StringLocalizado;
import java_cup.runtime.Symbol;

public class UnidadLexica extends Symbol{

	private int fila;
	private int columna;
	
	public UnidadLexica(int fila, int columna, int clase, String lexema) {
		super(clase, null);
		value = new StringLocalizado(lexema,fila,columna);
		this.fila = fila;
		this.columna = columna;
	}
	
	public int clase() {return sym;}
	public StringLocalizado lexema() {return (StringLocalizado) value;}
	//public String lexema() {return (String) value;}
	public int fila() {return fila;}
	public int columna() {return columna;}
}