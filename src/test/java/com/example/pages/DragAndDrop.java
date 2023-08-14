package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Locale;

public class DragAndDrop extends BasePage {

    @FindBy(css = "div[id='column-a']")
    private WebElement columnA;

    @FindBy(css = "div[id='column-b']")
    private WebElement columnB;

    public DragAndDrop(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(columnA);
    }

    public void DragAndDropAction() {
        Actions action = new Actions(driver);

        //Point x = columnA.getLocation();
        //Point y = columnB.getLocation();

        //action.dragAndDropBy(columnA, columnA.getLocation().getX(), columnB.getLocation().getY()).perform();

        /*action.moveToElement(columnA)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(columnA)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(50, 0)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();*/

        //action.clickAndHold(columnB).moveByOffset(columnA.getLocation().getX() - columnB.getLocation().getX() - 10, 0).release().build().perform();
                //dragAndDropBy(columnB, , 0).build().perform();
        //moveToElement(columnA, (columnA.getLocation().getX() / 2), columnA.getLocation().getY() / 2).clickAndHold().build().perform();
        //action.moveToElement(columnB, (columnB.getLocation().getX() / 2) , (columnB.getLocation().getY() / 2)).release().build().perform();*/

/*
        Action dragNDrop = action.clickAndHold(columnA).moveToElement(columnB).release(columnB).build();
        dragNDrop.perform();*/

        System.out.println(columnA.getText());
    }
}
