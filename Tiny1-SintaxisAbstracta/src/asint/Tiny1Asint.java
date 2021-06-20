package asint;

import c_ast_descendente.Token;

public class Tiny1Asint {
	
	public static abstract class Genero {
		public int _dir;
		public int _tam;
		public int _nivel;
		public String _tipo;
		public Genero _vinculo;
	}
	
	
	public static abstract class Exp  extends Genero{
        public Exp() {
        }   
        public abstract int prioridad();
        public abstract void procesa(Procesamiento procesamiento) throws Exception;
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
        
        public StringLocalizado(Token id) {
        	this(id.toString(), id.beginLine, id.beginColumn);
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
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Resta extends ExpAditiva {
    	public Resta(Exp arg0, Exp arg1) {
    		super(arg0, arg1);
    	}
    	public void procesa(Procesamiento p) throws Exception {
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
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Or extends ExpBooleana {
    	public Or(Exp arg0, Exp arg1) {
    		super(arg0, arg1);
    	}
    	public void procesa(Procesamiento p) throws Exception {
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
        public void procesa(Procesamiento p) throws Exception {
           p.procesa(this); 
        }     
    }
    public static class Menor extends ExpRelacional {
        public Menor(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) throws Exception {
           p.procesa(this); 
        }     
    }
    public static class Mayor extends ExpRelacional {
        public Mayor(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) throws Exception {
           p.procesa(this); 
        }     
    }
    public static class Menor_igual extends ExpRelacional {
        public Menor_igual(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) throws Exception {
           p.procesa(this); 
        }     
    }
    public static class Mayor_igual extends ExpRelacional {
        public Mayor_igual(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) throws Exception {
           p.procesa(this); 
        }     
    }
    public static class Dist extends ExpRelacional {
        public Dist(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) throws Exception {
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
        public void procesa(Procesamiento p) throws Exception {
           p.procesa(this); 
        }     
    }
    public static class Div extends ExpMultiplicativa {
        public Div(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) throws Exception {
           p.procesa(this); 
        }     
    }
    public static class Mod extends ExpMultiplicativa {
        public Mod(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) throws Exception {
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
        public void procesa(Procesamiento p) throws Exception {
            p.procesa(this); 
         }    
    }
    public static class Not extends ExpPrefijo {
		public Not(Exp arg) {
			super(arg);
		}
        public void procesa(Procesamiento p) throws Exception {
            p.procesa(this); 
         }    
    }
    
    
    public static class Indirecto extends ExpUn{
    	public Indirecto(Exp arg) {
    		super(arg);
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 6;
    	}
    }
    
    public static class Indice extends ExpBin{
		public Indice(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}
		public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 5;
    	}
    }
    
    public static abstract class ExpReg extends Exp{
    	private Exp arg;
    	private StringLocalizado id;
    	public ExpReg(Exp arg, StringLocalizado id) {
    		this.arg = arg;
    		this.id = id;
    	}
    	public Exp arg() {return arg;}
    	public StringLocalizado id() {return id;}
    	public final int prioridad() {
    		return 5;
    	}
    }
    public static class Reg_punto extends ExpReg{
    	public Reg_punto(Exp arg, StringLocalizado id) {
    		super(arg, id);
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Reg_flecha extends ExpReg{
    	public Reg_flecha(Exp arg, StringLocalizado id) {
    		super(arg, id);
    	}
    	public void procesa(Procesamiento p) throws Exception {
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
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 7;
    	}
    }
    public static class Real extends Exp {
    	private StringLocalizado real;
    	public Real(StringLocalizado real) {
    		super();
    		this.real = real;
    	}
    	public StringLocalizado real() {return real;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 7;
    	}
    }
    
    public static class True extends Exp {
    	public True() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 7;
    	}
    }
    public static class False extends Exp {
    	public False() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 7;
    	}
    }
    
    public static class Cadena extends Exp{
    	private StringLocalizado cadena;
    	public Cadena(StringLocalizado cadena) {
    		super();
    		this.cadena = cadena;
    	}
    	public StringLocalizado cadena() {return cadena;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 7;
    	}
    }
    
    public static class Identif extends Exp{
    	private StringLocalizado id;
    	public Identif(StringLocalizado id) {
    		super();
    		this.id = id;
    	}
    	public StringLocalizado id() {return id;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 7;
    	}
    }
    
    public static class Null extends Exp{
    	public Null() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    	public final int prioridad() {
    		return 7;
    	}
    }
    
    public static abstract class Bloque extends Genero{
    	public Bloque() {}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Bloque_no_vacio extends Bloque{
    	private Prog prog;
    	public Bloque_no_vacio(Prog prog) {
    		super();
    		this.prog = prog;
    	}
    	public Prog prog() {return prog;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Bloque_vacio extends Bloque{
    	public Bloque_vacio() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
        
    public static abstract class Insts extends Genero{
    	public Insts() {}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Insts_no_vacia extends Insts{
    	private LInsts linsts;
    	public Insts_no_vacia(LInsts linsts) {
    		super();
    		this.linsts = linsts;
    	}
    	public LInsts linsts() {return linsts;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Insts_vacia extends Insts{
    	public Insts_vacia() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }

    public static abstract class Lparamsr  extends Genero{
    	public Lparamsr() {}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Lparamsr_uno extends Lparamsr {
        private Exp exp; 
        public Lparamsr_uno(Exp exp) {
        	super();
        	this.exp = exp;
        }   
        public Exp exp() {return exp;}
        public void procesa(Procesamiento p)  throws Exception{
            p.procesa(this); 
         }     
     }
     public static class Lparamsr_muchos extends Lparamsr {
        private Exp exp;
        private Lparamsr lparams;
        public Lparamsr_muchos(Lparamsr lparams, Exp exp) {
           this.exp = exp;
           this.lparams = lparams;
        }
        public Exp exp() {return exp;}
        public Lparamsr lparams() {return lparams;}
        public void procesa(Procesamiento p) throws Exception {
            p.procesa(this); 
         }     
     }
    
     public static abstract class Paramsr extends Genero{
    	 public Paramsr() {}
    	 public abstract void procesa(Procesamiento p) throws Exception;
     }
    public static class Paramsr_vacio extends Paramsr{
    	public Paramsr_vacio() {
    		super();
    	}
    	public void procesa(Procesamiento p)  throws Exception{
    		p.procesa(this);
    	}
    }
    public static class Paramsr_no_vacio extends Paramsr{
    	private Lparamsr lparams;
    	public Paramsr_no_vacio(Lparamsr lparams) {
    		super();
    		this.lparams = lparams;
    	}
    	public Lparamsr lparams() {return lparams;}
    	public void procesa(Procesamiento p)  throws Exception{
    		p.procesa(this);
    	}
    }
    
    public static abstract class Inst  extends Genero{
    	public Inst() {}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Inst_asig extends Inst{
    	private Exp arg0, arg1;
    	public Inst_asig(Exp arg0, Exp arg1) {
    		super();
    		this.arg0 = arg0;
    		this.arg1 = arg1;
    	}
    	public Exp arg0() {return arg0;}
    	public Exp arg1() {return arg1;}
    	public void procesa(Procesamiento p)  throws Exception{
    		p.procesa(this);
    	}
    }
    public static class Inst_if extends Inst{
    	private Exp exp;
    	private Insts insts;
    	public Inst_if(Exp exp, Insts inst) {
    		super();
    		this.exp = exp;
    		this.insts = inst;
    	}
    	public Exp exp() { return exp;}
    	public Insts insts() {return insts;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_if_else extends Inst{
    	private Exp exp;
    	private Insts insts1, insts2;
    	public Inst_if_else(Exp exp, Insts inst1, Insts inst2) {
    		super();
    		this.exp = exp;
    		this.insts1 = inst1;
    		this.insts2 = inst2;
    	}
    	public Exp exp() {return exp;}
    	public Insts insts1() {return insts1;}
    	public Insts insts2() {return insts2;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_while extends Inst{
    	private Exp exp;
    	private Insts insts;
    	public Inst_while(Exp exp, Insts inst) {
    		super();
    		this.exp = exp;
    		this.insts = inst;
    	}
    	public Exp exp() { return exp;}
    	public Insts insts() {return insts;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_read extends Inst{
    	private Exp exp;
    	public Inst_read(Exp exp) {
    		super();
    		this.exp = exp;
    	}
    	public Exp exp() {return exp;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_write extends Inst{
    	private Exp exp;
    	public Inst_write(Exp exp) {
    		super();
    		this.exp = exp;
    	}
    	public Exp exp() {return exp;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_nl extends Inst{
    	public Inst_nl() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_new extends Inst{
    	private Exp exp;
    	public Inst_new(Exp exp) {
    		super();
    		this.exp = exp;
    	}
    	public Exp exp() {return exp;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_delete extends Inst{
    	private Exp exp;
    	public Inst_delete(Exp exp) {
    		super();
    		this.exp = exp;
    	}
    	public Exp exp() {return exp;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_call extends Inst{
    	private StringLocalizado identif;
    	private Paramsr paramsr;
    	public Inst_call(StringLocalizado identif, Paramsr paramsr) {
    		super();
    		this.identif = identif;
    		this.paramsr = paramsr;
    	}
    	public StringLocalizado identif() {return identif;}
    	public Paramsr paramsr() {return paramsr;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Inst_bloque extends Inst{
    	private Bloque bloque;
    	public Inst_bloque(Bloque bloque) {
    		super();
    		this.bloque = bloque;
    	}
    	public Bloque bloque() {return bloque;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static abstract class LInsts  extends Genero{
    	public LInsts() {
    	}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Insts_una extends LInsts {
    	private Inst inst;
    	public Insts_una(Inst inst) {
    		super();
    		this.inst = inst;
    	}
    	public Inst inst() {return inst;}
		public void procesa(Procesamiento p) throws Exception {
			p.procesa(this);
		}
    }
    public static class Insts_muchas extends LInsts {
    	private Inst inst;
    	private LInsts linsts;
    	public Insts_muchas(LInsts linsts, Inst inst) {
    		super();
    		this.inst = inst;
    		this.linsts = linsts;
    	}
    	public Inst inst() {return inst;}
    	public LInsts linsts() {return linsts;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    
    public static abstract class Tipo extends Genero{
    	public Tipo() {
    	}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Tipo_int extends Tipo {
    	public Tipo_int() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Tipo_bool extends Tipo {
    	public Tipo_bool() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Tipo_real extends Tipo {
    	public Tipo_real() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Tipo_string extends Tipo {
    	public Tipo_string() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    
    public static class Tipo_array extends Tipo {
    	private StringLocalizado tam;
    	private Tipo tipo;
    	public Tipo_array(StringLocalizado tam,Tipo tipo) {
    		super();
    		this.tam = tam;
    		this.tipo = tipo;
    	}
    	public StringLocalizado entero() {return tam;}
    	public Tipo tipo() {return tipo;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Tipo_pointer extends Tipo {
    	private Tipo tipo;
    	public Tipo_pointer(Tipo tipo) {
    		super();
    		this.tipo = tipo;
    	}
    	public Tipo tipo() {return tipo;}
    	public void procesa(Procesamiento p) throws Exception  {
    		p.procesa(this);
    	}
    }
    
    public static abstract class LTipos extends Genero{
    	public LTipos() {}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Tipos_uno extends LTipos {
        private Tipo tipo; 
        private StringLocalizado id;
        public Tipos_uno(Tipo tipo, StringLocalizado id) {
        	super();
        	this.tipo = tipo;
        	this.id = id;
        }   
        public Tipo tipo() {return tipo;}
        public StringLocalizado id() {return id;}
        public void procesa(Procesamiento p) throws Exception {
            p.procesa(this); 
        }     
     }
     public static class Tipos_muchos extends LTipos {
        private Tipo tipo;
        private LTipos ltipos;
        private StringLocalizado id;
        public Tipos_muchos(LTipos ltipos, Tipo tipo, StringLocalizado id) {
        	super();
        	this.tipo = tipo;
        	this.ltipos = ltipos;
        	this.id = id;
        }
        public Tipo tipo() {return tipo;}
        public LTipos ltipos() {return ltipos;}
        public StringLocalizado id() {return id;}
        public void procesa(Procesamiento p) throws Exception {
            p.procesa(this); 
        }     
     }
    
    public static class Tipo_record extends Tipo {
    	private LTipos ltipos;
    	public Tipo_record(LTipos ltipos) {
    		super();
    		this.ltipos = ltipos;
    	}
    	public LTipos ltipos() {return ltipos;}
    	public void procesa(Procesamiento p) throws Exception  {
    		p.procesa(this);
    	}
    }
    
    public static class Ref extends Tipo {
    	private StringLocalizado id;
    	public Ref(StringLocalizado id) {
    		super();
    		this.id = id;
    	}
    	public StringLocalizado id() {return id;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    
    public static abstract class Paramf extends Genero{
    	private Tipo tipo;
    	private StringLocalizado id;
    	public Paramf(Tipo tipo, StringLocalizado id) {
    		this.tipo = tipo;
    		this.id = id;
    	}
    	public Tipo tipo() {return tipo;}
    	public StringLocalizado id() {return id;}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Paramf_valor extends Paramf{
    	public Paramf_valor(Tipo tipo, StringLocalizado id) {
    		super(tipo, id);
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Paramf_referencia extends Paramf{
    	public Paramf_referencia(Tipo tipo, StringLocalizado id) {
    		super(tipo, id);
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }

    public static abstract class Lparamsf  extends Genero{
    	public Lparamsf() {
    	}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Lparamsf_uno extends Lparamsf {
        private Paramf paramf; 
        public Lparamsf_uno(Paramf paramf) {
           super();
           this.paramf = paramf;
        }   
        public Paramf paramf() {return paramf;}
        public void procesa(Procesamiento p) throws Exception {
            p.procesa(this); 
         }     
     }
     public static class Lparamsf_muchos extends Lparamsf {
        private Paramf paramf;
        private Lparamsf lparams;
        public Lparamsf_muchos(Lparamsf lparams, Paramf paramf) {
           super();
           this.paramf = paramf;
           this.lparams = lparams;
        }
        public Paramf paramf() {return paramf;}
        public Lparamsf lparams() {return lparams;}
        public void procesa(Procesamiento p) throws Exception {
            p.procesa(this); 
         }     
     }
    
     public static abstract class Paramsf extends Genero{
    	 public Paramsf() {}
     	public abstract void procesa(Procesamiento p) throws Exception;
     }
    public static class Paramsf_vacio extends Paramsf{
    	public Paramsf_vacio() {
    		super();
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Paramsf_no_vacio extends Paramsf{
    	private Lparamsf lparams;
    	public Paramsf_no_vacio(Lparamsf lparams) {
    		super();
    		this.lparams = lparams;
    	}
    	public Lparamsf lparams() {return lparams;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    
    public abstract static class Dec extends Genero{
    	public Dec() {}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    
    public abstract static class Dec_id extends Dec{
    	private StringLocalizado variable;
    	private Tipo tipo;
    	public Dec_id(Tipo tipo, StringLocalizado variable) {
    		this.variable = variable;
    		this.tipo = tipo;
    	}
    	public StringLocalizado variable() {return variable;}
    	public Tipo tipo() {return tipo;}
    }
    public static class Dec_var extends Dec_id{
    	public Dec_var(Tipo tipo, StringLocalizado variable) {
    		super(tipo,variable);
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    public static class Dec_type extends Dec_id{
    	public Dec_type(Tipo tipo, StringLocalizado variable) {
    		super(tipo,variable);
    	}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    
    public static class Dec_proc extends Dec{
    	private StringLocalizado id;
    	private Paramsf paramsf;
    	private Bloque bloque;
    	public Dec_proc(StringLocalizado id, Paramsf paramsf, Bloque bloque) {
    		super();
    		this.id = id;
    		this.paramsf = paramsf;
    		this.bloque = bloque;
    	}
    	public StringLocalizado id(){return id;}
    	public Paramsf paramsf() {return paramsf;}
    	public Bloque bloque() {return bloque;}
    	public void procesa(Procesamiento p) throws Exception {
    		p.procesa(this);
    	}
    }
    
    public static abstract class LDecs  extends Genero{
    	public LDecs() {}
    	public abstract void procesa(Procesamiento p) throws Exception;
    }
    public static class Decs_una extends LDecs {
        private Dec dec; 
        public Decs_una(Dec dec) {
           super();
           this.dec = dec;
        }   
        public Dec dec() {return dec;}
        public void procesa(Procesamiento p) throws Exception {
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
        public void procesa(Procesamiento p) throws Exception {
            p.procesa(this); 
         }     
     }
     
     public static class Prog_con_decs extends Prog{
    	 private LDecs ldecs;
    	 private LInsts linsts;
    	 public Prog_con_decs(LDecs ldecs, LInsts linsts) {
    		 super();
    		 this.ldecs = ldecs;
    		 this.linsts = linsts;
    	 }
    	 public LDecs ldecs() {return ldecs;}
    	 public LInsts linsts() {return linsts;}
    	 public void procesa(Procesamiento p) throws Exception {
    		 p.procesa(this);
    	 }
     }
     
     
     public static class Prog_sin_decs extends Prog{
    	 private LInsts linsts;
    	 public Prog_sin_decs(LInsts linsts) {
    		 super();
    		 this.linsts = linsts;
    	 }
    	 public LInsts linsts() {return linsts;}
    	 public void procesa(Procesamiento p) throws Exception {
    		 p.procesa(this);
    	 }
     }
     
     public static abstract class Prog  extends Genero{
    	 public abstract void procesa(Procesamiento p) throws Exception;
     }
     
     // Constructoras
     public Prog_sin_decs prog_sin_decs(LInsts linsts) {
    	 return new Prog_sin_decs(linsts);
     }
     public Prog_con_decs prog_con_decs(LDecs ldecs, LInsts linsts) {
    	 return new Prog_con_decs(ldecs, linsts);
     }
     public LDecs decs_una(Dec dec) {
    	 return new Decs_una(dec);
     }
     public LDecs decs_muchas(LDecs ldecs, Dec dec) {
    	 return new Decs_muchas(ldecs, dec);
     }
     public Dec dec_var(Tipo tipo, StringLocalizado variable) {
    	 return new Dec_var(tipo, variable);
     }
     public Dec dec_type(Tipo tipo, StringLocalizado variable) {
    	 return new Dec_type(tipo, variable);
     }
     public Dec dec_proc(StringLocalizado variable,Paramsf paramsf, Bloque bloque) {
    	 return new Dec_proc(variable,paramsf,bloque);
     }
     public Paramsf paramsf_vacio() {
    	 return new Paramsf_vacio();
     }
     public Paramsf paramsf_no_vacio(Lparamsf lparamsf) {
    	 return new Paramsf_no_vacio(lparamsf);
     }
     public Lparamsf lparamsf_uno(Paramf paramf) {
    	 return new Lparamsf_uno(paramf);
     }
     public Lparamsf lparamsf_muchos(Lparamsf lparamsf,Paramf paramf) {
    	 return new Lparamsf_muchos(lparamsf,paramf);
     }
     public Paramf paramf_referencia(Tipo tipo, StringLocalizado str) {
    	 return new Paramf_referencia(tipo,str);
     }
     public Paramf paramf_valor(Tipo tipo, StringLocalizado str) {
    	 return new Paramf_valor(tipo,str);
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
     public Tipo tipo_string() {
    	 return new Tipo_string();
     }
     public Tipo tipo_array(StringLocalizado tam, Tipo tipo) {
    	 return new Tipo_array(tam,tipo);
     }
     public Tipo tipo_pointer(Tipo tipo) {
    	 return new Tipo_pointer(tipo);
     }
     public Tipo tipo_record(LTipos ltipos) {
    	 return new Tipo_record(ltipos);
     }
     public Tipo ref(StringLocalizado id) {
    	 return new Ref(id);
     }
     public LTipos tipos_uno(Tipo tipo, StringLocalizado id) {
    	 return new Tipos_uno(tipo, id);
     }
     public LTipos tipos_muchos(LTipos ltipos, Tipo tipo, StringLocalizado id) {
    	 return new Tipos_muchos(ltipos, tipo, id);
     }
     public LInsts insts_una(Inst inst) {
    	 return new Insts_una(inst);
     }
     public LInsts insts_muchas(LInsts linsts,Inst inst) {
    	 return new Insts_muchas(linsts, inst);
     }
     public Inst inst_asig(Exp arg0, Exp arg1) {
    	 return new Inst_asig(arg0, arg1);
     }
     public Inst inst_if(Exp exp, Insts inst) {
    	 return new Inst_if(exp,inst);
     }
     public Inst inst_if_else(Exp exp, Insts inst1, Insts inst2) {
    	 return new Inst_if_else(exp,inst1,inst2);
     }
     public Inst inst_while(Exp exp, Insts inst) {
    	 return new Inst_while(exp,inst);
     }
     public Inst inst_read(Exp exp) {
    	 return new Inst_read(exp);
     }
     public Inst inst_write(Exp exp) {
    	 return new Inst_write(exp);
     }
     public Inst inst_nl() {
    	 return new Inst_nl();
     }
     public Inst inst_new(Exp exp) {
    	 return new Inst_new(exp);
     }
     public Inst inst_delete(Exp exp) {
    	 return new Inst_delete(exp);
     }
     public Inst inst_call(StringLocalizado str, Paramsr paramsr) {
    	 return new Inst_call(str,paramsr);
     }
     public Inst inst_bloque(Bloque bloque) {
    	 return new Inst_bloque(bloque);
     }
     public Paramsr paramsr_vacio() {
    	 return new Paramsr_vacio();
     }
     public Paramsr paramsr_no_vacio(Lparamsr lparams) {
    	 return new Paramsr_no_vacio(lparams);
     }
     public Lparamsr lparamsr_uno(Exp exp) {
    	 return new Lparamsr_uno(exp);
     }
     public Lparamsr lparamsr_muchos(Lparamsr lparams, Exp exp) {
    	 return new Lparamsr_muchos(lparams, exp);
     }
     public Insts insts_vacia() {
    	 return new Insts_vacia();
     }
     public Insts insts_no_vacia(LInsts linsts) {
    	 return new Insts_no_vacia(linsts);
     }
     public Bloque bloque_vacio() {
    	 return new Bloque_vacio();
     }
     public Bloque bloque_no_vacio(Prog prog) {
    	 return new Bloque_no_vacio(prog);
     }
     public Exp entero(StringLocalizado entero) {
    	 return new Entero(entero);
     }
     public Exp real(StringLocalizado real) {
    	 return new Real(real);
     }
     public Exp _true() {
    	 return new True();
     }
     public Exp _false() {
    	 return new False();
     }
     public Exp cadena(StringLocalizado cadena) {
    	 return new Cadena(cadena);
     }
     public Exp identif(StringLocalizado id) {
    	 return new Identif(id);
     }
     public Exp _null() {
    	 return new Null();
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
     public Exp mod(Exp arg0, Exp arg1) {
    	 return new Mod(arg0,arg1);
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
     public Exp indirecto(Exp exp) {
    	 return new Indirecto(exp);
     }
     public Exp indice(Exp arg0, Exp arg1) {
    	 return new Indice(arg0, arg1);
     }
     public Exp reg_punto(Exp arg, StringLocalizado id) {
    	 return new Reg_punto(arg, id);
     }
     public Exp reg_flecha(Exp arg, StringLocalizado id) {
    	 return new Reg_flecha(arg, id);
     }
     
     public StringLocalizado str(String s, int fila, int col) {
    	 return new StringLocalizado(s, fila, col);
     }
	
}

