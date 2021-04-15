package utils;

import io.appium.java_client.AppiumDriver;
import pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class ActionsHelper extends BasePage {


    public ActionsHelper(AppiumDriver driver){
        super(driver);
    }

    public void scrollToElement() {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "down");
        driver.executeScript("mobile: scroll", args);
//        JavascriptExecutor js = driver;
//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        scrollObject.put("direction", "down");
//        driver.executeScript("mobile: dr", scrollObject);

//        if (driver.getAutomationName())){
//            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId('"+element.getId()+"')).scrollForward()"));
//        }
    }

}
