package model;

import javax.swing.*;
import view.GraphicalUserInterface;

import java.awt.*;

public class GuiExceptions {

    Container container = GraphicalUserInterface.getContainer();
    public void showNumberFormatExceptionDialog() {
        JOptionPane.showMessageDialog(container,
                "The values entered aren't correct.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void showNotEnoughArgumentsException() {
        JOptionPane.showMessageDialog(container,
                "Not enough or too many arguments provided.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
