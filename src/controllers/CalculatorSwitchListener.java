package controllers;

import views.UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class CalculatorSwitchListener implements ActionListener {
    private final UserInterface newui;
    private final Consumer<UserInterface> switchHandler;

    public CalculatorSwitchListener(UserInterface newui, Consumer<UserInterface> switchHandler) {
        this.newui = newui;
        this.switchHandler = switchHandler;
    }


    @Override
    public void actionPerformed(ActionEvent e){
        switchHandler.accept(newui);
    }
}
