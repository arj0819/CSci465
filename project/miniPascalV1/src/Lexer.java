import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;

public class Lexer {
    
    // private Rules pascalLanguageRules = new Rules();

    private List<Match> matches = new ArrayList<Match>();

    private String currentLexeme = "";
    private String programText = "";
    private int programCounter = 0;
    private int programSize = 0;

    public Lexer (String programText) {
        this.programText = programText;
        this.programSize = programText.length()-1;
    }

    // public String getsym() {
    public void getsym() {

        while (programCounter <= programSize) {
            System.out.println(programText.charAt(programCounter));
            programCounter++;
        }        



        // Match symbol = new Match("","");
        // matches.add(symbol);
        // return symbol.toString();
    }

}