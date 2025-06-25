package models.ff;

import controllers.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class FFUi {

    public JPanel getButtonPanel(StringBuilder input, JTextField display){
        JPanel buttonPanel = new JPanel(new GridLayout(5,4,10,10));
        String[] buttonLabels= {
                "C", "D", "+/-", "/", // clear, delete, negative, division
                "7", "8", "9", "*", // 7, 8, 9, multiplication
                "4", "5", "6", "-", // 4, 5, 6, subtract
                "1", "2", "3", "+", // 1, 2, 3, addition
                "t", "0", ".", "=" // tbd, 0, decimal, equal
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
