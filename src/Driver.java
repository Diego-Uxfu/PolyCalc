import javax.swing.*;
import java.awt.*;

public class Driver {
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Framework calc = new Framework();
    }
}
