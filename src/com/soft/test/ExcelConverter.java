
/*
 * Prints the excel file taking params from read xls or xlsx filse 
 * and open the template in the editor.
 */
package com.soft.test;

/**
 *
 * @author Phanindhar
 */
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelConverter {

    public void processXlsxFile(int sheetIndex, InputStream inputStream, PrintStream printStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 0; rowNum <= physicalNumberOfRows; rowNum++) {
            XSSFRow row = sheet.getRow(rowNum);
            if (row != null) {
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                for (int cellNumber = 0; cellNumber <= physicalNumberOfCells; cellNumber++) {
                    XSSFCell cell = row.getCell(cellNumber);
                    if (cell != null) {
                        String value = null;
                        switch (cell.getCellType()) {
                            case HSSFCell.CELL_TYPE_STRING:
                                value = cell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                value = Double.toString(cell.getNumericCellValue());
                                break;
                            default:
                                value = cell.toString();
                                break;
                        }
                        if (cellNumber > 0) {
                            printStream.print(" ");
                        }
                        printStream.print(value);
                    }
                }
            }
            printStream.println();
        }
    }

    public void processXlsFile(int sheetIndex, InputStream inputStream ,PrintStream printStream) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 0; rowNum <= physicalNumberOfRows; rowNum++) {
            HSSFRow row = sheet.getRow(rowNum);
            if (row != null) {
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                for (int cellNumber = 0; cellNumber <= physicalNumberOfCells; cellNumber++) {
                    HSSFCell cell = row.getCell(cellNumber);
                    if (cell != null) {
                        String value = null;
                        switch (cell.getCellType()) {
                            case HSSFCell.CELL_TYPE_STRING:
                                value = cell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                value = Double.toString(cell.getNumericCellValue());
                                break;
                            default:
                                value =cell.toString();
                                break;
                        }
                        if (cellNumber > 0) {
                            printStream.print(" ");
                        }
                        printStream.print(value);
                    }
                }
            }
            printStream.println();
        }
    }

}