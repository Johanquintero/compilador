/* The following code was generated by JFlex 1.4.3 on 17/11/24, 11:27 a. m. */

package codigo;
import static codigo.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 17/11/24, 11:27 a. m. from the specification file
 * <tt>E:/Universidad/Compiladores/AnalizadorLexico/src/codigo/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\5\2\0\1\3\22\0\1\3\1\44\1\6\2\0"+
    "\1\52\1\42\1\0\1\53\1\54\1\52\1\50\1\3\1\51\1\0"+
    "\1\4\12\2\1\0\1\62\1\46\1\47\1\45\2\0\1\34\1\1"+
    "\1\30\1\32\1\25\7\1\1\33\2\1\1\13\3\1\1\24\6\1"+
    "\1\57\1\0\1\60\1\0\1\1\1\0\1\12\1\1\1\7\1\26"+
    "\1\14\1\16\1\31\1\22\1\10\1\35\1\1\1\61\1\27\1\20"+
    "\1\17\1\23\1\1\1\15\1\21\1\11\1\36\1\40\3\1\1\37"+
    "\1\55\1\43\1\56\163\0\1\41\uff0e\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\12\2\3\7\2\10\4\1\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\4\1\20\14\2\1\7\1\10"+
    "\1\21\1\0\21\2\1\0\13\2\1\22\4\2\1\3"+
    "\5\2\1\0\16\2\1\23\1\2\1\24\6\2\1\25"+
    "\21\2\1\26\2\2\1\27\5\2\1\30\4\2\1\31"+
    "\1\32\1\2\1\33\2\2\1\23\13\2\1\34\1\35"+
    "\1\2\1\36";

  private static int [] zzUnpackAction() {
    int [] result = new int[170];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\231\0\314\0\377\0\63\0\63"+
    "\0\u0132\0\u0165\0\u0198\0\u01cb\0\u01fe\0\u0231\0\u0264\0\u0297"+
    "\0\u02ca\0\u02fd\0\u0330\0\u0363\0\u0396\0\u03c9\0\u03fc\0\u0396"+
    "\0\u042f\0\u0462\0\u0495\0\u04c8\0\63\0\63\0\63\0\63"+
    "\0\63\0\63\0\u04fb\0\63\0\u052e\0\u0561\0\u0594\0\u05c7"+
    "\0\u05fa\0\u062d\0\u0660\0\u0693\0\u06c6\0\u06f9\0\u072c\0\u075f"+
    "\0\63\0\63\0\63\0\u0792\0\u07c5\0\u07f8\0\u082b\0\u085e"+
    "\0\u0891\0\u08c4\0\u08f7\0\u092a\0\u095d\0\u0990\0\u09c3\0\u09f6"+
    "\0\u0a29\0\u0a5c\0\u0a8f\0\u0ac2\0\u0af5\0\u0b28\0\u0b5b\0\u0b8e"+
    "\0\u0bc1\0\u0bf4\0\u0c27\0\u0c5a\0\u0c8d\0\u0cc0\0\u0cf3\0\u0d26"+
    "\0\u0d59\0\146\0\u0d8c\0\u0dbf\0\u0df2\0\u0e25\0\63\0\u0e58"+
    "\0\u0e8b\0\u0ebe\0\u0ef1\0\u0f24\0\u0f57\0\u0f8a\0\u0fbd\0\u0ff0"+
    "\0\u1023\0\u1056\0\u1089\0\u10bc\0\u10ef\0\u1122\0\u1155\0\u1188"+
    "\0\u11bb\0\u11ee\0\u1221\0\63\0\u1254\0\146\0\u1287\0\u12ba"+
    "\0\u12ed\0\u1320\0\u1353\0\u1386\0\146\0\u13b9\0\u13ec\0\u141f"+
    "\0\u1452\0\u1485\0\u14b8\0\u14eb\0\u151e\0\u1551\0\u1584\0\u15b7"+
    "\0\u15ea\0\u161d\0\u1650\0\u1683\0\u16b6\0\u16e9\0\146\0\u171c"+
    "\0\u174f\0\146\0\u1782\0\u17b5\0\u17e8\0\u181b\0\u184e\0\146"+
    "\0\u1881\0\u18b4\0\u18e7\0\u191a\0\146\0\146\0\u194d\0\146"+
    "\0\u1980\0\u19b3\0\146\0\u19e6\0\u1a19\0\u1a4c\0\u1a7f\0\u1ab2"+
    "\0\u1ae5\0\u1b18\0\u1b4b\0\u1b7e\0\u1bb1\0\u1be4\0\146\0\146"+
    "\0\u1c17\0\146";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[170];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\3\1\12\2\3\1\13\1\14\1\15\2\3\1\16"+
    "\1\17\1\20\2\3\1\21\6\3\1\22\3\3\1\2"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\3"+
    "\1\42\64\0\2\3\4\0\32\3\20\0\1\3\3\0"+
    "\1\4\63\0\1\5\63\0\1\43\42\0\1\44\14\0"+
    "\2\3\4\0\1\3\1\45\6\3\1\46\21\3\20\0"+
    "\1\3\2\0\2\3\4\0\5\3\1\47\24\3\20\0"+
    "\1\3\2\0\2\3\4\0\11\3\1\50\20\3\20\0"+
    "\1\3\2\0\2\3\4\0\5\3\1\51\24\3\20\0"+
    "\1\3\2\0\2\3\4\0\5\3\1\52\21\3\1\53"+
    "\2\3\20\0\1\3\2\0\2\3\4\0\1\3\1\54"+
    "\30\3\20\0\1\3\2\0\2\3\4\0\10\3\1\55"+
    "\21\3\20\0\1\3\2\0\2\3\4\0\5\3\1\56"+
    "\24\3\20\0\1\3\2\0\2\3\4\0\1\3\1\57"+
    "\30\3\20\0\1\3\2\0\2\3\4\0\27\3\1\60"+
    "\2\3\20\0\1\3\43\0\1\61\63\0\1\61\66\0"+
    "\1\62\60\0\1\62\1\0\1\62\61\0\2\62\62\0"+
    "\1\44\1\63\61\0\1\44\1\0\1\63\60\0\1\44"+
    "\64\0\1\64\11\0\5\43\1\0\55\43\1\0\2\3"+
    "\4\0\2\3\1\65\27\3\20\0\1\3\2\0\2\3"+
    "\4\0\11\3\1\66\6\3\1\67\11\3\20\0\1\3"+
    "\2\0\2\3\4\0\4\3\1\70\16\3\1\71\6\3"+
    "\20\0\1\3\2\0\2\3\4\0\22\3\1\72\7\3"+
    "\20\0\1\3\2\0\2\3\4\0\32\3\20\0\1\73"+
    "\2\0\2\3\4\0\1\74\31\3\20\0\1\3\2\0"+
    "\2\3\4\0\5\3\1\75\24\3\20\0\1\3\2\0"+
    "\2\3\4\0\5\3\1\76\3\3\1\77\12\3\1\100"+
    "\5\3\20\0\1\3\2\0\2\3\4\0\6\3\1\101"+
    "\23\3\20\0\1\3\2\0\2\3\4\0\6\3\1\102"+
    "\23\3\20\0\1\3\2\0\2\3\4\0\12\3\1\103"+
    "\16\3\1\104\20\0\1\3\2\0\2\3\4\0\11\3"+
    "\1\105\20\3\20\0\1\3\3\0\1\106\61\0\2\3"+
    "\4\0\3\3\1\107\26\3\20\0\1\3\2\0\2\3"+
    "\4\0\7\3\1\110\22\3\20\0\1\3\2\0\2\3"+
    "\4\0\14\3\1\111\15\3\20\0\1\3\2\0\2\3"+
    "\4\0\6\3\1\112\23\3\20\0\1\3\2\0\2\3"+
    "\4\0\5\3\1\113\24\3\20\0\1\3\2\0\2\3"+
    "\4\0\3\3\1\114\26\3\20\0\1\3\2\0\2\3"+
    "\4\0\3\3\1\115\26\3\20\0\1\3\2\0\2\3"+
    "\4\0\13\3\1\101\16\3\20\0\1\3\2\0\2\3"+
    "\4\0\6\3\1\116\23\3\20\0\1\3\2\0\2\3"+
    "\4\0\20\3\1\117\11\3\20\0\1\3\2\0\2\3"+
    "\4\0\1\120\31\3\20\0\1\3\2\0\2\3\4\0"+
    "\5\3\1\121\24\3\20\0\1\3\2\0\2\3\4\0"+
    "\3\3\1\122\26\3\20\0\1\3\2\0\2\3\4\0"+
    "\10\3\1\123\21\3\20\0\1\3\2\0\2\3\4\0"+
    "\2\3\1\124\27\3\20\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\125\30\3\20\0\1\3\2\0\2\3\4\0"+
    "\2\3\1\126\27\3\20\0\1\3\3\0\1\106\51\0"+
    "\1\127\7\0\2\3\4\0\4\3\1\130\25\3\20\0"+
    "\1\3\2\0\2\3\4\0\5\3\1\131\24\3\20\0"+
    "\1\3\2\0\2\3\4\0\6\3\1\132\23\3\20\0"+
    "\1\3\2\0\2\3\4\0\10\3\1\133\21\3\20\0"+
    "\1\3\2\0\2\3\4\0\17\3\1\134\12\3\20\0"+
    "\1\3\2\0\2\3\4\0\32\3\1\135\17\0\1\3"+
    "\2\0\2\3\4\0\1\136\31\3\20\0\1\3\2\0"+
    "\2\3\4\0\30\3\1\137\1\3\20\0\1\3\2\0"+
    "\2\3\4\0\14\3\1\140\15\3\20\0\1\3\2\0"+
    "\2\3\4\0\5\3\1\141\24\3\20\0\1\3\2\0"+
    "\2\3\4\0\25\3\1\142\4\3\20\0\1\3\2\0"+
    "\2\3\4\0\15\3\1\143\14\3\20\0\1\3\2\0"+
    "\2\3\4\0\3\3\1\144\26\3\20\0\1\3\2\0"+
    "\2\3\4\0\17\3\1\145\12\3\20\0\1\3\2\0"+
    "\2\3\4\0\10\3\1\146\21\3\20\0\1\3\2\0"+
    "\2\3\4\0\5\3\1\147\24\3\20\0\1\3\2\0"+
    "\2\3\4\0\12\3\1\150\17\3\20\0\1\3\2\0"+
    "\2\3\4\0\10\3\1\151\21\3\20\0\1\3\2\0"+
    "\2\3\4\0\20\3\1\152\11\3\20\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\153\30\3\20\0\1\3\20\0"+
    "\1\154\44\0\2\3\4\0\1\3\1\155\30\3\20\0"+
    "\1\3\2\0\2\3\4\0\3\3\1\156\26\3\20\0"+
    "\1\3\2\0\2\3\4\0\6\3\1\157\23\3\20\0"+
    "\1\3\2\0\2\3\4\0\6\3\1\160\23\3\20\0"+
    "\1\3\2\0\2\3\4\0\20\3\1\161\11\3\20\0"+
    "\1\3\2\0\2\3\4\0\5\3\1\162\24\3\20\0"+
    "\1\3\2\0\2\3\4\0\11\3\1\163\20\3\20\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\164\30\3\20\0"+
    "\1\3\2\0\2\3\4\0\12\3\1\165\17\3\20\0"+
    "\1\3\2\0\2\3\4\0\6\3\1\166\23\3\20\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\167\30\3\20\0"+
    "\1\3\2\0\2\3\4\0\20\3\1\170\11\3\20\0"+
    "\1\3\2\0\2\3\4\0\5\3\1\171\24\3\20\0"+
    "\1\3\2\0\2\3\4\0\1\172\31\3\20\0\1\3"+
    "\2\0\2\3\4\0\10\3\1\173\21\3\20\0\1\3"+
    "\2\0\2\3\4\0\5\3\1\174\24\3\20\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\175\30\3\20\0\1\3"+
    "\2\0\2\3\4\0\3\3\1\176\26\3\20\0\1\3"+
    "\2\0\2\3\4\0\16\3\1\177\13\3\20\0\1\3"+
    "\2\0\2\3\4\0\1\200\31\3\20\0\1\3\2\0"+
    "\2\3\4\0\20\3\1\201\11\3\20\0\1\3\2\0"+
    "\2\3\4\0\7\3\1\202\22\3\20\0\1\3\2\0"+
    "\2\3\4\0\10\3\1\203\21\3\20\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\204\30\3\20\0\1\3\2\0"+
    "\2\3\4\0\2\3\1\205\27\3\20\0\1\3\2\0"+
    "\2\3\4\0\10\3\1\206\21\3\20\0\1\3\2\0"+
    "\2\3\4\0\11\3\1\207\20\3\20\0\1\3\2\0"+
    "\2\3\4\0\21\3\1\210\10\3\20\0\1\3\2\0"+
    "\2\3\4\0\17\3\1\211\12\3\20\0\1\3\2\0"+
    "\2\3\4\0\12\3\1\212\17\3\20\0\1\3\2\0"+
    "\2\3\4\0\11\3\1\213\20\3\20\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\214\30\3\20\0\1\3\2\0"+
    "\2\3\4\0\10\3\1\215\21\3\20\0\1\3\2\0"+
    "\2\3\4\0\5\3\1\216\24\3\20\0\1\3\2\0"+
    "\2\3\4\0\11\3\1\122\20\3\20\0\1\3\2\0"+
    "\2\3\4\0\12\3\1\217\17\3\20\0\1\3\2\0"+
    "\2\3\4\0\10\3\1\220\21\3\20\0\1\3\2\0"+
    "\2\3\4\0\24\3\1\221\5\3\20\0\1\3\2\0"+
    "\2\3\4\0\10\3\1\222\21\3\20\0\1\3\2\0"+
    "\2\3\4\0\3\3\1\223\26\3\20\0\1\3\2\0"+
    "\2\3\4\0\2\3\1\224\27\3\20\0\1\3\2\0"+
    "\2\3\4\0\3\3\1\225\26\3\20\0\1\3\2\0"+
    "\2\3\4\0\12\3\1\226\17\3\20\0\1\3\2\0"+
    "\2\3\4\0\1\227\31\3\20\0\1\3\2\0\2\3"+
    "\4\0\10\3\1\230\21\3\20\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\231\30\3\20\0\1\3\2\0\2\3"+
    "\4\0\11\3\1\232\20\3\20\0\1\3\2\0\2\3"+
    "\4\0\17\3\1\233\12\3\20\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\234\30\3\20\0\1\3\2\0\2\3"+
    "\4\0\2\3\1\101\27\3\20\0\1\3\2\0\2\3"+
    "\4\0\15\3\1\235\14\3\20\0\1\3\2\0\2\3"+
    "\4\0\2\3\1\236\27\3\20\0\1\3\2\0\2\3"+
    "\4\0\5\3\1\237\24\3\20\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\240\30\3\20\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\241\30\3\20\0\1\3\2\0\2\3"+
    "\4\0\11\3\1\242\20\3\20\0\1\3\2\0\2\3"+
    "\4\0\5\3\1\243\24\3\20\0\1\3\2\0\2\3"+
    "\4\0\22\3\1\244\7\3\20\0\1\3\2\0\2\3"+
    "\4\0\17\3\1\245\12\3\20\0\1\3\2\0\2\3"+
    "\4\0\20\3\1\246\11\3\20\0\1\3\2\0\2\3"+
    "\4\0\10\3\1\247\21\3\20\0\1\3\2\0\2\3"+
    "\4\0\10\3\1\250\21\3\20\0\1\3\2\0\2\3"+
    "\4\0\14\3\1\251\15\3\20\0\1\3\2\0\2\3"+
    "\4\0\10\3\1\252\21\3\20\0\1\3\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7242];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\2\11\24\1\6\11\1\1\1\11"+
    "\14\1\3\11\1\0\21\1\1\0\20\1\1\11\5\1"+
    "\1\0\16\1\1\11\76\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[170];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 152) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 6: 
          { lexeme=yytext(); return Comillas;
          }
        case 31: break;
        case 15: 
          { lexeme=yytext(); return P_coma;
          }
        case 32: break;
        case 30: 
          { lexeme=yytext(); return TeDedicoMiTiempo;
          }
        case 33: break;
        case 8: 
          { lexeme = yytext(); return Op_relacional;
          }
        case 34: break;
        case 29: 
          { lexeme=yytext(); return PeroTeEntiendo;
          }
        case 35: break;
        case 13: 
          { lexeme = yytext(); return Corchete_a;
          }
        case 36: break;
        case 28: 
          { lexeme=yytext(); return SiempreContigo;
          }
        case 37: break;
        case 11: 
          { lexeme=yytext(); return Llave_a;
          }
        case 38: break;
        case 27: 
          { lexeme=yytext(); return Compromiso;
          }
        case 39: break;
        case 5: 
          { return Linea;
          }
        case 40: break;
        case 20: 
          { lexeme=yytext(); return Fuerza;
          }
        case 41: break;
        case 19: 
          { lexeme=yytext(); return Op_booleano;
          }
        case 42: break;
        case 16: 
          { lexeme = yytext(); return Op_atribucion;
          }
        case 43: break;
        case 26: 
          { lexeme=yytext(); return Dividimos;
          }
        case 44: break;
        case 17: 
          { lexeme = yytext(); return Op_incremento;
          }
        case 45: break;
        case 10: 
          { lexeme=yytext(); return Parentesis_c;
          }
        case 46: break;
        case 25: 
          { lexeme=yytext(); return Distancia;
          }
        case 47: break;
        case 3: 
          { lexeme=yytext(); return Numero;
          }
        case 48: break;
        case 2: 
          { lexeme=yytext(); return Identificador;
          }
        case 49: break;
        case 24: 
          { lexeme=yytext(); return TePrometo;
          }
        case 50: break;
        case 1: 
          { return ERROR;
          }
        case 51: break;
        case 22: 
          { lexeme=yytext(); return Relacion;
          }
        case 52: break;
        case 4: 
          { /*Ignore*/
          }
        case 53: break;
        case 7: 
          { lexeme=yytext(); return Op_logico;
          }
        case 54: break;
        case 23: 
          { lexeme=yytext(); return SiMeAmas;
          }
        case 55: break;
        case 18: 
          { lexeme=yytext(); return T_dato;
          }
        case 56: break;
        case 9: 
          { lexeme=yytext(); return Parentesis_a;
          }
        case 57: break;
        case 14: 
          { lexeme = yytext(); return Corchete_c;
          }
        case 58: break;
        case 21: 
          { lexeme=yytext(); return Juntos;
          }
        case 59: break;
        case 12: 
          { lexeme=yytext(); return Llave_c;
          }
        case 60: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
