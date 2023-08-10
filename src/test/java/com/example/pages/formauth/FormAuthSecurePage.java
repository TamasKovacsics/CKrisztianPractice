package com.example.pages.formauth;

import com.example.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAuthSecurePage extends BasePage {


    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    public FormAuthSecurePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(logoutButton);
    }

    public void logoutButtonClick() {
        logoutButton.click();
    }
}
