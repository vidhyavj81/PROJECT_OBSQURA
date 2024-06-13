package excelUtility;


	import java.io.FileInputStream;
	import java.io.IOException;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
	public class ExcelRead {
	public static FileInputStream f;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	static String project=System.getProperty("user.dir");

public static String readStringData(int i, int j) throws IOException{
		
		f=new FileInputStream(project+"\\src\\main\\resources\\Excelfile\\employee.xlsx");
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet("Sheet1");
		XSSFRow r=sh.getRow(i);
		XSSFCell c=r.getCell(j);
		return c.getStringCellValue();
		
	}
public static String readNumbericData(int i,int j)throws IOException{
		
		f=new FileInputStream(project+"\\src\\main\\resources\\Excelfile\\employee.xlsx");
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet("Sheet1");
		XSSFRow r=sh.getRow(i);
		XSSFCell c=r.getCell(j);
		int val=(int)c.getNumericCellValue();
		return String.valueOf(val);
	}		
		
	}



