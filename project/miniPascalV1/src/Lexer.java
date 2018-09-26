import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;

public class Lexer {
    
    // private Rules pascalLanguageRules = new Rules();

    private List<Match> matches = new ArrayList<Match>();

    private String currentLexeme = "";
    private String programText = "";
    private String lexerReport = "";
    private int programCounter = 0;
    private int programSize = 0;
    private int lineCounter = 1;
    private boolean hasSymbols = true;

    public Lexer (String programText) {
        this.programText = programText;
        this.programSize = programText.length()-1;
    }

    // public String getsym() {
    public void getsym() throws Exception{
        while (programCounter <= programSize) {
            char currentChar = programText.charAt(programCounter);
            System.out.println(currentChar);

            if (programCounter == 150) {
                throw new Exception("There was an erroneous token discovered on line "+lineCounter);
            }

            if ("\n".equals(Character.toString(currentChar))) {
                lineCounter++;
            }
            programCounter++;
        }        

        hasSymbols = false;

        /*
            Use switch case statements combined with finite automaton to
            implement the token detection. Use JFLAP for the automaton, 
            and simply take each state and use it as a case, then in that
            case, set the next state and repeat until failure.
        */



        // Match symbol = new Match("","");
        // matches.add(symbol);
        // return symbol.toString();
    }

    public boolean isReady() {
        return hasSymbols;
    }

}