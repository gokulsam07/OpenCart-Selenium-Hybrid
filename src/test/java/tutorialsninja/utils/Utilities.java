package tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.DataProvider;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 10;
	static Object[][] data;
	private static XSSFWorkbook workbook;

	public static String generateTimeStamp() {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String timeStamp=	date.toString().replace(" ", "_").replace(":", "_");
		return "gokul"+timeStamp+"@gmail.com";
	}



	// For data provider using POI

	public static Object[][] readExcel() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Data\\opencartTestData.xlsx");
		workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("credentials");

		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(1).getLastCellNum();
		data = new Object[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			XSSFRow rows = sheet.getRow(i+1);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = rows.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING: 
					data[i][j] = cell.getStringCellValue();	
					break;

				case NUMERIC: 
					data[i][j] = cell.getNumericCellValue();
					break;

				case BOOLEAN: 
					data[i][j] = cell.getBooleanCellValue();	
					break;
				default:
					System.out.println("Value type doesn't match");
					break;
				}
			}
		}
		return data; 
	}

	//Capture Screenshot

	public static String takeScreenshot(WebDriver driver, String testName) {


		File shoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = ("C:\\Data\\Screenshot"+testName+".png");
		try {
			FileHandler.copy(shoot, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
}
