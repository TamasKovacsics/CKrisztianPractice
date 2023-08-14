package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindows extends BasePage {

    @FindBy(css = "a[href='/windows/new']")
    private WebElement link;

    public MultipleWindows(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(link);
    }

    public void clickLink() {
        String originalWindow = driver.getWindowHandle();
        link.click();
        for(String windowHandle: driver.getWindowHandles()){
            if(!originalWindow.contentEquals(windowHandle)){
                driver.switchTo().window(windowHandle);
                System.out.println(driver.findElement(By.cssSelector("h3")).getText());
                break;
            }
        }
    }
}
