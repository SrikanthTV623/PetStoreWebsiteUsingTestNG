package com.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String takeScreenshot(String testName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);

        String fileName =
                testName + "_"
                        + System.currentTimeMillis()
                        + ".png";

        String filePath =
                System.getProperty("user.dir")
                        + "/screenshots/"
                        + fileName;

        File destination = new File(filePath);

        FileUtils.copyFile(source, destination);

        return filePath;
    }
}
