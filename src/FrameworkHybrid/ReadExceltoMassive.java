package FrameworkHybrid;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// испрользуем для создания  массива данных из файла
public class ReadExceltoMassive {

		static XSSFWorkbook wb;
		static XSSFSheet sheet;
		
		public ReadExceltoMassive() {
			
		}
		
		public static String[][] getData(String excelPath, String sheetname, int maxColumn) {
			
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
			
			sheet = wb.getSheet(sheetname);
			
			String[][] data = new String[7][maxColumn];
			for(int i=1;i<sheet.getLastRowNum();i++) {
				for(int j=1;j<maxColumn;j++) {
					data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return data;
		}
}		  

