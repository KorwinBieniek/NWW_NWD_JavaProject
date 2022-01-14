/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * @author Korwin Bieniek
 * * @version 1.0.0
 */
public class NWW {
    private int multiplyValue;

    /**
     * @return multiply value
     */
    public int getMultiplyValue() {
        return multiplyValue;
    }

    /**
     * @param multiplyValue - the value that is going to be multiplied
     */
    public void setMultiplyValue(int multiplyValue) {
        this.multiplyValue = multiplyValue;
    }

    /**
     * @param arrOfElements - the array of values that the least common multiplier will be calculated on
     * @return least common multiplier of a list of values
     */
    public int leastCommonMultiplier(int firstLength, int secondLength, ArrayList<Integer> arrOfElements) throws NegativeValuesException, NotEnoughArgumentsException {
        int lcmOfArrayElement = 1;
        int divisor = 2;

        if (firstLength > secondLength || firstLength < secondLength) {
            throw new NotEnoughArgumentsException("There should be " + firstLength + " arguments and " + secondLength + " were passed");
        }

        while (true) {
            int counter = 0;
            boolean isDivisible = false;

            for (int i = 0; i < arrOfElements.size(); i++) {
                if (arrOfElements.get(i) < 0) {
                    throw new NegativeValuesException("No negative are allowed");
                }
                if (arrOfElements.get(i) == 0) {
                    return 0;
                } //else if (arrOfElements.get(i) < 0) {
                //arrOfElements.set(i, arrOfElements.get(i) * -1);
                //}
                if (arrOfElements.get(i) == 1) {
                    counter++;
                }

                if (arrOfElements.get(i) % divisor == 0) {
                    isDivisible = true;
                    arrOfElements.set(i, arrOfElements.get(i) / divisor);
                }
            }

            if (isDivisible) {
                lcmOfArrayElement = lcmOfArrayElement * divisor;
            } else {
                divisor++;
            }
            if (counter == arrOfElements.size()) {
                return lcmOfArrayElement;
            }
        }
    }
}
