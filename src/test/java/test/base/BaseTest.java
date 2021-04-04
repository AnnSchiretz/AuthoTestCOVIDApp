package test.base;

import controller.AppiumController;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.MainPage;

import java.net.MalformedURLException;


public class BaseTest {
    public AppiumDriver driver;
    public MainPage mainPage;

    @Parameters
    @BeforeMethod
    public void createDriver(String platformName) throws MalformedURLException {
        AppiumController.instance.start(platformName);
        mainPage = new MainPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void stopProcessor() {
        AppiumController.instance.driver
                .closeApp();
    }
}
