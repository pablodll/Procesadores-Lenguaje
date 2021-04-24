package alex;

import asint.ClaseLexica;

public class ALexOperations {
	private AnalizadorLexicoTiny1 alex;
	public ALexOperations(AnalizadorLexicoTiny1 alex) {
		this.alex = alex;   
	}
	
	public UnidadLexica unidadTipoInt() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.TIPOINT, alex.lexema());
    }
	public UnidadLexica unidadTipoReal() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.TIPOREAL, alex.lexema());
    }
	public UnidadLexica unidadTipoBool() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.TIPOBOOL, alex.lexema());
    }
	public UnidadLexica unidadTipoString() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.TIPOSTRING, alex.lexema());
    }
	public UnidadLexica unidadAnd() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.AND, alex.lexema());
    }
	public UnidadLexica unidadOr() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.OR, alex.lexema());
    }
	public UnidadLexica unidadNot() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NOT, alex.lexema());
    }
	public UnidadLexica unidadTrue() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.TRUE, alex.lexema());
    }
    public UnidadLexica unidadFalse() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.FALSE, alex.lexema());
    }
    public UnidadLexica unidadVar() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.VAR, alex.lexema());
    }
    public UnidadLexica unidadType() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.TYPE, alex.lexema());
    }
    public UnidadLexica unidadProc() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PROC, alex.lexema());
    }
    public UnidadLexica unidadNull() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NULL, alex.lexema());
    }
    public UnidadLexica unidadIf() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IF, alex.lexema());
    }
    public UnidadLexica unidadThen() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.THEN, alex.lexema());
    }
    public UnidadLexica unidadElse() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ELSE, alex.lexema());
    }
    public UnidadLexica unidadEndIf() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ENDIF, alex.lexema());
    }
    public UnidadLexica unidadWhile() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.WHILE, alex.lexema());
    }
    public UnidadLexica unidadDo() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DO, alex.lexema());
    }
    public UnidadLexica unidadEndWhile() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ENDWHILE, alex.lexema());
    }
    public UnidadLexica unidadCall() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CALL, alex.lexema());
    }
    public UnidadLexica unidadRecord() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.RECORD, alex.lexema());
    }
    public UnidadLexica unidadArray() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ARRAY, alex.lexema());
    }
    public UnidadLexica unidadOf() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.OF, alex.lexema());
    }
    public UnidadLexica unidadPointer() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.POINTER, alex.lexema());
    }
    public UnidadLexica unidadNew() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NEW, alex.lexema());
    }
    public UnidadLexica unidadDelete() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DELETE, alex.lexema());
    }
    public UnidadLexica unidadRead() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.READ, alex.lexema());
    }
    public UnidadLexica unidadWrite() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.WRITE, alex.lexema());
    }
    public UnidadLexica unidadNL() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NL, alex.lexema());
    }
    public UnidadLexica unidadCadena() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CADENA, alex.lexema()); //
    }
    public UnidadLexica unidadId() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ID, alex.lexema()); //
    }
	public UnidadLexica unidadEnt() {
		return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ENTERO, alex.lexema()); //
	}
	public UnidadLexica unidadReal() {
		return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.REAL, alex.lexema()); //
	}
	public UnidadLexica unidadComa() {
		return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.COMA, alex.lexema());
	}
	public UnidadLexica unidadPuntoComa() {
		return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PUNTOCOMA, alex.lexema());
	}
	public UnidadLexica unidadAsig() {
		return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ASIG, alex.lexema());
	}	
	public UnidadLexica unidadSepSec() {
		return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.SEPSEC, alex.lexema());
	}
	public UnidadLexica unidadMas() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAS, alex.lexema());     
	}    
	public UnidadLexica unidadMenos() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOS, alex.lexema());     
	}    
	public UnidadLexica unidadPor() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.POR, alex.lexema());     
	}    
	public UnidadLexica unidadDiv() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIV, alex.lexema());     
	}    
	public UnidadLexica unidadMod() {
		return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MOD, alex.lexema());
	}
	public UnidadLexica unidadPAp() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PAP, alex.lexema());     
	}    
	public UnidadLexica unidadPCie() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PCIE, alex.lexema());     
	}
	public UnidadLexica unidadCAp() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CAP, alex.lexema());
    }
	public UnidadLexica unidadCCie() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CCIE, alex.lexema());
    }
	public UnidadLexica unidadLlAp() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LLAP, alex.lexema());
    }
	public UnidadLexica unidadLlCie() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LLCIE, alex.lexema());
    }
	public UnidadLexica unidadPunto() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PUNTO, alex.lexema());
    }
	public UnidadLexica unidadFlecha() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.FLECHA, alex.lexema());
    }
	public UnidadLexica unidadAmp() {
    	return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.AMP, alex.lexema());
    }
	public UnidadLexica unidadMenor() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOR, alex.lexema());     
	}
	public UnidadLexica unidadMayor() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAYOR, alex.lexema());     
	}
	public UnidadLexica unidadMenIgual() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENIGUAL, alex.lexema());     
	}
	public UnidadLexica unidadMayIgual() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAYIGUAL, alex.lexema());     
	}
	public UnidadLexica unidadIgual() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IGUAL, alex.lexema());     
	} 
	public UnidadLexica unidadDist() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIST, alex.lexema());     
	} 
	public UnidadLexica unidadEof() {
		return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EOF, alex.lexema());     
	}
 
	public void error() {
		
	    System.err.println("*** fila: "+alex.fila()+ ", columna: " + alex.columna() + " Caracter inesperado: "+ alex.lexema());
	}
}
