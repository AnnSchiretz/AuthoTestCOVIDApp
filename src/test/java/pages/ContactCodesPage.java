package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;

import java.util.concurrent.TimeUnit;

public class ContactCodesPage extends BasePage {


    @AndroidFindBy(accessibility = "Code input, Insert code")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Code input']")
    public MobileElement ENTER_CODE;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Недействительный код. Повторите попытку.')]")
    @iOSXCUITFindBy(accessibility = "Недействительный код. Повторите попытку.")
    public MobileElement CODE_RESULT;

    public ContactCodesPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterCode(String code){
        ENTER_CODE.sendKeys(code);
        if(driver instanceof IOSDriver){
            String result = CODE_RESULT.getAttribute("value");
            Assert.assertEquals("Недействительный код. Повторите попытку.", result);
        } else {
            String result = CODE_RESULT.getAttribute("text");
            Assert.assertEquals("Недействительный код. Повторите попытку.", result);
        }
    }
}