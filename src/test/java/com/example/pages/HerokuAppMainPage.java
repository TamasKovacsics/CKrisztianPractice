package com.example.pages;

import com.example.basepage.BasePage;
import com.example.pages.dynamicloading.DynamicLoadingPage;
import com.example.pages.formauth.FormAuthPage;
import com.example.pages.frames.Frames;
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

    @FindBy(css = "a[href='/drag_and_drop']")
    private WebElement dragAndDropLink;

    @FindBy(css = "a[href='/entry_ad']")
    private WebElement entryAdLink;

    @FindBy(css = "a[href='/exit_intent']")
    private WebElement exitIntentLink;

    @FindBy(css = "a[href='/download']")
    private WebElement fileDownloadLink;

    @FindBy(css = "a[href='/upload']")
    private WebElement fileUploadLink;

    @FindBy(css = "a[href='/frames']")
    private WebElement framesLink;

    @FindBy(css = "a[href='/windows']")
    private WebElement multipleWindowsLink;

    @FindBy(css = "a[href='/horizontal_slider']")
    private WebElement horizontalSliderLink;

    @FindBy(css = "a[href='/hovers']")
    private WebElement hoverLink;

    @FindBy(css = "a[href='/infinite_scroll']")
    private WebElement infiniteScrollLink;

    @FindBy(css = "a[href='/javascript_alerts']")
    private WebElement javaScriptAlertsLink;

    @FindBy(css = "a[href='/key_presses']")
    private WebElement keyPressesLink;

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

    public DragAndDrop clickDragAndDrop() {
        dragAndDropLink.click();
        return new DragAndDrop(driver);
    }

    public EntryAd clickEntryAd(boolean isWindowAppear) {
        entryAdLink.click();
        return new EntryAd(driver, isWindowAppear);
    }

    public ExitIntent clickExitIntent() {
        exitIntentLink.click();
        return new ExitIntent(driver);
    }

    public FileDownload clickFileDownload() {
        fileDownloadLink.click();
        return new FileDownload(driver);
    }

    public FileUpload clickFileUpload() {
        fileUploadLink.click();
        return new FileUpload(driver);
    }

    public Frames clickFrames() {
        framesLink.click();
        return new Frames(driver);
    }

    public MultipleWindows clickMultipleWindows() {
        multipleWindowsLink.click();
        return new MultipleWindows(driver);
    }

    public HorizontalSlider clickHorizontalSlider() {
        horizontalSliderLink.click();
        return new HorizontalSlider(driver);
    }

    public Hover clickHover() {
        hoverLink.click();
        return new Hover(driver);
    }

    public InfiniteScroll clickInfiniteScroll() {
        infiniteScrollLink.click();
        return new InfiniteScroll(driver);
    }

    public JavaScriptAlerts clickJavaScriptAlerts() {
        javaScriptAlertsLink.click();
        return new JavaScriptAlerts(driver);
    }

    public KeyPresses clickKeyPresses() {
        keyPressesLink.click();
        return new KeyPresses(driver);
    }
}
