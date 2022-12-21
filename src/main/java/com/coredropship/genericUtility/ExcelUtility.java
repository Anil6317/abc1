package com.coredropship.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class contains excel reusable methods 
 * @author SHIVA
 *
 */

public class ExcelUtility {
	 private Workbook workbook;
	private FileInputStream fisExcel;
	/**
	 * this  method is used to open excel
	 */
	public void openExcel()
	{
		try {
		fisExcel = new FileInputStream(IConstantPath.EXCEL_PATH);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		workbook=WorkbookFactory.create(fisExcel);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	/**
	 * this method is used to fetch  data from excel file
	 * @param sheetname
	 * @param rownumber
	 * @param cellnumber
	 * @return
	 */
	public String getDataFromExcel(String sheetname, int rownumber,int cellnumber)
	{
		
		
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetname).getRow(rownumber).getCell(cellnumber));
		return data;
	}
	public void closeExcel()
	{
		try {
			fisExcel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
