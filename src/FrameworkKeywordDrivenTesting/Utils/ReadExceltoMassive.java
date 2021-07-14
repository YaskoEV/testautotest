package FrameworkKeywordDrivenTesting.Utils;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import FrameworkDDT.Utils.ReadExcelFile;

// испрользуем для создания  массива данных из файла
public class ReadExceltoMassive {

		static XSSFWorkbook wb;
		static XSSFSheet sheet;
		
		public ReadExceltoMassive() {
			
		}
		
		public static String[][] getData(String excelPath, String sheetname, int sheetnumber, int maxColumn) {
			
			ReadExcelFile config = new ReadExcelFile(excelPath);
			int rows = config.getRowCount(0); // количество строк
			String[][] credentials = new String[rows][maxColumn];
			for (int i=1; i<rows; i++) {
				for (int j=1; j<maxColumn; j++) {
					credentials[i][j] = config.getData(sheetname,i,j).toString();
				}
			}
			return credentials;
		}
}		  

