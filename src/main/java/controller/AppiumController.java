package controller;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static configs.AndroidConfiguration.capabilitiesAndroid;
import static configs.IosDevice.capabilitiesIos;

public class AppiumController {

    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;

    public void start(String platform) throws MalformedURLException {
        if (platform.equals("android")) {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesAndroid());
        } else {
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesIos());
        }
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
