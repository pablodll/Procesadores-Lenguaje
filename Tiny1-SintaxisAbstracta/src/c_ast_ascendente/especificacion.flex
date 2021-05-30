package c_ast_ascendente;

import errors.GestionErroresTiny1;

%%
%cup
%line
%column
%class AnalizadorLexicoTiny1
%type  UnidadLexica
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny1 errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int col() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresTiny1 errores) {
  	this.errores = errores;
  }
%}

%eofval{
  return ops.token(ClaseLexica.EOF);
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra = ([a-z]|[A-Z])
digPos = [1-9]
dig = ({digPos}|0)
pDec = \.(({dig}*{digPos})|0)
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
{TipoInt}		{return ops.token(ClaseLexica.TIPOINT);}
{TipoReal}		{return ops.token(ClaseLexica.TIPOREAL);}
{TipoBool}		{return ops.token(ClaseLexica.TIPOBOOL);}
{TipoString}	{return ops.token(ClaseLexica.TIPOSTRING);}
{And}			{return ops.token(ClaseLexica.AND);}
{Or}			{return ops.token(ClaseLexica.OR);}
{Not}			{return ops.token(ClaseLexica.NOT);}
{True}			{return ops.token(ClaseLexica.TRUE);}
{False}			{return ops.token(ClaseLexica.FALSE);}
{Var}			{return ops.token(ClaseLexica.VAR);}
{Type}			{return ops.token(ClaseLexica.TYPE);}
{Proc}			{return ops.token(ClaseLexica.PROC);}
{Null}			{return ops.token(ClaseLexica.NULL);}
{If}			{return ops.token(ClaseLexica.IF);}
{Then}			{return ops.token(ClaseLexica.THEN);}
{Else}			{return ops.token(ClaseLexica.ELSE);}
{Endif}			{return ops.token(ClaseLexica.ENDIF);}
{While}			{return ops.token(ClaseLexica.WHILE);}
{Do}			{return ops.token(ClaseLexica.DO);}
{Endwhile}		{return ops.token(ClaseLexica.ENDWHILE);}
{Call}			{return ops.token(ClaseLexica.CALL);}
{Record}		{return ops.token(ClaseLexica.RECORD);}
{Array}			{return ops.token(ClaseLexica.ARRAY);}
{Of}			{return ops.token(ClaseLexica.OF);}
{Pointer}		{return ops.token(ClaseLexica.POINTER);}
{New}			{return ops.token(ClaseLexica.NEW);}
{Delete}		{return ops.token(ClaseLexica.DELETE);}
{Read}			{return ops.token(ClaseLexica.READ);}
{Write}			{return ops.token(ClaseLexica.WRITE);}
{Nl}			{return ops.token(ClaseLexica.NL);}
{Mod}			{return ops.token(ClaseLexica.MOD);}
{Cadena}		{return ops.token(ClaseLexica.CADENA);}
{Id}			{return ops.token(ClaseLexica.ID);}
{Entero}		{return ops.token(ClaseLexica.ENTERO);}
{Real}			{return ops.token(ClaseLexica.REAL);}
{Asig}			{return ops.token(ClaseLexica.ASIG);}
{Amp}			{return ops.token(ClaseLexica.AMP);}
{SepSec}		{return ops.token(ClaseLexica.SEPSEC);}
{Mas}			{return ops.token(ClaseLexica.MAS);}
{Menos}			{return ops.token(ClaseLexica.MENOS);}
{Por}			{return ops.token(ClaseLexica.POR);}
{Div}			{return ops.token(ClaseLexica.DIV);}
{PAp}			{return ops.token(ClaseLexica.PAP);}
{PCie}			{return ops.token(ClaseLexica.PCIE);}
{CAp}			{return ops.token(ClaseLexica.CAP);}
{CCie}			{return ops.token(ClaseLexica.CCIE);}
{LlAp}			{return ops.token(ClaseLexica.LLAP);}
{LlCie}			{return ops.token(ClaseLexica.LLCIE);}
{Flecha}		{return ops.token(ClaseLexica.FLECHA);}
{Menor}			{return ops.token(ClaseLexica.MENOR);}
{Mayor}			{return ops.token(ClaseLexica.MAYOR);}
{MenIgual}		{return ops.token(ClaseLexica.MENIGUAL);}
{MayIgual}		{return ops.token(ClaseLexica.MAYIGUAL);}
{Igual}			{return ops.token(ClaseLexica.IGUAL);}
{Dist}			{return ops.token(ClaseLexica.DIST);}
{PuntoComa}		{return ops.token(ClaseLexica.PUNTOCOMA);}
{Coma}			{return ops.token(ClaseLexica.COMA);}
{Punto}			{return ops.token(ClaseLexica.PUNTO);}
[^]				{errores.errorLexico(fila(),col(),lexema());}