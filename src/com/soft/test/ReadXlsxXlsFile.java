

/*
 * Reads the Excel file and Prints Records out of it .
 */
package com.soft.test;
/**
 *
 * @author Phanindhar
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadXlsxXlsFile {

    private final static int EXIT_STATUS_INPUT_FILE_NOT_FOUND = 1;
    private final static int EXIT_STATUS_INPUT_FILE_IO_EXCEPTION = 2;
    private static InputStream inputStream;
    private static File inputFile = null;

    public static void main(String[] args) {

        String inputFileName = args[0];
        try {
            inputFile = new File(inputFileName);
            inputStream = getInputStream(inputFile);
        } catch (FileNotFoundException e) {
            System.err.printf("error.file.notFound", e);
            System.exit(EXIT_STATUS_INPUT_FILE_NOT_FOUND);
        }
        ExcelConverter conv = new ExcelConverter();
        try {
            if (inputFileName.toLowerCase().endsWith(".xls")) {
                conv.processXlsFile(0,inputStream,System.out);
            } else {
                conv.processXlsxFile(0,inputStream,System.out);
            }
        } catch (IOException e) {
            System.err.printf("error.file.ioException", e);
            System.exit(EXIT_STATUS_INPUT_FILE_IO_EXCEPTION);
        }
    }

    private static InputStream getInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}