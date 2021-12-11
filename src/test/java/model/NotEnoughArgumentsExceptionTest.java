package model;

import controller.Controller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import view.ResultView;

import static org.junit.jupiter.api.Assertions.*;

class NotEnoughArgumentsExceptionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void isExceptionMessageCorrect() {
        NWD testNWD = new NWD();
        NWW testNWW = new NWW();
        ResultView testView = new ResultView();
        Controller testController = new Controller(testNWD, testNWW, testView);
        NotEnoughArgumentsException exception = assertThrows(NotEnoughArgumentsException.class,
                () -> testController.throwNotEnoughArgumentException(2, 3));

        assertEquals("There should be 2 arguments and 3 were passed", exception.getMessage());
    }

}