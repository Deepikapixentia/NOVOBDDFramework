package com.novo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.novo.exceptions.InvalidBrowserException;
import com.novo.util.CommonUtils;

public class BaseTest {

		
		public static WebDriver driver;
		
		public static CommonUtils common=new CommonUtils();

		
		public static WebDriver getDriver(){
			if(driver==null)
			{
			String browserName=common.getProperty("browser");
			
			switch (browserName) {
			case "chrome":
				driver = new ChromeDriver();				
				break;

			case "firefox":
				driver = new FirefoxDriver();				
				break;

			case "edge":
				driver = new EdgeDriver();
				
				break;

			default:
				try {
					throw new InvalidBrowserException();
				} catch (InvalidBrowserException e) {
					System.out.println(e.getMessage());
				}

				break;
			}			
			}
			return driver;			
		}		
				
		public static void launchApplication(){			
			driver=BaseTest.getDriver();		
			driver.get(common.getProperty("URL"));				
			driver.manage().window().maximize();
		}
		
	}