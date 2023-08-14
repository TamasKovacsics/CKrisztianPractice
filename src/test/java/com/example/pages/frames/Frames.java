package com.example.pages.frames;

import com.example.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frames extends BasePage {

    @FindBy(css = "a[href='/nested_frames']")
    private WebElement nestedFramesLink;

    @FindBy(css = "a[href='/iframe']")
    private WebElement iFrameLink;

    public Frames(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(nestedFramesLink);
    }

    public NestedFrames clickNestedFrames() {
        nestedFramesLink.click();
        return new NestedFrames(driver);
    }

    public IFrames clickIFrames() {
        iFrameLink.click();
        return new IFrames(driver);
    }
}
