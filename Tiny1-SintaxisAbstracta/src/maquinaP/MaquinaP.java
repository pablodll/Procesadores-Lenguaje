package maquinaP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;




public class MaquinaP {
   public static class EAccesoIlegitimo extends RuntimeException {} 
   public static class EAccesoAMemoriaNoInicializada extends RuntimeException {
      public EAccesoAMemoriaNoInicializada(int pc,int dir) {
         super("pinst:"+pc+" dir:"+dir); 
      } 
   } 
   public static class EAccesoFueraDeRango extends RuntimeException {} 
   
   private GestorMemoriaDinamica gestorMemoriaDinamica;
   private GestorPilaActivaciones gestorPilaActivaciones;
    
   private class Valor {
      public int valorInt() {throw new EAccesoIlegitimo();}  
      public boolean valorBool() {throw new EAccesoIlegitimo();} 
      public float valorReal() {throw new EAccesoIlegitimo();}
      public String valorString() {throw new EAccesoIlegitimo();}
   } 
   private class ValorInt extends Valor {
      private int valor;
      public ValorInt(int valor) {
         this.valor = valor; 
      }
      public int valorInt() {return valor;}
      public String toString() {
        return String.valueOf(valor);
      }
   }
   private class ValorBool extends Valor {
      private boolean valor;
      public ValorBool(boolean valor) {
         this.valor = valor; 
      }
      public boolean valorBool() {return valor;}
      public String toString() {
        return String.valueOf(valor);
      }
   }
   private class ValorReal extends Valor {
      private float valor;
      public ValorReal(float valor) {
         this.valor = valor; 
      }
      public float valorReal() {return valor;}
      public String toString() {
        return String.valueOf(valor);
      }
   }
   private class ValorString extends Valor {
      private String valor;
      public ValorString(String valor) {
         this.valor = valor; 
      }
      public String valorString() {return valor;}
      public String toString() {
        return String.valueOf(valor);
      }
   }

   private List<Instruccion> codigoP;
   private Stack<Valor> pilaEvaluacion;
   private Valor[] datos; 
   private int pc;

