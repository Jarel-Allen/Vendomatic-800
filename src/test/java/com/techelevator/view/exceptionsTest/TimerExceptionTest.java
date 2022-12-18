package com.techelevator.view.exceptionsTest;

import com.techelevator.exceptions.TimerException;
import org.junit.Test;

public class TimerExceptionTest {

    @Test
    public void yourTestMethodName() throws TimerException {
        //your logic goes here.
        if (true) {
            throw new TimerException("This is a test");
        }
    }
}
