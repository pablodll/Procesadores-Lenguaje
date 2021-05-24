package asint;

public class Tiny0ASint {

	public static abstract class Exp  {
        public Exp() {
        }   
        public abstract int prioridad();
        public abstract void procesa(Procesamiento procesamiento);
     }
	
    public static class StringLocalizado {
        private String s;
        private int fila;
        private int col;
        
        public StringLocalizado(String s, int fila, int col) {
            this.s = s;
            this.fila = fila;
            this.col = col;
        }
        
        public int fila() {return fila;}
        public int col() {return col;}
        
        public String toString() {
        	return s;
        }
        
        public boolean equals(Object o) {
            return (o == this) || (
                    (o instanceof StringLocalizado) &&
                    (((StringLocalizado)o).s.equals(s)));                
        }
        
        public int hashCode() {
            return s.hashCode();
        }
    }
    
    public static abstract class ExpBin extends Exp {
    	private Exp arg0;
    	private Exp arg1;
    	public Exp arg0() {return arg0;}
    	public Exp arg1() {return arg1;}
    	public ExpBin(Exp arg0, Exp arg1) {
    		super();
    		this.arg0 = arg0;
    		this.arg1 = arg1;
    	}
    }
    
    public static abstract class ExpAditiva extends ExpBin {
    	public ExpAditiva(Exp arg0, Exp arg1) {
    		super(arg0, arg1);
    	}
    	public final int prioridad() {
    		return 0;
    	}
    }
    public static class Suma extends ExpAditiva {
    	public Suma(Exp arg0, Exp arg1) {
    		super(arg0, arg1);
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    public static class Resta extends ExpAditiva {
    	public Resta(Exp arg0, Exp arg1) {
    		super(arg0, arg1);
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    
    private static abstract class ExpBooleana extends ExpBin {
    	public ExpBooleana(Exp arg0, Exp arg1) {
    		super(arg0, arg1);
    	}
    	public final int prioridad() {
    		return 1;
    	}
    }
    public static class And extends ExpBooleana {
    	public And(Exp arg0, Exp arg1) {
    		super(arg0, arg1);
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    public static class Or extends ExpBooleana {
    	public Or(Exp arg0, Exp arg1) {
    		super(arg0, arg1);
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    
    private static abstract class ExpRelacional extends ExpBin {
        public ExpRelacional(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public final int prioridad() {
            return 2;
        }
    }
    public static class Igual extends ExpRelacional {
        public Igual(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Menor extends ExpRelacional {
        public Menor(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Mayor extends ExpRelacional {
        public Mayor(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Menor_igual extends ExpRelacional {
        public Menor_igual(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Mayor_igual extends ExpRelacional {
        public Mayor_igual(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Dist extends ExpRelacional {
        public Dist(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    
    private static abstract class ExpMultiplicativa extends ExpBin {
        public ExpMultiplicativa(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public final int prioridad() {
            return 3;
        }
    }
    public static class Mul extends ExpMultiplicativa {
        public Mul(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Div extends ExpMultiplicativa {
        public Div(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    
    public static abstract class ExpUn extends Exp {
    	private Exp arg;
    	public Exp arg() {return arg;}
    	public ExpUn(Exp arg) {
    		super();
    		this.arg = arg;
    	}
    }
    private static abstract class ExpPrefijo extends ExpUn {
    	public ExpPrefijo(Exp arg) {
    		super(arg);
    	}
    	public final int prioridad() {
    		return 4;
    	}
    }
    public static class Menos extends ExpPrefijo {
		public Menos(Exp arg) {
			super(arg);
		}
        public void procesa(Procesamiento p) {
            p.procesa(this); 
         }    
    }
    public static class Not extends ExpPrefijo {
		public Not(Exp arg) {
			super(arg);
		}
        public void procesa(Procesamiento p) {
            p.procesa(this); 
         }    
    }
    
    public static class Entero extends Exp {
    	private StringLocalizado entero;
    	public Entero(StringLocalizado entero) {
    		super();
    		this.entero = entero;
    	}
    	public StringLocalizado entero() {return entero;}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 5;
    	}
    }
    public static class Real extends Exp {
    	private StringLocalizado real;
    	public Real(StringLocalizado real) {
    		super();
    		this.real = real;
    	}
    	public StringLocalizado real() {return real;}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 5;
    	}
    }
    public static class Variable extends Exp {
    	private StringLocalizado variable;
    	public Variable(StringLocalizado variable) {
    		super();
    		this.variable = variable;
    	}
    	public StringLocalizado variable() {return variable;}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 5;
    	}
    }
    public static class True extends Exp {
    	public True() {
    		super();
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 5;
    	}
    }
    public static class False extends Exp {
    	public False() {
    		super();
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 5;
    	}
    }
    
    public static abstract class Inst {
    	public Inst() {
    	}
    	public abstract void procesa(Procesamiento p);
    }
    public static class Asig extends Inst{
    	private StringLocalizado variable;
    	private Exp arg;
    	public Asig(StringLocalizado variable, Exp arg) {
    		this.variable = variable;
    		this.arg = arg;
    	}
    	public StringLocalizado variable() {return variable;}
    	public Exp arg() {return arg;}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    
    public static abstract class LInsts {
    	public LInsts() {
    	}
    	public abstract void procesa(Procesamiento p);
    }
    public static class Insts_una extends LInsts {
    	private Inst inst;
    	public Insts_una(Inst inst) {
    		super();
    		this.inst = inst;
    	}
    	public Inst inst() {return inst;}
		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
    }
    public static class Insts_muchas extends LInsts {
    	private Inst inst;
    	private LInsts linsts;
    	public Insts_muchas(LInsts linsts, Inst inst) {
    		this.inst = inst;
    		this.linsts = linsts;
    	}
    	public Inst inst() {return inst;}
    	public LInsts linsts() {return linsts;}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    
    public static abstract class Tipo {
    	public Tipo() {
    	}
    	public abstract void procesa(Procesamiento p);
    }
    public static class Tipo_int extends Tipo {
    	public Tipo_int() {
    		super();
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    public static class Tipo_bool extends Tipo {
    	public Tipo_bool() {
    		super();
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    public static class Tipo_real extends Tipo {
    	public Tipo_real() {
    		super();
    	}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    
    public static class Dec {
    	private StringLocalizado variable;
    	private Tipo tipo;
    	public Dec(Tipo tipo, StringLocalizado variable) {
    		this.variable = variable;
    		this.tipo = tipo;
    	}
    	public StringLocalizado variable() {return variable;}
    	public Tipo tipo() {return tipo;}
    	public void procesa(Procesamiento p) {
    		p.procesa(this);
    	}
    }
    public static abstract class LDecs {
    	public LDecs() {
    	}
    	public abstract void procesa(Procesamiento p);
    }
    public static class Decs_una extends LDecs {
        private Dec dec; 
        public Decs_una(Dec dec) {
           super();
           this.dec = dec;
        }   
        public Dec dec() {return dec;}
        public void procesa(Procesamiento p) {
            p.procesa(this); 
         }     
     }
     public static class Decs_muchas extends LDecs {
        private Dec dec;
        private LDecs ldecs;
        public Decs_muchas(LDecs ldecs, Dec dec) {
           super();
           this.dec = dec;
           this.ldecs = ldecs;
        }
        public Dec dec() {return dec;}
        public LDecs ldecs() {return ldecs;}
        public void procesa(Procesamiento p) {
            p.procesa(this); 
         }     
     }
     
     public static class Prog {
    	 private LDecs ldecs;
    	 private LInsts linsts;
    	 public Prog(LDecs ldecs, LInsts linsts) {
    		 this.ldecs = ldecs;
    		 this.linsts = linsts;
    	 }
    	 public LDecs ldecs() {return ldecs;}
    	 public LInsts linsts() {return linsts;}
    	 public void procesa(Procesamiento p) {
    		 p.procesa(this);
    	 }
     }
     
     // Constructoras
     public Prog prog(LDecs ldecs, LInsts linsts) {
    	 return new Prog(ldecs, linsts);
     }
     public LDecs decs_una(Dec dec) {
    	 return new Decs_una(dec);
     }
     public LDecs decs_muchas(LDecs ldecs, Dec dec) {
    	 return new Decs_muchas(ldecs, dec);
     }
     public Dec dec(Tipo tipo, StringLocalizado variable) {
    	 return new Dec(tipo, variable);
     }
     public Tipo tipo_int() {
    	 return new Tipo_int();
     }
     public Tipo tipo_bool() {
    	 return new Tipo_bool();
     }
     public Tipo tipo_real() {
    	 return new Tipo_real();
     }
     public LInsts inst_una(Inst inst) {
    	 return new Insts_una(inst);
     }
     public LInsts inst_muchas(LInsts linsts, Inst inst) {
    	 return new Insts_muchas(linsts, inst);
     }
     public Inst asig(StringLocalizado variable, Exp arg) {
    	 return new Asig(variable, arg);
     }
     public Exp entero(StringLocalizado entero) {
    	 return new Entero(entero);
     }
     public Exp real(StringLocalizado real) {
    	 return new Real(real);
     }
     public Exp varaible(StringLocalizado variable) {
    	 return new Variable(variable);
     }
     public Exp _true() {
    	 return new True();
     }
     public Exp _false() {
    	 return new False();
     }
     public Exp suma(Exp arg0, Exp arg1) {
    	 return new Suma(arg0, arg1);
     }
     public Exp resta(Exp arg0, Exp arg1) {
    	 return new Resta(arg0, arg1);
     }
     public Exp mul(Exp arg0, Exp arg1) {
    	 return new Mul(arg0, arg1);
     }
     public Exp div(Exp arg0, Exp arg1) {
    	 return new Div(arg0, arg1);
     }
     public Exp and(Exp arg0, Exp arg1) {
    	 return new And(arg0, arg1);
     }
     public Exp or(Exp arg0, Exp arg1) {
    	 return new Or(arg0, arg1);
     }
     public Exp igual(Exp arg0, Exp arg1) {
    	 return new Igual(arg0, arg1);
     }
     public Exp menor(Exp arg0, Exp arg1) {
    	 return new Menor(arg0, arg1);
     }
     public Exp mayor(Exp arg0, Exp arg1) {
    	 return new Mayor(arg0, arg1);
     }
     public Exp menor_igual(Exp arg0, Exp arg1) {
    	 return new Menor_igual(arg0, arg1);
     }
     public Exp mayor_igual(Exp arg0, Exp arg1) {
    	 return new Mayor_igual(arg0, arg1);
     }
     public Exp dist(Exp arg0, Exp arg1) {
    	 return new Dist(arg0, arg1);
     }
     public Exp not(Exp arg) {
    	 return new Not(arg);
     }
     public Exp menos(Exp arg) {
    	 return new Menos(arg);
     }
     
     public StringLocalizado str(String s, int fila, int col) {
    	 return new StringLocalizado(s, fila, col);
     }
	
}
