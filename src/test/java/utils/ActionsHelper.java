package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionsHelper extends BasePage {


    public ActionsHelper(AppiumDriver driver){
        super(driver);
    }

    public void scrollToElement() {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "down");
        driver.executeScript("mobile: scroll", args);
    }

    public void clickElementCustom(String className, String text){
        List<MobileElement> buttons = driver.findElementsByClassName(className);
        for(MobileElement button : buttons){
            if(button.getText().contains(text)){
                button.click();
                break;
            }
        }
    }

    public void scrollDownAndroid(){
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
    }
    public void scrollUpAndroid(){
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
    }
    public MobileElement scrollToMobileElementAndroid(String name){
        return driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains("+name+"))"));
    }
}