   public interface Instruccion {
      void ejecuta();  
   }
   private ISumaInt ISUMAINT;
   private class ISumaInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorInt(opnd1.valorInt()+opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "sumaInt";};
   }
   private ISumaReal ISUMAREAL;
   private class ISumaReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorReal(opnd1.valorReal()+opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "sumaReal";};
   }
   
   private IRestaInt IRESTAINT;
   private class IRestaInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorInt(opnd1.valorInt()-opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "restaInst";};
   }
   private IRestaReal IRESTAREAL;
   private class IRestaReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorReal(opnd1.valorReal()-opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "restaReal";};
   }
   
   private IMulInt IMULINT;
   private class IMulInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorInt(opnd1.valorInt()*opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "mulInt";};
   }
   private IMulReal IMULREAL;
   private class IMulReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorReal(opnd1.valorReal()*opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "mulReal";};
   }
   
   private IDivInt IDIVINT;
   private class IDivInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorInt(opnd1.valorInt()/opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "divInt";};
   }
   private IDivReal IDIVREAL;
   private class IDivReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorReal(opnd1.valorReal()/opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "divReal";};
   }
   
   private IMod IMOD;
   private class IMod implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorInt(opnd1.valorInt()%opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "mod";};
   }
   private IAnd IAND;
   private class IAnd implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorBool()&&opnd2.valorBool()));
         pc++;
      } 
      public String toString() {return "and";};
   }
   private IOr IOR;
   private class IOr implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorBool()||opnd2.valorBool()));
         pc++;
      } 
      public String toString() {return "or";};
   }
   private IIgualBool IIGUALBOOL;
   private class IIgualBool implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorBool()==opnd2.valorBool()));
         pc++;
      } 
      public String toString() {return "igualBool";};
   }
   private IIgualInt IIGUALINT;
   private class IIgualInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorInt()==opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "igualInt";};
   }
   private IIgualReal IIGUALREAL;
   private class IIgualReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorReal()==opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "igualReal";};
   }
   private IIgualString IIGUALSTRING;
   private class IIgualString implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorString().equals(opnd2.valorString())));
         pc++;
      } 
      public String toString() {return "igualString";};
   }
   
   private IMenorBool IMENORBOOL;
   private class IMenorBool implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(!opnd1.valorBool() && opnd2.valorBool()));
         pc++;
      } 
      public String toString() {return "menorBool";};
   }
   private IMenorInt IMENORINT;
   private class IMenorInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorInt() < opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "menorInt";};
   }
   private IMenorReal IMENORREAL;
   private class IMenorReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorReal() < opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "menorReal";};
   }
   private IMenorString IMENORSTRING;
   private class IMenorString implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorString().compareTo(opnd2.valorString()) < 0));
         pc++;
      } 
      public String toString() {return "menorString";};
   }
   
   private IMayorBool IMAYORBOOL;
   private class IMayorBool implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorBool() && !opnd2.valorBool()));
         pc++;
      } 
      public String toString() {return "mayorBool";};
   }
   private IMayorInt IMAYORINT;
   private class IMayorInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorInt() > opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "mayorInt";};
   }
   private IMayorReal IMAYORREAL;
   private class IMayorReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorReal() > opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "mayorReal";};
   }
   private IMayorString IMAYORSTRING;
   private class IMayorString implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
    	 pilaEvaluacion.push(new ValorBool(opnd1.valorString().compareTo(opnd2.valorString()) > 0));
         pc++;
      } 
      public String toString() {return "mayorString";};
   }
   
   private IMenorIgualBool IMENORIGUALBOOL;
   private class IMenorIgualBool implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(
        		 (!opnd1.valorBool() && opnd2.valorBool()) || 
        		 (opnd1.valorBool() == opnd2.valorBool())
 				));
         pc++;
      } 
      public String toString() {return "menorIgualBool";};
   }
   private IMenorIgualInt IMENORIGUALINT;
   private class IMenorIgualInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorInt() <= opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "menorIgualInt";};
   }
   private IMenorIgualReal IMENORIGUALREAL;
   private class IMenorIgualReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorReal() <= opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "menorIgualReal";};
   }
   private IMenorIgualString IMENORIGUALSTRING;
   private class IMenorIgualString implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorString().compareTo(opnd2.valorString()) <= 0));
         pc++;
      } 
      public String toString() {return "menorIgualString";};
   }
   
   private IMayorIgualBool IMAYORIGUALBOOL;
   private class IMayorIgualBool implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(
        		 (opnd1.valorBool() && !opnd2.valorBool()) || 
        		 (opnd1.valorBool() == opnd2.valorBool())
 				));
         pc++;
      } 
      public String toString() {return "mayorIgualBool";};
   }
   private IMayorIgualInt IMAYORIGUALINT;
   private class IMayorIgualInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorInt() >= opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "mayorIgualInt";};
   }
   private IMayorIgualReal IMAYORIGUALREAL;
   private class IMayorIgualReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorReal() >= opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "mayorIgualReal";};
   }
   private IMayorIgualString IMAYORIGUALSTRING;
   private class IMayorIgualString implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
    	 pilaEvaluacion.push(new ValorBool(
    			 opnd1.valorString().compareTo(opnd2.valorString()) >= 0)
    			 );
         pc++;
      } 
      public String toString() {return "mayorIgualString";};
   }
   private IDistBool IDISTBOOL;
   private class IDistBool implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorBool()!=opnd2.valorBool()));
         pc++;
      } 
      public String toString() {return "distBool";};
   }
   private IDistInt IDISTINT;
   private class IDistInt implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorInt()!=opnd2.valorInt()));
         pc++;
      } 
      public String toString() {return "distInt";};
   }
   private IDistReal IDISTREAL;
   private class IDistReal implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(opnd1.valorReal()!=opnd2.valorReal()));
         pc++;
      } 
      public String toString() {return "igualReal";};
   }
   private IDistString IDISTSTRING;
   private class IDistString implements Instruccion {
      public void ejecuta() {
         Valor opnd2 = pilaEvaluacion.pop(); 
         Valor opnd1 = pilaEvaluacion.pop();
         pilaEvaluacion.push(new ValorBool(!opnd1.valorString().equals(opnd2.valorString())));
         pc++;
      } 
      public String toString() {return "igualString";};
   }
   
   private IMenosInt IMENOSINT;
   private class IMenosInt implements Instruccion {
	   public void ejecuta() {
		   Valor val = pilaEvaluacion.pop();
		   pilaEvaluacion.push(new ValorInt(-val.valorInt()));
	   }
   }
   private IMenosReal IMENOSREAL;
   private class IMenosReal implements Instruccion {
	   public void ejecuta() {
		   Valor val = pilaEvaluacion.pop();
		   pilaEvaluacion.push(new ValorReal(-val.valorReal()));
	   }
   }
   private INot INOT;
   private class INot implements Instruccion {
	   public void ejecuta() {
		   Valor val = pilaEvaluacion.pop();
		   pilaEvaluacion.push(new ValorBool(!val.valorBool()));
	   }
   }
   
   private IRead IREAD;
   private class IRead implements Instruccion {
      public void ejecuta() {
         Scanner sc = new Scanner(System.in);
         Valor input = new ValorString(sc.next());
         sc.close();
         pilaEvaluacion.push(input);
         pc++;
      } 
      public String toString() {return "read";};
   }
   
   private IWrite IWRITE;
   private class IWrite implements Instruccion {
      public void ejecuta() {
         String val = pilaEvaluacion.pop().valorString();
         System.out.println(val);
         pc++;
      } 
      public String toString() {return "write";};
   }
   
   private class IApilaInt implements Instruccion {
      private int valor;
      public IApilaInt(int valor) {
        this.valor = valor;  
      }
      public void ejecuta() {
         pilaEvaluacion.push(new ValorInt(valor)); 
         pc++;
      } 
      public String toString() {return "apilaInt("+valor+")";};
   }

   private class IApilaBool implements Instruccion {
      private boolean valor;
      public IApilaBool(boolean valor) {
        this.valor = valor;  
      }
      public void ejecuta() {
         pilaEvaluacion.push(new ValorBool(valor)); 
         pc++;
      } 
      public String toString() {return "apilaBool("+valor+")";};
   }
   
   private class IApilaReal implements Instruccion {
      private float valor;
      public IApilaReal(float valor) {
        this.valor = valor;  
      }
      public void ejecuta() {
         pilaEvaluacion.push(new ValorReal(valor)); 
         pc++;
      } 
      public String toString() {return "apilaReal("+valor+")";};
   }
   
   private class IApilaString implements Instruccion {
      private String valor;
      public IApilaString(String valor) {
        this.valor = valor;  
      }
      public void ejecuta() {
         pilaEvaluacion.push(new ValorString(valor)); 
         pc++;
      } 
      public String toString() {return "apilaString("+valor+")";};
   }

   private class IIrA implements Instruccion {
      private int dir;
      public IIrA(int dir) {
        this.dir = dir;  
      }
      public void ejecuta() {
            pc=dir;
      } 
      public String toString() {return "ira("+dir+")";};
   }

   private class IIrF implements Instruccion {
      private int dir;
      public IIrF(int dir) {
        this.dir = dir;  
      }
      public void ejecuta() {
         if(! pilaEvaluacion.pop().valorBool()) { 
            pc=dir;
         }   
         else {
            pc++; 
         }
      } 
      public String toString() {return "irf("+dir+")";};
   }
   
   private class IMueve implements Instruccion {
      private int tam;
      public IMueve(int tam) {
        this.tam = tam;  
      }
      public void ejecuta() {
            int dirOrigen = pilaEvaluacion.pop().valorInt();
            int dirDestino = pilaEvaluacion.pop().valorInt();
            if ((dirOrigen + (tam-1)) >= datos.length)
                throw new EAccesoFueraDeRango();
            if ((dirDestino + (tam-1)) >= datos.length)
                throw new EAccesoFueraDeRango();
            for (int i=0; i < tam; i++) 
                datos[dirDestino+i] = datos[dirOrigen+i]; 
            pc++;
      } 
      public String toString() {return "mueve("+tam+")";};
   }
   
   private IApilaind IAPILAIND;
   private class IApilaind implements Instruccion {
      public void ejecuta() {
        int dir = pilaEvaluacion.pop().valorInt();
        if (dir >= datos.length) throw new EAccesoFueraDeRango();
        if (datos[dir] == null)  throw new EAccesoAMemoriaNoInicializada(pc,dir);
        pilaEvaluacion.push(datos[dir]);
        pc++;
      } 
      public String toString() {return "apilaind";};
   }

   private IDesapilaind IDESAPILAIND;
   private class IDesapilaind implements Instruccion {
      public void ejecuta() {
        Valor valor = pilaEvaluacion.pop();
        int dir = pilaEvaluacion.pop().valorInt();
        if (dir >= datos.length) throw new EAccesoFueraDeRango();
        datos[dir] = valor;
        pc++;
      } 
      public String toString() {return "desapilaind";};
   }
   
   private IToReal ITOREAL;
   private class IToReal implements Instruccion {
      public void ejecuta() {
        int val = pilaEvaluacion.pop().valorInt();
        pilaEvaluacion.push(new ValorReal((float) val));
        pc++;
      } 
      public String toString() {return "toreal";};
   }

   private class IAlloc implements Instruccion {
      private int tam;
      public IAlloc(int tam) {
        this.tam = tam;  
      }
      public void ejecuta() {
        int inicio = gestorMemoriaDinamica.alloc(tam);
        pilaEvaluacion.push(new ValorInt(inicio));
        pc++;
      } 
      public String toString() {return "alloc("+tam+")";};
   }

   private class IDealloc implements Instruccion {
      private int tam;
      public IDealloc(int tam) {
        this.tam = tam;  
      }
      public void ejecuta() {
        int inicio = pilaEvaluacion.pop().valorInt();
        gestorMemoriaDinamica.free(inicio,tam);
        pc++;
      } 
      public String toString() {return "dealloc("+tam+")";};
   }
   
   private class IActiva implements Instruccion {
       private int nivel;
       private int tamdatos;
       private int dirretorno;
       public IActiva(int nivel, int tamdatos, int dirretorno) {
           this.nivel = nivel;
           this.tamdatos = tamdatos;
           this.dirretorno = dirretorno;
       }
       public void ejecuta() {
          int base = gestorPilaActivaciones.creaRegistroActivacion(tamdatos);
          datos[base] = new ValorInt(dirretorno);
          datos[base+1] = new ValorInt(gestorPilaActivaciones.display(nivel));
          pilaEvaluacion.push(new ValorInt(base+2));
          pc++;
       }
       public String toString() {
          return "activa("+nivel+","+tamdatos+","+dirretorno+")";                 
       }
   }
   
   private class IDesactiva implements Instruccion {
       private int nivel;
       private int tamdatos;
       public IDesactiva(int nivel, int tamdatos) {
           this.nivel = nivel;
           this.tamdatos = tamdatos;
       }
       public void ejecuta() {
          int base = gestorPilaActivaciones.liberaRegistroActivacion(tamdatos);
          gestorPilaActivaciones.fijaDisplay(nivel,datos[base+1].valorInt());
          pilaEvaluacion.push(datos[base]); 
          pc++;
       }
       public String toString() {
          return "desactiva("+nivel+","+tamdatos+")";                 
       }

   }
   
   private class IDesapilad implements Instruccion {
       private int nivel;
       public IDesapilad(int nivel) {
         this.nivel = nivel;  
       }
       public void ejecuta() {
         gestorPilaActivaciones.fijaDisplay(nivel,pilaEvaluacion.pop().valorInt());  
         pc++;
       }
       public String toString() {
          return "setd("+nivel+")";                 
       }
   }
   private IDup IDUP;
   private class IDup implements Instruccion {
       public void ejecuta() {
           pilaEvaluacion.push(pilaEvaluacion.peek());
           pc++;
       }
       public String toString() {
          return "dup";                 
       }
   }
   private Instruccion ISTOP;
   private class IStop implements Instruccion {
       public void ejecuta() {
           pc = codigoP.size();
       }
       public String toString() {
          return "stop";                 
       }
   }
   
   
   private class IApilad implements Instruccion {
       private int nivel;
       public IApilad(int nivel) {
         this.nivel = nivel;  
       }
       public void ejecuta() {
         pilaEvaluacion.push(new ValorInt(gestorPilaActivaciones.display(nivel)));
         pc++;
       }
       public String toString() {
          return "apilad("+nivel+")";                 
       }

   }
   
   private Instruccion IIRIND;
   private class IIrind implements Instruccion {
       public void ejecuta() {
          pc = pilaEvaluacion.pop().valorInt();  
       }
       public String toString() {
          return "irind";                 
       }
   }

   public Instruccion sumaInt() {return ISUMAINT;}
   public Instruccion sumaReal() {return ISUMAREAL;}
   public Instruccion restaInt() {return IRESTAINT;}
   public Instruccion restaReal() {return IRESTAREAL;}
   
   public Instruccion mulInt() {return IMULINT;}
   public Instruccion mulReal() {return IMULREAL;}
   public Instruccion divInt() {return IDIVINT;}
   public Instruccion divReal() {return IDIVREAL;}
   
   public Instruccion mod() {return IMOD;}
   public Instruccion and() {return IAND;}
   public Instruccion or() {return IOR;}
   
   public Instruccion igualInt() {return IIGUALINT;}
   public Instruccion igualReal() {return IIGUALREAL;}
   public Instruccion igualBool() {return IIGUALBOOL;}
   public Instruccion igualString() {return IIGUALSTRING;}
   
   public Instruccion menorInt() {return IMENORINT;}
   public Instruccion menorReal() {return IMENORREAL;}
   public Instruccion menorBool() {return IMENORBOOL;}
   public Instruccion menorString() {return IMENORSTRING;}
   
   public Instruccion mayorInt() {return IMAYORINT;}
   public Instruccion mayorReal() {return IMAYORREAL;}
   public Instruccion mayorBool() {return IMAYORBOOL;}
   public Instruccion mayorString() {return IMAYORSTRING;}
   
   public Instruccion menorIgualInt() {return IMENORIGUALINT;}
   public Instruccion menorIgualReal() {return IMENORIGUALREAL;}
   public Instruccion menorIgualBool() {return IMENORIGUALBOOL;}
   public Instruccion menorIgualString() {return IMENORIGUALSTRING;}
   
   public Instruccion mayorIgualInt() {return IMAYORIGUALINT;}
   public Instruccion mayorIgualReal() {return IMAYORIGUALREAL;}
   public Instruccion mayorIgualBool() {return IMAYORIGUALBOOL;}
   public Instruccion mayorIgualString() {return IMAYORIGUALSTRING;}
   
   public Instruccion distBool() {return IDISTBOOL;}
   public Instruccion distInt() {return IDISTINT;}
   public Instruccion distReal() {return IDISTREAL;}
   public Instruccion distString() {return IDISTSTRING;}
   
   public Instruccion menosInt() {return IMENOSINT;}
   public Instruccion menosReal() {return IMENOSREAL;}
   public Instruccion not() {return INOT;}
   
   public Instruccion read() {return IREAD;}
   public Instruccion write() {return IWRITE;}
   
   public Instruccion apilaInt(int val) {return new IApilaInt(val);}
   public Instruccion apilaBool(boolean val) {return new IApilaBool(val);}
   public Instruccion apilaReal(float val) {return new IApilaReal(val);}
   public Instruccion apilaString(String val) {return new IApilaString(val);}
   public Instruccion apilad(int nivel) {return new IApilad(nivel);}
   public Instruccion apilaInd() {return IAPILAIND;}
   public Instruccion desapilaInd() {return IDESAPILAIND;}
   public Instruccion toReal() {return ITOREAL;}
   public Instruccion mueve(int tam) {return new IMueve(tam);}
   public Instruccion irA(int dir) {return new IIrA(dir);}
   public Instruccion irF(int dir) {return new IIrF(dir);}
   public Instruccion irInd() {return IIRIND;}
   public Instruccion alloc(int tam) {return new IAlloc(tam);} 
   public Instruccion dealloc(int tam) {return new IDealloc(tam);} 
   public Instruccion activa(int nivel,int tam, int dirretorno) {return new IActiva(nivel,tam,dirretorno);}
   public Instruccion desactiva(int nivel, int tam) {return new IDesactiva(nivel,tam);}
   public Instruccion desapilad(int nivel) {return new IDesapilad(nivel);}
   public Instruccion dup() {return IDUP;}
   public Instruccion stop() {return ISTOP;}
   
   public void ponInstruccion(Instruccion i) {
      codigoP.add(i); 
   }

   private int tamdatos;
   private int tamheap;
   private int ndisplays;
   public MaquinaP(int tamdatos, int tampila, int tamheap, int ndisplays) {
      this.tamdatos = tamdatos;
      this.tamheap = tamheap;
      this.ndisplays = ndisplays;
      this.codigoP = new ArrayList<>();  
      pilaEvaluacion = new Stack<>();
      datos = new Valor[tamdatos+tampila+tamheap];
      this.pc = 0;
      ISUMAINT = new ISumaInt();
      ISUMAREAL = new ISumaReal();
      IRESTAINT = new IRestaInt();
      IRESTAREAL = new IRestaReal();
      
      IAND = new IAnd();
      IOR = new IOr();
      
      IMULINT = new IMulInt();
      IMULREAL = new IMulReal();
      IDIVINT = new IDivInt();
      IDIVREAL = new IDivReal();
      
      IMOD = new IMod();
      
      IIGUALBOOL = new IIgualBool();
      IIGUALINT = new IIgualInt();
      IIGUALREAL = new IIgualReal();
      IIGUALSTRING = new IIgualString();
      
      IMENORBOOL = new IMenorBool();
      IMENORINT = new IMenorInt();
      IMENORREAL = new IMenorReal();
      IMENORSTRING = new IMenorString();
      
      IMAYORBOOL = new IMayorBool();
      IMAYORINT = new IMayorInt();
      IMAYORREAL = new IMayorReal();
      IMAYORSTRING = new IMayorString();
      
      IMENORIGUALBOOL = new IMenorIgualBool();
      IMENORIGUALINT = new IMenorIgualInt();
      IMENORIGUALREAL = new IMenorIgualReal();
      IMENORIGUALSTRING = new IMenorIgualString();
      
      IMAYORIGUALBOOL = new IMayorIgualBool();
      IMAYORIGUALINT = new IMayorIgualInt();
      IMAYORIGUALREAL = new IMayorIgualReal();
      IMAYORIGUALSTRING = new IMayorIgualString();
      
      IDISTBOOL = new IDistBool();
      IDISTINT = new IDistInt();
      IDISTREAL = new IDistReal();
      IDISTSTRING = new IDistString();
      
      IMENOSINT = new IMenosInt();
      IMENOSREAL = new IMenosReal();
      INOT = new INot();
      
      IREAD = new IRead();
      IWRITE = new IWrite();
      
      IAPILAIND = new IApilaind();
      IDESAPILAIND = new IDesapilaind();
      ITOREAL = new IToReal();
      IIRIND = new IIrind();
      IDUP = new IDup();
      ISTOP = new IStop();
      gestorPilaActivaciones = new GestorPilaActivaciones(tamdatos,(tamdatos+tampila)-1,ndisplays); 
      gestorMemoriaDinamica = new GestorMemoriaDinamica(tamdatos+tampila,(tamdatos+tampila+tamheap)-1);
   }
   public void ejecuta() {
      while(pc != codigoP.size()) {
          codigoP.get(pc).ejecuta();
      } 
   }
   public void muestraCodigo() {
     System.out.println("CodigoP");
     for(int i=0; i < codigoP.size(); i++) {
        System.out.println(" "+i+":"+codigoP.get(i));
     }
   }
   public void muestraEstado() {
     System.out.println("Tam datos:"+tamdatos);  
     System.out.println("Tam heap:"+tamheap); 
     System.out.println("PP:"+gestorPilaActivaciones.pp());      
     System.out.print("Displays:");
     for (int i=1; i <= ndisplays; i++)
         System.out.print(i+":"+gestorPilaActivaciones.display(i)+" ");
     System.out.println();
     System.out.println("Pila de evaluacion");
     for(int i=0; i < pilaEvaluacion.size(); i++) {
        System.out.println(" "+i+":"+pilaEvaluacion.get(i));
     }
     System.out.println("Datos");
     for(int i=0; i < datos.length; i++) {
        System.out.println(" "+i+":"+datos[i]);
     }
     System.out.println("PC:"+pc);
   }
   
   public static void main(String[] args) {
       MaquinaP m = new MaquinaP(5,10,10,2);
        
          /*
            int x;
            proc store(int v) {
             x = v
            }
           &&
            call store(5)
          */
            
       
       m.ponInstruccion(m.activa(1,1,8));
       m.ponInstruccion(m.dup());
       m.ponInstruccion(m.apilaInt(0));
       m.ponInstruccion(m.sumaInt());
       m.ponInstruccion(m.apilaInt(5));
       m.ponInstruccion(m.desapilaInd());
       m.ponInstruccion(m.desapilad(1));
       m.ponInstruccion(m.irA(9));
       m.ponInstruccion(m.stop());
       m.ponInstruccion(m.apilaInt(0));
       m.ponInstruccion(m.apilad(1));
       m.ponInstruccion(m.apilaInt(0));
       m.ponInstruccion(m.sumaInt());
       m.ponInstruccion(m.mueve(1));
       m.ponInstruccion(m.desactiva(1,1));
       m.ponInstruccion(m.irInd());       
       m.ejecuta();
       m.muestraEstado();
   }
}
