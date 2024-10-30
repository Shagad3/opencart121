package utilities;




import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {


  @DataProvider (name = "LoginData")
  public String [][] getData() throws IOException {
	
	  String path = ".\\testdata\\Opencart_LoginData.xlsx"; //taking xl file fromtest data 
	  ExcelUtility xlutil = new ExcelUtility(path); // creating an object XLutility
	  
	  int totelrows = xlutil.getRowCount("Sheet1"); //getting row count
	  int totelcols =xlutil.getCellCount("Sheet1",1);//getting colum count
	  
	  
	  String logindata [][] = new String [totelrows][totelcols];//created two dimentional array which can store the informtion
	  for( int i =1; i<=totelrows; i++) {
		  
		  for(int j=0; j<=totelcols; j++) {
			  logindata [i-1][j] = xlutil.getCellData("Sheet1", i, j);//1,0
		  }
	 
	  }
	return logindata;
	  
	  }}
