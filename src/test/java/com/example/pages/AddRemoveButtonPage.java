package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemoveButtonPage extends BasePage {

    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addButton;

    @FindBy(css = "button.added-manually[onclick='deleteElement()']")
    private WebElement removeButton;

    public AddRemoveButtonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(addButton);
    }

    public void addButtonClick() {
        addButton.click();
    }

    public void removeButtonClick() {
        removeButton.click();
    }

    public boolean isDeleteButtonPresent() {
        try {
            removeButton.getText();
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }
}
