package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Salto de linea */
( "\n" ) {return Linea;}

/* Comillas */
( "\"" ) {lexeme=yytext(); return Comillas;}

/* Tipos de datos */
( citaPerfecta | confesion | fecha | hora ) {lexeme=yytext(); return T_dato;}

/* Palabra reservada Else */
( peroTeEntiendo ) {lexeme=yytext(); return PeroTeEntiendo;}

/* Palabra reservada While */
( siempreContigo ) {lexeme=yytext(); return SiempreContigo;}

/* Palabra reservada For */
( teDedicoMiTiempo ) {lexeme=yytext(); return TeDedicoMiTiempo;}

/* Palabra reservada Do */
( tePrometo ) {lexeme=yytext(); return TePrometo;}

/* Palabra reservada If */
( siMeAmas ) {lexeme=yytext(); return SiMeAmas;}

/* Operador Igual */
( compromiso ) {lexeme=yytext(); return Compromiso;}

/* Operador Suma */
( juntos ) {lexeme=yytext(); return Juntos;}

/* Operador Resta */
( distancia ) {lexeme=yytext(); return Distancia;}

/* Operador Multiplicacion */
( fuerza ) {lexeme=yytext(); return Fuerza;}

/* Operador Division */
( dividimos ) {lexeme=yytext(); return Dividimos;}

/* Operadores Booleanos */
( sinceridad | engaño ) {lexeme=yytext(); return Op_booleano;}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {lexeme=yytext(); return Op_logico;}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {lexeme = yytext(); return Op_relacional;}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return Op_atribucion;}

/* Operadores Incremento y decremento */
( "++" | "--" ) {lexeme = yytext(); return Op_incremento;}

/* Parentesis de apertura */
( "(" ) {lexeme=yytext(); return Parentesis_a;}

/* Parentesis de cierre */
( ")" ) {lexeme=yytext(); return Parentesis_c;}

/* Llave de apertura */
( "{" ) {lexeme=yytext(); return Llave_a;}

/* Llave de cierre */
( "}" ) {lexeme=yytext(); return Llave_c;}

/* Corchete de apertura */
( "[" ) {lexeme = yytext(); return Corchete_a;}

/* Corchete de cierre */
( "]" ) {lexeme = yytext(); return Corchete_c;}

/* Marcador de inicio de algoritmo */
( "relacion" ) {lexeme=yytext(); return Relacion;}

/* Punto y coma */
( ";" ) {lexeme=yytext(); return P_coma;}

/* Identificador */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* Numero */
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}

/* Error de analisis */
 . {return ERROR;}