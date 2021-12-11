/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.NotEnoughArgumentsException;
import model.NWD;
import model.NWW;
import view.ResultView;

/**
 * @author SuperStudent
 */
public class Controller {
    private final NWD NWDModel;
    private final NWW NWWModel;
    private final ResultView view;

    /**
     * @param NWDmodel
     * @param NWWModel
     * @param view
     */
    public Controller(NWD NWDmodel, NWW NWWModel, ResultView view) {
        this.NWDModel = NWDmodel;
        this.NWWModel = NWWModel;
        this.view = view;
    }

    public void setNWDValue(int value) {
        NWDModel.setDivisorValue(value);
    }

    /**
     * @return
     */
    public int getNWDValue() {
        return NWDModel.getDivisorValue();
    }

    public void setNWWValue(int value) {
        NWWModel.setMultiplyValue(value);
    }

    /**
     * @return
     */
    public int getNWWValue() {
        return NWWModel.getMultiplyValue();
    }

    public void updateView() {
        view.printValue(NWDModel.getDivisorValue(), NWWModel.getMultiplyValue());
    }

    /**
     * @param firstLength
     * @param secondLength
     * @throws NotEnoughArgumentsException
     */
    public void throwNotEnoughArgumentException(int firstLength, int secondLength) throws NotEnoughArgumentsException {
        if (firstLength > secondLength || firstLength < secondLength) {
            throw new NotEnoughArgumentsException("There should be " + firstLength + " arguments and " + secondLength + " were passed");
        }
    }
}
