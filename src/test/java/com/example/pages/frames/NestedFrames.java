package com.example.pages.frames;

import com.example.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFrames extends BasePage {

    @FindBy(css = "frame[name='frame-top']")
    private WebElement topItem;

    @FindBy(css = "frame[name='frame-left']")
    private WebElement leftItem;

    @FindBy(css = "frame[name='frame-middle']")
    private WebElement middleItem;

    @FindBy(css = "frame[name='frame-right']")
    private WebElement rightItem;

    @FindBy(css = "frame[name='frame-bottom']")
    private WebElement bottomItem;

    public NestedFrames(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(topItem);
    }

    private String getTextFromFrame(WebElement rootFrame, WebElement frame){
        if (rootFrame!=null) {
            driver.switchTo().frame(rootFrame);
        }
        driver.switchTo().frame(frame);
        String text = driver.findElement(By.cssSelector("body")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public void getTexts() {
        System.out.println(getTextFromFrame(topItem, leftItem));
        System.out.println(getTextFromFrame(topItem, middleItem));
        System.out.println(getTextFromFrame(topItem, rightItem));
        System.out.println(getTextFromFrame(null, bottomItem));
    }
}
