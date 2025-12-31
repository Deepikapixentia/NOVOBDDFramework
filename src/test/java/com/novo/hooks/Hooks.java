package com.novo.hooks;

import com.novo.base.BaseTest;
import com.novo.util.CommonUtils; // Import your utils
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    @Before
    public void setup() {
        launchApplication();
    }

    @After
    public void tearDown(Scenario scenario) {
        
        if (scenario.isFailed()) {
            // Call the CommonUtils method
            // This method saves the file locally AND returns the bytes
            byte[] screenshot = CommonUtils.takeScreenshot(driver, scenario.getName());
            
            // Attach the bytes to the Extent Report / Cucumber Report
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}