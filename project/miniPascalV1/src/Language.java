// import java.util.Hashtable;
// import java.lang.reflect.Field;
// import java.lang.reflect.Modifier;

public final class Language {

    //Pascal reserved word token names
    public static final String TOK_RW_AND       = "AND";
    public static final String TOK_RW_ARRAY     = "ARRAY";
    public static final String TOK_RW_BEGIN     = "BEGAN";
    public static final String TOK_RW_DIV       = "DIVIDE";
    public static final String TOK_RW_DO        = "DO";
    public static final String TOK_RW_DOWNTO    = "DOWNTO";
    public static final String TOK_RW_ELSE      = "ELSE";
    public static final String TOK_RW_END       = "END";
    public static final String TOK_RW_FOR       = "FOR";
    public static final String TOK_RW_FUNCTION  = "FUNCTION";
    public static final String TOK_RW_IF        = "IF";
    public static final String TOK_RW_MOD       = "MOD";
    public static final String TOK_RW_NOT       = "NOT";
    public static final String TOK_RW_OF        = "OF";
    public static final String TOK_RW_OR        = "OR";
    public static final String TOK_RW_PROCEDURE = "PROCEDURE";
    public static final String TOK_RW_PROGRAM   = "PROGRAM";
    public static final String TOK_RW_THEN      = "THEN";
    public static final String TOK_RW_VAR       = "VAR";
    public static final String TOK_RW_WHILE     = "WHILE";

    //Pascal reserved symbol token names
    public static final String TOK_RS_PLUS       = "PLUS";
    public static final String TOK_RS_MINUS      = "MINUS";
    public static final String TOK_RS_MULT       = "MULT";
    public static final String TOK_RS_LT         = "LT";
    public static final String TOK_RS_LTE        = "LTE";
    public static final String TOK_RS_GT         = "GT";
    public static final String TOK_RS_GTE        = "GTE";
    public static final String TOK_RS_EQU        = "EQU";
    public static final String TOK_RS_NE         = "NE";
    public static final String TOK_RS_ASSIGN     = "ASSIGN";
    public static final String TOK_RS_COLON      = "COLON";
    public static final String TOK_RS_SEMICOLON  = "SEMICOLON";
    public static final String TOK_RS_COMMA      = "COMMA";
    public static final String TOK_RS_LPAREN     = "LAPREN";
    public static final String TOK_RS_RPAREN     = "RPAREN";
    public static final String TOK_RS_LSQBRACKET = "LSQBRACKET";
    public static final String TOK_RS_RSQBRACKET = "RSQBRACKET";
    public static final String TOK_RS_PERIOD     = "PERIOD";
    public static final String TOK_RS_RANGE      = "RANGE";

    //Pascal language patterns token names
    public static final String TOK_LP_ID      = "ID";
    public static final String TOK_LP_NUMBER  = "NUMBER";
    public static final String TOK_LP_STRING  = "STRING";
    public static final String TOK_LP_CHAR    = "CHAR";
    public static final String TOK_LP_EOF     = "EOF";
    public static final String TOK_LP_READ    = "READ";
    public static final String TOK_LP_READLN  = "READLN";
    public static final String TOK_LP_WRITE   = "WRITE";
    public static final String TOK_LP_WRITELN = "WRITELN";
    public static final String TOK_LP_ERROR   = "ERROR";

    //Pascal literal datatype token names
    public static final String TOK_LIT_INT   = "INTLIT";
    public static final String TOK_LIT_REAL  = "REALLIT";
    public static final String TOK_LIT_CHAR  = "CHRLIT";

    //Pascal regex for language pattern construStringctions
    public static final String REGEX_LETTER  = "[a-zA-Z]";
    public static final String REGEX_DIGIT   = "[0-9]";
    public static final String REGEX_NEWLINE = "\n";

