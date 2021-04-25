package test;


import org.testng.annotations.Test;
import test.base.BaseTest;


public class EnterCodeCloserContactsTest extends BaseTest {

    @Test
    public void enterCodeTest() {
        mainPage.goToNotificationsPage();
        notifications.goToSendCodeContacts();
        contactPage.enterCode("43874387");
    }
}
