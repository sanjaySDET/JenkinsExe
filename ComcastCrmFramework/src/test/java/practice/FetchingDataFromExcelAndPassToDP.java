package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class FetchingDataFromExcelAndPassToDP{

	
	
	@Test(dataProvider = "dataPro_bookTicket")
	public void bookTicket(String src,String dst)
	{
		System.out.println(src+" "+dst);
	}
	
	@DataProvider
	public Object[][] dataPro_bookTicket() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook = WorkbookFactory.create(new FileInputStream(System.getProperty("user.dir") + "/amazon.xlsx"));
		Sheet sheet = workbook.getSheet("Sheet2");
		int rowNum = sheet.getLastRowNum()+1;
		int cellNo = sheet.getRow(0).getLastCellNum();
		
	    Object[][] obj = new Object[rowNum][cellNo];
		for(int i=0;i<rowNum;i++)
		{
			for(int j=0;j<cellNo;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
