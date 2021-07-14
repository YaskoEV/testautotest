package FrameworkDDT.Utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// используем для DataProvider в TestNG
public class ReadExcelFile {

		XSSFWorkbook wb;
		XSSFSheet sheet;
		
		public ReadExcelFile(String excelPath) {
			try
			{
				File src = new File(excelPath);
				FileInputStream fls = new FileInputStream(src);
				wb = new XSSFWorkbook(fls);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		public String getData(String sheetname, int row, int column) {
			sheet = wb.getSheet(sheetname);
			String data=sheet.getRow(row).getCell(column).getStringCellValue();
			return data;
		}
		
		
		
		public int getRowCount(int sheetIndex) {
			int row = wb.getSheetAt(sheetIndex).getLastRowNum();
			row=row+1;
			return row;
		}
}		  

