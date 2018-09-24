import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class IOModule {
    
    private String programListing = "";

    public IOModule(String fileName) {

        try {
            File pascalInput = new File(fileName);
            BufferedReader rdr = new BufferedReader(new FileReader(pascalInput));
            String currentLine = "";

            while (rdr.ready()) {
                currentLine = rdr.readLine();
                programListing += currentLine+"\n";
            }
            programListing = programListing.trim();
            System.out.println(programListing);
            // totalSimTime = Integer.parseInt(currentLine);

            // String[] tokens = rdr.readLine().split(" ");
            // int numServers = Integer.parseInt(tokens[0]);
            // double probOfTransfer = Double.parseDouble(tokens[3]);
            // double serviceMean = Double.parseDouble(tokens[2]);
            // double interArrivalMean = Double.parseDouble(tokens[1]);
            // CareArea triage = new Triage (numServers,probOfTransfer,serviceMean,interArrivalMean);

            // emergencyDept.put(CareArea.TRIAGE, triage);
            // transferProbabilities.put(CareArea.TRIAGE, probOfTransfer);

            // tokens = rdr.readLine().split(" ");
            // numServers = Integer.parseInt(tokens[0]);
            // probOfTransfer = Double.parseDouble(tokens[2]);
            // serviceMean = Double.parseDouble(tokens[1]);
            // CareArea trauma = new Trauma (numServers,probOfTransfer,serviceMean);

            // emergencyDept.put(CareArea.TRAUMA, trauma);
            // transferProbabilities.put(CareArea.TRAUMA, probOfTransfer);

            // tokens = rdr.readLine().split(" ");
            // numServers = Integer.parseInt(tokens[0]);
            // probOfTransfer = Double.parseDouble(tokens[2]);
            // serviceMean = Double.parseDouble(tokens[1]);
            // CareArea acute = new Acute (numServers,probOfTransfer,serviceMean);

            // emergencyDept.put(CareArea.ACUTE, acute);
            // transferProbabilities.put(CareArea.ACUTE, probOfTransfer);

            // tokens = rdr.readLine().split(" ");
            // numServers = Integer.parseInt(tokens[0]);
            // probOfTransfer = Double.parseDouble(tokens[2]);
            // serviceMean = Double.parseDouble(tokens[1]);
            // CareArea prompt = new Prompt (numServers,probOfTransfer,serviceMean);

            // emergencyDept.put(CareArea.PROMPT, prompt);
            // transferProbabilities.put(CareArea.PROMPT, probOfTransfer);

            rdr.close();

        } catch (Exception e) {
            System.err.println("There was a problem reading the file.");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

}