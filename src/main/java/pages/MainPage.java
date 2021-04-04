package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

public class MainPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Приложение сейчас не может отправлять вам оповещения. Настройте оповещения о COVID.')]")
    public MobileElement MAIN_SCREEN;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name ,'Выберите ваш округ, чтобы посмотреть для него статистику, в настоящее время выбран вариант')]")
    public MobileElement CHANGE_CITY;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Поиск: показывает предлагаемые варианты автозаполнения')]")
    public MobileElement SELECT_CITY;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectCity(String city) {
        MAIN_SCREEN.isEnabled();
        CHANGE_CITY.click();
        SELECT_CITY.sendKeys(city);
        MobileElement searchResult = driver.findElementByXPath("//XCUIElementTypeOther[@name='" + city + "']");
        searchResult.click();
        String res = CHANGE_CITY.getAttribute("name");
        Assert.assertTrue(res.contains(city));
    }


}
