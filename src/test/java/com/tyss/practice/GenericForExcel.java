package com.tyss.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericForExcel {

	
		public String getExcelData(String sheetname,int row,int cell) throws IOException
		{
			FileInputStream fis=new FileInputStream("./src/test/resources/testscript1.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			DataFormatter df=new DataFormatter();
			 String data = df.formatCellValue(wb.getSheet(sheetname).getRow(row).getCell(cell));
			return data;
		
	}
	

}
