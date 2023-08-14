package com.example;

import com.example.constants.Constants;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import testbase.TestBase;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        WebDriver driver = ((TestBase) extensionContext.getTestInstance().get()).getDriver();
        if (extensionContext.getExecutionException().isPresent()) {
            screenShot(driver);
        }
    }

    public void screenShot(WebDriver driver) {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(screenshot, new File(Constants.SCREENSHOT_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
