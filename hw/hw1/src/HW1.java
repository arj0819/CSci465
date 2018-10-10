import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Stack;

/*
    Author: Aaron Johnson
    This program will translate arithmetic
    expressions in input.txt from infix
    notation to postfix notation.
*/

public class HW1 {

    public static final String MULT = "\\*";
    public static final String DIV  = "div";
    public static final String MOD  = "mod";
    public static final String PLUS = "\\+";
    public static final String MINUS = "-";

    public static Stack<String> operatorStack = new Stack<String>();
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
                System.out.println("Infix:\n"+currentLine+"\nPostfix:");

                for (int i = 0; i < tokens.length; i++) {
                    // System.out.println(tokens[i]);

                    if(tokens[i].matches("\\d+")) {
                        System.out.print(tokens[i]+" ");
                    }
                    if (operatorStack.isEmpty()) {
                        if (tokens[i].matches(MULT)) {
                            operatorStack.push(tokens[i]);
                        } else if (tokens[i].matches(DIV)) {
                            operatorStack.push(tokens[i]);
                        } else if (tokens[i].matches(MOD)) {
                            operatorStack.push(tokens[i]);
                        } else if (tokens[i].matches(PLUS)) {
                            operatorStack.push(tokens[i]);
                        } else if (tokens[i].matches(MINUS)) {
                            operatorStack.push(tokens[i]);
                        } else {
                            // System.out.print("Unrecognized operator");
                        }
                    } else if (operatorStack.peek().matches(PLUS) || operatorStack.peek().matches(MINUS)) {
                        if (tokens[i].matches(MULT)) {
                            operatorStack.push(tokens[i]);
                        } else if (tokens[i].matches(DIV)) {
                            operatorStack.push(tokens[i]);
                        } else if (tokens[i].matches(MOD)) {
                            operatorStack.push(tokens[i]);
                        } else if (tokens[i].matches(PLUS)) {
                            operatorStack.push(tokens[i]);
                        } else if (tokens[i].matches(MINUS)) {
                            operatorStack.push(tokens[i]);
                        } else {
                            // System.out.print("Unrecognized operator");
                        }
                    } else {
                        System.out.print(operatorStack.pop()+" ");
                    }
                    

                }
                System.out.println("\n");
            }
            rdr.close();
        } catch (Exception e) {
            System.err.println("There was a problem reading the file.");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

}