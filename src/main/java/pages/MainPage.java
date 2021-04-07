package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "android:id/content")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Приложение сейчас не может отправлять вам оповещения. Настройте оповещения о COVID.')]")
    public MobileElement MAIN_SCREEN;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Выберите ваш округ, чтобы посмотреть для него статистику, в настоящее время выбран вариант')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name ,'Выберите ваш округ, чтобы посмотреть для него статистику, в настоящее время выбран вариант')]")
    public MobileElement CHANGE_CITY;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Поиск: показывает предлагаемые варианты автозаполнения']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Поиск: показывает предлагаемые варианты автозаполнения')]")
    public MobileElement SELECT_CITY;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Выберите ваш округ, чтобы посмотреть для него статистику, в настоящее время выбран вариант')]/android.widget.TextView")
    public MobileElement SELECT_RESULT;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectCity(String city) {
        MAIN_SCREEN.isEnabled();
        wait.until(ExpectedConditions.elementToBeClickable(CHANGE_CITY)).click();
        SELECT_CITY.sendKeys(city);
        if (driver.getPlatformName().equals("android")) {
            MobileElement searchResult = driver.findElementByXPath("//android.widget.RadioButton[@content-desc='" + city + "']");
            searchResult.click();
            String selectResult = SELECT_RESULT.getText();
            Assert.assertTrue(selectResult.contains(city));
        } else {
            MobileElement searchResult = driver.findElementByXPath("//XCUIElementTypeOther[@name='" + city + "']");
            searchResult.click();
            String res = CHANGE_CITY.getAttribute("name");
            Assert.assertTrue(res.contains(city));
        }
    }

}
