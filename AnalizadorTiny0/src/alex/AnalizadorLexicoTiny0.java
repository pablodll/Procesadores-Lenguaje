package alex;

import java.io.IOException;
import java.io.Reader;

import errors.GestionErroresTiny0;

public class AnalizadorLexicoTiny0 {
	
	private GestionErroresTiny0 errores;
	private Reader input;
	private StringBuffer lex;
	private int sigCar;
	private int filaInicio;
	private int columnaInicio;
	private int filaActual;
	private int columnaActual;
	private static String NL = System.getProperty("line.separator");
	
	private enum Estado {
		INICIO, REC_PUNTOCOMA, REC_VARIABLE, REC_0, REC_ENT, REC_IDEC, REC_DEC, REC_0DEC, REC_IEXP, REC_NEGEXP, REC_POSEXP, REC_EXP, REC_MAS, REC_MENOS,
		REC_POR, REC_DIV, REC_MAYOR, REC_MAYIGUAL, REC_MENOR, REC_MENIGUAL, REC_ASIG, REC_IGUAL, REC_PAP, REC_PCIE, REC_IDIST, REC_DIST,
		REC_ISEP, REC_SEPSEC, REC_EOF
	}
	
	private Estado estado;
	
	public AnalizadorLexicoTiny0(Reader input) throws IOException {
		this.input = input;
		lex = new StringBuffer();
		sigCar = input.read();
		filaActual = 1;
		columnaActual = 1;
	}
	
	public void fijaGestionErrores(GestionErroresTiny0 err) {
		this.errores = err;
	}
	
	public UnidadLexica sigToken() throws IOException{
		estado = Estado.INICIO;
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		lex.delete(0, lex.length());
		
		while(true) {
			switch (estado) {
				case INICIO:
					if(hayLetra()) transita(Estado.REC_VARIABLE);
					else if(hayPuntoComa()) transita(Estado.REC_PUNTOCOMA);
					else if (hayCero()) transita(Estado.REC_0);
					else if (hayDigitoPos()) transita(Estado.REC_ENT);
					else if (hayMas()) transita(Estado.REC_MAS);
					else if (hayMenos()) transita(Estado.REC_MENOS);
					else if (hayPor()) transita(Estado.REC_POR);
					else if (hayDiv()) transita(Estado.REC_DIV);
					else if (hayMayor()) transita(Estado.REC_MAYOR);
					else if (hayMenor()) transita(Estado.REC_MENOR);
					else if (hayIgual()) transita(Estado.REC_ASIG);
					else if (hayPAp()) transita(Estado.REC_PAP);
					else if (hayPCie()) transita(Estado.REC_PCIE);
					else if (hayExclam()) transita(Estado.REC_IDIST);
					else if (hayAmper()) transita(Estado.REC_ISEP);
					else if (hayEOF()) transita(Estado.REC_EOF);
					else if(haySep()) transitaIgnorando(Estado.INICIO);
					else error();
					break;
				case REC_PUNTOCOMA: return unidadPuntoComa();
				case REC_VARIABLE:
					if(hayLetra() || hayDigito() || hayBarra()) transita(Estado.REC_VARIABLE);
					else return unidadId();
					break;
				case REC_0:
					if(hayPunto()) transita(Estado.REC_IDEC);
					else if(hayExp()) transita(Estado.REC_IEXP);
					else return unidadEnt();
					break;
				case REC_ENT:
					if(hayDigito()) transita(Estado.REC_ENT);
					else if(hayPunto()) transita(Estado.REC_IDEC);
					else if(hayExp()) transita(Estado.REC_IEXP);
					else return unidadEnt();
					break;
				case REC_IDEC:
					if(hayDigito()) transita(Estado.REC_DEC);
					else error(); 
					break;
				case REC_DEC:
					if(hayDigitoPos()) transita(Estado.REC_DEC);
					else if(hayExp()) transita(Estado.REC_IEXP);
					else if(hayCero()) transita(Estado.REC_0DEC);
					else return unidadReal();
					break;
				case REC_0DEC:
					if(hayCero()) transita(Estado.REC_0DEC);
					else if (hayDigitoPos()) transita(Estado.REC_DEC);
					else error();
					break;
				case REC_IEXP:
					if(hayDigitoPos()) transita(Estado.REC_EXP);
					else if(hayMenos()) transita(Estado.REC_NEGEXP);
					else if(hayMas()) transita(Estado.REC_POSEXP);
					else error();
					break;					
				case REC_NEGEXP:
					if(hayDigitoPos()) transita(Estado.REC_EXP);
					else error();
					break;
				case REC_POSEXP:
					if(hayDigitoPos()) transita(Estado.REC_EXP);
					else error();
				case REC_EXP:
					if(hayDigito()) transita(Estado.REC_EXP);
					else return unidadReal();
					break;
				case REC_MAS:
					if(hayDigitoPos()) transita(Estado.REC_ENT);
					else if(hayCero()) transita(Estado.REC_0);
					else return unidadMas();
					break;
				case REC_MENOS:
					if(hayDigitoPos()) transita(Estado.REC_ENT);
					else if(hayCero()) transita(Estado.REC_0);
					else return unidadMenos();
					break;
				case REC_POR: return unidadPor();
				case REC_DIV: return unidadDiv();
				case REC_MAYOR:
					if(hayIgual()) transita(Estado.REC_MAYIGUAL);
					else return unidadMayor();
					break;
				case REC_MAYIGUAL: return unidadMayIgual();
				case REC_MENOR:
					if(hayIgual()) transita(Estado.REC_MENIGUAL);
					else return unidadMenor();
					break;
				case REC_MENIGUAL: return unidadMenIgual();
				case REC_ASIG:
					if(hayIgual()) transita(Estado.REC_IGUAL);
					else return unidadAsig();
					break;
				case REC_IGUAL: return unidadIgual();
				case REC_PAP: return unidadPAp();
				case REC_PCIE: return unidadPCie();
				case REC_IDIST:
					if(hayIgual()) transita(Estado.REC_DIST);
					else error();
					break;
				case REC_DIST: return unidadDist();
				case REC_ISEP:
					if(hayAmper()) transita(Estado.REC_SEPSEC);
					else error();
					break;
				case REC_SEPSEC: return unidadSepSec();
				case REC_EOF: return unidadEof();
			}
		}
	}
	
