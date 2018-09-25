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

    }

}