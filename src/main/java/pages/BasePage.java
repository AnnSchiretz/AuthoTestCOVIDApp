package pages;

import controller.AppiumBaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends AppiumBaseClass {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        wait = new WebDriverWait(this.driver, 20);
    }
}
