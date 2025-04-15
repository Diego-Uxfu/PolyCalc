import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class ButtonListener implements ActionListener {
    final private JTextField display;
    private CalculatorType calculator;
    private StringBuilder input;

    /*
    ButtonListener constructor
     */
    public ButtonListener(StringBuilder input, JTextField display, CalculatorType calculator) {
        this.display = display;
        this.input = input;
        this.calculator = calculator;
    }

    /*
    @method actionPerformed will handle receiving the input from button presses
    using switch cases, this method will focus on simple arithmetic ops
    more advanced ops, i.e. derivative, integration, will be handled else where
     */
    @Override
    public void actionPerformed(ActionEvent e){
        String buttonText = ((JButton)e.getSource()).getText(); // retrieves input from the button

        switch (buttonText) {
            case "C": // clear
                input.setLength(0);
                display.setText("");
                break;

            case "D": // backspace
                if(input.length() > 0) {
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

            default: // simply adds the numbers
                if(buttonText.equals(".")){
                    if(!canAddDecimal(input)){
                        return;
                    }
                }
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

    /*
    canAddDecimal is helper method that will determine if a decimal can be added in the specific placement
     */
    private boolean canAddDecimal(StringBuilder input){
        int i = input.length() - 1; // used to traverse the input backwards

        while(i >= 0 && !isOperator(input.charAt(i))){ // if not empty and is not op,
            if(input.charAt(i) == '.'){ // checks if there is already a decimal
                return false; // cannot add decimal
            }
            i--; // decrement
        }
        return true; // else return true
    }

    private boolean negativeSwitch(char c){
        int i = input.length() - 1;
        return true;
    }
}
