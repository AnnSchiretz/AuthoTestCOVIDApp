package configs;

import org.openqa.selenium.remote.DesiredCapabilities;


public class AndroidConfiguration {

    public static DesiredCapabilities capabilitiesAndroid() {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName", "xiaomi");
        config.setCapability("platformName", "android");
        config.setCapability("platformVersion", "8.1");
        config.setCapability("udid", "379656517d84");
        config.setCapability("automationName", "UiAutomator2");
        config.setCapability("appWaitDuration", 20000);
        config.setCapability("noReset", true);
        config.setCapability("appPackage", "gov.ny.health.proximity");
        config.setCapability("appActivity", "gov.ny.health.proximity.MainActivity");
        return config;
    }
}
