package view;

import javax.swing.*;

import java.awt.*;

/**
 * @author Korwin Bieniek
 * @version 1.0.0
 * <p>
 * The exceptions for the GUI are stored here.
 */
public class GuiExceptions {

    Container container = GraphicalUserInterface.getContainer();


    public void showNumberFormatWarning() {
        JOptionPane.showMessageDialog(container,
                "The values entered aren't correct.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void showNotEnoughArgumentsWarning() {
        JOptionPane.showMessageDialog(container,
                "Not enough or too many arguments provided.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void showNegativeArgumentsWarning() {
        JOptionPane.showMessageDialog(container,
                "Negative arguments provided.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void showLengthLessThanZeroWarning() {
        JOptionPane.showMessageDialog(container,
                "Arguments length is less than 0",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void nonArgumentsWarning() {
        JOptionPane.showMessageDialog(container,
                "No start parameters used",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
