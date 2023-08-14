package com.example.pages;

import com.example.basepage.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HorizontalSlider extends BasePage {

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(css = "span[id='range']")
    private WebElement span;

    public HorizontalSlider(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(slider);
    }

    public boolean checkNumber(double number) {
        return !(number > 5.0) && !(number < 0.0);
    }

    public double getNumber(){
        return Double.parseDouble(span.getText());
    }

    public void slideHorizontally(double number) {
        Actions action = new Actions(driver);
        int width = (slider.getSize().getWidth())/2;
        action.moveToElement(slider, -width, 0).click().build().perform();

        double spanNumber = getNumber();
        while(number > spanNumber) {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            spanNumber = getNumber();
        }
    }

    public double roundTheNumber(double number){
        if(!checkNumber(number))
            return 0.0;

        return Math.round(number*2)/2.0;
    }
}
