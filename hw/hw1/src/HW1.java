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
                // read current line, split tokens on the space between them
                currentLine = rdr.readLine();
                String[] tokens = currentLine.split(" ");
                System.out.println("Infix:\n"+currentLine+"\nPostfix:");

                // for each token on this line...
                for (int i = 0; i < tokens.length; i++) {
                    // if it's an operand, simply print it out
                    if(tokens[i].matches("\\d+")) {
                        System.out.print(tokens[i]+" ");
                    } 
                    // else, it must be an operator. If the stack is empty, push the operator
                    else if (operatorStack.isEmpty()) {
                        operatorStack.push(tokens[i]);
                    } 
                    // else, the top operator on the stack is of lowest precedence, simply push current 
                    // operator on top of it. this takes care of operator precedence and associative properties
                    else if (operatorStack.peek().matches(PLUS) || operatorStack.peek().matches(MINUS)) {
                        operatorStack.push(tokens[i]);
                    } 
                    // else, current operator is of lowest precedence, so we pop the top operator
                    // and print, then reevaluate the current operator (which is why we decrement i)
                    else {
                        System.out.print(operatorStack.pop()+" ");
                        i--;
                    }

                    // if we ran out of tokens, we need to pop and print all operators remaining in the stack
                    if (i == tokens.length-1) {
                        while (!operatorStack.isEmpty()) {
                            System.out.print(operatorStack.pop()+" ");
                        }
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