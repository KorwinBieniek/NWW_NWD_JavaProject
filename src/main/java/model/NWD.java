/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * @author Korwin Bieniek
 * @version 1.0.0
 */
public class NWD {
    private int divisorValue;

    /**
     * @return a value of the divisor
     */
    public int getDivisorValue() {
        return divisorValue;
    }

    /**
     * @param divisorValue - the value that is going to be the divisor
     */
    public void setDivisorValue(int divisorValue) {
        this.divisorValue = divisorValue;
    }

    /**
     * @param firstNumber  - the first value that the greatest common divisor will be calculated on
     * @param secondNumber - the second value that the greatest common divisor will be calculated on
     * @return greatest common divisor of two numbers
     */
    private int greatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber == 0)
            return secondNumber;
        return greatestCommonDivisor(secondNumber % firstNumber, firstNumber);
    }

    /**
     * @param arrOfNums - array of values that the greatest common divisor will be taken from
     * @return greatest common divisor of a list of numbers
     */
    public Integer greatestCommonDivisorForArray(int firstLength, int secondLength, ArrayList<Integer> arrOfNums) throws NegativeValuesException, NotEnoughArgumentsException {
        int result = 0;
        if (firstLength > secondLength || firstLength < secondLength) {
            throw new NotEnoughArgumentsException("There should be " + firstLength + " arguments and " + secondLength + " were passed");
        }
        for (int element : arrOfNums) {
            if (element < 0) {
                throw new NegativeValuesException("No negative are allowed");
            }
            result = greatestCommonDivisor(result, element);

            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

}
