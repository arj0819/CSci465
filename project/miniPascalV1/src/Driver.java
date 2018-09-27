public class Driver {

    private static String fileName = "";

    public static void main(String[] args) {

        // Try to read in the file name from the command line
        try {
            fileName = args[0];
        } catch (Exception e) {
            System.err.println("Incorrect args provided.\nPlease provide a Pascal file to use with this program.");
            System.exit(1);
        }

        // Create a new IOModule and give it the file to read
        IOModule io = new IOModule(fileName);
        // Create a new Lexer and give it the programText read in by io
        Lexer lexer = new Lexer(io.getProgramText());

        // Try reading symbols from the Lexer
        try {
            // While the Lexer is ready to read symbols...
            while (lexer.isReady()) {
                // Get the next symbol from the Lexer
                String symbol = lexer.getsym();
                // If the Lexer didn't find anything, and if it didn't find a COMMENT
                if (!"".equals(symbol) && !Language.TOK_LP_COMMENT.equals(lexer.getDetectedToken())) {
                    // Add a new match to IOModule's matches List
                    io.addMatch(new Match(lexer.getDetectedToken(),symbol));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        // Print all the matches from IOModule
        io.printMatches();

    }

}