import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class IOModule {
    
    private String programText = "";
    private List<Match> matches = new ArrayList<Match>();

    public IOModule(String fileName) {

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
            System.out.println(programText);
        } catch (Exception e) {
            System.err.println("There was a problem reading the file.");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        this.addMatch(new Match("TOKEN","LEXEME"));
        this.addMatch(new Match("",""));
    }

    public String getProgramText() {
        return programText;
    }

    public void addMatch(Match newMatch) {
        matches.add(newMatch);
    }

    public void printMatches() {
        System.out.println();
        for (Match m : matches) {
            System.out.println(m);
        }
    }

}