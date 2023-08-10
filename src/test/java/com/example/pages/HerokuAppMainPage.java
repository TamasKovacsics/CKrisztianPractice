package com.example.pages;

import com.example.basepage.BasePage;
import com.example.pages.dynamicloading.DynamicLoadingPage;
import com.example.pages.formauth.FormAuthPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerokuAppMainPage extends BasePage {

    @FindBy(css = "a[href='/add_remove_elements/']")
    private WebElement addRemoveElementLink;

    @FindBy(css = "a[href='/checkboxes']")
    private WebElement checkboxElementLink;

    @FindBy(css = "a[href='/dynamic_loading']")
    private WebElement dynamicLoadingElementLink;

    @FindBy(css = "a[href='/basic_auth']")
    private WebElement basicAuthPageLink;

    @FindBy(css = "a[href='/login']")
    private WebElement formAuthPageLink;

    public HerokuAppMainPage (WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElementToAppear(addRemoveElementLink);
    }

    public AddRemoveButtonPage clickAddRemoveLink() {
        addRemoveElementLink.click();
        return new AddRemoveButtonPage(driver);
    }

    public CheckboxesPage clickCheckboxesLink() {
        checkboxElementLink.click();
        return new CheckboxesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingLink() {
        dynamicLoadingElementLink.click();
        return new DynamicLoadingPage(driver);
    }

    public BasicAuthPage clickBasicAuthLink() {
        basicAuthPageLink.click();
        return new BasicAuthPage(driver);
    }

    public FormAuthPage clickFormAuthLink() {
        formAuthPageLink.click();
        return new FormAuthPage(driver);
    }
}
