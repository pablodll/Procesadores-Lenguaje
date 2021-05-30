package procesamientos;


import asint.ProcesamientoPorDefecto;
import asint.Tiny1Asint.Exp;
import asint.Tiny1Asint.And;
import asint.Tiny1Asint.Bloque_no_vacio;
import asint.Tiny1Asint.Bloque_vacio;
import asint.Tiny1Asint.Cadena;
import asint.Tiny1Asint.Dec_proc;
import asint.Tiny1Asint.Dec_type;
import asint.Tiny1Asint.Dec_var;
import asint.Tiny1Asint.Decs_muchas;
import asint.Tiny1Asint.Decs_una;
import asint.Tiny1Asint.Dist;
import asint.Tiny1Asint.Div;
import asint.Tiny1Asint.Entero;
import asint.Tiny1Asint.False;
import asint.Tiny1Asint.Identif;
import asint.Tiny1Asint.Igual;
import asint.Tiny1Asint.Indice;
import asint.Tiny1Asint.Indirecto;
import asint.Tiny1Asint.Inst_asig;
import asint.Tiny1Asint.Inst_bloque;
import asint.Tiny1Asint.Inst_call;
import asint.Tiny1Asint.Inst_delete;
import asint.Tiny1Asint.Inst_if;
import asint.Tiny1Asint.Inst_if_else;
import asint.Tiny1Asint.Inst_new;
import asint.Tiny1Asint.Inst_nl;
import asint.Tiny1Asint.Inst_read;
import asint.Tiny1Asint.Inst_while;
import asint.Tiny1Asint.Inst_write;
import asint.Tiny1Asint.Insts_muchas;
import asint.Tiny1Asint.Insts_no_vacia;
import asint.Tiny1Asint.Insts_una;
import asint.Tiny1Asint.Insts_vacia;
import asint.Tiny1Asint.Lparamsf_muchos;
import asint.Tiny1Asint.Lparamsf_uno;
import asint.Tiny1Asint.Lparamsr_muchos;
import asint.Tiny1Asint.Lparamsr_uno;
import asint.Tiny1Asint.Mayor;
import asint.Tiny1Asint.Mayor_igual;
import asint.Tiny1Asint.Menor;
import asint.Tiny1Asint.Menor_igual;
import asint.Tiny1Asint.Menos;
import asint.Tiny1Asint.Mod;
import asint.Tiny1Asint.Mul;
import asint.Tiny1Asint.Not;
import asint.Tiny1Asint.Null;
import asint.Tiny1Asint.Or;
import asint.Tiny1Asint.Paramf_referencia;
import asint.Tiny1Asint.Paramf_valor;
import asint.Tiny1Asint.Paramsf_no_vacio;
import asint.Tiny1Asint.Paramsf_vacio;
import asint.Tiny1Asint.Paramsr_no_vacio;
import asint.Tiny1Asint.Paramsr_vacio;
import asint.Tiny1Asint.Prog_con_decs;
import asint.Tiny1Asint.Prog_sin_decs;
import asint.Tiny1Asint.Real;
import asint.Tiny1Asint.Ref;
import asint.Tiny1Asint.Reg_flecha;
import asint.Tiny1Asint.Reg_punto;
import asint.Tiny1Asint.Resta;
import asint.Tiny1Asint.Suma;
import asint.Tiny1Asint.Tipo_array;
import asint.Tiny1Asint.Tipo_bool;
import asint.Tiny1Asint.Tipo_int;
import asint.Tiny1Asint.Tipo_pointer;
import asint.Tiny1Asint.Tipo_real;
import asint.Tiny1Asint.Tipo_record;
import asint.Tiny1Asint.Tipo_string;
import asint.Tiny1Asint.Tipos_muchos;
import asint.Tiny1Asint.Tipos_uno;
import asint.Tiny1Asint.True;

public class Impresion extends ProcesamientoPorDefecto{
	
	public Impresion() {
	}
	
