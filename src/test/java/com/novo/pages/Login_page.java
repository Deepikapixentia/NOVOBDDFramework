package com.novo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page extends BasePage{


	    public Login_page(WebDriver driver) {
	        super(driver);
	      
	        addObject("UsernameField", By.xpath("//input[@formcontrolname='username']")); 
	        addObject("PasswordField", By.xpath("//input[@formcontrolname='password']"));
	        addObject("LoginButton", By.xpath("//button[@type='submit']"));
	    }

	 
	    public void enterUsername(String username) {
	      
	        type("UsernameField", username); 
	    }

	    public void enterPassword(String password) {
	        type("PasswordField", password);
	    }

	    public void clickLogin() {
	        click("LoginButton");
	    }
	}

