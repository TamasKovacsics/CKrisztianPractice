package com.example.pages.formauth;

import com.example.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAuthPage extends BasePage {

    @FindBy(css = "input[id='username']")
    private WebElement inputUsername;

    @FindBy(css = "input[id='password']")
    private WebElement inputPassword;

    @FindBy(css = "button[class='radius']")
    private WebElement loginButton;

    @FindBy(css = "div[class='flash error']")
    private WebElement errorMessage;


    public static String username = "tomsmith";
    public static String password = "SuperSecretPassword!";

    public static String wrongPassword = "admin";

    public FormAuthPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(inputUsername);
    }

    public void enterUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    private void clickLogin() {
        loginButton.click();
    }

    public FormAuthSecurePage loginButtonClick() {
        clickLogin();
        return new FormAuthSecurePage(driver);
    }

    public FormAuthPage loginButtonClickWrongCredentials() {
        clickLogin();
        return new FormAuthPage(driver);
    }

    public String getErrorMessage() {
        return errorMessage.getText().trim();
    }
}
