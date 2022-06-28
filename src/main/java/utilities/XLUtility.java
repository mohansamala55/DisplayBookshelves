package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLUtility {

	public FileInputStream fileinput;
	public FileOutputStream fileoutput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	String path = null;

	public XLUtility(String path) {
		this.path = path;
	}

	/*************** Method to get number of rows in xl sheet *************/
	public int getRowCount(String sheetName) throws IOException {
		fileinput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fileinput.close();

		return rowcount;
	}

	/*************** Method to get number of columns in xl sheet *************/
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fileinput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();

		return cellcount;
	}

	/*************** Method to cell data in xl sheet *************/
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		fileinput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data = null;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		workbook.close();
		fileinput.close();
		return data;
	}

}
