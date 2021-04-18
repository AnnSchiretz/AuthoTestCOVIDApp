package test.base;

import controller.AppiumBaseClass;
import controller.AppiumController;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeTest;
import pages.ContactCodesPage;
import pages.HealthJournalPage;
import pages.MainPage;
import pages.NotificationsPage;
import java.net.MalformedURLException;


public class BaseTest extends AppiumBaseClass {
    public AppiumDriver driver;
    public MainPage mainPage;
    public ContactCodesPage contactPage;
    public NotificationsPage notifications;
    public HealthJournalPage healthJournal;


    @BeforeTest
    public void createDriver() throws MalformedURLException {
      AppiumController.instance.start();
      mainPage = new MainPage(driver());
      contactPage = new ContactCodesPage(driver());
      notifications = new NotificationsPage(driver());
      healthJournal = new HealthJournalPage(driver());
    }



//    @AfterTest
//    public void stopProcessor() {
//        AppiumController.instance.driver.quit();
//    }
}
