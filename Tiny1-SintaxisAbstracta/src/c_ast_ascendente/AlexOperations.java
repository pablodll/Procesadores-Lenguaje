package c_ast_ascendente;

public class ALexOperations {
  private AnalizadorLexicoTiny1 alex;
  public ALexOperations(AnalizadorLexicoTiny1 alex) {
	  this.alex = alex;   
  }
  public UnidadLexica token(int clase) {
	  UnidadLexica t = new UnidadLexica(alex.fila(), alex.col(), clase, alex.lexema());
//	  alex.incCol();
	  return t;     
  }
}
