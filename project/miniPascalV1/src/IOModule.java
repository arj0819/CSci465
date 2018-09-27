import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

/*
    IOModule uses the following importd:
    BufferedReader - used to read the input file
    FileReader - used to construct an object readable by BufferedReaader
    File - used to construct an object for the actual input file
    List - used to generically loop through Matches ArrayList
    ArrayList - used to create an ArrayList of Matches
*/

public class IOModule {
    
    // The IOModule has programText, which is built as
    // the input file is read in, and matches, which is
    // a list to contain all symbol matches found by the
    // Lexer.

    private String programText = "";
    private List<Match> matches = new ArrayList<Match>();

    public IOModule(String fileName) {

        // Try to construct and read from the input file.
        try {
            File pascalInput = new File(fileName);
            BufferedReader rdr = new BufferedReader(new FileReader(pascalInput));
            String currentLine = "";

            while (rdr.ready()) {
                currentLine = rdr.readLine();
                programText += currentLine+"\n";
            }
            programText = programText.trim();
            rdr.close();
            // System.out.println(programText);
        } catch (Exception e) {
            System.err.println("There was a problem reading the file.");
            System.err.println(e.getMessage());
            System.exit(1);
        }

        // These are adding dummy Matches to the matches 
        // list to provide better output formatting, that all!
        this.addMatch(new Match("TOKEN","LEXEME"));
        this.addMatch(new Match("",""));
    }

    // Returns the programText read from the input file
    public String getProgramText() {
        return programText;
    }

    // Adds a symbol match to the matches list
    public void addMatch(Match newMatch) {
        matches.add(newMatch);
    }

    // Prints out all matches in the matches list
    public void printMatches() {
        System.out.println();
        for (Match m : matches) {
            System.out.println(m);
        }
    }
}