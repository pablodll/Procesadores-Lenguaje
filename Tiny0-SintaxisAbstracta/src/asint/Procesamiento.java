package asint;

import asint.Tiny0ASint.And;
import asint.Tiny0ASint.Asig;
import asint.Tiny0ASint.Dec;
import asint.Tiny0ASint.Decs_muchas;
import asint.Tiny0ASint.Decs_una;
import asint.Tiny0ASint.Dist;
import asint.Tiny0ASint.Div;
import asint.Tiny0ASint.Entero;
import asint.Tiny0ASint.False;
import asint.Tiny0ASint.Igual;
import asint.Tiny0ASint.Insts_muchas;
import asint.Tiny0ASint.Insts_una;
import asint.Tiny0ASint.Mayor;
import asint.Tiny0ASint.Mayor_igual;
import asint.Tiny0ASint.Menor;
import asint.Tiny0ASint.Menor_igual;
import asint.Tiny0ASint.Menos;
import asint.Tiny0ASint.Mul;
import asint.Tiny0ASint.Not;
import asint.Tiny0ASint.Or;
import asint.Tiny0ASint.Prog;
import asint.Tiny0ASint.Real;
import asint.Tiny0ASint.Resta;
import asint.Tiny0ASint.Suma;
import asint.Tiny0ASint.Tipo_bool;
import asint.Tiny0ASint.Tipo_int;
import asint.Tiny0ASint.Tipo_real;
import asint.Tiny0ASint.True;
import asint.Tiny0ASint.Variable;

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
	void procesa(Menos exp);
	void procesa(Not exp);
	void procesa(Entero exp);
	void procesa(Real exp);
	void procesa(Variable exp);
	void procesa(True exp);
	void procesa(False exp);
	void procesa(Asig inst);
	void procesa(Insts_una linsts);
	void procesa(Insts_muchas linsts);
	void procesa(Tipo_int tipo);
	void procesa(Tipo_bool tipo);
	void procesa(Tipo_real tipo);
	void procesa(Dec dec);
	void procesa(Decs_una ldecs);
	void procesa(Decs_muchas ldecs);
	void procesa(Prog prog);
}
