package Exceldrivenpk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadrivenex {
	
	//Identifiy Test cases column
	//Once you identify column find purchase order row
	//Grab the data from purchase order row

	
		public ArrayList getData(String testcasename) throws IOException
		
		{
		FileInputStream fis=new FileInputStream("C:\\Paramesh\\demodata.xlsx");
		
		ArrayList a=new ArrayList();
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	//get access to sheet
	for(int i=0;i<sheets;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
				{
			XSSFSheet sheet=workbook.getSheetAt(i); // got sheet access.sheet is collection of rows
			
			Iterator<Row> rows=sheet.rowIterator(); //row is collection of cells
			Row firstrow=rows.next();
			
			Iterator<Cell> cell=firstrow.cellIterator();
			int k=0;
			int column=0;
			while(cell.hasNext())
			{
				Cell value=cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("Test cases"))
					
						{
					column=k;
					
						}
				k++;
			}
			System.out.println(column);
			
			while(rows.hasNext())
			{
				Row row=rows.next();
				if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					Iterator<Cell> cv=row.cellIterator();
					
					while(cv.hasNext())
					{
						
						Cell c=cv.next();
						if(c.getCellType()==CellType.STRING)
						{
					a.add(c.getStringCellValue());
						
					}
						else
						{
							
							
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
						}
					
				}
				
			
				
				}
			}
				}
	}
	return a;
						
				
	

		
	}
	
	public static void main(String[] args) throws IOException
	{
		
	}

	
	}
		

