package com.sales.products;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.coredropship.genericUtility.ExcelUtility;
import com.coredropship.genericUtility.FileUtility;
import com.coredropship.genericUtility.IConstantPath;
import com.coredropship.genericUtility.JavaUtility;
import com.coredropship.genericUtility.PropertyFileKeys;
import com.coredropship.genericUtility.SheetName;
import com.coredropship.genericUtility.WebDriverUtility;
import com.coredropship.objectRepository.AddCustomerDetailsPage;
import com.coredropship.objectRepository.CommonPage;
import com.coredropship.objectRepository.CreateCustomerPage;
import com.coredropship.objectRepository.LoginPage;

public class CreateProductTest4New 
{

	public static void main(String[] args) 
	{
		//create obj for generic utility
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility =new ExcelUtility();
		JavaUtility javautility=new JavaUtility();
		WebDriverUtility webdriverutility=new WebDriverUtility();

		//open and read data from property file
		fileUtility.openPropertyFile();
		String browser=fileUtility.getDataFromProprtyFile(PropertyFileKeys.BROWSER.convertToString());
		String url=fileUtility.getDataFromProprtyFile(PropertyFileKeys.URL.convertToString());
		String username=fileUtility.getDataFromProprtyFile(PropertyFileKeys.USERNAME.convertToString());
		String password=fileUtility.getDataFromProprtyFile(PropertyFileKeys.PASSWORD.convertToString());
		String timeout1 = fileUtility.getDataFromProprtyFile(PropertyFileKeys.TIMEOUT.convertToString());
		Long timeout = (Long) javautility.StringToAnyDataType(timeout1, "long");
		String randomNumberLimit = fileUtility.getDataFromProprtyFile(PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());

		// open excel and read data from excel
		excelUtility.openExcel();
		String fName = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(), 5, 10);
		String lName = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(), 5, 11);
		String pNumber = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(), 5, 12);

		//open browser
		WebDriver driver=webdriverutility.launchapplication(browser, timeout, url);

		LoginPage login=new LoginPage(driver);
		CommonPage commonpage=new CommonPage(driver);
		CreateCustomerPage createcustomerpage=new CreateCustomerPage(driver);
		AddCustomerDetailsPage addcustomerdetailspage=new AddCustomerDetailsPage(driver);

		//login by entering user name and password and click on login
		login.loginAction(username, password);

		//handle alert pop-up
		webdriverutility.switch_to_alert_accept();

		//click on customer module
		commonpage.clickCustomer();

		//click on + symbol to add customer details 
		createcustomerpage.clickOnAddIconForCustomer();

		//enter customer details like first name ,last name and phno etc then click on save button
		addcustomerdetailspage.customerFirstName(fName);
		addcustomerdetailspage.customerLastName(lName);
		addcustomerdetailspage.customerPhoneNumber(pNumber);		
		addcustomerdetailspage.saveCustomerDetails();
		addcustomerdetailspage.verifyCustomer(fName);
		fileUtility.closePropertyFile();
		excelUtility.closeExcel();
		webdriverutility.closeBrowser();



	}

}

