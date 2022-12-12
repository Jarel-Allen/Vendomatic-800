package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.exit;

public class File_Reader extends File_Path {
    //this is our file reader before running the virtual vending machine
    public File_Reader() {
        File dataFile = new File(getFile());
        try (Scanner dataInput = new Scanner(dataFile)) {
            } catch(FileNotFoundException e) {
                System.out.println("File Not Found.");
                exit(0);
            }
    }
}
