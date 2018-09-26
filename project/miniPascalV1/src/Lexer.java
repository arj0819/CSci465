import java.util.regex.*;

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
                stopSearching = true;
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

            switch (state) {
                case Language.ST_COLON : 
                // System.out.println("HELLO from case 0");
                    if (currentChar.matches(Language.REGEX_RS_COLON)) {
                        detectedToken = Language.TOK_RS_COLON;
                        currentLexeme += currentChar;
                        detectedLexeme = currentLexeme;
                        lookAheadCounter++;
                        currentLexeme += Character.toString(programText.charAt(lookAheadCounter));
                        state = Language.ST_COLON_EQUALS;
                    } else {
                        stopSearching = true;
                        break;
                    }
                case Language.ST_COLON_EQUALS:
                // System.out.println("HELLO from case 1");
                    if (currentLexeme.matches(Language.REGEX_RS_ASSIGN)) {
                        detectedToken = Language.TOK_RS_ASSIGN;
                        detectedLexeme = currentLexeme;
                        programCounter = lookAheadCounter;

                        state = 0;
                        stopSearching = true;
                        break;
                    } else {
                        state = 0;
                        stopSearching = true;
                        break;
                    }
                default:
                    state = 0;
                    stopSearching = true;
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

}