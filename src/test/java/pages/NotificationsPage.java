package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.TimeoutException;
import utils.ActionsHelper;

import java.util.concurrent.TimeUnit;

public class NotificationsPage extends BasePage{

    public ActionsHelper helper;

    @iOSXCUITFindBy(accessibility = "Что делать, если у вас положительный результат анализа на COVID-19")
    public MobileElement IF_YOUR_TEST_IS_POSITIVE;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Передать коды тесных контактов']")
    public MobileElement GO_TO_CODE_PAGE;

    public NotificationsPage(AppiumDriver driver) {
        super(driver);
    }

    public void goToSendCodeContacts() {
        if (driver instanceof IOSDriver){
            helper = new ActionsHelper(driver);
            helper.scrollToElement();
            IF_YOUR_TEST_IS_POSITIVE.click();
            helper.scrollToElement();
            GO_TO_CODE_PAGE.click();
        } else {
            helper.scrollToMobileElementAndroid("Что делать, если у вас положительный результат анализа на COVID-19").click();
            MobileElement goToCodePage = driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().textContains(\"Передать коды тесных контактов\"))"));
            goToCodePage.click();
        }

    }

}