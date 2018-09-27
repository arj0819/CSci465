public class Match {

    // A Match consists of a token and a lexeme,
    // along with a matchID in case we need to 
    // identify matches later in the project.
    // The Match Class has a static int field
    // to keep track of the totalMatches created.
    private static int totalMatches = 0;
    private int matchID = 0;
    private String lexeme = "";
    private String token = "";

    // Constructor assigns the token and lexeme,
    // and gives this instance a matchID while
    // incrementing the totalMatches.
    public Match (String token, String lexeme) {
        this.lexeme = lexeme;
        this.token = token;
        this.matchID = ++totalMatches;
    }

    // Match overrides toString for 
    // convenient printout.
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