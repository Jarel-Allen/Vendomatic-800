package com.techelevator.view.exceptionsTest;

import com.techelevator.view.exceptions.DataFileNotFoundException;
import org.junit.Test;

public class DataFileNotFoundExceptionTest {
    @Test
    public void yourTestMethodName() throws DataFileNotFoundException {
        //your logic goes here.
        if (true) {
            throw new DataFileNotFoundException("This is a test");
        }
    }
}
