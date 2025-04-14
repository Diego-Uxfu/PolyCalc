import javax.swing.*;
import java.awt.*;

public class Calculator{
    private StringBuilder input;
    private JTextField display;


    public Calculator(){
        // creates frame, visibility, size, title, and exitonclose
        JFrame frame = new JFrame(); // creates the frame
        JMenuBar menuBar = new JMenuBar(); // creates a menu bar
        JPanel buttonPanel = new JPanel(); // panel, lays ontop of the frame, allows for buttons

        frame.setSize(300, 500);
        frame.setTitle("PolyCalc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5 , 5)); // creating a BL to create sections

        JMenu calculatorMenu = new JMenu("Calculators"); // creating obj
        menuBar.add(calculatorMenu); // adding ^ into the menu bar

        JMenuItem fourFunctionCalculator = new JMenuItem("Four Function"); // allows options dropdown
        JMenuItem scientificCalculator = new JMenuItem("Scientific");
        JMenuItem Calculus = new JMenuItem("Calculus");
        JMenuItem LinearAlgebraCalculator = new JMenuItem("Linear Algebra");

        calculatorMenu.add(fourFunctionCalculator); // adding the option
        calculatorMenu.add(new JSeparator());
        calculatorMenu.add(scientificCalculator);
        calculatorMenu.add(new JSeparator());
        calculatorMenu.add(Calculus);
        calculatorMenu.add(new JSeparator());
        calculatorMenu.add(LinearAlgebraCalculator);
        calculatorMenu.add(new JSeparator());


        buttonPanel.setLayout(new GridLayout(4,4,10,10));
        frame.add(buttonPanel, BorderLayout.CENTER); // button panel in the center of the panel, always remain center

        frame.setVisible(true);
        frame.setJMenuBar(menuBar); // essentially ^ for menu bar
    }
}
