import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class ButtonListener implements ActionListener {
    private JTextField display;
    private StringBuilder input;

    public ButtonListener(StringBuilder input, JTextField display) {
        this.display = display;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String buttonText = ((JButton)e.getSource()).getText(); // retrieves input from the button

        switch (buttonText) {
            case "C":
                input.setLength(0);
                display.setText("");
                break;

            case "=":
                double result = evaluateExpression(input.toString());
                display.setText(String.valueOf(result));
                input.setLength(0);
                input.append(result);
                break;
            case "+": case "-": case "*": case "/":
                if(input.length() > 0 && isOperator(input.charAt(input.length() - 1))){
                    input.setCharAt(input.length() - 1, buttonText.charAt(0));
                }
                else if(input.length() > 0){
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

    private double evaluateExpression(String expression){
        Expression exp = new ExpressionBuilder(expression).build();
        return exp.evaluate();
    }

    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
