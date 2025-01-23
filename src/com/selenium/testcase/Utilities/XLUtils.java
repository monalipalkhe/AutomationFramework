package com.selenium.testcase.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	/*
	 * // Method to get row count public static int getRowCount(String xlfile,
	 * String xlsheet) throws IOException { try (FileInputStream fis = new
	 * FileInputStream(xlfile); XSSFWorkbook wb = new XSSFWorkbook(fis)) { XSSFSheet
	 * ws = wb.getSheet(xlsheet); return ws.getLastRowNum(); } }
	 */
    // Method to get cell count in a row
    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        try (FileInputStream fis = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            return row.getLastCellNum();
        }
    }

    // Method to get cell data
    public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
        try (FileInputStream fis = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            XSSFCell cell = row.getCell(colnum);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            // Log error and return a default value
            System.err.println("Error reading data from Excel: " + e.getMessage());
            return "ERROR";
        }
    }
    
    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
            }
        }
		return data;
    }
}
