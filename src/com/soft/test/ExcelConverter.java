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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExcelConverter {

	Map BeanMap = new HashMap();
	String manifestName;

	public void processXlsxFile(int sheetIndex, InputStream inputStream, PrintStream printStream) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		for (int rowNum = 0; rowNum <= physicalNumberOfRows; rowNum++) {
			XSSFRow row = sheet.getRow(rowNum);
			if (row != null) {
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				String[] beanValues = new String[8];
				for (int cellNumber = 0; cellNumber <= physicalNumberOfCells; cellNumber++) {
					XSSFCell cell = row.getCell(cellNumber);
					if (cell != null) {
						String value = cell.toString();
						if (cellNumber > 0) {
							printStream.print(" ");
						}
						printStream.print(value);
						if (physicalNumberOfCells == 8) {
							beanValues[cellNumber] = value;
						}
					}
				}
				if (physicalNumberOfCells == 8 && rowNum != 1)
					makeBeans(beanValues);
			}
			printStream.println();
		}
	}

	public void processXlsFile(int sheetIndex, InputStream inputStream,	PrintStream printStream) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		manifestName = sheet.getRow(0).getCell(0).getStringCellValue();
		for (int rowNum = 0; rowNum <= physicalNumberOfRows; rowNum++) {
			HSSFRow row = sheet.getRow(rowNum);
			if (row != null) {
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				String[] beanValues = new String[8];
				for (int cellNumber = 0; cellNumber <= physicalNumberOfCells; cellNumber++) {
					HSSFCell cell = row.getCell(cellNumber);
					if (cell != null) {
						String value = cell.toString();
						if (cellNumber > 0) {
							printStream.print(" ");
						}
						printStream.print(value);
						if (physicalNumberOfCells == 8) {
							beanValues[cellNumber] = value;
						}
					}
				}
				if (physicalNumberOfCells == 8 && rowNum != 1)
					makeBeans(beanValues);
			}
			printStream.println();
		}
	}

	private void makeBeans(String cell[]) {
		try {
			FlightManifestBean record = new FlightManifestBean(  cell[6]);
			record.setPassengerName(  cell[1]);
			record.setCls(cell[2]);
			record.setSeat(cell[3]);
			record.setGender(cell[4]);
			record.setDob(stringToDate(cell[5]));
			record.setNationality(cell[7]);
			record.setManifestName(manifestName);
			BeanMap.put(record, record);
		} catch (Exception e) {
			System.err.println();
			System.err.println("Invalid Entries");
		} finally {
			return;
		}
	}

	public Date stringToDate(String textDate) throws ParseException {
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("dd-MMM-yy");
		date = formatter.parse(textDate);
		return date;
	}

}