    //Pascal regex for reserved words
    public static final String REGEX_RW_AND       = "^and$";
    public static final String REGEX_RW_ARRAY     = "^array$";
    public static final String REGEX_RW_BEGIN     = "^begin$";
    public static final String REGEX_RW_DIV       = "^div$";
    public static final String REGEX_RW_DO        = "^do$";
    public static final String REGEX_RW_DOWNTO    = "^downto$";
    public static final String REGEX_RW_ELSE      = "^else$";
    public static final String REGEX_RW_END       = "^end$";
    public static final String REGEX_RW_FOR       = "^for$";
    public static final String REGEX_RW_FUNCTION  = "^function$";
    public static final String REGEX_RW_IF        = "^if$";
    public static final String REGEX_RW_MOD       = "^mod$";
    public static final String REGEX_RW_NOT       = "^not$";
    public static final String REGEX_RW_OF        = "^of$";
    public static final String REGEX_RW_OR        = "^or$";
    public static final String REGEX_RW_PROCEDURE = "^procedure$";
    public static final String REGEX_RW_THEN      = "^then$";
    public static final String REGEX_RW_TO        = "^to$";
    public static final String REGEX_RW_VAR       = "^var$";
    public static final String REGEX_RW_WHILE     = "^while$";

    //Pascal regex for reserved symbols
    public static final String REGEX_RS_PLUS       = "+";
    public static final String REGEX_RS_MINUS      = "-";
    public static final String REGEX_RS_MULT       = "*";
    public static final String REGEX_RS_LT         = "<";
    public static final String REGEX_RS_LTE        = "^<=$";
    public static final String REGEX_RS_GT         = ">";
    public static final String REGEX_RS_GTE        = "^>=$";
    public static final String REGEX_RS_EQU        = "=";
    public static final String REGEX_RS_NE         = "^<>$";
    public static final String REGEX_RS_ASSIGN     = "^:=$";
    public static final String REGEX_RS_COLON      = ":";
    public static final String REGEX_RS_SEMICOLON  = ";";
    public static final String REGEX_RS_COMMA      = ",";
    public static final String REGEX_RS_LPAREN     = "(";
    public static final String REGEX_RS_RPAREN     = ")";
    public static final String REGEX_RS_LSQBRACKED = "[";
    public static final String REGEX_RS_RSQBRACKET = "]";
    public static final String REGEX_RS_PERIOD     = ".";
    public static final String REGEX_RS_RANGE      = "^..$";

    //Pascal regex for literal datatypes
    public static final String REGEX_LIT_INT = REGEX_DIGIT + "+";
    public static final String REGEX_LIT_REAL = REGEX_DIGIT + "+\\.?" +REGEX_DIGIT+"+";
    public static final String REGEX_LIT_CHAR = "\'.\'";
    public static final String REGEX_LIT_STRING = "\'.*\'";

    //Pascal regex for language patterns
    public static final String REGEX_PT_ID    = REGEX_LETTER+"("+REGEX_LETTER+"|"+REGEX_DIGIT+")*";
    public static final String REGEX_PT_COMMENT = "\\{.*\\}";
    public static final String REGEX_PT_ADDOP = "["+REGEX_RS_PLUS+REGEX_RS_MINUS+"]";
    public static final String REGEX_PT_RELOP = "^(^("+REGEX_RS_NE+")?|^("+REGEX_RS_LTE+")?|^("+REGEX_RS_GTE+")?|^("+REGEX_RS_LT+")?|^("+REGEX_RS_GT+")?|^("+REGEX_RS_EQU+")?)?";
    // public static final String REGEX_PT_MULOP 


    // private static Hashtable<String,String> pascalLanguageRules = new Hashtable<String,String>(); 


    public Constants() {
        // Field[] finalFields = Constants.class.getDeclaredFields();
        // for (Field f : finalFields) {
        //     if (Modifier.isFinal(f.getModifiers())) {
        //         System.out.println(f.getName());
        //     }
        // }



    }

    // public Hashtable<String,String> getLanguageRules() {
    //     return pascalLanguageRules;
    // } 

}