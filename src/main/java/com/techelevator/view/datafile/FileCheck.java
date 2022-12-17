package com.techelevator.view.datafile;

import com.techelevator.view.misc.ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.exit;

public class FileCheck extends FilePath {
    // this is our file reader before running the virtual vending machine
    public FileCheck() {
        File dataFile = new File(getFile());

        // just reads if the file can be read
        try (Scanner dataInput = new Scanner(dataFile)) { }

        catch(FileNotFoundException e) {
            // if the file cannot be read, it will stop running the program
            ExceptionHandling.fileException();
        }
    }

}