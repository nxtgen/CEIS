package com.soft.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsxXlsFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		OPCPackage pkg = OPCPackage.open("\\6E25.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext()) {
			XSSFRow row = (XSSFRow) rows.next();
			List<String> cellArray = getCells(row);
			displayCells(cellArray);
		}

	}

	private static void displayCells(List<String> cellList) {
		// TODO Auto-generated method stub
		Iterator<String> iter = cellList.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println();
	}

	private static List<String> getCells(XSSFRow row) {
		Iterator<Cell> cells = row.cellIterator();
		ArrayList<String> cellList = new ArrayList<String>();
		while (cells.hasNext()) {
			XSSFCell cell = (XSSFCell) cells.next();
			if(cell != null) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					cellList.add(cell.getStringCellValue());
				}
				else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					cellList.add(""+cell.getNumericCellValue());
				}
			}
		}
		return cellList;
	}

}
