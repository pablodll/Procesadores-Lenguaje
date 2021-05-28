package asint;

import asint.Tiny1Asint.And;
import asint.Tiny1Asint.Inst_asig;
import asint.Tiny1Asint.Dec;
import asint.Tiny1Asint.Decs_muchas;
import asint.Tiny1Asint.Decs_una;
import asint.Tiny1Asint.Dist;
import asint.Tiny1Asint.Div;
import asint.Tiny1Asint.Entero;
import asint.Tiny1Asint.False;
import asint.Tiny1Asint.Igual;
import asint.Tiny1Asint.Insts_muchas;
import asint.Tiny1Asint.Insts_una;
import asint.Tiny1Asint.Mayor;
import asint.Tiny1Asint.Mayor_igual;
import asint.Tiny1Asint.Menor;
import asint.Tiny1Asint.Menor_igual;
import asint.Tiny1Asint.Menos;
import asint.Tiny1Asint.Mul;
import asint.Tiny1Asint.Not;
import asint.Tiny1Asint.Or;
import asint.Tiny1Asint.Prog;
import asint.Tiny1Asint.Real;
import asint.Tiny1Asint.Resta;
import asint.Tiny1Asint.Suma;
import asint.Tiny1Asint.Tipo_bool;
import asint.Tiny1Asint.Tipo_int;
import asint.Tiny1Asint.Tipo_real;
import asint.Tiny1Asint.Tipo_string;
import asint.Tiny1Asint.True;
import asint.Tiny1Asint.Tipo_array;
import asint.Tiny1Asint.Tipo_pointer;
import asint.Tiny1Asint.Tipo_record;
import asint.Tiny1Asint.Ref;
import asint.Tiny1Asint.Mod;

import asint.Tiny1Asint.*;

public interface Procesamiento {
	void procesa(Suma exp);
	void procesa(Resta exp);
	void procesa(And exp);
	void procesa(Or exp);
	void procesa(Igual exp);
	void procesa(Menor exp);
	void procesa(Mayor exp);
	void procesa(Menor_igual exp);
	void procesa(Mayor_igual exp);
	void procesa(Dist exp);
	void procesa(Mul exp);
	void procesa(Div exp);
	void procesa(Mod exp);	//
	void procesa(Menos exp);
	void procesa(Not exp);
	void procesa(Indirecto exp);	//
	void procesa(Indice exp);	//
	void procesa(Reg_punto exp);	//
	void procesa(Reg_flecha exp);	//
	void procesa(Entero exp);
	void procesa(Real exp);
	void procesa(True exp);
	void procesa(False exp);
	void procesa(Cadena exp);	//
	void procesa(Identif exp);	//
	void procesa(Null exp);	//
	void procesa(Bloque_vacio bloque);	//
	void procesa(Bloque_no_vacio bloque);	//
	void procesa(Insts_vacia insts);	//
	void procesa(Insts_no_vacia insts);	//
	void procesa(Paramsr_vacio paramsr);	//
	void procesa(Paramsr_no_vacio paramsr);	//
	void procesa(Lparamsr_uno lparamsr);	//
	void procesa(Lparamsr_muchos lparamsr);	//
	void procesa(Inst_asig inst);	//
	void procesa(Inst_if inst);	//
	void procesa(Inst_if_else inst);	//
	void procesa(Inst_while inst);	//
	void procesa(Inst_read inst);	//
	void procesa(Inst_write inst);	//
	void procesa(Inst_nl inst);	//
	void procesa(Inst_new inst);	//
	void procesa(Inst_delete inst);	//
	void procesa(Inst_call inst);	//
	void procesa(Inst_bloque inst);	//
	void procesa(Insts_una linsts);
	void procesa(Insts_muchas linsts);
	void procesa(Tipo_int tipo);
	void procesa(Tipo_bool tipo);
	void procesa(Tipo_real tipo);
	void procesa(Tipo_string tipo);  //
	void procesa(Tipo_array tipo);	//
	void procesa(Tipos_uno ltipos);
	void procesa(Tipos_muchos ltipos);
	void procesa(Tipo_pointer tipo);	//
	void procesa(Tipo_record tipo);	//
	void procesa(Ref tipo);	//
	void procesa(Paramf_valor paramf);	//
	void procesa(Paramf_referencia paramf);	//
	void procesa(Lparamsf_muchos lparamsf);	//
	void procesa(Lparamsf_uno lparamsf);		//
	void procesa(Paramsf_no_vacio paramsf);	//
	void procesa(Paramsf_vacio paramsf);	//
	void procesa(Dec_var dec);	//
	void procesa(Dec_type dec);	//
	void procesa(Dec_proc dec);	//
	void procesa(Decs_una ldecs);
	void procesa(Decs_muchas ldecs);
	void procesa(Prog_con_decs prog);	//
	void procesa(Prog_sin_decs prog);	//
}
