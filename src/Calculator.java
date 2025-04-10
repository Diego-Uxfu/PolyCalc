import javax.swing.*;
import java.awt.*;

public class Calculator{
    private StringBuilder input;
    private JTextField display;

    
    public Calculator(){
        // creates frame, visibility, size, title, and exitonclose
        JFrame frame = new JFrame();

        frame.setSize(300, 500);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5 , 5)); // creating a BL to create sections

        // a panel to hold all buttons proposed
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4,10,10));
        frame.add(buttonPanel, BorderLayout.CENTER); // button panel in the center of the panel, always remain center

        // main panel will display the numbers and stuff yk
        input = new StringBuilder(); // will contain the input
        display = new JTextField(); // displays the string builder
        display.setFont(new Font("Serif", Font.PLAIN, 50)); // setting font output
        display.setEditable(false); // prevents direct typing
        frame.add(display, BorderLayout.NORTH); // display will always remain at the top

        String[] buttonLabels = { // array will be read and button for each char will be made
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for(String label : buttonLabels){ // creating button obj per string item
            JButton button = new JButton(label); // creating button obj
            button.setFont(new Font("Arial", Font.PLAIN, 35)); // setting font
            button.addActionListener(new ButtonListener(input, display)); // creating BL obj from other class
            buttonPanel.add(button); // adding th ebutton to the panel
        }

        frame.setVisible(true);
    }
}
