import org.asynchttpclient.uri.Uri;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.HomePage;
import pages.ItemPage;
import pages.SearchResultsPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static Urls.Urls.homePageUrl;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.drive", "chromedriver.exe");
       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("platformName", "WINDOWS");

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.18.10:4444"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void goHome() {
        driver.get(homePageUrl);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("screenshots\\"+result.getName() + ".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
