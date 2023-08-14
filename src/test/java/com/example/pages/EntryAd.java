package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryAd extends BasePage {

    @FindBy(css = "div[id='modal']")
    private WebElement adWindow;
    @FindBy(css = "div[class='modal-footer']")
    private WebElement closeButton;
    public EntryAd(WebDriver driver, boolean isWindowAppear) {
        super(driver);
        if (isWindowAppear) {
            waitForElementToBeDisplayed(adWindow);
        }
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(adWindow);
    }

    public void entryAdClose() {
        closeButton.click();
    }

    public boolean isAdVisible() {
        return adWindow.isDisplayed();
    }
}
