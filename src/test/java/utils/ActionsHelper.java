package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.BasePage;

import java.util.HashMap;
import java.util.List;

public class ActionsHelper extends BasePage {


    public ActionsHelper(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement scrollToElement(MobileElement el) {
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", el.getId());
        driver.executeScript("mobile: swipe", scrollObject);
        return el;
    }

    public void clickElementCustom(String className, String text) {
        List<MobileElement> buttons = driver.findElementsByClassName(className);
        for (MobileElement button : buttons) {
            if (button.getText().contains(text)) {
                button.click();
                break;
            }
        }
    }

    public void scrollUpAndroid() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
    }

    public MobileElement scrollToMobileElementAndroid(String name) {
        return driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + name + "\"))"));
    }
}
