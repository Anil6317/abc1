package com.tyss.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchPriceOfProduct {

	public static void main(String[] args) 
	{
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver =new ChromeDriver();
	   driver.get("https://www.amazon.in/s?k=mobile+under+15000&rh=n%3A1389432031&ref=nb_sb_noss");
	   driver .manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   List<String>productlist=new ArrayList<String>();
	  productlist.add("Samsung Galaxy M13 (Aqua Green, 6GB, 128GB Storage) | 6000mAh Battery | Upto 12GB RAM with RAM Plus");
	   productlist.add("Samsung Galaxy M53 5G (Emerald Brown, 6GB, 128GB Storage) | 108MP | sAmoled+ 120Hz | 12GB RAM with RAM Plus | Travel Adapter to be Purchased Separately");
	    productlist.add("Redmi A1 (Light Blue, 2GB RAM, 32GB Storage) | Helio A22 | 5000 mAh Battery | 8MP AI Dual Cam | Leather Texture Design | Android 12");
	  productlist.add("Redmi 9A Sport (Coral Green, 2GB RAM, 32GB Storage) | 2GHz Octa-core Helio G25 Processor | 5000 mAh Battery");
	   for(String productname:productlist)
	   {
	 String price=driver.findElement(By.xpath("//span[text()='"+productname+"']/ancestor::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/following-sibling::div[@class='sg-row']/descendant::span[@class='a-price-whole']")).getText();
		System.out.println(price);   
	   }
		

	}

}
