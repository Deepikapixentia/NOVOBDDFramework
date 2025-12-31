package com.novo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtils {

    public String getProperty(String key) {
        FileInputStream fis1 = null;
        try {
            // FIX: Include the folder AND the filename
            fis1 = new FileInputStream("src/test/resources/application_properties/novo.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties prop = new Properties();
        try {
            prop.load(fis1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
    
    public static byte[] takeScreenshot(WebDriver driver, String scenarioName) {
        // 1. Prepare the Timestamp
        String pattern = "yyyy-MM-dd_HH-mm-ss"; 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        // 2. Define the File Path
        // System.getProperty("user.dir") gives the project root folder
        String screenshotFileName = scenarioName.replaceAll(" ", "_") + "_" + date + ".png";
        String screenshotFilePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + screenshotFileName;

        File destinationFile = new File(screenshotFilePath);

        // 3. Capture the Screenshot as a FILE (for local storage)
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // 4. Capture the Screenshot as BYTES (for the Report)
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        try {
            // Save to local folder
            FileUtils.copyFile(srcFile, destinationFile);
            System.out.println("Screenshot saved at: " + screenshotFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return bytes so we can attach to the report
        return screenshotBytes;
    }
}
