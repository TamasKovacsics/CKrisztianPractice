package com.example;

import com.example.pages.*;
import com.example.pages.dynamicloading.DynamicLoadingPage;
import com.example.pages.dynamicloading.DynamicLoadingPageOne;
import com.example.pages.dynamicloading.DynamicLoadingPageTwo;
import com.example.pages.formauth.FormAuthPage;
import com.example.pages.formauth.FormAuthSecurePage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testbase.TestBase;

public class TestingHerokuApp extends TestBase {

    private HerokuAppMainPage herokuAppMainPage;

    @BeforeEach
    public void startUp() {
        driver.get("https://the-internet.herokuapp.com");
        herokuAppMainPage = new HerokuAppMainPage(driver);
    }

    @Test
    public void testAddRemoveButton() {
        AddRemoveButtonPage addRemoveButtonPage = herokuAppMainPage.clickAddRemoveLink();

        Assertions.assertFalse(addRemoveButtonPage.isDeleteButtonPresent(), "The delete button should not be present, yet");
        addRemoveButtonPage.addButtonClick();
        Assertions.assertTrue(addRemoveButtonPage.isDeleteButtonPresent(), "The delete button should appear");
        addRemoveButtonPage.removeButtonClick();
        Assertions.assertFalse(addRemoveButtonPage.isDeleteButtonPresent(), "The delete button should not be present");
    }

    @Test
    public void testCheckboxes() {
        CheckboxesPage checkboxesPage = herokuAppMainPage.clickCheckboxesLink();

        Assertions.assertFalse(checkboxesPage.isCheckBoxOneChecked(), "The first checkbox should be unchecked");
        Assertions.assertTrue(checkboxesPage.isCheckBoxTwoChecked(), "The second checkbox should be checked");
        checkboxesPage.checkBoxOneCheck();
        Assertions.assertTrue(checkboxesPage.isCheckBoxOneChecked(), "The first checkbox should be checked");
        checkboxesPage.checkBoxTwoCheck();
        Assertions.assertFalse(checkboxesPage.isCheckBoxTwoChecked(), "The second checkbox should be unchecked");
    }

    @Test
    public void testDynamicLoadingOne() {
        DynamicLoadingPage dynamicLoadingPage = herokuAppMainPage.clickDynamicLoadingLink();
        DynamicLoadingPageOne dynamicLoadingPageOne = dynamicLoadingPage.clickExampleOneLink();

        Assertions.assertFalse(dynamicLoadingPageOne.isTextDisplayed(), "The text should be hidden");
        dynamicLoadingPageOne.startButtonClick();
        Assertions.assertTrue(dynamicLoadingPageOne.isTextDisplayed(), "The text should be visible");
    }

    @Test
    public void testDynamicLoadingTwo() {
        DynamicLoadingPage dynamicLoadingPage = herokuAppMainPage.clickDynamicLoadingLink();
        DynamicLoadingPageTwo dynamicLoadingPageTwo = dynamicLoadingPage.clickExampleTwoLink();

        Assertions.assertFalse(dynamicLoadingPageTwo.isTextDisplayed(), "The text shouldn't be rendered");
        dynamicLoadingPageTwo.startButtonClick();
        Assertions.assertTrue(dynamicLoadingPageTwo.isTextDisplayed(), "The text should be rendered");
    }

    @Test
    public void testBasicAuth() {
        BasicAuthPage basicAuthPage = herokuAppMainPage.clickBasicAuthLink();

        basicAuthPage.authButtonClick();
    }

    @Test
    public void testFormAuth() {
        FormAuthPage formAuthPage = herokuAppMainPage.clickFormAuthLink();

        formAuthPage.enterUsername(FormAuthPage.username);
        formAuthPage.enterPassword(FormAuthPage.password);

        FormAuthSecurePage formAuthSecurePage = formAuthPage.loginButtonClick();

        formAuthSecurePage.logoutButtonClick();
    }

    @Test
    public void testFormAuthWrong() {
        FormAuthPage formAuthPage = herokuAppMainPage.clickFormAuthLink();
        formAuthPage.enterUsername(FormAuthPage.username);
        formAuthPage.enterPassword(FormAuthPage.wrongPassword);

        formAuthPage = formAuthPage.loginButtonClickWrongCredentials();
        Assert.assertEquals("Your password is invalid!\n×", formAuthPage.getErrorMessage());
    }


}
