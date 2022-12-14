package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.exit;

public class FileCheck extends File_Path {
    // this is our file reader before running the virtual vending machine
    public FileCheck() {
        File dataFile = new File(getFile());

        // just reads if the file can be read
        try (Scanner dataInput = new Scanner(dataFile)) { }

            // if the file cannot be read, it will stop running the program
            catch(FileNotFoundException e) {
                System.out.println();
                System.out.println("File Not Found.");
                exit(0);
        }
    }
}
