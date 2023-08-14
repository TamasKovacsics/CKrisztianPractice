package com.example.pages;

import com.example.basepage.BasePage;
import com.example.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUpload extends BasePage {

    @FindBy(css = "input[id='file-upload']")
    private WebElement fileLink;

    @FindBy(css = "input[id='file-submit']")
    private WebElement submitButton;

    @FindBy(css = "h3")
    private WebElement pageTitle;

    public FileUpload(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(fileLink);
    }

    public void uploadFile() {
        fileLink.sendKeys(Constants.UPLOAD_PATH);
        submitButton.click();
    }

    public String getPageTitle() {
        return pageTitle.getText().trim();
    }
}
