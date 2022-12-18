package com.techelevator.view.exceptionsTest;

import com.techelevator.exceptions.StringToNumberException;
import org.junit.Test;

public class StringToNumberExceptionTest {
    @Test
    public void yourTestMethodName() throws StringToNumberException {
        //your logic goes here.
        if (true) {
            throw new StringToNumberException("This is a test");
        }
    }
}
