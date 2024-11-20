package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

/* Tipos de datos */
( citaPerfecta | confesion | fecha | hora ) {return new Symbol(sym.T_dato, yychar, yyline, yytext());}

/* Palabra reservada Else */
( peroTeEntiendo ) {return new Symbol(sym.PeroTeEntiendo, yychar, yyline, yytext());}

/* Palabra reservada While */
( siempreContigo ) {return new Symbol(sym.SiempreContigo, yychar, yyline, yytext());}

/* Palabra reservada For */
( teDedicoMiTiempo ) {return new Symbol(sym.TeDedicoMiTiempo, yychar, yyline, yytext());}

/* Palabra reservada Do */
( tePrometo ) {return new Symbol(sym.TePrometo, yychar, yyline, yytext());}

/* Palabra reservada If */
( siMeAmas ) {return new Symbol(sym.SiMeAmas, yychar, yyline, yytext());}

/* Operador Igual */
( compromiso ) {return new Symbol(sym.Compromiso, yychar, yyline, yytext());}

/* Operador Suma */
( juntos ) {return new Symbol(sym.Juntos, yychar, yyline, yytext());}

/* Operador Resta */
( distancia ) {return new Symbol(sym.Distancia, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( fuerza ) {return new Symbol(sym.Fuerza, yychar, yyline, yytext());}

/* Operador Division */
( dividimos ) {return new Symbol(sym.Dividimos, yychar, yyline, yytext());}

/* Operadores Booleanos */
( sinceridad | engaño ) {return new Symbol(sym.Op_booleano, yychar, yyline, yytext());}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {return new Symbol(sym.Op_logico, yychar, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.Op_incremento, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}

/* Marcador de inicio de algoritmo */
( "relacion" ) {return new Symbol(sym.Relacion, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}