package alex;

%%
%line
%column
%class AnalizadorLexicoTiny1
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra = ([a-z]|[A-Z])
digPos = [1-9]
dig = ({digPos}|0)
pDec = .(({dig}*{digPos})|0)
pExp = (e|E)(\-)?{digPos}{dig}*
Sep = (" "|\t|\r|\b|\n)
Com = #[^\n]*
TipoInt = int
TipoReal = real
TipoBool = bool
TipoString = string
And = and
Or = or
Not = not
True = true
False = false
Var = var
Type = type
Proc = proc
Null = null
If = if
Then  = then
Else = else
Endif = endif
While = while
Do = do
Endwhile = endwhile
Call = call
Record = record
Array = array
Of = of
Pointer = pointer
New = new
Delete = delete
Read = read
Write = write
Nl = nl
Mod = \%
Cadena = \"[^\"\n\b\r]*\"
Id = {letra}({letra}|{dig}|_)*
Entero = (\+|\-)?(0|({digPos}{dig}*))
Real = {Entero}({pDec}|{pExp}|({pDec}{pExp}))
Asig = \=
Amp = &
SepSec = &&
Mas = \+
Menos = \-
Por = \*
Div = \/
PAp = \(
PCie = \)
CAp = \[
CCie = \]
LlAp = \{
LlCie = \}
Flecha = ->
Menor = \<
Mayor = \>
MenIgual = <\=
MayIgual = >\=
Igual = \=\=
Dist = \!\=
PuntoComa = \;
Coma = \,
Punto = \.
%%
{Sep}			{}
{Com}			{}
{TipoInt}		{return ops.unidadTipoInt();}
{TipoReal}		{return ops.unidadTipoReal();}
{TipoBool}		{return ops.unidadTipoBool();}
{TipoString}	{return ops.unidadTipoString();}
{And}			{return ops.unidadAnd();}
{Or}			{return ops.unidadOr();}
{Not}			{return ops.unidadNot();}
{True}			{return ops.unidadTrue();}
{False}			{return ops.unidadFalse();}
{Var}			{return ops.unidadVar();}
{Type}			{return ops.unidadType();}
{Proc}			{return ops.unidadProc();}
{Null}			{return ops.unidadNull();}
{If}			{return ops.unidadIf();}
{Then}			{return ops.unidadThen();}
{Else}			{return ops.unidadElse();}
{Endif}			{return ops.unidadEndIf();}
{While}			{return ops.unidadWhile();}
{Do}			{return ops.unidadDo();}
{Endwhile}		{return ops.unidadEndWhile();}
{Call}			{return ops.unidadCall();}
{Record}		{return ops.unidadRecord();}
{Array}			{return ops.unidadArray();}
{Of}			{return ops.unidadOf();}
{Pointer}		{return ops.unidadPointer();}
{New}			{return ops.unidadNew();}
{Delete}		{return ops.unidadDelete();}
{Read}			{return ops.unidadRead();}
{Write}			{return ops.unidadWrite();}
{Nl}			{return ops.unidadNL();}
{Mod}			{return ops.unidadMod();}
{Cadena}		{return ops.unidadCadena();}
{Id}			{return ops.unidadId();}
{Entero}		{return ops.unidadEnt();}
{Real}			{return ops.unidadReal();}
{Asig}			{return ops.unidadAsig();}
{Amp}			{return ops.unidadAmp();}
{SepSec}		{return ops.unidadSepSec();}
{Mas}			{return ops.unidadMas();}
{Menos}			{return ops.unidadMenos();}
{Por}			{return ops.unidadPor();}
{Div}			{return ops.unidadDiv();}
{PAp}			{return ops.unidadPAp();}
{PCie}			{return ops.unidadPCie();}
{CAp}			{return ops.unidadCAp();}
{CCie}			{return ops.unidadCCie();}
{LlAp}			{return ops.unidadLlAp();}
{LlCie}			{return ops.unidadLlCie();}
{Flecha}		{return ops.unidadFlecha();}
{Menor}			{return ops.unidadMenor();}
{Mayor}			{return ops.unidadMayor();}
{MenIgual}		{return ops.unidadMenIgual();}
{MayIgual}		{return ops.unidadMayIgual();}
{Igual}			{return ops.unidadIgual();}
{Dist}			{return ops.unidadDist();}
{PuntoComa}		{return ops.unidadPuntoComa();}
{Coma}			{return ops.unidadComa();}
{Punto}			{return ops.unidadPunto();}
[^]				{ops.error();}