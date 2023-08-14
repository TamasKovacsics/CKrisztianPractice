package testbase;

import com.example.CaptureScreenshot;
import com.example.LoggingClass;
import com.example.constants.Constants;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(LoggingClass.class)
@ExtendWith(CaptureScreenshot.class)
public class TestBase {
    protected WebDriver driver;

    public static final Logger logger = LoggerFactory.getLogger(TestBase.class);;

    @BeforeEach
    public void setUp() {
        try {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.prompt_for_download", false);
            prefs.put("download.default_directory", Constants.DOWNLOAD_PATH);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
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

    @AfterAll
    public static void clearDownloads() {
        File[] listOfFiles;

        String fileName;

        listOfFiles = new File(Constants.DOWNLOAD_PATH).listFiles();

        for (File file : listOfFiles) {
            file.delete();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
