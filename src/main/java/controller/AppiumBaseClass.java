package controller;

import io.appium.java_client.AppiumDriver;

public class AppiumBaseClass {

    public AppiumDriver driver() {
        return AppiumController.instance.driver;
    }
}
