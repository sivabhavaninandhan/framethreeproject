package thirddatadrivenformatterextentframeworkthird;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class datadrivenExtentTest {
	
	@DataProvider
	public String[][] verification() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\bhavani.xlsx";
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rws=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] passvalues=new String[rws-1][cols];
		
		for(int r=0;r<rws-1;r++)
		{
		for(int c=0;c<cols;c++)	
		{
			DataFormatter df=new DataFormatter();
			passvalues[r][c]=df.formatCellValue(sheet.getRow(r+1).getCell(c));
		}
		
		}
		fis.close();
		return passvalues;
		
	}

}
