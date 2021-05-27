package procesamientos;

import asint.ProcesamientoPorDefecto;
import asint.Tiny0ASint.And;
import asint.Tiny0ASint.Asig;
import asint.Tiny0ASint.Dec;
import asint.Tiny0ASint.Decs_muchas;
import asint.Tiny0ASint.Decs_una;
import asint.Tiny0ASint.Dist;
import asint.Tiny0ASint.Div;
import asint.Tiny0ASint.Entero;
import asint.Tiny0ASint.Exp;
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
   public void procesa(Menos exp) {
	   System.out.print(" - ");
	   imprime_arg(exp.arg(), 5);
   }
   public void procesa(Not exp) {
	   System.out.print(" not ");
	   imprime_arg(exp.arg(), 4);
   }
   public void procesa(Entero exp) {
	   System.out.print(exp.entero());
   }
   public void procesa(Real exp) {
	   System.out.print(exp.real());
   }
   public void procesa(Variable exp) {
	   System.out.print(exp.variable());
   }
   public void procesa(True exp) {
	   System.out.print("true");
   }
   public void procesa(False exp) {
	   System.out.print("false");
   }
   public void procesa(Asig inst) {
	   System.out.print(inst.variable() + " = ");
	   inst.arg().procesa(this);
   }
   public void procesa(Insts_una linsts) {
	   linsts.inst().procesa(this);
   }
   public void procesa(Insts_muchas linsts) {
	   linsts.linsts().procesa(this);
	   System.out.println(";");
	   linsts.inst().procesa(this);
   }
   public void procesa(Tipo_int tipo) {
	   System.out.print("int");
   }
   public void procesa(Tipo_bool tipo) {
	   System.out.print("bool");
   }
   public void procesa(Tipo_real tipo) {
	   System.out.print("real");
   }
   public void procesa(Dec dec) {
	   dec.tipo().procesa(this);
	   System.out.print(" " + dec.variable());
   }
   public void procesa(Decs_una ldecs) {
	   ldecs.dec().procesa(this);
   }
   public void procesa(Decs_muchas ldecs) {
	   ldecs.ldecs().procesa(this);
	   System.out.println(";");
	   ldecs.dec().procesa(this);
   }
   public void procesa(Prog prog) {
	   prog.ldecs().procesa(this);
	   System.out.println();
	   System.out.println("&&");
	   prog.linsts().procesa(this);
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
