package com.example.pages.dynamicloading;

import com.example.basepage.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPageOne extends BasePage {

    @FindBy(css = "button")
    private WebElement startButton;

    @FindBy(css = "div[id='finish']")
    private WebElement text;

    @FindBy(css = "h3")
    private WebElement heading;

    public DynamicLoadingPageOne(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(heading);
    }

    public void startButtonClick() {
        startButton.click();
        waitForElementToBeDisplayed(text);
    }

    public boolean isTextDisplayed() {
        return text.isDisplayed();
    }
}
