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
 * @version 1.2.0
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
     * First parameter is the length of the list and next parameters are the values.
     * The number of values provided has to be equal to the length, otherwise an exception will be thrown.
     * For example: 4 5 4 3 2 -> it is correct, the length is args[0] so 4, and 5 4 3 2 are the values
     * 3 6 5 -> throws exception, the length is 3 and only 2 values were provided
     * 3 6 5 4 3 -> throws exception, the length is 3 and 4 values were provided
     * No arguments can be passed or 0 arguments can be passed.
     *
     * @param args - command line arguments, where the first one dictates the number of values that will be input and the next numbers are the values.
     */

    public static void main(String[] args) {
        GuiExceptions warnings = new GuiExceptions();
        boolean negativeValuesFlag = false;
        boolean zeroLengthFlag = false;
        boolean notEnoughArguments = false;
        ArrayList<Integer> values = new ArrayList<>();
        int listLength = 0;

        try {
            listLength = Integer.parseInt(args[0]);
            if (listLength < 0) {
                zeroLengthFlag = true;
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            warnings.nonArgumentsWarning();
        }
        if (listLength != 0 && listLength != args.length - 1) {
            notEnoughArguments = true;
        }
        try {

            for (int i = 1; i <= listLength; i++) {
                if (Integer.parseInt(args[i]) < 0) {
                    negativeValuesFlag = true;
                }
                values.add(Integer.parseInt(args[i]));
            }
            if (negativeValuesFlag) {
                warnings.showNegativeArgumentsWarning();
            } else if (zeroLengthFlag) {
                warnings.showLengthLessThanZeroWarning();
            } else if (notEnoughArguments) {
                warnings.showNotEnoughArgumentsWarning();
            } else {
                GraphicalUserInterface application = new GraphicalUserInterface(values, listLength);
                application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            warnings.showNotEnoughArgumentsWarning();
        }


    }
}
