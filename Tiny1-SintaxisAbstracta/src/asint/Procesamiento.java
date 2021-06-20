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
import asint.Tiny1Asint.Mod;

import asint.Tiny1Asint.*;

public interface Procesamiento {
	void procesa(Suma exp) throws Exception;;
	void procesa(Resta exp) throws Exception;;
	void procesa(And exp) throws Exception;;
	void procesa(Or exp) throws Exception;;
	void procesa(Igual exp) throws Exception;;
	void procesa(Menor exp) throws Exception;;
	void procesa(Mayor exp) throws Exception;;
	void procesa(Menor_igual exp) throws Exception;;
	void procesa(Mayor_igual exp) throws Exception;;
	void procesa(Dist exp) throws Exception;;
	void procesa(Mul exp) throws Exception;;
	void procesa(Div exp) throws Exception;
	void procesa(Mod exp) throws Exception;;	//
	void procesa(Menos exp) throws Exception;;
	void procesa(Not exp) throws Exception;;
	void procesa(Indirecto exp) throws Exception;;	//
	void procesa(Indice exp) throws Exception;;	//
	void procesa(Reg_punto exp) throws Exception;;	//
	void procesa(Reg_flecha exp) throws Exception;;	//
	void procesa(Entero exp) throws Exception;;
	void procesa(Real exp) throws Exception;;
	void procesa(True exp) throws Exception;;
	void procesa(False exp) throws Exception;;
	void procesa(Cadena exp) throws Exception;;	//
	void procesa(Identif exp) throws Exception;;	//
	void procesa(Null exp) throws Exception;;	//
	void procesa(Bloque_vacio bloque) throws Exception;;	//
	void procesa(Bloque_no_vacio bloque) throws Exception;;	//
	void procesa(Insts_vacia insts) throws Exception;;	//
	void procesa(Insts_no_vacia insts) throws Exception;;	//
	void procesa(Paramsr_vacio paramsr) throws Exception;;	//
	void procesa(Paramsr_no_vacio paramsr) throws Exception;;	//
	void procesa(Lparamsr_uno lparamsr) throws Exception;;	//
	void procesa(Lparamsr_muchos lparamsr) throws Exception;;	//
	void procesa(Inst_asig inst) throws Exception;;	//
	void procesa(Inst_if inst) throws Exception;;	//
	void procesa(Inst_if_else inst) throws Exception;;	//
	void procesa(Inst_while inst) throws Exception;;	//
	void procesa(Inst_read inst) throws Exception;;	//
	void procesa(Inst_write inst) throws Exception;;	//
	void procesa(Inst_nl inst) throws Exception;;	//
	void procesa(Inst_new inst) throws Exception;;	//
	void procesa(Inst_delete inst) throws Exception;;	//
	void procesa(Inst_call inst) throws Exception;;	//
	void procesa(Inst_bloque inst) throws Exception;;	//
	void procesa(Insts_una linsts) throws Exception;;
	void procesa(Insts_muchas linsts) throws Exception;;
	void procesa(Tipo_int tipo) throws Exception;;
	void procesa(Tipo_bool tipo) throws Exception;;
	void procesa(Tipo_real tipo) throws Exception;;
	void procesa(Tipo_string tipo) throws Exception;;  //
	void procesa(Tipo_array tipo) throws Exception;;	//
	void procesa(Tipos_uno ltipos) throws Exception;;
	void procesa(Tipos_muchos ltipos) throws Exception;;
	void procesa(Tipo_pointer tipo) throws Exception;;	//
	void procesa(Tipo_record tipo) throws Exception;;	//
	void procesa(Ref tipo) throws Exception;;	//
	void procesa(Paramf_valor paramf) throws Exception;;	//
	void procesa(Paramf_referencia paramf) throws Exception;;	//
	void procesa(Lparamsf_muchos lparamsf) throws Exception;;	//
	void procesa(Lparamsf_uno lparamsf) throws Exception;;		//
	void procesa(Paramsf_no_vacio paramsf) throws Exception;;	//
	void procesa(Paramsf_vacio paramsf) throws Exception;;	//
	void procesa(Dec_var dec) throws Exception;	//
	void procesa(Dec_type dec) throws Exception;;	//
	void procesa(Dec_proc dec) throws Exception;;	//
	void procesa(Decs_una ldecs) throws Exception;;
	void procesa(Decs_muchas ldecs) throws Exception;;
	void procesa(Prog_con_decs prog) throws Exception;;	//
	void procesa(Prog_sin_decs prog) throws Exception;;	//
}
