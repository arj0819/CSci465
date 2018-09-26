import java.util.regex.*;
import java.util.Stack;

public class Lexer {

    private String currentLexeme = "";
    private String currentChar = "";
    private String detectedLexeme = "";
    private String detectedToken = "";
    private String programText = "";
    private String lexerReport = "";
    private int programCounter = 0;
    private int lookAheadCounter = 0;
    private int programSize = 0;
    private int lineCounter = 1;
    private int state = 0;
    private boolean hasSymbols = true;
    private boolean stopSearching = false;

    private Stack<Integer> stateStack = new Stack<Integer>();

    public Lexer (String programText) {
        this.programText = programText;
        this.programSize = programText.length()-1;
    }

    public String getsym() throws Exception {

        // reset the stopSearching flag, currentLexeme, and 
        // detectedLexemeto properly search for the next symbol.
        stopSearching = false;
        currentChar = "";
        currentLexeme = "";
        detectedLexeme = "";

        // While we shouldn't stop searching for a match...
        while (!stopSearching) {

            // If programCounter has reached programSize, we should stop
            // searching because we have run out of symbols in the programText.
            if (programCounter >= programSize) {
                stopSearching();
                hasSymbols = false;
                break;
            }

            // Example of how an exception may be thrown to be handled by the Driver
            // if (programCounter == 150) {
            //     throw new Exception("There was an erroneous token discovered on line "+lineCounter);
            // }

            // If we found a newline, increment the lineCounter
            if (currentChar.matches(Language.REGEX_NEWLINE)) {
                System.out.println("Next Line Started");
                lineCounter++;
            }

            System.out.println("CURRENT STATE: "+state);
            switch (state) {
                // --------------------\/-------------------- ST_START --------------------\/-------------------- //
                case Language.ST_START :
                    // start by increasing the program counter to look at
                    // the next character in the programText
                    programCounter++;
                    // Set the lookAheadCounter = to the programCounter so we 
                    // know where to start looking ahead from if necessary.
                    lookAheadCounter = programCounter;
                    // Set the currentChar to the char in the programText
                    // currently pointed to by the programCounter
                    currentChar = Character.toString(programText.charAt(programCounter));

                    // if (currentChar.matches(Language.REGEX_NEWLINE)) {
                    //     lineCounter++;
                    // }

                    if (currentChar.matches(Language.REGEX_RS_COLON)) {
                        state = Language.ST_COLON;
                    } else if (currentChar.matches(Language.REGEX_RS_LCRLYBRACK)) {
                        state = Language.ST_LCRLYBRK;
                    } else if (currentChar.matches(Language.REGEX_RS_LPAREN)) {
                        state = Language.ST_LPAREN;
                    } else if (currentChar.matches(Language.REGEX_RS_RPAREN)) {
                        state = Language.ST_RPAREN;
                    }
                    break;
                // --------------------/\-------------------- ST_START --------------------/\-------------------- //
                // --------------------\/-------------------- ST_COLON --------------------\/-------------------- //
                case Language.ST_COLON : 
                    System.out.println("Entering ST_COLON");

                    detectedToken = Language.TOK_RS_COLON;
                    currentLexeme += currentChar;
                    detectedLexeme = currentLexeme;
                    state = Language.ST_COLON_EQUALS;
                    break;
                
                // --------------------/\-------------------- ST_COLON --------------------/\-------------------- //
                // --------------------\/-------------------- ST_COLON_EQUALS --------------------\/-------------------- //
                case Language.ST_COLON_EQUALS :
                    System.out.println("Entering ST_COLON_EQUALS");
                    lookAheadCounter++;
                    System.out.println("Lookahead counter incremented");
                    currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                    System.out.println(currentLexeme);
                    if (currentLexeme.matches(Language.REGEX_RS_ASSIGN)) {
                        detectedToken = Language.TOK_RS_ASSIGN;
                        detectedLexeme = currentLexeme;
                        programCounter = lookAheadCounter;

                        System.out.println("State Reset by ST_COLON_EQUALS - found an ASSIGN");
                        resetStateAndStopSearching();
                        break;
                    } else {
                        System.out.println("State Reset by ST_COLON_EQUALS - did not find ASSIGN");
                        resetStateAndStopSearching();
                        break;
                    }
                // --------------------/\-------------------- ST_COLON_EQUALS --------------------/\-------------------- //
                // --------------------\/-------------------- ST_LCRLYBRK --------------------\/-------------------- //
                case Language.ST_LCRLYBRK :
                    System.out.println("Entering ST_LCRLYBRK");
                    detectedToken = Language.TOK_LP_COMMENT;
                    currentLexeme += currentChar;
                    detectedLexeme = currentLexeme;
                    lookAheadCounter++;
                    if (Character.toString(programText.charAt(lookAheadCounter)).equals(Language.REGEX_NEWLINE)) {
                        System.out.println("Next Line Started");
                        lineCounter++;
                        currentLexeme += Character.toString(programText.charAt(lookAheadCounter)).replace("\n","\\n");
                    } else {
                        currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                    }
                    System.out.println("Leaving state ST_LCRLYBRK - found a LCRLYBRACK");
                    state = Language.ST_LCRLYBRK_IGNOREALL;
                    break;
                // --------------------/\-------------------- ST_LCRLYBRK --------------------/\-------------------- //
                // --------------------\/-------------------- ST_LCRLYBRK_IGNOREALL --------------------\/-------------------- //
                case Language.ST_LCRLYBRK_IGNOREALL :
                    System.out.println("Entering ST_LCRLYBRK_IGNOREALL");
                    if (currentLexeme.matches(Language.REGEX_PT_CRLYCOMMENT)) {
                        detectedLexeme = currentLexeme;
                        programCounter = lookAheadCounter;

                        System.out.println("State Reset by ST_LCRLYBRK_IGNOREALL - found a COMMENT");
                        resetStateAndStopSearching();
                        break;
                    } else {
                        lookAheadCounter++;
                        System.out.println("Lookahead counter incremented");
                        System.out.println("No state change - have not yet detected RCRLYBRACK");
                        if (Character.toString(programText.charAt(lookAheadCounter)).equals(Language.REGEX_NEWLINE)) {
                            System.out.println("Next Line Started");
                            lineCounter++;
                            currentLexeme += Character.toString(programText.charAt(lookAheadCounter)).replace("\n","\\n");
                        } else {
                            currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                        }
                        break;
                    }
                // --------------------/\-------------------- ST_LCRLYBRK_IGNOREALL --------------------/\-------------------- //
                // --------------------\/-------------------- ST_LPAREN --------------------\/-------------------- //
                case Language.ST_LPAREN :
                    System.out.println("Entering ST_LPAREN");
                    detectedToken = Language.TOK_RS_LPAREN;
                    currentLexeme += currentChar;
                    detectedLexeme = currentLexeme;
                    state = Language.ST_LBIGRAM;
                    break;
                // --------------------/\-------------------- ST_LPAREN --------------------/\-------------------- //
                // --------------------\/-------------------- ST_LBIGRAM --------------------\/-------------------- //
                case Language.ST_LBIGRAM :
                    System.out.println("Entering ST_LBIGRAM");
                    System.out.println(currentLexeme);
                    lookAheadCounter++;
                    System.out.println("Lookahead counter incremented");
                    currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                    if (currentLexeme.matches(Language.REGEX_RS_LBIGRAM)) {
                        detectedToken = Language.TOK_LP_COMMENT;
                        detectedLexeme = currentLexeme;
                        lookAheadCounter++;
                        currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                        System.out.println("Leaving state ST_BIGRAM - found a LBIGRAM");
                        state = Language.ST_LBIGRAM_IGNOREALL;
                        break;
                    } else {
                        System.out.println("State Reset by ST_LBIGRAM - did not find LBIGRAM");
                        resetStateAndStopSearching();
                        break;
                    }
                // --------------------/\-------------------- ST_LBIGRAM --------------------/\-------------------- //
                // --------------------\/-------------------- ST_LBIGRAM_IGNOREALL --------------------\/-------------------- //
                case Language.ST_LBIGRAM_IGNOREALL :
                    System.out.println("Entering ST_LBIGRAM_IGNOREALL");
                    if (currentLexeme.matches(Language.REGEX_PT_BGRMCOMMENT)) {
                        detectedLexeme = currentLexeme;
                        programCounter = lookAheadCounter;

                        System.out.println("State Reset by ST_LBIGRAM_IGNOREALL - found a COMMENT");
                        resetStateAndStopSearching();
                        break;
                    } else {
                        lookAheadCounter++;
                        System.out.println("Lookahead counter incremented");
                        System.out.println("No state change - have not yet detected RBIGRAM");
                        if (Character.toString(programText.charAt(lookAheadCounter)).equals(Language.REGEX_NEWLINE)) {
                            System.out.println("Next Line Started");
                            lineCounter++;
                            currentLexeme += Character.toString(programText.charAt(lookAheadCounter)).replace("\n","\\n");
                        } else {
                            currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                        }
                        break;
                    }
                // --------------------/\-------------------- ST_LBIGRAM_IGNOREALL --------------------/\-------------------- //
                // --------------------\/-------------------- ST_RPAREN --------------------\/-------------------- //
                case Language.ST_RPAREN :
                    System.out.println("Entering ST_RPAREN");
                    detectedToken = Language.TOK_RS_RPAREN;
                    currentLexeme += currentChar;
                    detectedLexeme = currentLexeme;
                    System.out.println("State Reset by ST_RPAREN - found a RPAREN");
                    resetStateAndStopSearching();
                break;
            // --------------------/\-------------------- ST_RPAREN --------------------/\-------------------- //
                // --------------------\/-------------------- DEFAULT --------------------\/-------------------- //
                default:
                    System.out.println("State Reset by default case");
                    resetStateAndStopSearching();
                    break;
                // --------------------/\-------------------- DEFAULT --------------------/\-------------------- //
            }
        }        

        /*
            Use switch case statements combined with finite automaton to
            implement the token detection. Use JFLAP for the automaton, 
            and simply take each state and use it as a case, then in that
            case, set the next state and repeat until failure.
        */
        System.out.println("CURRENT LEXEME: "+currentLexeme);
        if (!detectedLexeme.equals("")) {
            System.out.println("RETURNED A LEXEME: " + detectedLexeme + " on line "+lineCounter);
        }
        return detectedLexeme;


        // Match symbol = new Match("","");
        // matches.add(symbol);
        // return symbol.toString();
    }

    public boolean isReady() {
        return hasSymbols;
    }

    public String getDetectedToken() {
        return detectedToken;
    }
    public String getDetectedLexeme() {
        return detectedLexeme;
    }
    public void resetStateAndStopSearching() {
        state = Language.ST_START;
        stopSearching();
    }
    public void resetState() {
        System.out.println("STATE RESET from resetState()");
        state = Language.ST_START;
    }
    public void stopSearching() {
        stopSearching = true;
    }
}