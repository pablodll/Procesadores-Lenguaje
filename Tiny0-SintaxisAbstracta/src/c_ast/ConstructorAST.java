package c_ast;

import java.io.IOException;
import java.io.Reader;

import alex.AnalizadorLexicoTiny0;
import alex.ClaseLexica;
import alex.UnidadLexica;
import errors.GestionErroresTiny0;
import semops.SemOps;

import asint.Tiny0ASint.Prog;
import asint.Tiny0ASint.LDecs;
import asint.Tiny0ASint.Dec;
import asint.Tiny0ASint.Tipo;
import asint.Tiny0ASint.LInsts;
import asint.Tiny0ASint.Inst;
import asint.Tiny0ASint.Exp;

public class ConstructorAST {
	private AnalizadorLexicoTiny0 alex;
	private UnidadLexica anticipo;
	private GestionErroresTiny0 errores;
	private SemOps sem;
	
	public ConstructorAST(Reader input) throws IOException {
		errores = new GestionErroresTiny0();
		alex = new AnalizadorLexicoTiny0(input);
		alex.fijaGestionErrores(errores);
		sigToken();
		sem = new SemOps();
	}
	
	public Prog Sp() {
		Prog prog = S();
		empareja(ClaseLexica.EOF);
		return prog;
	}
	
