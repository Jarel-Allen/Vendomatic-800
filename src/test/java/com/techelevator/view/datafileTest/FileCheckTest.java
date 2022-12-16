package com.techelevator.view.datafileTest;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileCheckTest {

    @Test
    public void file_test() {
        File file = new File("test.txt");
        List<List<String>> items = new ArrayList<>();
        try (Scanner dataInput = new Scanner(file)) {
            while (dataInput.hasNextLine()) {
                List<String> lineOfInput = Arrays.asList(dataInput.nextLine().split("\\|"));
                items.add(lineOfInput);
            }
        } catch (Exception e) {
            System.out.println("File Not Found");
        }

    }
}
