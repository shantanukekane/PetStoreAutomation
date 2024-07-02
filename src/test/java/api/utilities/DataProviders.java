package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name = "LoginData")
	public String [][] getdata() throws IOException
	{
		
		String path = System.getProperty("user.dir")+"//testdata//Userdata.xlsx"; // location of excel file
		
		
		ExcelUtility xlUtil = new ExcelUtility(path);  // create an object for the xlUtil 
		
		int totalrows = xlUtil.getRowCount("Sheet1"); // total Number of rows
		int totalcols = xlUtil.getCellCount("Sheet1", 1); // total Number of columns
		
		String logindata [][] = new String[totalrows][totalcols]; // create a two dimensional array
		                                                           
		for(int i = 1;i<=totalrows;i++)  // i = rows, 1
		{
			
			for(int j = 0;j<totalcols;j++) // j = cols, 0
			{
				
				logindata[i-1][j] = xlUtil.getCellData("Sheet1", i, j); // read the data from the Excel and 
				                                                       //store in two dimenstional array
			}
		
		}
	
		return logindata; // returning two dimenstion array
	} 
	   
	
	// data provider 2
	
	@DataProvider(name = "userNames")
	public String[] getUserNames() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testdata//Userdata.xlsx";
		
		ExcelUtility xlUtil = new ExcelUtility(path);
		
		int totalrows = xlUtil.getRowCount("Sheet1"); // total Number of rows
		
		String apidata[] = new String[totalrows];
		
		for(int i = 1;i<=totalrows;i++)
		{
			apidata[i-1] = xlUtil.getCellData("Sheet1", i, 1);
		}
		
		return apidata;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	// data provider 3
	
	
	
	
	// data provider 4
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	