	private Prog S() {
		switch(anticipo.clase()){
			case TIPOBOOL: case TIPOINT: case TIPOREAL:
				LDecs ldecs = LDecs();
				empareja(ClaseLexica.SEPSEC);
				LInsts linsts = LInsts();
				return sem.prog(ldecs, linsts);
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
					ClaseLexica.SEPSEC);
				return null;
		}
	}
	
	private LDecs LDecs() {
		switch(anticipo.clase()){
			case TIPOBOOL: case TIPOINT: case TIPOREAL:
				Dec dec = Dec();
				return RLDecs(sem.decs_una(dec));
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
					ClaseLexica.TIPOBOOL, ClaseLexica.TIPOINT, ClaseLexica.TIPOREAL);
				return null;
		}
	}
	
	private LDecs RLDecs(LDecs ldecsh) {
		switch(anticipo.clase()) {
			case PUNTOCOMA:
				empareja(ClaseLexica.PUNTOCOMA);
				Dec dec = Dec();
				return RLDecs(sem.decs_muchas(ldecsh, dec));
			case SEPSEC: return ldecsh;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
					ClaseLexica.PUNTOCOMA, ClaseLexica.SEPSEC);
				return null;
		}
	}
	
	private Dec Dec() {
		switch(anticipo.clase()) {
			case TIPOBOOL: case TIPOINT: case TIPOREAL:
				Tipo tipo = Tipo();
				UnidadLexica tkVar= anticipo;
				empareja(ClaseLexica.VARIABLE);
				return sem.dec(tipo, sem.str(tkVar.lexema(), tkVar.fila(), tkVar.columna()));
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
					ClaseLexica.TIPOBOOL, ClaseLexica.TIPOINT, ClaseLexica.TIPOREAL);	
				return null;
		}
	}
	
	private Tipo Tipo() {
		switch(anticipo.clase()) {
			case TIPOINT:
				empareja(ClaseLexica.TIPOINT);
				return sem.tipo_int();
			case TIPOBOOL:
				empareja(ClaseLexica.TIPOBOOL);
				return sem.tipo_bool();
			case TIPOREAL:
				empareja(ClaseLexica.TIPOREAL);
				return sem.tipo_real();
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.TIPOBOOL, ClaseLexica.TIPOINT, ClaseLexica.TIPOREAL);
				return null;
		}
	}
	
	private LInsts LInsts() {
		switch(anticipo.clase()) {
			case VARIABLE:
				Inst inst = Inst();
				return RLInsts(sem.inst_una(inst));
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.VARIABLE);
				return null;
		}
	}
	
	private LInsts RLInsts(LInsts linstsh) {
		switch(anticipo.clase()) {
			case PUNTOCOMA:
				empareja(ClaseLexica.PUNTOCOMA);
				Inst inst = Inst();
				return RLInsts(sem.inst_muchas(linstsh, inst));
			case EOF: return linstsh;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
				return null;
		}
	}
	
	private Inst Inst() {
		switch(anticipo.clase()) {
			case VARIABLE:
				UnidadLexica tkVar = anticipo;
				empareja(ClaseLexica.VARIABLE);
				empareja(ClaseLexica.ASIG);
				Exp arg0 = E0();
				return sem.asig(sem.str(tkVar.lexema(), tkVar.fila(), tkVar.columna()), arg0);
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.VARIABLE);
				return null;
		}
	}
	
	private Exp E0() {
		switch(anticipo.clase()) {
			case ENTERO: case REAL: case TRUE: case FALSE: case MENOS: case NOT: case PAP: case VARIABLE:
				Exp arg0 = E1();
				return RE0(arg0);
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
				return null;
		}
	}
	
	private Exp RE0(Exp argh) {
		switch(anticipo.clase()) {
			case MAS:
				empareja(ClaseLexica.MAS);
				Exp arg1 = E0();
				return sem.exp("+", argh, arg1);
			case MENOS:
				empareja(ClaseLexica.MENOS);
				Exp arg2 = E1();
				return sem.exp("-", argh, arg2);
			case PCIE: case PUNTOCOMA: case EOF:
				return argh;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.EOF);
				return null;
		}
	}
	
	private Exp E1() {
		switch(anticipo.clase()) {
			case ENTERO: case REAL: case TRUE: case FALSE: case MENOS: case NOT: case PAP: case VARIABLE:
				Exp arg0 = E2();
				return RE1(arg0);
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
				return null;
		}
	}
	
	private Exp RE1(Exp argh) {
		switch(anticipo.clase()) {
			case AND: case OR:
				String op = OpAI1();
				Exp arg1 = E2();
				return RE1(sem.exp(op, argh, arg1));
			case MAS: case MENOS: case PCIE: case PUNTOCOMA: case EOF:
				return argh;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.EOF);
				return null;
		}
	}
	
	private Exp E2() {
		switch(anticipo.clase()) {
			case ENTERO: case REAL: case TRUE: case FALSE: case MENOS: case NOT: case PAP: case VARIABLE:
				Exp arg0 = E3();
				return RE2(arg0);
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
				return null;
		}
	}
	
	private Exp RE2(Exp argh) {
		switch(anticipo.clase()) {
			case IGUAL: case DIST: case MAYOR: case MENOR: case MAYIGUAL: case MENIGUAL:
				String op = OpAI2();
				Exp arg1 = E3();
				return RE2(sem.exp(op, argh, arg1));
			case AND: case OR: case MAS: case MENOS: case PCIE: case PUNTOCOMA: case EOF:
				return argh;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.IGUAL, ClaseLexica.DIST, ClaseLexica.MAYOR, ClaseLexica.MENOR,
				ClaseLexica.MAYIGUAL, ClaseLexica.MENIGUAL, ClaseLexica.AND, ClaseLexica.OR,
				ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.EOF);
				return null;
		}
	}
	
	private Exp E3() {
		switch(anticipo.clase()) {
			case ENTERO: case REAL: case TRUE: case FALSE: case MENOS: case NOT: case PAP: case VARIABLE:
				Exp arg0 = E4();
				return RE3(arg0);
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
				return null;
		}
	}
	
	private Exp RE3(Exp argh) {
		switch(anticipo.clase()) {
			case DIV: case POR:
				String op = OpNA3();
				Exp arg1 =  E4();
				return sem.exp(op, argh, arg1);
			case AND: case OR: case IGUAL: case DIST: case MAS: case MENOS: case MAYOR: case MENOR:
			case MAYIGUAL: case MENIGUAL: case PCIE: case PUNTOCOMA: case EOF:
				return argh;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.IGUAL, ClaseLexica.DIST, 
				ClaseLexica.MAYOR, ClaseLexica.MENOR, ClaseLexica.MAYIGUAL, ClaseLexica.MENIGUAL, 
				ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.EOF);
				return null;
		}
	}
	
	private Exp E4() {
		switch(anticipo.clase()) {
			case MENOS:
				empareja(ClaseLexica.MENOS);
				Exp arg0 = E5();
				return sem.menos(arg0);
			case NOT:
				empareja(ClaseLexica.NOT);
				Exp arg1 = E4();
				return sem.not(arg1);
			case ENTERO: case REAL: case TRUE: case FALSE: case PAP: case VARIABLE:
				return E5();
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAP, ClaseLexica.VARIABLE);
				return null;
		}
	}
	
	private Exp E5() {
		switch(anticipo.clase()) {
			case ENTERO:
				UnidadLexica tkEntero = anticipo;
				empareja(ClaseLexica.ENTERO);
				return sem.entero(sem.str(tkEntero.lexema(), tkEntero.fila(), tkEntero.columna()));
			case REAL:
				UnidadLexica tkReal = anticipo;
				empareja(ClaseLexica.REAL);
				return sem.real(sem.str(tkReal.lexema(), tkReal.fila(), tkReal.columna()));
			case VARIABLE:
				UnidadLexica tkVar = anticipo;
				empareja(ClaseLexica.VARIABLE);
				return sem.real(sem.str(tkVar.lexema(), tkVar.fila(), tkVar.columna()));
			case TRUE:
				empareja(ClaseLexica.TRUE);
				return sem._true();
			case FALSE:
				empareja(ClaseLexica.FALSE);
				return sem._false();
			case PAP:
				empareja(ClaseLexica.PAP);
				Exp exp = E0();
				empareja(ClaseLexica.PCIE);
				return exp;
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.ENTERO, ClaseLexica.REAL, ClaseLexica.TRUE, ClaseLexica.FALSE, 
				ClaseLexica.PAP, ClaseLexica.VARIABLE);
				return null;
		}	
	}
	
	private String OpAI1() {
		switch(anticipo.clase()) {
			case AND:
				empareja(ClaseLexica.AND);
				return "and";
			case OR:
				empareja(ClaseLexica.OR);
				return "or";
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.AND, ClaseLexica.OR);
				return null;
		}
	}
	
	private String OpAI2() {
		switch(anticipo.clase()) {
			case IGUAL:
				empareja(ClaseLexica.IGUAL);
				return "==";
			case MENOR:
				empareja(ClaseLexica.MENOR);
				return "<";
			case MAYOR:
				empareja(ClaseLexica.MAYOR);
				return ">";
			case MAYIGUAL:
				empareja(ClaseLexica.MAYIGUAL);
				return ">=";
			case MENIGUAL:
				empareja(ClaseLexica.MENIGUAL);
				return "<=";
			case DIST:
				empareja(ClaseLexica.DIST);
				return "!=";
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.IGUAL, ClaseLexica.DIST, ClaseLexica.MAYOR, ClaseLexica.MENOR, 
				ClaseLexica.MAYIGUAL, ClaseLexica.MENIGUAL);
				return null;
		}
	}
	
	private String OpNA3() {
		switch(anticipo.clase()) {
			case POR:
				empareja(ClaseLexica.POR);
				return "*";
			case DIV:
				empareja(ClaseLexica.DIV);
				return "/";
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.POR, ClaseLexica.DIV);
			return null;
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
