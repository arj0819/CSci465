public class Match {

    private static int totalMatches = 0;
    private int matchID = 0;
    private String lexeme = "";
    private String token = "";

    public Match (String token, String lexeme) {
        this.lexeme = lexeme;
        this.token = token;
        this.matchID = ++totalMatches;
    }

    @Override
    public String toString() {
        String str = "%-20s %-20s";
        str = String.format(
            str,
            token,
            lexeme
        );
        return str;
    }

}