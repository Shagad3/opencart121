package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
      String path;
	
	

	public ExcelUtility(String path) {
		
		this.path=path;
		// TODO Auto-generated constructor stub
	}




	public  int getRowCount( String Xsheet) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(Xsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();

		return rowcount;
		
	}

	public  int getCellCount(String Xsheet, int rownum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(Xsheet);
		row=ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();

		return cellcount;
		
		
	}
	public  String getCellData( String Xsheet, int rownum, int colnum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(Xsheet);
		row=ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		String data;
		try
		{
			data=cell.toString();
			/* DataFormatter formatter =new DataFormatter();
			 * data = formatter.formatCellValue(cell);//returns the formmated value of a cell as a string 
			 */
		}
		catch(Exception e)
		{
			data="";
			
		}
		
		wb.close();
		fi.close();

		return data;
		
		
	}
	
	public   void setCellData( String Xsheet, int rownum, int colnum,String data) throws IOException {
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(Xsheet);
		row=ws.getRow(rownum);
		cell = row.getCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public   void fillGreenColor( String Xsheet, int rownum, int colnum) throws IOException {
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(Xsheet);
		row=ws.getRow(rownum);
		cell = row.getCell(colnum);
	style =wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	fo=new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	}
	public   void fillRedColor( String Xsheet, int rownum, int colnum) throws IOException {
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(Xsheet);
		row=ws.getRow(rownum);
		cell = row.getCell(colnum);
	style =wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	fo=new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	}
	
	
	
	
}
