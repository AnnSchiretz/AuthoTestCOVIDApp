package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.net.MalformedURLException;

public class MainPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Приложение сейчас не может отправлять вам оповещения. Настройте оповещения о COVID.')]")
    public MobileElement MAIN_SCREEN;
    @iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[contains(@name ,'Выберите ваш округ, чтобы посмотреть для него статистику, в настоящее время выбран вариант')]")
    public MobileElement CHANGE_CITY;
    @iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[contains(@name, 'Поиск: показывает предлагаемые варианты автозаполнения')]")
    public MobileElement SELECT_CITY;

    public MainPage(AppiumDriver driver) throws MalformedURLException {
        super(driver);
    }





}
