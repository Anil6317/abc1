package com.tyss.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int rowcount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colcount = driver.findElements(By.xpath("//table[@id='customers']//tr//th")).size();
		System.out.println("rows>>>>>" + rowcount +  "   columns>>>>"+ colcount);
		String expected = "Island Trading";
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<=colcount;j++)
			{
				String actual = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[5]/td[1]")).getText();
				{
					if(actual.equals(expected))
					{
						System.out.println(actual);
						break;
					}
				}
				
			}
		}
		
	}

}
