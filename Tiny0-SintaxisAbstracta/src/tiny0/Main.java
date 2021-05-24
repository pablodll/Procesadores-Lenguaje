package tiny0;

import alex.AnalizadorLexicoTiny0;
import alex.ClaseLexica;
import alex.UnidadLexica;
import asint.Tiny0ASint.Prog;
import c_ast.ConstructorAST;
import errors.GestionErroresTiny0;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import procesamientos.Impresion;

public class Main {
	
   public static void main(String[] args) throws Exception {
	   if (args[0].equals("-lex")) {  
		   ejecuta_lexico(args[1]);
	   }
	   else if (args[0].equals("-ast")){
		   Prog prog = null;
	       prog = ejecuta_descendente_manual(args[1]);
		   prog.procesa(new Impresion());
	   }
   }
   
   private static void ejecuta_lexico(String in) throws Exception {
	   Reader input = new InputStreamReader(new FileInputStream(in));
	   AnalizadorLexicoTiny0 alex = new AnalizadorLexicoTiny0(input);
	   GestionErroresTiny0 errores = new GestionErroresTiny0();
	   UnidadLexica t = (UnidadLexica) alex.sigToken();
	   while (t.clase() != ClaseLexica.EOF) {
		   System.out.println(t);
		   t = (UnidadLexica) alex.sigToken();   
	   }
   }
   
   private static Prog ejecuta_descendente_manual(String in) throws Exception {
	   Reader input = new InputStreamReader(new FileInputStream(in));
	   ConstructorAST constructorast = new ConstructorAST(input);
	   return constructorast.Sp();
   }
   
   
   
}
