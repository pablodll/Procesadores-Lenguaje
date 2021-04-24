package asint;

import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny1;

public class Main {
	
//	public static void main(String[] args) throws Exception{
//		AnalizadorSintacticoTiny1_JAVACC asint = new AnalizadorSintacticoTiny1_JAVACC(new FileReader(args[0]));
//		asint.Sp();
//		System.out.println("OK");
//	}
	
	public static void main(String[] args) throws Exception{
		switch(args[1]) {
			case "desc":
				AnalizadorSintacticoTiny1_JAVACC asint_desc = new AnalizadorSintacticoTiny1_JAVACC(new FileReader(args[0]));
				asint_desc.Sp();
				break;
			case "asc":
				Reader input = new InputStreamReader(new FileInputStream(args[0]));
				AnalizadorLexicoTiny1 alex = new AnalizadorLexicoTiny1(input);
				AnalizadorSintacticoTiny1_CUP asint_asc = new AnalizadorSintacticoTiny1_CUP(alex);
				asint_asc.parse();
				break;
			default:
				System.err.println("ERROR: Invalid arguments USAGE: inputFile (desc | asc)");
		}
		
		System.out.println("OK");
		
	}
	
}
