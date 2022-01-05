package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NWWTest {

    NWW nww;

    @BeforeEach
    void setUp() {
        nww = new NWW();
    }

    @Test
    @DisplayName("Simple values should work")
    public void positiveValues() throws NegativeValuesException {
        ArrayList<Integer> test_list = new ArrayList<>();
        test_list.add(1);
        test_list.add(2);
        assertEquals(2, nww.leastCommonMultiplier(test_list));
    }

    @Test
    @DisplayName("Zero value should work")
    public void zeroValues() throws NegativeValuesException {
        ArrayList<Integer> test_list = new ArrayList<>();
        test_list.add(0);
        assertEquals(0, nww.leastCommonMultiplier(test_list));
    }

    @Test
    @DisplayName("Negative values should work")
    public void negativeValues() throws NegativeValuesException {
        ArrayList<Integer> test_list = new ArrayList<>();
        test_list.add(-1);
        test_list.add(-2);
        assertEquals(2, nww.leastCommonMultiplier(test_list));
    }

    @Test
    @DisplayName("Null values should return an error")
    public void nullValues() {
        ArrayList<Integer> test_list = new ArrayList<>();
        test_list.add(null);
        assertThrows(NullPointerException.class, () -> nww.leastCommonMultiplier(test_list));
    }
}