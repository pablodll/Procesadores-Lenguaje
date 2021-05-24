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

public class ProcesamientoPorDefecto implements Procesamiento {
	public void procesa(Suma exp) {}
	public void procesa(Resta exp) {}
	public void procesa(And exp) {}
	public void procesa(Or exp) {}
	public void procesa(Igual exp) {}
	public void procesa(Menor exp) {}
	public void procesa(Mayor exp) {}
	public void procesa(Menor_igual exp) {}
	public void procesa(Mayor_igual exp) {}
	public void procesa(Dist exp) {}
	public void procesa(Mul exp) {}
	public void procesa(Div exp) {}
	public void procesa(Menos exp) {}
	public void procesa(Not exp) {}
	public void procesa(Entero exp) {}
	public void procesa(Real exp) {}
	public void procesa(Variable exp) {}
	public void procesa(True exp) {}
	public void procesa(False exp) {}
	public void procesa(Asig inst) {}
	public void procesa(Insts_una linsts) {}
	public void procesa(Insts_muchas linsts) {}
	public void procesa(Tipo_int tipo) {}
	public void procesa(Tipo_bool tipo) {}
	public void procesa(Tipo_real tipo) {}
	public void procesa(Dec dec) {}
	public void procesa(Decs_una ldecs) {}
	public void procesa(Decs_muchas ldecs) {}
	public void procesa(Prog prog) {}

}
