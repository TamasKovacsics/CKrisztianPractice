package com.example.pages.dynamicloading;

import com.example.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {



    @FindBy(css = "a[href='/dynamic_loading/1']")
    private WebElement exampleOneLink;

    @FindBy(css = "a[href='/dynamic_loading/2']")
    private WebElement exampleTwoLink;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(exampleOneLink);
    }

    public DynamicLoadingPageOne clickExampleOneLink() {
        exampleOneLink.click();
        return new DynamicLoadingPageOne(driver);
    }

    public DynamicLoadingPageTwo clickExampleTwoLink() {
        exampleTwoLink.click();
        return new DynamicLoadingPageTwo(driver);
    }

}
