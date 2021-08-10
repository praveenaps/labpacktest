package com.qa.excelReader;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.qa.utils.Utils;


import jxl.Sheet;

	public class excelReader {
	
	    XSSFWorkbook wb;
		XSSFSheet Sheet1;
		static Sheet sheets;
		public static String SheetName1 = "";

	public excelReader(String excelpath)
	{
		try 
		{
		File src = new File(excelpath);
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("InputData");
	    XSSFRow row = sh.getRow(0);
	    int colNum = row.getLastCellNum();
	    System.out.println("Total Number of Columns in the excel is : "+colNum);
	    int rowNum = sh.getLastRowNum()+1;
	    System.out.println("Total Number of Rows in the excel is : "+rowNum);
	   } 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());			
		}
	}

	public int getRowCount(String SheetName1)
	{
		XSSFSheet sh = wb.getSheet(SheetName1);
	    XSSFRow row = sh.getRow(0);
	    int rowCount = sh.getLastRowNum()+1;
	    return rowCount;
	}

	public int getColumnCount(String SheetName1)
	{
		XSSFSheet sh = wb.getSheet(SheetName1);
	    XSSFRow row = sh.getRow(0);
	    int colCount = row.getLastCellNum();
	    return colCount;
	}
	public String getData(int sheetNumber, int row, int column) throws InterruptedException
	//public String getData(String sheetNumber, int row, int column) throws InterruptedException
	{
		System.out.println("sheetNumber"+ sheetNumber);
		 Sheet1 = wb.getSheetAt(sheetNumber);
System.out.println("sheetrow"+Sheet1.getRow(row));
		XSSFCell cell = Sheet1.getRow(row).getCell(column);

		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		
		DataFormatter formatter = new DataFormatter();
		
		String val = "";   
		
		 switch (cell.getCellType()) 
         {
             case Cell.CELL_TYPE_NUMERIC:
            	 val = String.valueOf(formatter.formatCellValue(cell));
                 System.out.print(cell.getNumericCellValue() + "t");
                 break;
             case Cell.CELL_TYPE_STRING:
            	 val = formatter.formatCellValue(cell);
                 System.out.print(cell.getStringCellValue() + "t");
                 break;
                 
             default:
     			break;
         }
	 /*  switch(cell.getCellTypeEnum()) 
	    {
	        case NUMERIC:
	            val = String.valueOf(formatter.formatCellValue(cell));
	            break;
	        case STRING:
	            val = formatter.formatCellValue(cell);
	            break;
	        case FORMULA:
	            val = String.valueOf(evaluator.evaluateInCell(cell));      
				break;
		    default:
			break;
	    }*/
	   
		//DataFormatter formatter = new DataFormatter();
	    //String cellData = formatter.formatCellValue(cell);
	    /*DecimalFormat decimalFormat = new DecimalFormat(".#");
	    String result = decimalFormat.format(value);  */
	    
	    //String value = val.replaceAll(",", "");
	   
		return val;
	}
		


	public int getRowcount(int SheetIndex)
	{
		int row = wb.getSheetAt(SheetIndex).getLastRowNum();
		System.out.println(row);
		row = row+1;
		return row;
	}
	}
	