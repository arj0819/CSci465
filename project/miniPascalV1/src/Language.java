public final class Language {

    //Pascal reserved word token names
    public static final String TOK_RW_AND       = "AND";
    public static final String TOK_RW_ARRAY     = "ARRAY";
    public static final String TOK_RW_BEGIN     = "BEGIN";
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
    public static final String TOK_RW_TO        = "TO";
    public static final String TOK_RW_VAR       = "VAR";
    public static final String TOK_RW_WHILE     = "WHILE";

    //Pascal reserved type specifier names
    public static final String TOK_TS_INT       = "INTTYPE";
    public static final String TOK_TS_REAL      = "REALTYPE";
    public static final String TOK_TS_BOOL      = "BOOLTYPE";
    public static final String TOK_TS_STRING    = "STRTYPE";
    public static final String TOK_TS_CHAR      = "CHARTYPE";

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

    //Pascal language pattern token names
    public static final String TOK_LP_ID      = "ID";
    public static final String TOK_LP_NUMBER  = "NUMBER";
    public static final String TOK_LP_STRING  = "STRING";
    public static final String TOK_LP_CHAR    = "CHAR";
    public static final String TOK_LP_EOF     = "EOF";
    public static final String TOK_LP_READ    = "READ";
    public static final String TOK_LP_READLN  = "READLN";
    public static final String TOK_LP_WRITE   = "WRITE";
    public static final String TOK_LP_WRITELN = "WRITELN";
    public static final String TOK_LP_COMMENT = "COMMENT";
    public static final String TOK_LP_ERROR   = "ERROR";

    //Pascal literal datatype token names
    public static final String TOK_LIT_INT  = "INTLIT";
    public static final String TOK_LIT_REAL = "REALLIT";
    public static final String TOK_LIT_BOOL = "BOOLLIT";
    public static final String TOK_LIT_CHAR = "CHRLIT";
    public static final String TOK_LIT_STR  = "STRLIT";

    //Pascal data type names
    public static final String TOK_TYPE_INT  = "INTTYPE";
    public static final String TOK_TYPE_REAL = "REALTYPE";
    public static final String TOK_TYPE_BOOL = "BOOLTYPE";
    public static final String TOK_TYPE_CHAR = "CHRTYPE";
    public static final String TOK_TYPE_STR  = "STRTYPE";

    //Pascal regex for language pattern constructions
    public static final String REGEX_LETTER     = "[a-zA-Z]";
    public static final String REGEX_DIGIT      = "[0-9]";
    public static final String REGEX_TRUE       = "true";
    public static final String REGEX_FALSE      = "false";
    public static final String REGEX_NEWLINE    = "\n";
    public static final String REGEX_SINGLEQT   = "'";
    public static final String REGEX_ANYTHING   = ".*";
    public static final String REGEX_WHITESPACE = "\\s";

    //Pascal regex for reserved words
    public static final String REGEX_RW_AND       = "and";
    public static final String REGEX_RW_ARRAY     = "array";
    public static final String REGEX_RW_BEGIN     = "begin";
    public static final String REGEX_RW_BOOL      = "boolean";
    public static final String REGEX_RW_CHAR      = "char";
    public static final String REGEX_RW_DIV       = "div";
    public static final String REGEX_RW_DO        = "do";
    public static final String REGEX_RW_DOWNTO    = "downto";
    public static final String REGEX_RW_ELSE      = "else";
    public static final String REGEX_RW_END       = "end";
    public static final String REGEX_RW_FOR       = "for";
    public static final String REGEX_RW_FUNCTION  = "function";
    public static final String REGEX_RW_IF        = "if";
    public static final String REGEX_RW_INT       = "integer";
    public static final String REGEX_RW_MOD       = "mod";
    public static final String REGEX_RW_NOT       = "not";
    public static final String REGEX_RW_OF        = "of";
    public static final String REGEX_RW_OR        = "or";
    public static final String REGEX_RW_PROCEDURE = "procedure";
    public static final String REGEX_RW_PROGRAM   = "program";
    public static final String REGEX_RW_REAL      = "real";
    public static final String REGEX_RW_STR       = "string";
    public static final String REGEX_RW_THEN      = "then";
    public static final String REGEX_RW_TO        = "to";
    public static final String REGEX_RW_VAR       = "var";
    public static final String REGEX_RW_WHILE     = "while";

    //Pascal regex for reserved symbols
    public static final String REGEX_RS_PLUS       = "\\+";
    public static final String REGEX_RS_MINUS      = "-";
    public static final String REGEX_RS_MULT       = "\\*";
    public static final String REGEX_RS_DIVIDE     = "/";
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
    public static final String REGEX_RS_LPAREN     = "\\(";
    public static final String REGEX_RS_RPAREN     = "\\)";
    public static final String REGEX_RS_LSQBRACKET = "\\[";
    public static final String REGEX_RS_RSQBRACKET = "\\]";
    public static final String REGEX_RS_LCRLYBRACK = "\\{";
    public static final String REGEX_RS_RCRLYBRACK = "}";
    public static final String REGEX_RS_LBIGRAM    = "\\(\\*";
    public static final String REGEX_RS_RBIGRAM    = "\\*\\)";
    public static final String REGEX_RS_PERIOD     = "\\.";
    public static final String REGEX_RS_DECIMAL    = ".";
    public static final String REGEX_RS_RANGE      = "..";

    //Pascal regex for literal datatypes
    public static final String REGEX_LIT_INT    = REGEX_DIGIT + "+";
    public static final String REGEX_LIT_REAL   = REGEX_DIGIT + "+\\." +REGEX_DIGIT+"+";
    public static final String REGEX_LIT_BOOL   = REGEX_TRUE + "|" + REGEX_FALSE;
    public static final String REGEX_LIT_CHAR   = "\'.\'";
    public static final String REGEX_LIT_STRING = REGEX_SINGLEQT + REGEX_ANYTHING + REGEX_SINGLEQT;

    //Pascal regex for complex language patterns
    public static final String REGEX_PT_ID          = REGEX_LETTER+"("+REGEX_LETTER+"|"+REGEX_DIGIT+")*";
    public static final String REGEX_PT_CRLYCOMMENT = REGEX_RS_LCRLYBRACK+REGEX_ANYTHING+REGEX_RS_RCRLYBRACK;
    public static final String REGEX_PT_BGRMCOMMENT = REGEX_RS_LBIGRAM+REGEX_ANYTHING+REGEX_RS_RBIGRAM;
    public static final String REGEX_PT_ADDOP       = "["+REGEX_RS_PLUS+REGEX_RS_MINUS+"]";
    public static final String REGEX_PT_RELOP       = "^(^("+REGEX_RS_NE+")?|^("+REGEX_RS_LTE+")?|^("+REGEX_RS_GTE+")?|^("+REGEX_RS_LT+")?|^("+REGEX_RS_GT+")?|^("+REGEX_RS_EQU+")?)?";

    //State values for lexical analysis
    public static final int ST_START                       = 0;
    public static final int ST_COLON                       = 1;
    public static final int ST_COLON_EQUALS                = 2;
    public static final int ST_LCRLYBRK                    = 3;
    public static final int ST_LCRLYBRK_IGNOREALL          = 4;
    public static final int ST_LCRLYBRK_IGNOREALL_RCRLYBRK = 5;
    public static final int ST_LPAREN                      = 6;
    public static final int ST_LBIGRAM                     = 7;
    public static final int ST_LBIGRAM_IGNOREALL           = 8;
    public static final int ST_LBIGRAM_IGNOREALL_RBIGRAM   = 9;
    public static final int ST_RPAREN                      = 10;
    public static final int ST_LETTER                      = 11;
    public static final int ST_ID                          = 12;
    public static final int ST_COMMA                       = 13;
    public static final int ST_SEMICOLON                   = 14;
    public static final int ST_EQU                         = 15;
    public static final int ST_LT                          = 16;
    public static final int ST_LT_EQU                      = 17;
    public static final int ST_NE                          = 18;
    public static final int ST_GT                          = 19;
    public static final int ST_GT_EQU                      = 20;
    public static final int ST_DIGIT                       = 21;
    public static final int ST_INTEGER                     = 22;
    public static final int ST_REAL                        = 23;
    public static final int ST_PERIOD                      = 24;
    public static final int ST_RANGE                       = 25;
    public static final int ST_PLUS                        = 26;
    public static final int ST_MINUS                       = 27;
    public static final int ST_MULT                        = 28;
    public static final int ST_DIVIDE                      = 29;
    public static final int ST_LSQBRACKET                  = 30;
    public static final int ST_RSQBRACKET                  = 31;
    public static final int ST_SINGLEQT                    = 32;
    public static final int ST_SINGLEQT_ACCEPTALL          = 33;
    public static final int ST_SINGLEQT_ACCEPTALL_SINGLEQT = 34;

    //An empty constructor for readability
    public Language() {}
}