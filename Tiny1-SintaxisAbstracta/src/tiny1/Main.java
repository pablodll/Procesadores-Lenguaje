package tiny1;

import c_ast_ascendente.AnalizadorLexicoTiny1;
import c_ast_ascendente.ConstructorAST_Asc;
import asint.Tiny1Asint.Prog;
import c_ast_ascendente.ClaseLexica;
import errors.GestionErroresTiny1;
import c_ast_ascendente.UnidadLexica;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import procesamientos.CompTiposErrorException;
import procesamientos.ComprobacionTipos;
import procesamientos.Impresion;
import procesamientos.TablaSimbolos;
import procesamientos.Vinculacion;
import procesamientos.VinculacionErrorException;

public class Main {
   public static void main(String[] args) throws Exception {
     if (args[0].equals("-lex")) {  
         ejecuta_lexico(args[1]);
     }
     else {
         Prog prog = null;
         if (args[0].equals("-asc"))
            prog = ejecuta_ascendente(args[1]);
         else if (args[0].equals("-desc"))
            prog = ejecuta_descendente(args[1]);
         prog.procesa(new Impresion());  
         
         TablaSimbolos ts = new TablaSimbolos();
         try {
        	 prog.procesa(new Vinculacion(ts));
         } catch (VinculacionErrorException e) {
        	 System.err.println("ERROR DE VINCULACION");
         }
         
         try {
        	 prog.procesa(new ComprobacionTipos());
         } catch (CompTiposErrorException e) {
        	 System.err.println("ERROR DE TIPOS");
         }
     }
   }
   
   private static void ejecuta_lexico(String in) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(in));
     AnalizadorLexicoTiny1 alex = new AnalizadorLexicoTiny1(input);
     GestionErroresTiny1 errores = new GestionErroresTiny1();
     UnidadLexica t = (UnidadLexica) alex.next_token();
     while (t.clase() != ClaseLexica.EOF) {
         System.out.println(t);
         t = (UnidadLexica) alex.next_token();   
     }
   }
   private static Prog ejecuta_ascendente(String in) throws Exception {       
     Reader input = new InputStreamReader(new FileInputStream(in));
     AnalizadorLexicoTiny1 alex = new AnalizadorLexicoTiny1(input);
     ConstructorAST_Asc constructorast = new ConstructorAST_Asc(alex);
     return (Prog)constructorast.parse().value;
  }
   private static Prog ejecuta_descendente(String in) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(in));
     c_ast_descendente.ConstructorAST_Desc constructorast = new c_ast_descendente.ConstructorAST_Desc(input);
     return constructorast.Sp();
   }
}   
   
