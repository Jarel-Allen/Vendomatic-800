package com.techelevator.view.exceptionsTest;


import com.techelevator.exceptions.LogFileException;
import org.junit.Test;

public class LogFileExceptionTest {
    @Test
    public void yourTestMethodName() throws LogFileException {
        //your logic goes here.
        if (true) {
            throw new LogFileException("This is a test");
        }
    }
}
