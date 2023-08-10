package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.NotActiveException;


public class CheckboxesPage extends BasePage {

    @FindBy(css = "input[type = 'checkbox']:nth-child(1)")
    private WebElement checkboxOne;

    @FindBy(css = "input[type = 'checkbox']:nth-child(3)")
    private WebElement checkboxTwo;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(checkboxOne);
    }

    public void checkBoxOneCheck() {
        checkboxOne.click();
    }

    public void checkBoxTwoCheck() {
        checkboxTwo.click();
    }

    public boolean isCheckBoxOneChecked() {
        return checkboxOne.isSelected();
    }

    public boolean isCheckBoxTwoChecked() {
        return checkboxTwo.isSelected();
    }


}
