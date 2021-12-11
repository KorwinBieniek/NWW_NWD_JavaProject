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
public class NWD {
    private int divisorValue;

    /**
     * @return
     */
    public int getDivisorValue() {
        return divisorValue;
    }

    /**
     * @param divisorValue
     */
    public void setDivisorValue(int divisorValue) {
        this.divisorValue = divisorValue;
    }

    /**
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    private int greatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber == 0)
            return secondNumber;
        return greatestCommonDivisor(secondNumber % firstNumber, firstNumber);
    }

    /**
     * @param arrOfNums
     * @return
     */
    public Integer greatestCommonDivisorForArray(ArrayList<Integer> arrOfNums) {
        int result = 0;
        for (int element : arrOfNums) {
            result = greatestCommonDivisor(result, element);

            if (result == 1) {
                return 1;
            }
        }
        return result;
    }
}
