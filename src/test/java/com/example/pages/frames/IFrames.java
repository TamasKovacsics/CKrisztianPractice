package com.example.pages.frames;

import com.example.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrames extends BasePage {

    @FindBy(css = "iframe[id='mce_0_ifr']")
    private WebElement iFrameWindow;

    public IFrames(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(iFrameWindow);
    }

    private String getTextFromIFrame(WebElement element) {
        driver.switchTo().frame(element);
        return waitForElementToAppear(By.cssSelector("p")).getText();
    }

    public void getTexts() {
        System.out.println(getTextFromIFrame(iFrameWindow));
    }
}
