package com.actitime.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements AutoConstant
{
	public static String getStringCellData(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		String cellvalue = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return cellvalue;
	}
	
	public static boolean getBooleanCellData(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		boolean cellvalue = wb.getSheet(sheet).getRow(row).getCell(cell).getBooleanCellValue();
		return cellvalue;
	}
	
	public static double getNumericCellData(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		double cellvalue = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		return cellvalue;
	}
	
	public static Date getDateCellData(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		Date cellvalue = wb.getSheet(sheet).getRow(row).getCell(cell).getDateCellValue();
		return cellvalue;
	}
	
	public static CellAddress getCellAddress(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		CellAddress celladdress = wb.getSheet(sheet).getRow(row).getCell(cell).getAddress();
		return celladdress;
	}
	
	public static int rowCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		int rowNum = wb.getSheet(sheet).getLastRowNum();
		return rowNum;
	}
	
	public static int cellCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		int rowNum = wb.getSheet(sheet).getLastRowNum();
		int cellCount=0;
		for(int i=0;i<=rowNum;i++)
		{
			cellCount=wb.getSheet(sheet).getRow(i).getLastCellNum();
		}
		return cellCount;
	}
}