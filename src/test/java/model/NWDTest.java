package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NWDTest {

    NWD nwd;

    @BeforeEach
    void setUp() {
        nwd = new NWD();
    }

    @Test
    @DisplayName("Simple values should work")
    public void positiveValues() throws NegativeValuesException {
        ArrayList<Integer> test_list = new ArrayList<>();
        test_list.add(1);
        test_list.add(2);
        assertEquals(1, nwd.greatestCommonDivisorForArray(test_list));
    }

    @Test
    @DisplayName("Zero value should work")
    public void zeroValue() throws NegativeValuesException {
        ArrayList<Integer> test_list = new ArrayList<>();
        test_list.add(0);
        assertEquals(0, nwd.greatestCommonDivisorForArray(test_list));
    }

    static ArrayList<Integer> generateData() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(11);
        numbers.add(3);
        return (numbers);
    }

    @ParameterizedTest
    @DisplayName("Negative values should work")
    @ValueSource(ints = {1, 3, 5, -3, 15})
    public void negativeValues(int p) throws NegativeValuesException {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(p);
        assertEquals(1, nwd.greatestCommonDivisorForArray(testList));
    }

    @Test
    @DisplayName("Null values should return an error")
    public void nullValues() {
        ArrayList<Integer> test_list = new ArrayList<>();
        test_list.add(null);
        assertThrows(NullPointerException.class, () -> nwd.greatestCommonDivisorForArray(test_list));
    }


}