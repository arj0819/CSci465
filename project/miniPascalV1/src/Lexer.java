import java.util.regex.*;
import java.util.Stack;

public class Lexer {

    private String currentLexeme = "";
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

            // Set the lookAheadCounter = to the programCounter so we 
            // know where to start looking ahead from if necessary.
            lookAheadCounter = programCounter;

            // Set the currentChar to the char in the programText
            // currently pointed to by the programCounter
            String currentChar = Character.toString(programText.charAt(programCounter));

            // Example of how an exception may be thrown to be handled by the Driver
            // if (programCounter == 150) {
            //     throw new Exception("There was an erroneous token discovered on line "+lineCounter);
            // }

            // If we found a newline, increment the lineCounter
            if (currentChar.matches(Language.REGEX_NEWLINE)) {
                lineCounter++;
            }

            System.out.println("CURRENT STATE: "+state);
            switch (state) {
                case Language.ST_COLON : 
                    System.out.println("HELLO from Language.ST_COLON");
                    if (currentChar.matches(Language.REGEX_RS_COLON)) {
                        detectedToken = Language.TOK_RS_COLON;
                        currentLexeme += currentChar;
                        detectedLexeme = currentLexeme;
                        lookAheadCounter++;
                        currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                        state = Language.ST_COLON_EQUALS;
                        break;
                    } else {
                        state = Language.ST_LCRLYBRK;
                        break;
                    }
                case Language.ST_COLON_EQUALS :
                    System.out.println("HELLO from Language.ST_COLON_EQUALS");
                    if (currentLexeme.matches(Language.REGEX_RS_ASSIGN)) {
                        detectedToken = Language.TOK_RS_ASSIGN;
                        detectedLexeme = currentLexeme;
                        programCounter = lookAheadCounter;

                        System.out.println("State Reset by ST_COLON_EQUALS in the if");
                        resetStateAndStopSearching();
                        break;
                    } else {
                        System.out.println("State Reset by ST_COLON_EQUALS in the else");
                        resetStateAndStopSearching();
                        break;
                    }
                case Language.ST_LCRLYBRK :
                    System.out.println("HELLO from Language.ST_LCRLYBRK");
                    if (currentChar.matches(Language.REGEX_RS_LCRLYBRACK)) {
                        detectedToken = Language.TOK_LP_COMMENT;
                        currentLexeme += currentChar;
                        detectedLexeme = currentLexeme;
                        lookAheadCounter++;
                        currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                        state = Language.ST_LCRLYBRK_IGNOREALL;
                        break;
                    } else {
                        System.out.println("State Reset by ST_LCRLYBRK in the else");
                        resetStateAndStopSearching();
                        break;
                    }
                case Language.ST_LCRLYBRK_IGNOREALL :
                    System.out.println("HELLO from Language.ST_LCRLYBRK_IGNOREALL");
                    if (currentLexeme.matches(Language.REGEX_PT_COMMENT)) {
                        detectedLexeme = currentLexeme;
                        programCounter = lookAheadCounter;

                        System.out.println("State Reset by ST_LCRLYBRK_IGNOREALL in the if");
                        resetStateAndStopSearching();
                        break;
                    } else {
                        lookAheadCounter++;
                        currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                        break;
                    }
                default:
                    System.out.println("State Reset by DEFAULT CASE");
                    resetStateAndStopSearching();
                    break;
            }
            programCounter++;
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
        state=0;
        stopSearching();
    }
    public void resetState() {
        System.out.println("STATE RESET from resetState()");
        state=0;
    }
    public void stopSearching() {
        stopSearching = true;
    }
}