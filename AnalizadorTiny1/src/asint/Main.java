package asint;

import java.io.FileReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		AnalizadorSintacticoTiny1 asint = new AnalizadorSintacticoTiny1(new FileReader(args[0]));
		asint.Sp();
		System.out.println("OK");
	}
	
}
