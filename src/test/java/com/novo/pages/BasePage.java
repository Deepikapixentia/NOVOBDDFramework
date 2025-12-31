package com.novo.pages;

import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions; 
import com.novo.base.BaseTest;

public class BasePage extends BaseTest {
    
    WebDriver driver;
    WebDriverWait wait; 
    HashMap<String, By> objectRepo = new HashMap<String, By>();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        long waitTime = Long.parseLong(common.getProperty("explicitwait")); 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

    public void addObject(String logicalName, By by) {
        objectRepo.put(logicalName, by);
    }

    public void type(String logicalName, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectRepo.get(logicalName)));
        getElement(logicalName).sendKeys(text);
    }

    public void click(String logicalName) {
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.get(logicalName)));
        getElement(logicalName).click();
    }

    public void validateTitle(String expTitle) {
        try {
            wait.until(ExpectedConditions.titleIs(expTitle));
            Assertions.assertEquals(expTitle, driver.getTitle());
        } catch (Exception e) {
            Assertions.fail("Title mismatch! Expected: " + expTitle + " Actual: " + driver.getTitle());
        }
    }
    
    private WebElement getElement(String logicalName) {
        return driver.findElement(objectRepo.get(logicalName));
    }
}