package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends BasePage {

    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void authButtonClick() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
