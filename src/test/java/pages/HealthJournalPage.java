package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import pages.base.BasePage;
import utils.ActionsHelper;

import java.util.List;


public class HealthJournalPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Продолжить']")
    MobileElement CONTINUE_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(
            accessibility = "Нам жаль, что вы плохо себя чувствуете. К сожалению, симптомы, которые вы указали сегодня, могут быть " +
                    "признаками COVID-19.")
    MobileElement BAD_RESULT;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Готово']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text ='Готово']")
    MobileElement DONE_BUTTON;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Я хорошо себя чувствую сегодня']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Я хорошо себя чувствую сегодня']")
    MobileElement GOOD_FEELING_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[@name ='Спасибо, что заполнили журнал сегодня.Мы рады, что вы хорошо себя " +
            "чувствуете!']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name ='Спасибо, что заполнили журнал сегодня. " +
            "Мы рады, что вы хорошо себя чувствуете!']")
    MobileElement NOT_SYMPTOMS_RESULT;

    String OPTIONS_IOS = "//XCUIElementTypeOther";
    String ELEMENT_HEALTH_JOURNAL_IOS = "//XCUIElementTypeStaticText";
    String ELEMENT_HEALTH_JOURNAL_ANDROID = "//android.view.ViewGroup[2]/android.widget.TextView/android.widget.TextView";

    ActionsHelper helper = new ActionsHelper(this.driver);

    public HealthJournalPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectSymptoms(String... symptoms) {
        if (driver instanceof IOSDriver) {
            for (String opt : symptoms) {
                String option = opt + ", Сегодня у вас наблюдались какие-либо из следующих 11 симптомов?";
                MobileElement el = driver.findElementByXPath(OPTIONS_IOS + "[@name=\"" + option + "\"]");
                helper.scrollToElement(el).click();
            }
        } else {
            for (String el : symptoms) {
                try {
                    helper.scrollToMobileElementAndroid(el).click();
                } catch (NotFoundException ex) {
                    throw new NotFoundException("Not found element!");
                }
            }
        }
    }

    public void haveNotSymptoms() {
        if (driver instanceof IOSDriver) {
            GOOD_FEELING_BUTTON.click();
            String result = NOT_SYMPTOMS_RESULT.getText();
            Assert.assertEquals(result, "Спасибо, что заполнили журнал сегодня. Мы рады, что вы хорошо себя чувствуете!");
            DONE_BUTTON.click();
            List<MobileElement> listElement = driver.findElementsByXPath(ELEMENT_HEALTH_JOURNAL_IOS);
            for (MobileElement el : listElement) {
                if (el.getText().startsWith("0   симптомов")) {
                    Assert.assertTrue(el.getText().startsWith("0   симптомов"));
                }
            }
        } else {
            GOOD_FEELING_BUTTON.click();
            String result = NOT_SYMPTOMS_RESULT.getText();
            Assert.assertEquals("Results are not equals", result, "Спасибо, что заполнили журнал сегодня. Мы рады, что вы хорошо себя " +
                    "чувствуете!");
            List<MobileElement> listElement = driver.findElementsByXPath(ELEMENT_HEALTH_JOURNAL_ANDROID);
            for (MobileElement el : listElement) {
                if (el.getText().startsWith("0   симптомов")) {
                    Assert.assertTrue(el.getText().startsWith("0   симптомов"));
                }
            }
        }
    }

    public void continueStep() {
        if (driver instanceof IOSDriver) {
            helper.scrollToElement(CONTINUE_BUTTON).click();
        } else {
            helper.scrollToMobileElementAndroid("Продолжить").click();
        }

    }

    public void badResult(String... symptoms) {
        if (driver instanceof IOSDriver) {
            String result = BAD_RESULT.getText();
            Assert.assertEquals("Results are not equals",
                                "Нам жаль, что вы плохо себя чувствуете. К сожалению, симптомы, которые вы указали сегодня, могут быть " +
                                        "признаками COVID-19.",
                                result);
            helper.scrollToElement(DONE_BUTTON).click();
            for (String str : symptoms) {
                List<MobileElement> res = driver.findElementsByXPath("//XCUIElementTypeStaticText");
                for (MobileElement el : res) {
                    if (el.getText().contains(str)) {
                        Assert.assertTrue(el.getText().contains(str));
                    }
                    continue;
                }
            }
        } else {
            helper.scrollUpAndroid();
            String result = BAD_RESULT.getText();
            Assert.assertEquals("Results are not equals",
                                "Нам жаль, что вы плохо себя чувствуете. К сожалению, симптомы, которые вы указали сегодня, могут быть " +
                                        "признаками COVID-19.",
                                result);
            helper.scrollToMobileElementAndroid("Готово").click();
            for (String str : symptoms) {
                List<MobileElement> res = driver.findElementsByXPath("//android.view.ViewGroup[2]/android.widget.TextView/android.widget" +
                                                                             ".TextView");
                for (MobileElement el : res) {
                    if (el.getText().equals(str)) {
                        Assert.assertEquals(el.getText(), str);
                    }
                    continue;
                }
            }
        }
    }
}


