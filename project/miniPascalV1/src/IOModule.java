import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class IOModule {
    
    private String programText = "";

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
    }

    public String getProgramText() {
        return programText;
    }

}