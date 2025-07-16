import views.FourFunctionUi;
import views.scientificUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Framework {
    private StringBuilder input;
    private JTextField display;
    private JPanel buttonPanel;
    private FourFunctionUi defaultUI;
    private scientificUI scienceUI;

    public Framework() {
        JFrame frame = new JFrame();
        JMenuBar menuBar = new JMenuBar();
        buttonPanel = new JPanel(); // panel, exists within the frame, holds buttons

        frame.setSize(400, 500);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5,5)); // borderlayout creates sections

        input = new StringBuilder();
        display = new JTextField();
        display.setFont(new Font("Serif", Font.PLAIN, 40));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT); //align text
        frame.add(display, BorderLayout.NORTH);

        JMenu calculatorMenu = new JMenu("Calculators"); // creating obj
        JMenu historyMenu = new JMenu("History");
        menuBar.add(calculatorMenu); // adding ^ into the menu bar
        menuBar.add(historyMenu);

        JMenuItem fourFunctionCalculator = new JMenuItem("Four Function");
        JMenuItem scientificCalculator = new JMenuItem("Scientific");
        JMenuItem Calculus = new JMenuItem("Calculus");
        JMenuItem LinearAlgebraCalculator = new JMenuItem("Linear Algebra");

        JMenuItem fourFunctionHistory = new JMenuItem("Four Function History");
        JMenuItem scientificHistory = new JMenuItem("Scientific History");
        JMenuItem calculusHistory = new JMenuItem("Calculus History");
        JMenuItem linearAlgebraHistory = new JMenuItem("Linear Algebra History");

         /*
        adds the options into the drop-down menu of the ui
         */
        calculatorMenu.add(fourFunctionCalculator);
        calculatorMenu.add(new JSeparator());
        calculatorMenu.add(scientificCalculator);
        calculatorMenu.add(new JSeparator());
        calculatorMenu.add(Calculus);
        calculatorMenu.add(new JSeparator());
        calculatorMenu.add(LinearAlgebraCalculator);
        calculatorMenu.add(new JSeparator());

        historyMenu.add(fourFunctionHistory);
        historyMenu.add(new JSeparator());
        historyMenu.add(scientificHistory);
        historyMenu.add(new JSeparator());
        historyMenu.add(calculusHistory);
        historyMenu.add(new JSeparator());
        historyMenu.add(linearAlgebraHistory);

        defaultUI = new FourFunctionUi(); // calling the 4func ui
        buttonPanel = defaultUI.getButtonPanel(input, display); // retrieving the button panel for 4func
        frame.add(buttonPanel, BorderLayout.CENTER); // adding panel to the frame

        frame.setVisible(true);
        frame.setJMenuBar(menuBar);
    }
}
