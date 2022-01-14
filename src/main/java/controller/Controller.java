/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.NegativeValuesException;
import model.NotEnoughArgumentsException;
import model.NWD;
import model.NWW;
import view.ResultView;

import java.util.ArrayList;

/**
 * @author Korwin Bieniek
 * @version 1.1.2
 */
public class Controller {
    private final NWD nwdModel;
    private final NWW nwwModel;
    private final ResultView view;

    /**
     * @param nwdModel - the instance of an nwdModel object from NWD class
     * @param nwwModel - the instance of an nwwModel object from NWW class
     * @param view     - the instance of a view class
     */
    public Controller(NWD nwdModel, NWW nwwModel, ResultView view) {
        this.nwdModel = nwdModel;
        this.nwwModel = nwwModel;
        this.view = view;
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

    public void updateView() {
        view.printValue(nwdModel.getDivisorValue(), nwwModel.getMultiplyValue());
    }

    /**
     * @param firstLength  - the default number of values
     * @param secondLength - the actual number of values
     * @throws NotEnoughArgumentsException - the exception will be thrown when the length of the command line arguments will be incorrect
     */

    /**
     * @author Korwin Bieniek
     * @version 2.0.1
     *
     * First parameter is the length of the list and next parameters are the values.
     * The number of values provided has to be equal to the length, otherwise an exception will be thrown.
     */
    /**
     * @param args - command line arguments, where the first one dictates the number of values that will be input and the next numbers are the values.
     * @throws NotEnoughArgumentsException - custom made exception to catch, whether there are not enough or too many command line arguments.
     */
    public static void main(String[] args) throws NotEnoughArgumentsException, NegativeValuesException {
        NWD nwdModel = new NWD();
        NWW nwwModel = new NWW();
        ResultView view = new ResultView();
        ArrayList<Integer> values = new ArrayList<>();
        int listLength = Integer.parseInt(args[0]);
        for (int i = 1; i <= listLength; i++) {
            values.add(Integer.parseInt(args[i]));
        }
        try {
            view.printValue(nwdModel.greatestCommonDivisorForArray(listLength, args.length - 1, values), nwwModel.leastCommonMultiplier(listLength, args.length - 1, values));
        } catch (NegativeValuesException e) {
            System.out.println("Negative values are not allowed");
        } catch (NotEnoughArgumentsException e) {
            System.out.println("The number of arguments is incorrect");
        }

    }
}
