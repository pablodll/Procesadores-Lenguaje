package asint;

import alex.AnalizadorLexicoTiny0;
import alex.UnidadLexica;
import alex.ClaseLexica;
import errors.GestionErroresTiny0;

import java.io.IOException;
import java.io.Reader;

public class AnalizadorSintacticoTiny0 {

	private AnalizadorLexicoTiny0 alex;
	private UnidadLexica anticipo;
	private GestionErroresTiny0 errores;
	
	public AnalizadorSintacticoTiny0(Reader input) throws IOException {
		errores = new GestionErroresTiny0();
		alex = new AnalizadorLexicoTiny0(input);
		alex.fijaGestionErrores(errores);
		sigToken();
	}
	
	public void Sp() {
		S();
		empareja(ClaseLexica.EOF);
	}
	
	private void S() {
		switch(anticipo.clase()){
			case TIPOBOOL: case TIPOINT: case TIPOREAL:
				LDecs();
				empareja(ClaseLexica.SEPSEC);
				LInsts();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
					ClaseLexica.SEPSEC);
		}
	}
	
	private void LDecs() {
		switch(anticipo.clase()){
			case TIPOBOOL: case TIPOINT: case TIPOREAL:
				Dec();
				RLDecs();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
					ClaseLexica.TIPOBOOL, ClaseLexica.TIPOINT, ClaseLexica.TIPOREAL);
		}
	}
	
	private void RLDecs() {
		switch(anticipo.clase()) {
			case PUNTOCOMA:
				empareja(ClaseLexica.PUNTOCOMA);
				Dec();
				RLDecs();
				break;
			case SEPSEC:
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
					ClaseLexica.PUNTOCOMA, ClaseLexica.SEPSEC);
		}
	}
	
	private void Dec() {
		switch(anticipo.clase()) {
			case TIPOBOOL: case TIPOINT: case TIPOREAL:
				Tipo();
				empareja(ClaseLexica.VARIABLE);
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
					ClaseLexica.TIPOBOOL, ClaseLexica.TIPOINT, ClaseLexica.TIPOREAL);		
		}
	}
	
	private void Tipo() {
		switch(anticipo.clase()) {
			case TIPOINT:
				empareja(ClaseLexica.TIPOINT);
				break;
			case TIPOBOOL:
				empareja(ClaseLexica.TIPOBOOL);
				break;
			case TIPOREAL:
				empareja(ClaseLexica.TIPOREAL);
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.TIPOBOOL, ClaseLexica.TIPOINT, ClaseLexica.TIPOREAL);
		}
	}
	
	private void LInsts() {
		switch(anticipo.clase()) {
			case VARIABLE:
				Inst();
				RLInsts();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.VARIABLE);
		}
	}
	
	private void RLInsts() {
		switch(anticipo.clase()) {
			case PUNTOCOMA:
				empareja(ClaseLexica.PUNTOCOMA);
				Inst();
				RLInsts();
				break;
			case EOF:
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
		}
	}
	
	private void Inst() {
		switch(anticipo.clase()) {
			case VARIABLE:
				empareja(ClaseLexica.VARIABLE);
				empareja(ClaseLexica.ASIG);
				E0();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.VARIABLE);
		}
	}
	
	private void E0() {
		switch(anticipo.clase()) {
			case ENTERO: case REAL: case TRUE: case FALSE: case MENOS: case NOT: case PAP: case VARIABLE:
				E1();
				RE0();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
		}
	}
	
	private void RE0() {
		switch(anticipo.clase()) {
			case MAS:
				E0();
				break;
			case MENOS:
				E1();
				break;
			case PCIE: case PUNTOCOMA: case EOF:
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
		}
	}
	
	private void E1() {
		switch(anticipo.clase()) {
			case ENTERO: case REAL: case TRUE: case FALSE: case MENOS: case NOT: case PAP: case VARIABLE:
				E2();
				RE1();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
		}
	}
	
	private void RE1() {
		switch(anticipo.clase()) {
			case AND: case OR:
				OpAI1();
				E2();
				RE1();
				break;
			case MAS: case MENOS: case PCIE: case PUNTOCOMA: case EOF:
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.MAS, ClaseLexica.MENOS, 
				ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
		}
	}
	
	private void E2() {
		switch(anticipo.clase()) {
			case ENTERO: case REAL: case TRUE: case FALSE: case MENOS: case NOT: case PAP: case VARIABLE:
				E3();
				RE2();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
		}
	}
	
	private void RE2() {
		switch(anticipo.clase()) {
			case IGUAL: case DIST: case MAYOR: case MENOR: case MAYIGUAL: case MENIGUAL:
				OpAI2();
				E3();
				RE2();
				break;
			case AND: case OR: case MAS: case MENOS: case PCIE: case PUNTOCOMA: case EOF:
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.IGUAL, ClaseLexica.DIST, ClaseLexica.MAYOR, ClaseLexica.MENOR,
				ClaseLexica.MAYIGUAL, ClaseLexica.MENIGUAL, ClaseLexica.AND, ClaseLexica.OR,
				ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
		}
	}
	
	private void E3() {
		switch(anticipo.clase()) {
			case ENTERO: case REAL: case TRUE: case FALSE: case MENOS: case NOT: case PAP: case VARIABLE:
				E4();
				RE3();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
		}
	}
	
	private void RE3() {
		switch(anticipo.clase()) {
			case DIV: case POR:
				OpNA3();
				E4();
				break;
			case AND: case OR: case IGUAL: case DIST: case MAS: case MENOS: case MAYOR: case MENOR:
			case MAYIGUAL: case MENIGUAL: case PCIE: case PUNTOCOMA: case EOF:
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.IGUAL, ClaseLexica.DIST, 
				ClaseLexica.MAYOR, ClaseLexica.MENOR, ClaseLexica.MAYIGUAL, ClaseLexica.MENIGUAL, 
				ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.MAS, ClaseLexica.MENOS, 
				ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
		}
	}
	
	private void E4() {
		switch(anticipo.clase()) {
			case MENOS:
				empareja(ClaseLexica.MENOS);
				E5();
				break;
			case NOT:
				empareja(ClaseLexica.NOT);
				E4();
			case ENTERO: case REAL: case TRUE: case FALSE: case PAP: case VARIABLE:
				E5();
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
		}
	}
	
	private void E5() {
		switch(anticipo.clase()) {
			case ENTERO:
				empareja(ClaseLexica.ENTERO);
				break;
			case REAL:
				empareja(ClaseLexica.REAL);
				break;
			case VARIABLE:
				empareja(ClaseLexica.VARIABLE);
				break;
			case TRUE:
				empareja(ClaseLexica.TRUE);
				break;
			case FALSE:
				empareja(ClaseLexica.FALSE);
				break;
			case PAP:
				empareja(ClaseLexica.PAP);
				E0();
				empareja(ClaseLexica.PCIE);
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.PAP, ClaseLexica.VARIABLE);
		}	
	}
	
	private void OpAI1() {
		switch(anticipo.clase()) {
			case AND:
				empareja(ClaseLexica.AND);
				break;
			case OR:
				empareja(ClaseLexica.OR);
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.AND, ClaseLexica.OR);
		}
	}
	
	private void OpAI2() {
		switch(anticipo.clase()) {
			case IGUAL:
				empareja(ClaseLexica.IGUAL);
				break;
			case MENOR:
				empareja(ClaseLexica.MENOR);
				break;
			case MAYOR:
				empareja(ClaseLexica.MAYOR);
				break;
			case MAYIGUAL:
				empareja(ClaseLexica.MAYIGUAL);
				break;
			case MENIGUAL:
				empareja(ClaseLexica.MENIGUAL);
				break;
			case DIST:
				empareja(ClaseLexica.DIST);
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.IGUAL, ClaseLexica.DIST, ClaseLexica.MAYOR, ClaseLexica.MENOR, 
				ClaseLexica.MAYIGUAL, ClaseLexica.MENIGUAL);
		}
	}
	
	private void OpNA3() {
		switch(anticipo.clase()) {
			case POR:
				empareja(ClaseLexica.POR);
				break;
			case DIV:
				empareja(ClaseLexica.DIV);
				break;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.POR, ClaseLexica.DIV);
		}
	}
	
	private void empareja(ClaseLexica claseEsperada) {
		if(anticipo.clase() == claseEsperada)
			sigToken();
		else errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), claseEsperada);
	}
	
	private void sigToken() {
		try {
			anticipo = alex.sigToken();
		} catch (IOException e) {
			errores.errorFatal(e);
		}
	}
	
}
