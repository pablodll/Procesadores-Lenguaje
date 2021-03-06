package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import asint.ClaseLexica;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
     if(args.length <= 0) {
    	System.err.println("Falta argumento con fichero a analizar");
		return;
     }
	 Reader input = new InputStreamReader(new FileInputStream(args[0]));
     AnalizadorLexicoTiny1 al = new AnalizadorLexicoTiny1(input);
     UnidadLexica unidad;
     do {
       unidad = al.next_token();
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);
    }        
} 
