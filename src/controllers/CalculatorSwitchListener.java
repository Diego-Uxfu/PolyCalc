package controllers;

import views.UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class CalculatorSwitchListener implements ActionListener {
    private final UserInterface newUI;
    private final Consumer<UserInterface> switchHandler;

    public CalculatorSwitchListener(UserInterface newUI, Consumer<UserInterface> switchHandler) {
        this.newUI = newUI;
        this.switchHandler = switchHandler;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switchHandler.accept(newUI);
    }
}
