package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class Exceldata {

	public static void takeScreenshot(WebDriver driver, String filepath, String name) throws IOException {
		TakesScreenshot capture= (TakesScreenshot)driver;
		File srcfile=capture.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat timestamp=new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss");
		String currenttime=timestamp.format(new Date());
		File destfile= new File(filepath+name+currenttime+".png");
		FileUtils.copyFile(srcfile, destfile);
	}
	
	public static Object[][] generateDataArray(List<String> dataList, int rowCount, int columnCount) {
		//columnCount = columnCount / rowCount;
		int k = 7;
		String[][] xlsData = new String[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < columnCount; j++) {
				xlsData[i][j] = dataList.get(k++);
			}
		}
		return xlsData;
	}

	
	
	@DataProvider
	public static Object[][] provideDataFromExcel() throws IOException {

		
		int rowCount = 0;
	
		List<String> records = new ArrayList();

		Workbook workbook = new  XSSFWorkbook("D:\\New folder\\AvactisProject\\src\\test\\java\\testResources\\data.xlsx");

		Sheet sheet = (Sheet) workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			XSSFRow row = (XSSFRow) rowIterator.next();
			rowCount++;
			System.out.println("rowcount is "+rowCount);
			Iterator<Cell> cellIterator = row.iterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {

				case STRING:

					records.add(cell.getStringCellValue());
					

				}
			}
		}

		Object[][] output = generateDataArray(records, 3, 7);

		System.out.println(Arrays.deepToString(output));
		return output;
	}
}
	


