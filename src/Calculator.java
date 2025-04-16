import javax.swing.*;
import java.awt.*;

public class Calculator{
    private StringBuilder input;
    private JTextField display;
    private CalculatorUI currentUI;
    private JPanel buttonPanel;

    public Calculator(){
        // creates frame, visibility, size, title, and exitonclose
        JFrame frame = new JFrame(); // creates the frame
        JMenuBar menuBar = new JMenuBar(); // creates a menu bar
        JPanel buttonPanel = new JPanel(); // panel, lays ontop of the frame, allows for buttons

        /*
        fram foundation, size title, close op
         */
        frame.setSize(400, 500);
        frame.setTitle("PolyCalc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5 , 5)); // creating a BL to create sections

        /*
        instantiates input, display, and display details
         */
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

        /*
        creating menu items to insert into drop-down menu
         */
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

        currentUI = new FourFunctionUI(); // calling the 4func ui
        buttonPanel = currentUI.getButtonPanel(input, display); // retrieving the button panel for 4func
        frame.add(buttonPanel, BorderLayout.CENTER); // adding panel to the frame

        frame.setVisible(true);
        frame.setJMenuBar(menuBar); // essentially ^ for menu bar
    }
}
