package alex;

public class ALexOperations {
	private AnalizadorLexicoTiny1 alex;
	public ALexOperations(AnalizadorLexicoTiny1 alex) {
		this.alex = alex;   
	}
	
	public UnidadLexica unidadTipoInt() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.TIPOINT);
    }
	public UnidadLexica unidadTipoReal() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.TIPOREAL);
    }
	public UnidadLexica unidadTipoBool() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.TIPOBOOL);
    }
	public UnidadLexica unidadTipoString() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.TIPOSTRING);
    }
	public UnidadLexica unidadAnd() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.AND);
    }
	public UnidadLexica unidadOr() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.OR);
    }
	public UnidadLexica unidadNot() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.NOT);
    }
	public UnidadLexica unidadTrue() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.TRUE);
    }
    public UnidadLexica unidadFalse() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.FALSE);
    }
    public UnidadLexica unidadVar() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.VAR);
    }
    public UnidadLexica unidadType() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.TYPE);
    }
    public UnidadLexica unidadProc() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.PROC);
    }
    public UnidadLexica unidadNull() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.NULL);
    }
    public UnidadLexica unidadIf() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.IF);
    }
    public UnidadLexica unidadThen() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.THEN);
    }
    public UnidadLexica unidadElse() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.ELSE);
    }
    public UnidadLexica unidadEndIf() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.ENDIF);
    }
    public UnidadLexica unidadWhile() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.WHILE);
    }
    public UnidadLexica unidadDo() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.DO);
    }
    public UnidadLexica unidadEndWhile() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.ENDWHILE);
    }
    public UnidadLexica unidadCall() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.CALL);
    }
    public UnidadLexica unidadRecord() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.RECORD);
    }
    public UnidadLexica unidadArray() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.ARRAY);
    }
    public UnidadLexica unidadOf() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.OF);
    }
    public UnidadLexica unidadPointer() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.POINTER);
    }
    public UnidadLexica unidadNew() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.NEW);
    }
    public UnidadLexica unidadDelete() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.DELETE);
    }
    public UnidadLexica unidadRead() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.READ);
    }
    public UnidadLexica unidadWrite() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.WRITE);
    }
    public UnidadLexica unidadNL() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.NL);
    }
    public UnidadLexica unidadCadena() {
    	return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(), ClaseLexica.CADENA, alex.lexema());
    }
    public UnidadLexica unidadId() {
    	return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(), ClaseLexica.IDENTIF, alex.lexema());
    }
	public UnidadLexica unidadEnt() {
		return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(), ClaseLexica.ENTERO, alex.lexema());
	}
	public UnidadLexica unidadReal() {
		return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(), ClaseLexica.REAL, alex.lexema());
	}
	public UnidadLexica unidadComa() {
		return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.COMA);
	}
	public UnidadLexica unidadPuntoComa() {
		return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.PUNTOCOMA);
	}
	public UnidadLexica unidadAsig() {
		return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.ASIG);
	}	
	public UnidadLexica unidadSepSec() {
		return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.SEPSEC);
	}
	public UnidadLexica unidadMas() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.MAS);     
	}    
	public UnidadLexica unidadMenos() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.MENOS);     
	}    
	public UnidadLexica unidadPor() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.POR);     
	}    
	public UnidadLexica unidadDiv() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.DIV);     
	}    
	public UnidadLexica unidadMod() {
		return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.MOD);
	}
	public UnidadLexica unidadPAp() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.PAP);     
	}    
	public UnidadLexica unidadPCie() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.PCIE);     
	}
	public UnidadLexica unidadCAp() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.CAP);
    }
	public UnidadLexica unidadCCie() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.CCIE);
    }
	public UnidadLexica unidadLlAp() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.LLAP);
    }
	public UnidadLexica unidadLlCie() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.LLCIE);
    }
	public UnidadLexica unidadPunto() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.PUNTO);
    }
	public UnidadLexica unidadFlecha() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.FLECHA);
    }
	public UnidadLexica unidadAmp() {
    	return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(), ClaseLexica.AMP);
    }
	public UnidadLexica unidadMenor() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.MENOR);     
	}
	public UnidadLexica unidadMayor() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.MAYOR);     
	}
	public UnidadLexica unidadMenIgual() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.MENIGUAL);     
	}
	public UnidadLexica unidadMayIgual() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.MAYIGUAL);     
	}
	public UnidadLexica unidadIgual() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.IGUAL);     
	} 
	public UnidadLexica unidadDist() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.DIST);     
	} 
	public UnidadLexica unidadEof() {
		return new UnidadLexicaUnivaluada(alex.fila(),alex.columna(),ClaseLexica.EOF);     
	}
 
	public void error() {
	    System.err.println("*** fila: "+alex.fila()+ ", columna: " + alex.columna() + " Caracter inesperado: "+ alex.lexema());
	}
}
