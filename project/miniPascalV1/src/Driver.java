public class Driver {

    private static String fileName = "";

    public static void main(String[] args) {

        try {
            fileName = args[0];
        } catch (Exception e) {
            System.err.println("Incorrect args provided.\nPlease provide a Pascal file to use with this program.");
            System.exit(1);
        }

        IOModule io = new IOModule(fileName);
        Lexer lexer = new Lexer(io.getProgramText());

        try {
            while (lexer.isReady()) {
                String symbol = lexer.getsym();
                if (!"".equals(symbol)) {// && !Language.TOK_LP_COMMENT.equals(lexer.getDetectedToken())
                    io.addMatch(new Match(lexer.getDetectedToken(),symbol));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        io.printMatches();

    }

}