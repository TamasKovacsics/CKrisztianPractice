package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScroll extends BasePage {



    public InfiniteScroll(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void scrolling() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for(int i = 0; i<500; i++)
            jse.executeScript("window.scrollBy(0,200)","");

    }
}
