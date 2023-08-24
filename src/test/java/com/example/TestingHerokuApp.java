package com.example;

import com.example.constants.Constants;
import com.example.pages.*;
import com.example.pages.dynamicloading.DynamicLoadingPage;
import com.example.pages.dynamicloading.DynamicLoadingPageOne;
import com.example.pages.dynamicloading.DynamicLoadingPageTwo;
import com.example.pages.formauth.FormAuthPage;
import com.example.pages.formauth.FormAuthSecurePage;
import com.example.pages.frames.Frames;
import com.example.pages.frames.IFrames;
import com.example.pages.frames.NestedFrames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testbase.TestBase;



public class TestingHerokuApp extends TestBase {

    private com.example.pages.HerokuAppMainPage herokuAppMainPage;

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

        formAuthPage.enterUsername(Constants.USERNAME);
        formAuthPage.enterPassword(Constants.PASSWORD);

        FormAuthSecurePage formAuthSecurePage = formAuthPage.loginButtonClick();

        formAuthSecurePage.logoutButtonClick();
    }

    @Test
    public void testFromAuthWrongUser() {
        FormAuthPage formAuthPage = herokuAppMainPage.clickFormAuthLink();
        formAuthPage.enterUsername(Constants.WRONGUSER);
        formAuthPage.enterPassword(Constants.PASSWORD);

        formAuthPage = formAuthPage.loginButtonClickWrongCredentials();
        Assertions.assertEquals("Your username is invalid!\n×", formAuthPage.getErrorMessage());
    }

    @Test
    public void testFormAuthWrongPass() {
        FormAuthPage formAuthPage = herokuAppMainPage.clickFormAuthLink();
        formAuthPage.enterUsername(Constants.USERNAME);
        formAuthPage.enterPassword(Constants.WRONGPASS);

        formAuthPage = formAuthPage.loginButtonClickWrongCredentials();
        Assertions.assertEquals("Your password is invalid!\n×", formAuthPage.getErrorMessage());
    }

    @Test
    public void testDragAndDrop() {
        DragAndDrop dragAndDrop = herokuAppMainPage.clickDragAndDrop();

        dragAndDrop.DragAndDropAction();
    }

    @Test
    public void testEntryAd() {
        EntryAd entryAd = herokuAppMainPage.clickEntryAd(true);

        Assertions.assertTrue(entryAd.isAdVisible(), "The Entry Ad should be visible");
        entryAd.entryAdClose();
        Assertions.assertFalse(entryAd.isAdVisible(), "The Entry Ad should be hidden");


        driver.get("https://the-internet.herokuapp.com");
        herokuAppMainPage = new HerokuAppMainPage(driver);
        entryAd = herokuAppMainPage.clickEntryAd(false);
    }

    @Test
    public void testExitIntent() {
        ExitIntent exitIntent = herokuAppMainPage.clickExitIntent();

        exitIntent.moveOutOfViewport();
    }

    @Test
    public void testFileDownload() {
        FileDownload fileDownload = herokuAppMainPage.clickFileDownload();

        //fileDownload.downloadFile();
        //Assertions.assertTrue(fileDownload.getDownloadedFile(), "The file is not downloaded");
    }

    @Test
    public void testFileUpload() {
        FileUpload fileUpload = herokuAppMainPage.clickFileUpload();

        fileUpload.uploadFile();
        Assertions.assertEquals("File Uploaded!", fileUpload.getPageTitle());
    }

    @Test
    public void testNestedFrames() {
        Frames frames = herokuAppMainPage.clickFrames();
        NestedFrames nestedFrames = frames.clickNestedFrames();

        nestedFrames.getTexts();
    }

    @Test
    public void testIFrames() {
        Frames frames = herokuAppMainPage.clickFrames();
        IFrames iFrames = frames.clickIFrames();

        iFrames.getTexts();
    }

    @Test
    public void testMultipleWindows() {
        MultipleWindows multipleWindows = herokuAppMainPage.clickMultipleWindows();
        multipleWindows.clickLink();
    }

    @Test
    public void testHorizontalSlider() {
        HorizontalSlider horizontalSlider = herokuAppMainPage.clickHorizontalSlider();

        horizontalSlider.slideHorizontally(horizontalSlider.roundTheNumber(1.1));
        Assertions.assertTrue(horizontalSlider.checkNumber(1.1), "You have to give a number between 0 and 5");
        horizontalSlider.slideHorizontally(horizontalSlider.roundTheNumber(0.2));
        Assertions.assertTrue(horizontalSlider.checkNumber(0.2), "You have to give a number between 0 and 5");
        horizontalSlider.slideHorizontally(horizontalSlider.roundTheNumber(2.8));
        Assertions.assertTrue(horizontalSlider.checkNumber(2.8), "You have to give a number between 0 and 5");
        horizontalSlider.slideHorizontally(horizontalSlider.roundTheNumber(4.4));
        Assertions.assertTrue(horizontalSlider.checkNumber(4.4), "You have to give a number between 0 and 5");
    }

    @Test
    public void testHover() {
        Hover hover = herokuAppMainPage.clickHover();
        hover.clickFirst();
        Assertions.assertTrue(hover.isFirstVisible(), "The cursor is missplaced");
        hover.clickSecond();
        Assertions.assertTrue(hover.isSecondVisible(), "The cursor is missplaced");
        hover.clickThird();
        Assertions.assertTrue(hover.isThirdVisible(), "The cursor is missplaced");
    }

    @Test
    public void testInfiniteScroll() {
        InfiniteScroll infiniteScroll = herokuAppMainPage.clickInfiniteScroll();
        infiniteScroll.scrolling();
    }

    @Test
    public void testJavaScriptAlerts() {
        JavaScriptAlerts javaScriptAlerts = herokuAppMainPage.clickJavaScriptAlerts();
        javaScriptAlerts.clickJsAlertButton();
        javaScriptAlerts.clickJsConfirmButton();
        javaScriptAlerts.clickPromptButton();
    }

    @Test
    public void testKeyPresses() {
        KeyPresses keyPresses = herokuAppMainPage.clickKeyPresses();
        keyPresses.sendKeysToInput();
    }

    @Test
    public void testLogging() {
        logger.info("Example log from {}", TestingHerokuApp.class.getSimpleName());
    }
}
