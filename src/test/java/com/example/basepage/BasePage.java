package com.example.basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.awt.color.ICC_ColorSpace;

public abstract class BasePage extends LoadableComponent {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.get();
    }

    @Override
    protected void load() {

    }

    public WebElement waitForElementToAppear(WebElement element) {
        for(int i = 0; i <= 150; i++) {
            try {
                element.getText();
                return element;
            } catch (NoSuchElementException e) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        throw new AssertionError("Element did not appear");
    }

    public WebElement waitForElementToAppear(By locator) {
        for(int i = 0; i <= 150; i++) {
            try {
                driver.findElement(locator).getText();
                return driver.findElement(locator);
            } catch (NoSuchElementException e) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        throw new AssertionError("Element did not appear");
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        for(int i = 0; i <= 150; i++) {
            try {
                if(element.isDisplayed())
                    return;
                else {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } catch (NoSuchElementException e) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
