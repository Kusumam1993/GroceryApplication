package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class ExcelUtility 
{
	
		static FileInputStream f;  //excel file path
		static XSSFWorkbook w; //username  password
		static XSSFSheet s;// sheet name ..
		public static String getStringData(int a,int b,String sheet) throws IOException// a is row ,b is column or cell
		{
			f=new FileInputStream(Constants.EXCELPATH);
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheet);
			XSSFRow r=s.getRow(a);
			XSSFCell c=r.getCell(b);
			return c.getStringCellValue(); //inbuilt method for excelsheet connection
			
		}
		
		public static String getIntegerData(int a,int b,String sheet) throws IOException
		{ 
			f=new FileInputStream(Constants.EXCELPATH);
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheet);
			XSSFRow r=s.getRow(a);
			XSSFCell c=r.getCell(b);
			int y=(int) c.getNumericCellValue();//Convert String datatype to int using type casting
			return String.valueOf(y);
		}
	
	}



