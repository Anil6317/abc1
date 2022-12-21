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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc4 
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
			
			
			GenericForExcel g=new GenericForExcel();
			String firstName = g.getExcelData("product", 5,10 );
			System.out.println(firstName);
			String lastName = g.getExcelData("product", 5, 11);
			System.out.println(lastName);
			String phoneNumber = g.getExcelData("product", 5, 12);
			System.out.println(phoneNumber);
			//String phoneNumber = g.getExcelData("product", 5, 12);
			//System.out.println(phoneNumber);
					
			
		/*	FetchingDataUsingKey f=new FetchingDataUsingKey();
			String firstName=f.fetchExcelData("product", "CreateProductTest4", "First name");
			System.out.println(firstName);
			String lasttName=f.fetchExcelData("product", "CreateProductTest4", "last name");
			String phoneNumber=f.fetchExcelData("product", "CreateProductTest4", "phone number");
			System.out.println( phoneNumber);
		System.out.println(lasttName);
		System.out.println();*/
			
		
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
			
			driver.findElement(By.xpath("//span[text()='Customer']")).click();
			driver.findElement(By.xpath("//a[@data-target='#customerModal']")).click();
			driver.findElement(By.name("firstname")).sendKeys(firstName);
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			driver.findElement(By.name("phonenumber")).sendKeys(phoneNumber);
			driver.findElement(By.xpath("(//form[@role='form']/descendant::button[@type='submit'])[1]")).click();
			
			driver.findElement(By.xpath("//span[text()='Customer']")).click();
		
			List<WebElement>expectedName=driver.findElements(By.xpath("//table/tbody//tr[3]/td[1]"));
			for(int i=0;i<expectedName.size();i++)
			{
				String data = expectedName.get(i).getText();
				System.out.println(data);
				if(firstName.equals(data))
				{
					System.out.println("pass");
					
					
				}
			}
			}
			catch(Exception e)
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
