package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {

		String path = ConfigReader.getProperty("xlPath");
		String sheet = ConfigReader.getProperty("xlSheet");
		ExcelUtility xlutils = new ExcelUtility(path);
		int rowCount = xlutils.getRowCount(sheet);
		int cellCount = xlutils.getCellCount(sheet, 1);
		String loginData[][] = new String[rowCount][cellCount];
		for (int r = 1; r <= rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				loginData[r - 1][c] = xlutils.getCellValue("Data", r, c);
			}
		}

		return loginData;

	}

}
