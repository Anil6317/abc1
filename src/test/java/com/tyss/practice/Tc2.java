package com.tyss.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc2 {
	static WebDriver driver=null;

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/commondata.property");
		try{
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		
		FetchingDataUsingKey f=new FetchingDataUsingKey();
		String productCode=f.fetchExcelData("product", "CreateProductTest1", "Product code");
		String productName=f.fetchExcelData("product", "CreateProductTest1", "Product name");
		String productDesc=f.fetchExcelData("product", "CreateProductTest1", "Description");
		String productQnt=f.fetchExcelData("product", "CreateProductTest1", "Quantity");
		String productOnHand=f.fetchExcelData("product", "CreateProductTest1", "On Hand");
		String productPrice=f.fetchExcelData("product", "CreateProductTest1", "Price");
		String productCtg=f.fetchExcelData("product", "CreateProductTest1", "Category");
		String productSupplier=f.fetchExcelData("product", "CreateProductTest1", "Supplier");
		String productDateStockIn=f.fetchExcelData("product", "CreateProductTest1", "Date Stock In");
		

		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/index.php");
		
		driver.findElement(By.name("user")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("btnlogin")).click();
		
		Alert a=driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//div[@class='card-header py-3']/h4/a")).click();
		driver.findElement(By.name("prodcode")).sendKeys(productCode);
		driver.findElement(By.name("name")).sendKeys(productName);
		String productname="samsung phone";
		
		driver.findElement(By.xpath("//h5[.='Add Product']/../following::div[@class='form-group']/child::textarea")).sendKeys(productDesc);
		
		driver.findElement(By.name("quantity")).sendKeys(productQnt);
		driver.findElement(By.name("onhand")).sendKeys(productOnHand);
		driver.findElement(By.name("price")).sendKeys(productPrice);
		
		WebElement ctg = driver.findElement(By.name("category"));
		Select s=new Select(ctg);
		s.selectByValue("0");
		
		WebElement sup = driver.findElement(By.name("supplier"));
		Select s1=new Select(sup);
		s1.selectByValue("35");
		
		   driver.findElement(By.name("datestock")).click();
		   driver.findElement(By.name("datestock")).sendKeys(productDateStockIn);
		  
		   driver.findElement(By.xpath("//h5[text()='Add Product']/../../div[2]/form/button[@type='submit']")).click();
		   driver.findElement(By.xpath("//span[text()='Inventory']")).click();
		   driver.findElement(By.xpath("//input[@type='search']")).click();
		   Thread.sleep(6000);
		   driver.findElement(By.xpath("//input[@type='search']")).sendKeys(productName);
		   
		   List<WebElement>pname=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		   for(int i=0;i<pname.size();i++)
		   {
			  String name = pname.get(i).getText();
			System.out.println("erroe");
			  if(name.equals(productname))
			  {
				  System.out.println("test passed" );
				  break;
			  }
			  
		   }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
			driver.quit();
		}
		   
	}


}
