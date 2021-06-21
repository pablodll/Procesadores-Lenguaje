package procesamientos;

import asint.ProcesamientoPorDefecto;
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

public class Etiquetado extends ProcesamientoPorDefecto{
	
	private int etq = 0;
	
	@Override
	public void procesa(Suma exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp._tipo.equals("real")) {
			if(exp.arg0()._tipo.equals("int")) {
				etq++;
			}
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;
		}
		if(exp._tipo.equals("real")) {
			if(exp.arg1()._tipo.equals("int")) {
				etq++;
			}
		}
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Resta exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp._tipo.equals("real")) {
			if(exp.arg0()._tipo.equals("int")) {
				etq++;
			}
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;
		}
		if(exp._tipo.equals("real")) {
			if(exp.arg1()._tipo.equals("int")) {
				etq++;
			}
		}
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(And exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;
		}
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Or exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;
		}
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Igual exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp.arg1()._tipo.equals("real") && exp.arg0()._tipo.equals("int")) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;;
		}
		if(exp.arg0()._tipo.equals("real") && exp.arg1()._tipo.equals("int")) {
			etq++;
		}
		
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Menor exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp.arg1()._tipo.equals("real") && exp.arg0()._tipo.equals("int")) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;;
		}
		if(exp.arg0()._tipo.equals("real") && exp.arg1()._tipo.equals("int")) {
			etq++;
		}
		
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Mayor exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp.arg1()._tipo.equals("real") && exp.arg0()._tipo.equals("int")) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;;
		}
		if(exp.arg0()._tipo.equals("real") && exp.arg1()._tipo.equals("int")) {
			etq++;
		}
		
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Menor_igual exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp.arg1()._tipo.equals("real") && exp.arg0()._tipo.equals("int")) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;;
		}
		if(exp.arg0()._tipo.equals("real") && exp.arg1()._tipo.equals("int")) {
			etq++;
		}
		
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Mayor_igual exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp.arg1()._tipo.equals("real") && exp.arg0()._tipo.equals("int")) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;;
		}
		if(exp.arg0()._tipo.equals("real") && exp.arg1()._tipo.equals("int")) {
			etq++;
		}
		
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Dist exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp.arg1()._tipo.equals("real") && exp.arg0()._tipo.equals("int")) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;;
		}
		if(exp.arg0()._tipo.equals("real") && exp.arg1()._tipo.equals("int")) {
			etq++;
		}
		
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Mul exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp._tipo.equals("real")) {
			if(exp.arg0()._tipo.equals("int")) {
				etq++;
			}
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;
		}
		if(exp._tipo.equals("real")) {
			if(exp.arg1()._tipo.equals("int")) {
				etq++;
			}
		}
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Div exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		if(exp._tipo.equals("real")) {
			if(exp.arg0()._tipo.equals("int")) {
				etq++;
			}
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;
		}
		if(exp._tipo.equals("real")) {
			if(exp.arg1()._tipo.equals("int")) {
				etq++;
			}
		}
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Mod exp) throws Exception {
		exp._etqi = etq;
		exp.arg0().procesa(this);
		if(exp.arg0()._desig) {
			etq++;
		}
		
		exp.arg1().procesa(this);
		if(exp.arg1()._desig) {
			etq++;
		}
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Menos exp) throws Exception {
		exp._etqi = etq;
		exp.arg().procesa(this);
		if(exp.arg()._desig) {
			etq++;
		}
		
		if(exp._tipo.equals("int")) {
			etq++;
		}
		else if(exp._tipo.equals("real")) {
			etq++;
		}
		exp._etqs = etq;
	}

	@Override
	public void procesa(Not exp) throws Exception {
		exp._etqi = etq;
		exp.arg().procesa(this);
		if(exp.arg()._desig) {
			etq++;
		}
		
		etq++;
		exp._etqs = etq;
	}

	@Override
	public void procesa(Indirecto exp) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Entero exp) throws Exception {
		etq++;
	}

	@Override
	public void procesa(Real exp) throws Exception {
		etq++;
	}

	@Override
	public void procesa(True exp) throws Exception {
		etq++;
	}

	@Override
	public void procesa(False exp) throws Exception {
		etq++;
	}

	@Override
	public void procesa(Cadena exp) throws Exception {
		etq++;
	}

	@Override
	public void procesa(Identif exp) throws Exception {
		etq++;
	}

	@Override
	public void procesa(Null exp) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Bloque_vacio bloque) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Bloque_no_vacio bloque) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Insts_vacia insts) throws Exception {

	}

	@Override
	public void procesa(Insts_no_vacia insts) throws Exception {
		insts._etqi = etq;
		insts.linsts().procesa(this);
		insts._etqs = etq;
	}

	@Override
	public void procesa(Paramsr_vacio paramsr) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Paramsr_no_vacio paramsr) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Lparamsr_uno lparamsr) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Lparamsr_muchos lparamsr) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Inst_asig inst) throws Exception {
		inst._etqi = etq;
		inst.arg0().procesa(this);
		inst.arg1().procesa(this);
		if(inst.arg0()._tipo.equals("real") && inst.arg1()._tipo.equals("int")) {
			if(inst.arg0()._desig) etq++;
			etq++;
			etq++;
		}
		else {
			etq++;
		}
		inst._etqs = etq;
	}

	@Override
	public void procesa(Inst_if inst) throws Exception {
		inst._etqi = etq;
		inst.exp().procesa(this);
		if(inst.exp()._desig) etq++;
		etq++;
		inst.insts().procesa(this);
		inst._etqs = etq;
	}

	@Override
	public void procesa(Inst_if_else inst) throws Exception {
		inst._etqi = etq;
		inst.exp().procesa(this);
		if(inst.exp()._desig) etq++;
		etq++;
		inst.insts1().procesa(this);
		etq++;
		inst.insts2().procesa(this);
		inst._etqs = etq;
	}

	@Override
	public void procesa(Inst_while inst) throws Exception {
		inst._etqi = etq;
		inst.exp().procesa(this);
		if(inst.exp()._desig) etq++;
		etq++;
		inst.insts().procesa(this);
		etq++;
		inst._etqs = etq;
	}

	@Override
	public void procesa(Inst_read inst) throws Exception {
		inst._etqi = etq;
		inst.exp().procesa(this);
		etq++;
		etq++;
		inst._etqs = etq;
	}

	@Override
	public void procesa(Inst_write inst) throws Exception {
		inst._etqi = etq;
		inst.exp().procesa(this);
		if(inst.exp()._desig) etq++;
		etq++;
		inst._etqs = etq;
	}

	@Override
	public void procesa(Inst_nl inst) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Inst_new inst) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Inst_delete inst) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Inst_call inst) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Inst_bloque inst) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Insts_una linsts) throws Exception {
		linsts._etqi = etq;
		linsts.inst().procesa(this);
		linsts._etqs = etq;
	}

	@Override
	public void procesa(Insts_muchas linsts) throws Exception {
		linsts._etqi = etq;
		linsts.linsts().procesa(this);
		linsts.inst().procesa(this);
		linsts._etqs = etq;
	}

	@Override
	public void procesa(Tipo_int tipo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_bool tipo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_real tipo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_string tipo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_array tipo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipos_uno ltipos) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipos_muchos ltipos) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_pointer tipo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_record tipo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Ref tipo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Paramf_valor paramf) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Paramf_referencia paramf) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Lparamsf_muchos lparamsf) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Lparamsf_uno lparamsf) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Paramsf_no_vacio paramsf) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Paramsf_vacio paramsf) throws Exception{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Dec_var dec) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Dec_type dec) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Dec_proc dec) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Decs_una ldecs) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Decs_muchas ldecs) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Prog_con_decs prog) throws Exception {
		prog._etqi = etq;
		prog.linsts().procesa(this);
		prog._etqs = etq;
	}

	@Override
	public void procesa(Prog_sin_decs prog) throws Exception {
		prog._etqi = etq;
		prog.linsts().procesa(this);
		prog._etqs = etq;
	}

	@Override
	public void procesa(Indice exp) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Reg_punto exp) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Reg_flecha exp) throws Exception {
		// TODO Auto-generated method stub
		
	}
}