	private void transita(Estado sig) throws IOException {
		lex.append((char) sigCar);
		sigCar();
		estado = sig;
	}
	
	private void transitaIgnorando(Estado sig) throws IOException {
		sigCar();
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		estado = sig;
	}
	
	private void sigCar() throws IOException{
		sigCar = input.read();
		if(sigCar == NL.charAt(0)) saltaFinDeLinea();
		if(sigCar == '\n') {
			filaActual++;
			columnaActual = 0;
		}
		else {
			columnaActual++;
		}
	}

	private void saltaFinDeLinea() throws IOException{
		for(int i = 1; i < NL.length(); i++) {
			sigCar = input.read();
			if(sigCar != NL.charAt(i)) error();
		}
		sigCar = '\n';
	}
	
	private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' ||
									   sigCar >= 'A' && sigCar <= 'Z';}
	private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
	private boolean hayCero() {return sigCar == '0';}
	private boolean hayDigito() {return hayDigitoPos() || hayCero();}
	private boolean hayExp() {return sigCar == 'e' || sigCar == 'E';}
	private boolean hayMas() {return sigCar == '+';}
	private boolean hayMenos() {return sigCar == '-';}
	private boolean hayPor() {return sigCar == '*';}
	private boolean hayDiv() {return sigCar == '/';}
	private boolean hayMenor() {return sigCar =='<';}
	private boolean hayMayor() {return sigCar =='>';}
   	private boolean hayPAp() {return sigCar == '(';}
   	private boolean hayPCie() {return sigCar == ')';} 
   	private boolean hayIgual() {return sigCar == '=';}
   	private boolean hayExclam() {return sigCar =='1';}
   	private boolean hayBarra() {return sigCar == '_';}
   	private boolean hayPunto() {return sigCar == '.';}
   	private boolean hayPuntoComa() {return sigCar == ';';}
   	private boolean hayAmper() {return sigCar == '&';}
   	private boolean hayNL() {return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';}
   	private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || hayNL();}
    private boolean hayEOF() {return sigCar == -1;}
    
    private UnidadLexica unidadId() {
    	switch(lex.toString()) {
    		case "int":
    			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.TIPOINT);
    		case "real":
    			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.TIPOREAL);
    		case "bool":
    			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.TIPOBOOL);
    		case "and":
    			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.AND);
    		case "or":
    			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OR);
    		case "not":
    			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.NOT);
    		case "true":
    			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.TRUE);
    		case "false":
    			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.FALSE);
    		default:
    			return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.VARIABLE, lex.toString());
    	}
    }
    
    private UnidadLexica unidadEnt() {
    	return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.ENTERO, lex.toString());
    }
    private UnidadLexica unidadReal() {
    	return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.REAL, lex.toString());
    }
    private UnidadLexica unidadPuntoComa() {
    	return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.PUNTOCOMA);
    }
    private UnidadLexica unidadAsig() {
    	return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.ASIG);
    }
    private UnidadLexica unidadSepSec() {
    	return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.SEPSEC);
    }
    private UnidadLexica unidadMas() {
        return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAS);     
    }    
    private UnidadLexica unidadMenos() {
    	return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);     
    }    
    private UnidadLexica unidadPor() {
    	return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.POR);     
    }    
	private UnidadLexica unidadDiv() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);     
	}    
	private UnidadLexica unidadPAp() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAP);     
	}    
	private UnidadLexica unidadPCie() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCIE);     
	}
	private UnidadLexica unidadMenor() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOR);     
	}
	private UnidadLexica unidadMayor() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYOR);     
	}
	private UnidadLexica unidadMenIgual() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENIGUAL);     
	}
	private UnidadLexica unidadMayIgual() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYIGUAL);     
	}
	private UnidadLexica unidadIgual() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUAL);     
	} 
	private UnidadLexica unidadDist() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIST);     
	} 
	private UnidadLexica unidadEof() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EOF);     
	}
   
	private void error() {
		errores.errorLexico(filaActual, columnaActual, Character.toString(sigCar));
	}
}
