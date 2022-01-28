package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Korwin Bieniek
 * * @version 1.0.0
 */
class NWDTest {

    NWD nwd;

    /**
     * generates instance of an NWD object
     */
    @BeforeEach
    void setUp() {
        nwd = new NWD();
    }

    /**
     * generates Stream of arguments to parametrize the test
     */
    private static Stream<Arguments> providePositiveTestValues() {
        return Stream.of(
                Arguments.of(1, 0, 1, 1),
                Arguments.of(4, 14, 6, 2),
                Arguments.of(18, 12, 30, 6),
                Arguments.of(53252, 22, 241, 1),
                Arguments.of(1, 1, 1, 1),
                Arguments.of(0, 5, 0, 5));
    }

    private static Stream<Arguments> provideNegativeTestValues() {
        return Stream.of(
                Arguments.of(-1, 0, -1),
                Arguments.of(-2, 1, 2),
                Arguments.of(-2, -1, -2));
    }

    private static Stream<Arguments> provideZeroTestValues() {
        return Stream.of(
                Arguments.of(0, 0, 0, 0));
    }

    /**
     * @param first  - the first value of the arguments passed from the stream
     * @param second - the second value of the arguments passed from the stream
     * @param third  - the third value of the arguments passed from the stream
     * @param result - the fourth value of the arguments passed from the stream, which will be used as a result to assert.
     */
    @ParameterizedTest
    @MethodSource("providePositiveTestValues")
    @DisplayName("Positive values should work")
    public void positiveValues(int first, int second, int third, int result) throws NotEnoughArgumentsException {
        try {
            ArrayList<Integer> testList = new ArrayList<>();
            testList.add(first);
            testList.add(second);
            testList.add(third);
            assertEquals(result, nwd.greatestCommonDivisorForArray(3, 3, testList));
        } catch (AssertionError assertionError) {
            fail("The values are not equal");
        }
    }

    /**
     * @param first  - the first value of the arguments passed from the stream
     * @param second - the second value of the arguments passed from the stream
     * @param third  - the third value of the arguments passed from the stream
     * @param result - the fourth value of the arguments passed from the stream, which will be used as a result to assert.
     */
    @ParameterizedTest
    @MethodSource("provideZeroTestValues")
    @DisplayName("Zero value should work")
    public void zeroValue(int first, int second, int third, int result) throws NotEnoughArgumentsException {
        try {
            ArrayList<Integer> testList = new ArrayList<>();
            testList.add(first);
            testList.add(second);
            testList.add(third);
            assertEquals(result, nwd.greatestCommonDivisorForArray(3, 3, testList));
        } catch (AssertionError assertionError) {
            fail("The values are not equal");
        }
    }


    /**
     * @param first  - the first value of the arguments passed from the stream
     * @param second - the second value of the arguments passed from the stream
     * @param third  - the third value of the arguments passed from the stream
     */
    @ParameterizedTest
    @MethodSource("providePositiveTestValues")
    @DisplayName("The message below should appear when there are not enough values provided")
    public void isExceptionMessageCorrectForNotEnoughValues(int first, int second, int third) throws NotEnoughArgumentsException {
        try {
            ArrayList<Integer> testList = new ArrayList<>();
            testList.add(first);
            testList.add(second);
            testList.add(third);
            NotEnoughArgumentsException exception = assertThrows(NotEnoughArgumentsException.class,
                    () -> nwd.greatestCommonDivisorForArray(2, 3, testList));
            assertEquals(Strings.FIRST_MESSAGE.toString(), exception.getMessage());
        } catch (AssertionError assertionError) {
            fail("The exception doesn't occur");
        }
    }


    /**
     * @param first  - the first value of the arguments passed from the stream
     * @param second - the second value of the arguments passed from the stream
     * @param third  - the third value of the arguments passed from the stream
     */
    @ParameterizedTest
    @MethodSource("providePositiveTestValues")
    @DisplayName("The message below should appear when there are too many values provided")
    public void isExceptionMessageCorrectForTooManyValues(int first, int second, int third) throws NotEnoughArgumentsException {
        try {
            ArrayList<Integer> testList = new ArrayList<>();
            testList.add(first);
            testList.add(second);
            testList.add(third);
            NotEnoughArgumentsException exception = assertThrows(NotEnoughArgumentsException.class,
                    () -> nwd.greatestCommonDivisorForArray(4, 3, testList));
            assertEquals(Strings.SECOND_MESSAGE.toString(), exception.getMessage());
        } catch (AssertionError assertionError) {
            fail("The exception doesn't occur");
        }
    }
}