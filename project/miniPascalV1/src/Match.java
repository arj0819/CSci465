public class Match {

    private String lexeme = "";
    private String token = "";

    public Match (String lexeme, String token) {
        this.lexeme = lexeme;
        this.token = token;
    }

    @Override
    public String toString() {
        String str = "%-20s %-20s";
        str = String.format(
            str,
            lexeme,
            token
        );
        return str;
    }

}