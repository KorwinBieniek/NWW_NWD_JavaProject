/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * Class to calculate NWW
 *
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
     * @param firstLength   - the length that is taken as the first command line argument, it specifies how many values should be entered
     * @param secondLength  - the real length of an array, so the number of command line arguments that were actually passed to the function.
     * @return least common multiplier of a list of values
     * @throws NotEnoughArgumentsException this exception is thrown when there are too many or not enough arguments passed to an array
     */
    public int leastCommonMultiplier(int firstLength, int secondLength, ArrayList<Integer> arrOfElements) throws NotEnoughArgumentsException {
        if (arrOfElements == null) {
            arrOfElements = new ArrayList<>();
            return -1;
        }
        int lcmOfArrayElement = 1;
        int divisor = 2;

        if (firstLength > secondLength || firstLength < secondLength) {
            throw new NotEnoughArgumentsException("There should be " + firstLength + " arguments and " + secondLength + " were passed");
        }

        while (true) {
            int counter = 0;
            boolean isDivisible = false;

            for (int i = 0; i < arrOfElements.size(); i++) {
                if (arrOfElements.get(i) == 0) {
                    return 0;
                }
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
