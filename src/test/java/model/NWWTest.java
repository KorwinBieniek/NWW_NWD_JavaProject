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
class NWWTest {

    NWW nww;

    @BeforeEach
    void setUp() {
        nww = new NWW();
    }

    private static Stream<Arguments> providePositiveTestValues() {
        return Stream.of(
                Arguments.of(1, 0, 1, 0),
                Arguments.of(5, 17, 1, 85),
                Arguments.of(1, 12, 41, 492),
                Arguments.of(53252, 1, 241, 12833732),
                Arguments.of(1, 1, 1, 1),
                Arguments.of(0, 1, 0, 0));
    }

    private static Stream<Arguments> provideNegativeTestValues() {
        return Stream.of(
                Arguments.of(-1, 0, -1, 0),
                Arguments.of(-2, 1, 2, 1),
                Arguments.of(-2, -1, -2, -2));
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
    public void positiveValues(int first, int second, int third, int result) throws NegativeValuesException, NotEnoughArgumentsException {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(first);
        testList.add(second);
        testList.add(third);
        assertEquals(result, nww.leastCommonMultiplier(3, 3, testList));
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
    public void zeroValue(int first, int second, int third, int result) throws NegativeValuesException, NotEnoughArgumentsException {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(first);
        testList.add(second);
        testList.add(third);
        assertEquals(result, nww.leastCommonMultiplier(3, 3, testList));
    }

    /**
     * @param first  - the first value of the arguments passed from the stream
     * @param second - the second value of the arguments passed from the stream
     * @param third  - the third value of the arguments passed from the stream
     */
    @ParameterizedTest
    @MethodSource("provideNegativeTestValues")
    @DisplayName("Negative values should not work. They should throw an exception")
    public void negativeValues(int first, int second, int third) {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(first);
        testList.add(second);
        testList.add(third);
        assertThrows(NegativeValuesException.class, () -> nww.leastCommonMultiplier(3, 3, testList));
    }

    /**
     * No parameters because list reference is null
     */
    @ParameterizedTest
    @MethodSource("providePositiveTestValues")
    @DisplayName("Negative values should not work. They should throw an exception")
    public void listReferenceIsNull() {
        assertThrows(NullPointerException.class, () -> {
            nww.leastCommonMultiplier(3, 3, null);
        });
    }

    /**
     * @param first  - the first value of the arguments passed from the stream
     * @param second - the second value of the arguments passed from the stream
     * @param third  - the third value of the arguments passed from the stream
     */
    @ParameterizedTest
    @MethodSource("providePositiveTestValues")
    @DisplayName("The message below should appear when there are not enough values provided")
    public void isExceptionMessageCorrectForNotEnoughValues(int first, int second, int third) throws NegativeValuesException, NotEnoughArgumentsException {

        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(first);
        testList.add(second);
        testList.add(third);
        NotEnoughArgumentsException exception = assertThrows(NotEnoughArgumentsException.class,
                () -> nww.leastCommonMultiplier(2, 3, testList));


        assertEquals(Strings.FIRST_MESSAGE.toString(), exception.getMessage());
    }

    /**
     * @param first  - the first value of the arguments passed from the stream
     * @param second - the second value of the arguments passed from the stream
     * @param third  - the third value of the arguments passed from the stream
     */
    @ParameterizedTest
    @MethodSource("providePositiveTestValues")
    @DisplayName("The message below should appear when there are too many values provided")
    public void isExceptionMessageCorrectForTooManyValues(int first, int second, int third) throws NegativeValuesException, NotEnoughArgumentsException {

        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(first);
        testList.add(second);
        testList.add(third);
        NotEnoughArgumentsException exception = assertThrows(NotEnoughArgumentsException.class,
                () -> nww.leastCommonMultiplier(4, 3, testList));


        assertEquals(Strings.SECOND_MESSAGE.toString(), exception.getMessage());
    }
}