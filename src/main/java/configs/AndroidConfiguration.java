package configs;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AndroidConfiguration {

    public static DesiredCapabilities capabilitiesAndroid() {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName", MobileCapabilityType.DEVICE_NAME);
        config.setCapability("platformName", MobileCapabilityType.PLATFORM_NAME);
        config.setCapability("platformVersion", MobileCapabilityType.PLATFORM_VERSION);
        config.setCapability("udid", MobileCapabilityType.AUTOMATION_NAME);
        config.setCapability("adbExecTimeout", 120000);
        config.setCapability("automationName", "UiAutomator2");
        config.setCapability("appPackage", "gov.ny.health.proximity");
        config.setCapability("appActivity", "gov.ny.health.proximity.MainActivity");
        return config;
    }
}
