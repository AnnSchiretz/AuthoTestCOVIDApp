package pages;

import controller.AppiumBaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class BasePage extends AppiumBaseClass {
    public  AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver driver) throws MalformedURLException {
        this.driver = driver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
}
