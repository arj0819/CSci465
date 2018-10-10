import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.List;
import java.util.ArrayList;


public class HW1 {

    public static void main(String[] args) {

        // Try to construct and read from the input file.
        try {
            String fileName = args[0];
            File txtInput = new File(fileName);
            BufferedReader rdr = new BufferedReader(new FileReader(txtInput));
            String currentLine = "";

            while (rdr.ready()) {
                currentLine = rdr.readLine();
                String[] tokens = currentLine.split(" ");
                // System.out.println(currentLine);

                for (int i = 0; i < tokens.length; i++) {
                    System.out.println(tokens[i]);
                }
            }
            rdr.close();
            // System.out.println(programText);
        } catch (Exception e) {
            System.err.println("There was a problem reading the file.");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

}