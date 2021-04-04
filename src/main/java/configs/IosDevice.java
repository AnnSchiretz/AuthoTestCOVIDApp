package configs;

import org.openqa.selenium.remote.DesiredCapabilities;


public class IosDevice {
    public static DesiredCapabilities capabilitiesIos(){
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName", "iPhone");
        config.setCapability("platformName", "iOS");
        config.setCapability("platformVersion","13.6");
        config.setCapability("automationName", "XCUITest");
        config.setCapability("udid","9d6d8d0c873886807340d78230b3ce1f4d9e7568");
        config.setCapability("app", "gov.ny.health.proximity");
        config.setCapability("appWaitDuration", 30000);
        return config;
    }
}
