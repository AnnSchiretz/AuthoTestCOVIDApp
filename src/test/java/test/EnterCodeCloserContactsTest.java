package test;


import org.testng.annotations.Test;
import test.base.BaseTest;


import java.net.MalformedURLException;

public class EnterCodeCloserContactsTest extends BaseTest {
    @Test
    public void enterCodeTest() throws MalformedURLException {
//        createDriver();
        notifications.goToSendCodeContacts();
        contactPage.enterCode("43874387");

    }
}
