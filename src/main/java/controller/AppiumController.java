package controller;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static configs.AndroidConfiguration.capabilitiesAndroid;
import static configs.IosDevice.capabilitiesIos;

public class AppiumController {

    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;
    public WebDriverWait wait;

    public void start(String platform) throws MalformedURLException {
        if (platform.equals("Android")) {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesAndroid());
        } else {
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesIos());
        }
        wait = new WebDriverWait(driver, 20);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
