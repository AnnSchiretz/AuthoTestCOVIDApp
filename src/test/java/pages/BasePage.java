package pages;

import controller.AppiumBaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage extends AppiumBaseClass {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
}
