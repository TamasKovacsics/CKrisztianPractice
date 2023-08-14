package com.example.pages;

import com.example.basepage.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Hover extends BasePage {

    @FindBy(css = "div.example > div:nth-child(3) img")
    private WebElement imgFirst;

    @FindBy(css = "div.example > div:nth-child(4) img")
    private WebElement imgSecond;

    @FindBy(css = "div.example > div:nth-child(5) img")
    private WebElement imgThird;

    @FindBy(css = "div.example > div:nth-child(3) div > h5")
    private WebElement textFirst;

    @FindBy(css = "div.example > div:nth-child(4) div > h5")
    private WebElement textSecond;

    @FindBy(css = "div.example > div:nth-child(5) div > h5")
    private WebElement textThird;

    public Hover(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(imgFirst);
    }

    public void clickFirst() {
        clickToImg(imgFirst, textFirst);
    }

    public void clickSecond() {
        clickToImg(imgSecond, textSecond);
    }

    public void clickThird() {
        clickToImg(imgThird, textThird);
    }

    public boolean isFirstVisible() {
        return isTextVisible(textFirst);
    }

    public boolean isSecondVisible() {
        return isTextVisible(textSecond);
    }

    public boolean isThirdVisible() {
        return isTextVisible(textThird);
    }

    private void clickToImg(WebElement element, WebElement text) {
        Actions action = new Actions(driver);

        action.click(element).build().perform();
        if(isTextVisible(text))
            System.out.println(text.getText());
    }

    private boolean isTextVisible(WebElement text) {
        return text.isDisplayed();
    }
}
