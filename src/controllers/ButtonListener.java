package controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/*
Next Steps:
fix the way the algorithm interprets +/-
    know when to make negative, and which
    know when and what to revert to positive

when a solution is given, and a digit is pressed,
it appends to the solution, fix to where it resets the display,
and then it appends the new digit
    note: think of how to determine a 'solution state'
    perhaps a true false switch?
 */

public class ButtonListener implements ActionListener {
    final private JTextField display;
    private StringBuilder input;

    public ButtonListener(StringBuilder input, JTextField display) {
        this.input = input;
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String buttonText = ((JButton) e.getSource()).getText(); // retrieves input from the button

        switch(buttonText){
            case "C": // clear
                input.setLength(0);
                display.setText("");
                break;

            case "D": // backspace
                if(!input.isEmpty()){
                    input.deleteCharAt(input.length() - 1);
                    display.setText(input.toString());
                }
                break;

            case "=":
                double result = evaluateExpression(input.toString()); // calls exp to return solution
                display.setText(String.valueOf(result)); // sets display to result
                input.setLength(0); // resets the input
                input.append(result); // appends the result to the input to allow for further ops on the answer
                break;

            case "+/-":
                if (input.isEmpty()){
                    break;
                }
                int startPosition = findVariableStart(input.toString());

                if(startPosition > 0 && input.charAt(startPosition - 1) == '-'){ // removes negative if already in place
                    input.deleteCharAt(startPosition - 1);
                    display.setText(input.toString());
                }
                else{
                    input.insert(startPosition, '-');
                    display.setText(input.toString());
                }
                break;

            case "+": case "-": case "*": case "/":
                /*
                checks the input, and calls helper @method isOp
                essentially prevents repeat operations
                 */
                if(!input.isEmpty() && isOperator(input.charAt(input.length() - 1))){
                    input.setCharAt(input.length() - 1, buttonText.charAt(0));
                }
                else if(!input.isEmpty()){
                    input.append(buttonText.charAt(0));
                }
                display.setText(input.toString());
                break;

            default:
                input.append(buttonText);
                display.setText(input.toString());
                break;
        }
    }

    /*
    using exp4j's api, @method evaluateExpression is called once '=' is used
     */
    private double evaluateExpression(String expression){
        Expression exp = new ExpressionBuilder(expression).build(); // creating exp obj
        return exp.evaluate(); // returning evaluation
    }

    /*
    @method isOperator determines if the input is any arithmetic opoeration, and returns
     */
    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int findVariableStart(String input){
        int i = input.length() - 1; // starts tracking at the latest input

        while(i >= 0 && !isOperator(input.charAt(i))){ // will continue to decrement until there's no operator
            i--;
        }
        return i + 1;
    }
}
