package com.novo.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.novo.base.BaseTest;
import com.novo.pages.Login_page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdef extends BaseTest  {

	    Login_page loginPage;

	    @Given("user launched the browser")
	    public void user_launched_the_browser() {
	        // Initializes the driver (Chrome/Edge) defined in BaseTest
	        BaseTest.getDriver(); 
	    }

	    @And("user launched the application URL")
	    public void user_launched_the_application_url() {
	        // Uses the method in BaseTest to load URL from properties file
	        launchApplication(); 	        
	        loginPage = new  Login_page(driver);
	    }

	    @When("user enters username data {string} in username field")
	    public void user_enters_username_data_in_username_field(String username) {
	        loginPage.enterUsername(username);
	    }

	    @And("user enters password data {string} in password field")
	    public void user_enters_password_data_in_password_field(String password) {
	        loginPage.enterPassword(password);
	    }

	    @And("user clicks on the Login button")
	    public void user_clicks_on_the_login_button() {
	        loginPage.clickLogin();
	    }

	    @Then("user redirects to {string} page")
	    public void user_redirects_to_page(String expectedPageTitle) {
	        String actualTitle = driver.getTitle();
	        
	        // Using JUnit 5 Assertions
	        Assertions.assertTrue(actualTitle.contains(expectedPageTitle), 
	            "Expected title to contain: " + expectedPageTitle + " but got: " + actualTitle);
	        	    
	    }
	}

