package com.tyss.practice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.coredropship.genericUtility.ExcelUtility;
import com.coredropship.genericUtility.FileUtility;
import com.coredropship.genericUtility.JavaUtility;
import com.coredropship.genericUtility.PropertyFileKeys;
import com.coredropship.genericUtility.SheetName;
import com.coredropship.genericUtility.WebDriverUtility;

public class Tc1A 
{
	public static void main(String[] args) 
	{

	    //create obj for generic utility
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility =new ExcelUtility();
		JavaUtility javautility=new JavaUtility();
		WebDriverUtility webdriverutility=new WebDriverUtility();
		
		//read data from property file
		String browser=fileUtility.getDataFromProprtyFile(
				PropertyFileKeys.BROWSER.convertToString());
		String url=fileUtility.getDataFromProprtyFile( 
				PropertyFileKeys.URL.convertToString());
		//System.out.println(url);
		
		String username=fileUtility.getDataFromProprtyFile(
				PropertyFileKeys.USERNAME.convertToString());
		
		String password=fileUtility.getDataFromProprtyFile(
				PropertyFileKeys.PASSWORD.convertToString());
		
		String timeout1 = fileUtility.getDataFromProprtyFile(PropertyFileKeys.TIMEOUT.convertToString());
		Long timeout = (Long) javautility.StringToAnyDataType(timeout1, "long");
		System.out.println(timeout);
		
		String randomNumberLimit = fileUtility.getDataFromProprtyFile(
				PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());
		
		//read data from excel file
		String actualID = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(), 2, 1);
		WebDriver driver=webdriverutility.launchapplication(browser, timeout, url);
		String pName = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(), 2, 2);
		String description = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(), 2, 3);
		String qnt = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(),2 , 4);
		String onHand = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(),2 , 5);
		String price = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(), 2, 6);
		String ctg = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 7);
		String supplier = excelUtility.getDataFromExcel(SheetName.PRODUCT.toString(), 2, 8);
		String dateStockIn = excelUtility.getDataFromExcel( SheetName.PRODUCT.toString(), 2, 9);
		//open the browser
		//WebDriver driver=webdriverutility.launchapplication(browser, timeout, url);*/
		
		//login to app
		driver.findElement(By.name("user")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnlogin")).click();
		
        //after login handle alert pop-up
		Alert a=driver.switchTo().alert();
		a.accept();
		
		//click on product module 
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//div[@class='card-header py-3']/h4/a")).click();
		
		//enter all details of product
		driver.findElement(By.name("prodcode")).sendKeys(actualID);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(pName);
		String productcode="1450";
		
		driver.findElement(By.xpath("//h5[.='Add Product']/../following::div[@class='form-group']/child::textarea")).sendKeys(description);
		
		driver.findElement(By.name("quantity")).sendKeys(qnt);
		driver.findElement(By.name("onhand")).sendKeys(onHand);
		driver.findElement(By.name("price")).sendKeys(price);
		
		WebElement ctg1 = driver.findElement(By.name("category"));
		Select s=new Select(ctg1);
		s.selectByValue("9");
		
		WebElement sup = driver.findElement(By.name("supplier"));
		Select s1=new Select(sup);
		s1.selectByValue("16");
		
		   driver.findElement(By.name("datestock")).click();
		   driver.findElement(By.name("datestock")).sendKeys(dateStockIn);
		  
		   driver.findElement(By.xpath("//h5[text()='Add Product']/../../div[2]/form/button[@type='submit']")).click();
		   
		  //after submitting all details check whether product is created or not
		   driver.findElement(By.xpath("//span[text()='Product']")).click();
		  
		  List<WebElement>pid=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		  boolean flag=false;
		   for(int i=0;i<pid.size();i++)
		   {
			   String id=pid.get(i).getText();
			   if(id.equals(productcode))
			   {
				   System.out.println("pass>>>> product created suucessfully");
				   flag=true;
				   break;
			   }
		   }
		   if(!flag) {
			   System.out.println("test case is failed");
		   }
		
		}
		

}
