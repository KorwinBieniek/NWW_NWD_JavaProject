/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import view.GraphicalUserInterface;
import view.GuiExceptions;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Korwin Bieniek
 * @version 1.1.2
 */
public class Controller {
    private final NWD nwdModel;
    private final NWW nwwModel;

    /**
     * @param nwdModel - the instance of an nwdModel object from NWD class
     * @param nwwModel - the instance of an nwwModel object from NWW class
     */
    public Controller(NWD nwdModel, NWW nwwModel) {
        this.nwdModel = nwdModel;
        this.nwwModel = nwwModel;
    }

    public void setNWDValue(int value) {
        nwdModel.setDivisorValue(value);
    }

    /**
     * @return the divisor value
     */
    public int getNWDValue() {
        return nwdModel.getDivisorValue();
    }

    public void setNWWValue(int value) {
        nwwModel.setMultiplyValue(value);
    }

    /**
     * @return the multiply value
     */
    public int getNWWValue() {
        return nwwModel.getMultiplyValue();
    }

    /**
     * @param firstLength  - the default number of values
     * @param secondLength - the actual number of values
     * @throws NotEnoughArgumentsException - the exception will be thrown when the length of the command line arguments will be incorrect
     */

    /**
     * @author Korwin Bieniek
     * @version 3.0.0
     *
     * First parameter is the length of the list and next parameters are the values.
     * The number of values provided has to be equal to the length, otherwise an exception will be thrown.
     */
    /**
     * @param args - command line arguments, where the first one dictates the number of values that will be input and the next numbers are the values.
     * @throws NotEnoughArgumentsException - custom made exception to catch, whether there are not enough or too many command line arguments.
     */
    public static ArrayList<Integer> values = new ArrayList<>();
    public static int listLength;

    public static void main(String[] args) {
        GuiExceptions exceptions = new GuiExceptions();
        try {
            listLength = Integer.parseInt(args[0]);
            if (listLength < 0) {
                exceptions.showLengthLessThanZeroException();
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            exceptions.nonArgumentsException();
        }

        try {
            for (int i = 1; i <= listLength; i++) {
                if (Integer.parseInt(args[i]) < 0) {
                    exceptions.showNegativeArgumentsException();
                }
                values.add(Integer.parseInt(args[i]));
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            exceptions.showNotEnoughArgumentsException();
        }

        GraphicalUserInterface application = new GraphicalUserInterface();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
