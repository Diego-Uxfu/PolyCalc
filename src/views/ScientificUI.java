package views;

import javax.swing.*;
import java.awt.*;

import controllers.ButtonListener;

public class ScientificUI implements UserInterface {
    @Override
    public JPanel getButtonPanel(StringBuilder input, JTextField display){
        JPanel buttonPanel = new JPanel(new GridLayout(5,5,5,5));

        String[] buttonLabels = {
                "x^-1", "(", ")", "/",
                "7",    "8", "9", "*", // 7, 8, 9, multiplication
                "4",    "5", "6", "-", // 4, 5, 6, subtract
                "1",    "2", "3", "+", // 1, 2, 3, addition
                "t",    "0", ".", "=" // tbd, 0, decimal, equal

        };
        for(String label: buttonLabels){ // shorthand for loop
            JButton button = new JButton(label); // create button
            button.setFont(new Font("Arial", Font.PLAIN, 12)); // making font
            button.addActionListener(new ButtonListener(input, display)); // creating action listener per button
            buttonPanel.add(button); // adding button to panel
        }
        return buttonPanel;
    }


}
