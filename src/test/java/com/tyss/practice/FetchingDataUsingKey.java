package com.tyss.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataUsingKey {

public String fetchExcelData(String sheetName,String testCaseName,String expectedKey) throws Exception, IOException 
{
	String value="";
	FileInputStream fis1=new FileInputStream("./src/test/resources/testscript1.xlsx");
	Workbook wb=WorkbookFactory.create(fis1);
	DataFormatter df=new DataFormatter();
	
  
	try{
	Sheet sheet = wb.getSheet(sheetName);
	int lastrowno = sheet.getLastRowNum();
	short lastcellcount = sheet.getRow(0).getLastCellNum();
	System.out.println(lastrowno);
	System.out.println(lastcellcount);

	

	for(int i=0;i<lastrowno;i++)
	{
	    String actualTestcase = sheet.getRow(i).getCell(0).getStringCellValue();
	    System.out.println(actualTestcase);
		if(actualTestcase.equals(testCaseName))
		{
			for(int j=1;j<lastcellcount-1;j++)
			{
				String actualkey = sheet.getRow(i).getCell(j).getStringCellValue();
				if(actualkey.equals(expectedKey))
				{
					value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
					break;
				}
			}
			break;
		}}
	}
	
finally {
	}

return value;
}}
