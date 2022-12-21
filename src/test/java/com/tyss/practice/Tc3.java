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

public class Tc3 
{
	static WebDriver driver=null;

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/commondata.property");
		try {
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
		driver.get(url);
		
		driver.findElement(By.name("user")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("btnlogin")).click();
		
		Alert a=driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//div[@class='card-header py-3']/h4/a")).click();
		driver.findElement(By.name("prodcode")).sendKeys(productCode);
		driver.findElement(By.name("name")).sendKeys(productName);
		//String productname="samsung phone";
		
		driver.findElement(By.xpath("//h5[.='Add Product']/../following::div[@class='form-group']/child::textarea")).sendKeys(productDesc);
		
		driver.findElement(By.name("quantity")).sendKeys(productQnt);
		driver.findElement(By.name("onhand")).sendKeys(productOnHand);
		driver.findElement(By.name("price")).sendKeys(productPrice);
		
		WebElement ctg = driver.findElement(By.name("category"));
		Select s=new Select(ctg);
		s.selectByValue("7");
		
		WebElement sup = driver.findElement(By.name("supplier"));
		Select s1=new Select(sup);
		s1.selectByValue("12");
		
		String exceptedid="8";
		   driver.findElement(By.name("datestock")).click();
		   driver.findElement(By.name("datestock")).sendKeys(productDateStockIn);
		  
		   driver.findElement(By.xpath("//h5[text()='Add Product']/../../div[2]/form/button[@type='submit']")).click();
		   
		   driver.findElement(By.xpath("//span[text()='Product']")).click();
		   
		   List<WebElement>pid=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<WebElement> editLInk =driver.findElements(By.xpath("//table/tbody/tr/td[5]/div/div/a"));
		   for(int i=0;i<pid.size();i++)
		   {
			  String pid1=pid.get(i).getText();
			  if(pid1.equals(exceptedid))
			  {
				  editLInk.get(i).click();
				  break;
			  }
		   }
		
	
		   driver.findElement(By.xpath("//ul[@class='dropdown-menu text-center show']//a[@class='btn btn-warning bg-gradient-warning btn-block']")).click();
		   driver.findElement(By.name("prodname")).clear();
		   driver.findElement(By.name("prodname")).sendKeys(productName);
		 WebElement w  =driver.findElement(By.name("category"));
		 Select s2=new Select(w);
		 s2.selectByValue("9");
		   driver.findElement(By.xpath("//button[@class='btn btn-warning btn-block']")).click();
		   String actualtxt = "You've Update Product Successfully.";
		   Alert b=driver.switchTo().alert();
		   String exptxt = b.getText();
		   b.accept();
		   if(exptxt.equals(actualtxt))
		   {
			   System.out.println(" test pass>>>>>>");
		   }
		   
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		finally {
			fis.close();
			driver.close();
			
		}
	

}
}
