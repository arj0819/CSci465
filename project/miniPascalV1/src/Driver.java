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
        
        Match match1 = new Match(Definitions.ASSIGN,":=");
        System.out.println(match1);
        Match match2 = new Match(Definitions.AND,"and");
        System.out.println(match2);
        Match match3 = new Match(Definitions.BEGIN,"begin");
        System.out.println(match3);
        Match match4 = new Match(Definitions.FUNCTION,"function");
        System.out.println(match4);
        Match match5 = new Match(Definitions.SEMICOLON,";");
        System.out.println(match5);


    }

}