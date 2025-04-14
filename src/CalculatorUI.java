import javax.swing.*;

public interface CalculatorUI {
    /*
    @param input  StringBuilder that holds the users inputs
    @param display  a display that displays input
    @return  a panel the holds the button layout of sepcified calculator
     */
    JPanel getButtonPanel(StringBuilder input, JTextField display);


    CalculatorType getCalculatorLogic();
}
