package com.unicommerce;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main (String[] args)  {
		 
		//System.setProperty("webdriver.chrome.driver", "//Users//bpoonia//Downloads//chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();		 
		driver.get("http://www.flipkart.com");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		 
		}
	 



}


