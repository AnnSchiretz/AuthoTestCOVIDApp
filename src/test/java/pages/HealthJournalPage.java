package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.object.ExpectedObject;
import utils.ActionsHelper;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HealthJournalPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Продолжить']")
    MobileElement CONTINUE_BUTTON;
    @iOSXCUITFindBy(accessibility = "Нам жаль, что вы плохо себя чувствуете. К сожалению, симптомы, которые вы указали сегодня, могут быть признаками COVID-19.")
    MobileElement BAD_RESULT;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Готово']")
    MobileElement DONE_BUTTON;

    String OPTIONS_IOS = "//XCUIElementTypeOther";
    String OPTIONS_ANDROID = "//android.widget.CheckBox";
    String CONTINUE_BUTTON_ANDROID = "android.widget.TextView";

    ActionsHelper helper = new ActionsHelper(this.driver);

    public HealthJournalPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectSymptoms(Object... values) {
        if(driver instanceof IOSDriver){
            driver.findElementByXPath(OPTIONS_IOS).isDisplayed();
            String userOption = Arrays.toString(Arrays.stream(values).toArray()).replace("[", "").replace("]", "") + ", Сегодня у вас наблюдались какие-либо из следующих 11 симптомов?";
            List<MobileElement> optionsInApp = driver.findElementsByXPath(OPTIONS_IOS);
            optionsInApp.stream().map(ExpectedObject::new).forEach((ExpectedObject elem) -> {
                if (userOption.equals(elem.name) && elem.value.equals("true")) {
                    try{
                        elem.element.click();
                    } catch (Exception ex){
                        helper.scrollToElement();
                        elem.element.click();
                    }
                }
            });
        } else {
            driver.findElementByXPath(OPTIONS_ANDROID).isDisplayed();
            String userOption = Arrays.toString(Arrays.stream(values).toArray()).replace("[", "").replace("]", "") + ", Сегодня у вас наблюдались какие-либо из следующих 11 симптомов?";
            List<MobileElement>optionsInApp = driver.findElementsByXPath(OPTIONS_ANDROID);
            optionsInApp.forEach((option) -> {
                        if (userOption.equals(option.getAttribute("content-desc"))) {
                            option.click();
                        }
                    });
            helper.scrollDownAndroid();
            optionsInApp.addAll(driver.findElementsByXPath(OPTIONS_ANDROID));
            optionsInApp.forEach((option) -> {
                if (userOption.equals(option.getAttribute("content-desc"))) {
                    System.out.println(option.getAttribute("content-desc"));
                    option.click();
                }
            });
    }};
    public void continueStep(){
        if(driver instanceof IOSDriver){
            helper.scrollToElement();
            CONTINUE_BUTTON.click();
        } else {
            helper.scrollDownAndroid();
            helper.clickElementCustom(CONTINUE_BUTTON_ANDROID, "Продолжить");
        }

    }

    public void badResult(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if(driver instanceof IOSDriver){
            String result = BAD_RESULT.getText();
            Assert.assertEquals("Не сошлись результаты", "Нам жаль, что вы плохо себя чувствуете. К сожалению, симптомы, которые вы указали сегодня, могут быть признаками COVID-19.", result);
            helper.scrollToElement();
            helper.scrollToElement();
            DONE_BUTTON.click();
            List<MobileElement> res = driver.findElementsByClassName("");
            Assert.assertNotEquals("Не должны сходиться числа", res.size() + 1, res.size());
        } else {
            driver.findElementByClassName("android.widget.TextView").click();
            String result = driver.findElementByClassName("android.widget.TextView").getText();
            helper.scrollDownAndroid();
            helper.scrollDownAndroid();
            Assert.assertEquals("Не сошлись результаты", "Нам жаль, что вы плохо себя чувствуете. К сожалению, симптомы, которые вы указали сегодня, могут быть признаками COVID-19.", result);
            helper.clickElementCustom(CONTINUE_BUTTON_ANDROID, "Готово");
            List<MobileElement> res = driver.findElementsByClassName("android.widget.TextView");
            Assert.assertNotEquals("Не должны сходиться числа", res.size() + 1, res.size());
        }
    }
}


