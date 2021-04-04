package test.base;


import org.junit.Test;

import java.net.MalformedURLException;

public class FirstTest extends BaseTest {
    @Test
    public void first () throws MalformedURLException {
        createDriver("iOS");
        mainPage.selectCity("Clinton");
    }


}
