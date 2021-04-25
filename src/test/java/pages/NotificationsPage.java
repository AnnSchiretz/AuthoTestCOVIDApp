package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.base.BasePage;
import utils.ActionsHelper;


public class NotificationsPage extends BasePage {

    public ActionsHelper helper;

    @iOSXCUITFindBy(accessibility = "Что делать, если у вас положительный результат анализа на COVID-19")
    public MobileElement IF_YOUR_TEST_IS_POSITIVE;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Передать коды тесных контактов']")
    public MobileElement GO_TO_CODE_PAGE;

    public NotificationsPage(AppiumDriver driver) {
        super(driver);
    }

    public void goToSendCodeContacts() {
        if (driver instanceof IOSDriver) {
            helper = new ActionsHelper(this.driver);
            helper.scrollToElement(IF_YOUR_TEST_IS_POSITIVE).click();
            helper.scrollToElement(GO_TO_CODE_PAGE).click();
        } else {
            helper = new ActionsHelper(this.driver);
            helper.scrollToMobileElementAndroid("Что делать, если у вас положительный результат анализа на COVID-19").click();
            helper.scrollToMobileElementAndroid("Передать коды тесных контактов").click();
        }

    }

}