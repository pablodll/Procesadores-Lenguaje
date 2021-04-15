package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import errors.GestionErroresTiny0;

public class Main {
	public static void main(String arg[]) throws IOException {
		if(arg.length <= 0) {
			System.err.println("Falta argumento con fichero a analizar");
			return;
		}
		
		Reader input = new InputStreamReader(new FileInputStream(arg[0]));
		AnalizadorLexicoTiny0 alex = new AnalizadorLexicoTiny0(input);
		UnidadLexica unidad;
		
		GestionErroresTiny0 errores = new GestionErroresTiny0();
		alex.fijaGestionErrores(errores);
		
		do {
			unidad = alex.sigToken();
			System.out.println(unidad);
		} while(unidad.clase() != ClaseLexica.EOF);
	}
} 
