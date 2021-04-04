package test.base;


import org.junit.Test;

import java.net.MalformedURLException;

public class SelectAnotherCityTest extends BaseTest {

    @Test
    public void selectAnotherCity() throws MalformedURLException {
        createDriver("iOS");
        mainPage.selectCity("Broome");
    }


}