	public void procesa(Suma exp) {
		imprime_arg(exp.arg0(), 1);
	   	System.out.print(" + ");
	   	imprime_arg(exp.arg1(), 0);
	} 
	public void procesa(Resta exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" - ");
		imprime_arg(exp.arg1(), 1);
	}
	public void procesa(And exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" and ");
		imprime_arg(exp.arg1(), 2);
	}
	public void procesa(Or exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" or ");
		imprime_arg(exp.arg1(), 2);
	}
	public void procesa(Igual exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" == ");
		imprime_arg(exp.arg1(), 3);
	}
	public void procesa(Menor exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" < ");
		imprime_arg(exp.arg1(), 3);
	}
	public void procesa(Mayor exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" > ");
		imprime_arg(exp.arg1(), 3);
	}
	public void procesa(Menor_igual exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" <= ");
		imprime_arg(exp.arg1(), 3);
	}
	public void procesa(Mayor_igual exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" >= ");
		imprime_arg(exp.arg1(), 3);
	}
	public void procesa(Dist exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" != ");
		imprime_arg(exp.arg1(), 3);
	}
	public void procesa(Mul exp) {
		imprime_arg(exp.arg0(), 4);
		System.out.print(" * ");
		imprime_arg(exp.arg1(), 4);
	}
	public void procesa(Div exp) {
		imprime_arg(exp.arg0(), 4);
		System.out.print(" / ");
		imprime_arg(exp.arg1(), 4);
	}
	public void procesa(Mod exp) {
		imprime_arg(exp.arg0(), 4);
		System.out.print(" % ");
		imprime_arg(exp.arg1(), 4);
	}
	
	public void procesa(Menos exp) {
		System.out.print(" -");
		imprime_arg(exp.arg(), 5);
	}
	public void procesa(Not exp) {
		System.out.print(" not ");
		imprime_arg(exp.arg(), 4);
	}

	@Override
	public void procesa(Indirecto exp) {
		System.out.print(" *");
		imprime_arg(exp.arg(), 6);
	}

	@Override
	public void procesa(Entero exp) {
	   System.out.print(exp.entero());
	}

	@Override
	public void procesa(Real exp) {
		System.out.print(exp.real());
	}

	@Override
	public void procesa(True exp) {
		System.out.print("true");
	}

	@Override
	public void procesa(False exp) {
		System.out.print("false");
	}

	@Override
	public void procesa(Cadena exp) {
		System.out.print(exp.cadena());
	}

	@Override
	public void procesa(Identif exp) {
		System.out.print(exp.id());
	}

	@Override
	public void procesa(Null exp) {
		System.out.print("null");
	}

	@Override
	public void procesa(Bloque_vacio bloque) {
		System.out.println("{ ");
		
		System.out.println("} ");
	}

	@Override
	public void procesa(Bloque_no_vacio bloque) {
		System.out.println("{ ");
		bloque.prog().procesa(this);
		System.out.println("} ");
	}

	@Override
	public void procesa(Insts_vacia insts) {
		System.out.println();
	}

	@Override
	public void procesa(Insts_no_vacia insts) {
		insts.linsts().procesa(this);
	}

	@Override
	public void procesa(Paramsr_vacio paramsr) {
		System.out.println();
	}

	@Override
	public void procesa(Paramsr_no_vacio paramsr) {
		paramsr.lparams().procesa(this);
	}

	@Override
	public void procesa(Lparamsr_uno lparamsr) {
		lparamsr.exp().procesa(this);
	}

	@Override
	public void procesa(Lparamsr_muchos lparamsr) {
		lparamsr.lparams().procesa(this);
		System.out.print(", ");
		lparamsr.exp().procesa(this);
	}

	@Override
	public void procesa(Inst_asig inst) {
		inst.arg0().procesa(this);
		System.out.print(" = ");
		inst.arg1().procesa(this);
	}

	@Override
	public void procesa(Inst_if inst) {
		System.out.print("if ");
		inst.exp().procesa(this);
		System.out.println(" then");
		inst.insts().procesa(this);
		System.out.println();
		System.out.println("endif");
	}

	@Override
	public void procesa(Inst_if_else inst) {
		System.out.print("if ");
		inst.exp().procesa(this);
		System.out.println(" then");
		inst.insts1().procesa(this);
		System.out.println("else ");
		inst.insts2().procesa(this);
		System.out.println();
		System.out.println("endif");
	}

	@Override
	public void procesa(Inst_while inst) {
		System.out.print("while ");
		inst.exp().procesa(this);
		System.out.println(" do");
		inst.insts().procesa(this);
		System.out.println();
		System.out.println("endwhile");
	}

	@Override
	public void procesa(Inst_read inst) {
		System.out.print("read ");
		inst.exp().procesa(this);
	}

	@Override
	public void procesa(Inst_write inst) {
		System.out.print("write ");
		inst.exp().procesa(this);
	}

	@Override
	public void procesa(Inst_nl inst) {
		System.out.println("nl");
	}

	@Override
	public void procesa(Inst_new inst) {
		System.out.print("new ");
		inst.exp().procesa(this);
	}

	@Override
	public void procesa(Inst_delete inst) {
		System.out.print("delete ");
		inst.exp().procesa(this);
	}

	@Override
	public void procesa(Inst_call inst) {
		System.out.print("call " + inst.identif() + "( ");
		inst.paramsr().procesa(this);
		System.out.println(" )");
	}

	@Override
	public void procesa(Inst_bloque inst) {
		inst.bloque().procesa(this);
	}

	@Override
	public void procesa(Insts_una linsts) {
		linsts.inst().procesa(this);
	}

	@Override
	public void procesa(Insts_muchas linsts) {
		linsts.linsts().procesa(this);
		System.out.println(";");
		linsts.inst().procesa(this);
	}

	@Override
	public void procesa(Tipo_int tipo) {
		System.out.print("int");
	}

	@Override
	public void procesa(Tipo_bool tipo) {
		System.out.print("bool");
	}

	@Override
	public void procesa(Tipo_real tipo) {
		System.out.print("real");
	}

	@Override
	public void procesa(Tipo_string tipo) {
		System.out.print("string");
	}

	@Override
	public void procesa(Tipo_array tipo) {
		System.out.print("array [" + tipo.entero() + "] of ");
		tipo.tipo().procesa(this);
	}

	@Override
	public void procesa(Tipos_uno ltipos) {
		ltipos.tipo().procesa(this);
		System.out.println(ltipos.id());
	}

	@Override
	public void procesa(Tipos_muchos ltipos) {
		ltipos.ltipos().procesa(this);
		System.out.println(";");
		ltipos.tipo().procesa(this);
		System.out.println(ltipos.id());
	}

	@Override
	public void procesa(Tipo_pointer tipo) {
		System.out.print("pointer ");
		tipo.tipo().procesa(this);
	}

	@Override
	public void procesa(Tipo_record tipo) {
		System.out.println("record {");
		tipo.ltipos().procesa(this);
		System.out.println("}");
	}

	@Override
	public void procesa(Ref tipo) {
		System.out.println(tipo.id());
	}

	@Override
	public void procesa(Paramf_valor paramf) {
		paramf.tipo().procesa(this);
		System.out.println(paramf.id());
	}

	@Override
	public void procesa(Paramf_referencia paramf) {
		paramf.tipo().procesa(this);
		System.out.println(" & " + paramf.id());
	}

	@Override
	public void procesa(Lparamsf_muchos lparamsf) {
		lparamsf.lparams().procesa(this);
		System.out.print(", ");
		lparamsf.paramf().procesa(this);
	}

	@Override
	public void procesa(Lparamsf_uno lparamsf) {
		lparamsf.paramf().procesa(this);
	}

	@Override
	public void procesa(Paramsf_no_vacio paramsf) {
		paramsf.lparams().procesa(this);
	}

	@Override
	public void procesa(Paramsf_vacio paramsf) {
		System.out.println();
	}

	@Override
	public void procesa(Dec_var dec) {
		System.out.print("var ");
		dec.tipo().procesa(this);
		System.out.print(" " + dec.variable());
	}

	@Override
	public void procesa(Dec_type dec) {
		System.out.print("type ");
		dec.tipo().procesa(this);
		System.out.print(" " + dec.variable());
	}

	@Override
	public void procesa(Dec_proc dec) {
		System.out.print("proc " + dec.id() + "(");
		dec.paramsf().procesa(this);
		System.out.println(")");
		dec.bloque().procesa(this);
	}

	@Override
	public void procesa(Decs_una ldecs) {
		ldecs.dec().procesa(this);
	}

	@Override
	public void procesa(Decs_muchas ldecs) {
		ldecs.ldecs().procesa(this);
		System.out.println(";");
		ldecs.dec().procesa(this);
	}

	@Override
	public void procesa(Prog_con_decs prog) {
		prog.ldecs().procesa(this);
		System.out.println();
		System.out.println("&&");
		prog.linsts().procesa(this);
	}

	@Override
	public void procesa(Prog_sin_decs prog) {
		prog.linsts().procesa(this);
	}

	@Override
	public void procesa(Indice exp) {
		exp.arg0().procesa(this);
		System.out.print("[");
		exp.arg1().procesa(this);
		System.out.print("]");
	}

	@Override
	public void procesa(Reg_punto exp) {
		exp.arg().procesa(this);
		System.out.print("." + exp.id());
	}

	@Override
	public void procesa(Reg_flecha exp) {
		exp.arg().procesa(this);
		System.out.print("->" + exp.id());
	}
	
   private void imprime_arg(Exp arg, int p) {
	   if(arg.prioridad() < p) {
		   System.out.print("(");
		   arg.procesa(this);
		   System.out.print(")");
	   }
	   else {
		   arg.procesa(this);
	   }
   }
	
}
