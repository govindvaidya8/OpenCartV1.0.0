package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;

	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetxl) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetxl);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}

	public int getCellCount(String sheetxl, int row) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetxl);
		int cellCount = sheet.getRow(row).getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
	}

	public String getCellValue(String sheetxl, int rowNum, int cellNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetxl);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		DataFormatter formatter = new DataFormatter();
		String cellValue = formatter.formatCellValue(cell);
		workbook.close();
		fi.close();
		return cellValue;
	}

	public void setCellValue(String sheetxl, int rowNum, int cellNum, String value) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetxl);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		cell.setCellValue(value);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();
	}

	public void fillGreenColor(String sheetxl, int rowNum, int cellNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetxl);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();
	}

	public void fillRedColor(String sheetxl, int rowNum, int cellNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetxl);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();

	}
}
