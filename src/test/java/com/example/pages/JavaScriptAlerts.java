package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlerts extends BasePage {

    @FindBy(css = "button[onclick='jsAlert()']")
    private WebElement jsAlertButton;

    @FindBy(css = "button[onclick='jsConfirm()']")
    private WebElement jsConfirmButton;

    @FindBy(css = "button[onclick='jsPrompt()']")
    private WebElement jsPromptButton;

    private Alert alert;

    public JavaScriptAlerts(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void clickJsAlertButton() {
        jsAlertButton.click();
        alert = driver.switchTo().alert();
        sleep(1000);
        alert.accept();
    }

    public void clickJsConfirmButton() {
        jsConfirmButton.click();
        alert = driver.switchTo().alert();
        sleep(1000);
        alert.dismiss();

        jsConfirmButton.click();
        alert = driver.switchTo().alert();
        sleep(1000);
        alert.accept();
    }

    public void clickPromptButton() {
        jsPromptButton.click();
        alert = driver.switchTo().alert();
        sleep(1000);
        alert.sendKeys("Hello World!");
        alert.dismiss();

        jsPromptButton.click();
        alert = driver.switchTo().alert();
        sleep(1000);
        alert.sendKeys("Hello World!");
        alert.accept();
        sleep(2000);
    }
}
