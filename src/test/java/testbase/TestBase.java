package testbase;

import com.example.pages.HerokuAppMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected static WebDriver driver;

    @BeforeEach
    public void setUp() {
        try {
            driver = new ChromeDriver();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @AfterEach
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
