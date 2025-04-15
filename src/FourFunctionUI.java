import javax.swing.*;
import java.awt.*;

public class FourFunctionUI implements CalculatorUI{
    private final CalculatorType calculatorLogic = new FourFunctionCalculator();

    @Override
    public CalculatorType getCalculatorLogic(){
        return calculatorLogic;
    }
    
    @Override
    public JPanel getButtonPanel(StringBuilder input, JTextField display){
        JPanel buttonPanel = new JPanel(new GridLayout(5,4,10,10));
        String[] buttonLabels= {
                "C", "t", "t", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "t", "0", ".", "="
        };

        for(String label: buttonLabels){
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.addActionListener(new ButtonListener(input, display, calculatorLogic));
            buttonPanel.add(button);
        }
        return buttonPanel;
    }
}
