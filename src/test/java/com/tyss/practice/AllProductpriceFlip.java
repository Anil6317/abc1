package com.tyss.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllProductpriceFlip 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		//driver.findElement(By.name("q")).sendKeys("iphone"+Keys.ENTER);
		List<WebElement>pname=driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../following-sibling::div/div/div/div/a/div[2]/div[1]/div[1]"));
		List<WebElement>Pprice=driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../following-sibling::div/div/div/div/a/div[2]/div[2]/div[1]/div[1]/div[1]"));
		int count = Pprice.size();
		for(int i=0;i<count;i++)
		{
			String name = pname.get(i).getText();
			String price = Pprice.get(i).getText();
			System.out.println(name+ ">>>>>>>>"+price);
		}
}
		
		
		
	}


