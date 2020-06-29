package com.kodilla.exception.main;
import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHanding;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main(String args[]) throws IOException {

        FileReader fileReader = new FileReader();

        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.print("Problem while reading a file");
        }
    }

}
