package com.example.pages;

import com.example.basepage.BasePage;
import com.example.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileDownload extends BasePage {

    @FindBy(css = "a[href='download/slider-8.jpg']")
    private WebElement fileLink;
    public FileDownload(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        //waitForElementToAppear(fileLink);
    }

    public void downloadFile() {
        fileLink.click();

        sleep(5000);
    }

    public boolean getDownloadedFile() {
        File[] listOfFiles;

        String fileName;

        listOfFiles = new File(Constants.DOWNLOAD_PATH).listFiles();

        for (File file : listOfFiles) {
            fileName = file.getName().toLowerCase();

            if(fileName.equals(Constants.FILE_NAME.toLowerCase())) {
                return true;
            }
        }
        return false;

    }
}
