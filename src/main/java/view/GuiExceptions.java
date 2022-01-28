package view;

import javax.swing.*;

import view.GraphicalUserInterface;

import java.awt.*;

public class GuiExceptions {

    Container container = GraphicalUserInterface.getContainer();

    /**
     * @author Korwin Bieniek
     * @version 1.0.0
     * <p>
     * The exceptions for the GUI are stored here.
     */
    public void showNumberFormatExceptionDialog() {
        JOptionPane.showMessageDialog(container,
                "The values entered aren't correct.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void showNotEnoughArgumentsException() {
        JOptionPane.showMessageDialog(container,
                "Not enough or too many arguments provided. Please restart the application and provide correct amount of arguments",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void showNegativeArgumentsException() {
        JOptionPane.showMessageDialog(container,
                "Negative arguments provided.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void showLengthLessThanZeroException() {
        JOptionPane.showMessageDialog(container,
                "Arguments length is less than 0",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void nonArgumentsException() {
        JOptionPane.showMessageDialog(container,
                "No start parameters used",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
