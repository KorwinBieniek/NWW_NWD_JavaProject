/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * @author SuperStudent
 */
public class NWW {
    private int multiplyValue;

    /**
     * @return
     */
    public int getMultiplyValue() {
        return multiplyValue;
    }

    /**
     * @param multiplyValue
     */
    public void setMultiplyValue(int multiplyValue) {
        this.multiplyValue = multiplyValue;
    }

    /**
     * @param arrOfElements
     * @return
     */
    public int leastCommonMultiplier(ArrayList<Integer> arrOfElements) {
        int lcmOfArrayElement = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean isDivisible = false;

            for (int i = 0; i < arrOfElements.size(); i++) {
                if (arrOfElements.get(i) == 0) {
                    return 0;
                } else if (arrOfElements.get(i) < 0) {
                    arrOfElements.set(i, arrOfElements.get(i) * -1);
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
