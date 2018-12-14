package com.experiment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {

		// Set up chrome driver path
		WebDriverManager.chromedriver().setup();

		// invoke selenium webdriver
		WebDriver driver = new ChromeDriver();

		// fullscreen
		//driver.manage().window().fullscreen();

		// Set universal wait time in case web page is slow
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * Strep 1 Launch browser and navigate to http://www.dice.com Expected: dice
		 * home page should be displayed.
		 */
		String url = "http://www.dice.com";
		driver.get(url);
		// driver.navigate().to("http://www.dice.com");
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Find Jobs in Tech | Dice.com";
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		    throw new RuntimeException("Step Fail. dice homepage did not load Successfully");
		    
		}

		driver.findElement(By.id("search-field-keyword")).clear();
		String keyword="Automation engeener";
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
	
		String location="22102";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();
		
		String count= driver.findElement(By.id("posiCountId")).getText();  
		
		int countResult =Integer.parseInt(count.replaceAll(",",""));
		
		if (countResult>0) {
			System.out.println("Step PASS: keyword: "+keyword+
					", search return: "+ countResult+", result in "+location);
		}else {
			System.out.println("Step Fail: keyword: "+keyword+
					", search return: "+ countResult+", result in "+location);
			
		}
		
		
		
		driver.close();
		System.out.println("TEST COMPLITED");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
