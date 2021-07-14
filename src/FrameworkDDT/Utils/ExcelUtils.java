package FrameworkDDT.Utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class ExcelUtils {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
                
            //Открыть файл по заданному пути на указанном листе 
            public static void setExcelFile(String Path,String SheetName) throws Exception {
                   try {
                    //Открыть файл
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    // Перейти на лист
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    ExcelWSheet = ExcelWBook.getSheet(SheetName);
                    System.out.println("Excel sheet opened");
                    } catch (Exception e){
                        throw (e);
                    }
            }
            
            //Считать значение из ячейки по указанным координатам
            public static String getCellData(int RowNum, int ColNum) throws Exception{
                   try{
                	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                      String CellData = Cell.getStringCellValue();
                      return CellData;
                      }catch (Exception e){
                        return"";
                      }
            }
            
            //Записать значение в Excel
            @SuppressWarnings("static-access")
			public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception    {
                   try{
                    Row  = ExcelWSheet.getRow(RowNum);
                    Cell = Row.getCell(ColNum);
                    if (Cell == null) {
                        Cell = Row.createCell(ColNum);
                        Cell.setCellValue(Result);
                        } else {
                            Cell.setCellValue(Result);
                        }

                          FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
                          ExcelWBook.write(fileOut);
                        fileOut.close();
                        }catch(Exception e){
                            throw (e);
                    }
                }
            // Найти строку, содержащую название тест-кейса
        	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
        		int i;
        		try {
        			int rowCount = ExcelUtils.getRowUsed();
        			for ( i=0 ; i<rowCount; i++){
        				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
        					break;
        				}
        			}
        			return i;
        				}catch (Exception e){
        			System.out.println("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        			throw(e);
        			}
        		}
        	// найти количество заполненных строк
        	public static int getRowUsed() throws Exception {
        		try{
        			int RowCount = ExcelWSheet.getLastRowNum();
        			System.out.println("Total number of Row used return as < " + RowCount + " >.");		
        			return RowCount;
        		}catch (Exception e){
        			System.out.println("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
        			System.out.println(e.getMessage());
        			throw (e);
        		}

        	}
    }