package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class KeyPresses extends BasePage {

    public KeyPresses(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void sendKeysToInput() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
        sleep(1000);
    }
}
