/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import model.NWD;
import model.NWW;
import view.ResultView;
import model.NotEnoughArgumentsException;

import java.util.ArrayList;

/**
 * @author SuperStudent
 *
 * First parameter is the length of the list and next parameters are the values.
 * The number of values provided has to be equal to the length, otherwise an exception will be thrown.
 */
public class Main {
    /**
     * @param args
     * @throws NotEnoughArgumentsException
     */
    public static void main(String[] args) throws NotEnoughArgumentsException {
        NWD NWDmodel = new NWD();
        NWW NWWmodel = new NWW();
        ResultView view = new ResultView();
        Controller controller = new Controller(NWDmodel, NWWmodel, view);
        ArrayList<Integer> values = new ArrayList<>();
        int listLength = Integer.parseInt(args[0]);
        controller.throwNotEnoughArgumentException(listLength, args.length - 1);
        for (int i = 1; i <= listLength; i++) {
            values.add(Integer.parseInt(args[i]));
        }
        view.printValue(NWDmodel.greatestCommonDivisorForArray(values), NWWmodel.leastCommonMultiplier(values));
    }
}
