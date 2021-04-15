package controller;


import com.android.ddmlib.IDevice;
import controller.device.AndroidFinder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumController {

    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;


    public AppiumDriver start() throws MalformedURLException {
        IDevice result = new AndroidFinder().findAndroid();

        if (driver != null) {
            return driver;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (result != null) {
            capabilities.setCapability("deviceName", "xiaomi");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("platformVersion", "8.1");
            capabilities.setCapability("udid", "379656517d84");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("appWaitDuration", 30000);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("appPackage", "gov.ny.health.proximity");
            capabilities.setCapability("appActivity", "gov.ny.health.proximity.MainActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } else {
            capabilities.setCapability("deviceName", "iPhone");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "13.6");
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("udid", "9d6d8d0c873886807340d78230b3ce1f4d9e7568");
            capabilities.setCapability("app", "gov.ny.health.proximity");
            capabilities.setCapability("appWaitDuration", 30000);
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        return driver;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

