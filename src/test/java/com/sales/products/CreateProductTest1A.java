package com.sales.products;
////
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.coredropship.genericUtility.ExcelUtility;
import com.coredropship.genericUtility.FileUtility;
import com.coredropship.genericUtility.IConstantPath;
import com.coredropship.genericUtility.JavaUtility;
import com.coredropship.genericUtility.PropertyFileKeys;
import com.coredropship.genericUtility.SheetName;
import com.coredropship.genericUtility.WebDriverUtility;
import com.coredropship.objectRepository.AddProductPage;
import com.coredropship.objectRepository.CommonPage;
import com.coredropship.objectRepository.CreateProductPage;
import com.coredropship.objectRepository.LoginPage;

public class CreateProductTest1A 
{
	public static void main(String[] args) throws InterruptedException
	{
		//create obj for generic utility
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility =new ExcelUtility();
		JavaUtility javautility=new JavaUtility();
		WebDriverUtility webdriverutility=new WebDriverUtility();

		//open property file and read data from property file
		fileUtility.openPropertyFile();
		String browser=fileUtility.getDataFromProprtyFile(PropertyFileKeys.BROWSER.convertToString());
		String url=fileUtility.getDataFromProprtyFile( PropertyFileKeys.URL.convertToString());
		String username=fileUtility.getDataFromProprtyFile(PropertyFileKeys.USERNAME.convertToString());
		String password=fileUtility.getDataFromProprtyFile(PropertyFileKeys.PASSWORD.convertToString());
		String timeout1 = fileUtility.getDataFromProprtyFile(PropertyFileKeys.TIMEOUT.convertToString());
		Long timeout = (Long) javautility.StringToAnyDataType(timeout1, "long");
		System.out.println(timeout);
		String randomNumberLimit = fileUtility.getDataFromProprtyFile(PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());

		//open the excel file
		excelUtility.openExcel();

		//read data from excel file
		String actualID = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 1);
		String pName = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 2);
		String description = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 3);
		String qnt = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(),2 , 4);
		String onHand = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(),2 , 5);
		String price = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 6);
		String ctg = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 7);
		String supplier = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 8);
		String dateStockIn = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 9);

		//open the browser
		WebDriver driver=webdriverutility.launchapplication(browser, timeout, url);

		//create obj for pom classes like for login,creating product etc

		LoginPage login=new LoginPage(driver);
		CommonPage commonpage=new CommonPage(driver);
		CreateProductPage createproductpage=new CreateProductPage(driver);
		AddProductPage addproductpage=new AddProductPage(driver);
		login.loginAction(username,password);

		//after login handle alert pop-up
		webdriverutility.switch_to_alert_accept();

		commonpage.clickProduct();
		createproductpage.clickOnAddIconForProduct();
		addproductpage.pCode(actualID);
		addproductpage.pName(pName);
		addproductpage.pDescription(description);
		addproductpage.pQuant(qnt);
		addproductpage.inHandProd(onHand);
		addproductpage.pPrice(price);	
		addproductpage.pCategory(webdriverutility, ctg);
		addproductpage.pSupplier(webdriverutility, supplier);
		webdriverutility.scrollToBottomOfPage();
		addproductpage.pDateStock(webdriverutility,timeout,dateStockIn);
		addproductpage.saveButton();
		commonpage.clickProduct();
		addproductpage.compareID(actualID);
		fileUtility.closePropertyFile();
		excelUtility.closeExcel();
		webdriverutility.closeBrowser();




	}

}
