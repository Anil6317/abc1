package com.tyss.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("testing");////ul[@role='listbox']//li/descendant::div[@class='wM6W7d']
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{	
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("testing course"))
			{
				list.get(i).click();
				break;
			}
		}

	}

}


