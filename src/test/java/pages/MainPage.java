package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ActionsHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {
    ActionsHelper helper;
    String CLASS_NAME = "XCUIElementTypeButton";
    String TEXT = "Журнал здоровья Сообщите нам, если у вас\n" +
            "сегодня имеются симптомы";
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MAIN_SCREEN.isEnabled();
        CHANGE_CITY.click();
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
    public void goToHealthJournal(){
        String CLASS = "android.widget.TextView";
        String text = "Журнал здоровья";
        if(driver instanceof AndroidDriver){
            helper = new ActionsHelper(this.driver);
            helper.clickElementCustom(CLASS, text);
        } else {
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            helper = new ActionsHelper(this.driver);
            helper.clickElementCustom(CLASS_NAME, TEXT);
        }
    }

}
