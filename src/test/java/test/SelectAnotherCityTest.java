package test;


import org.testng.annotations.Test;
import test.base.BaseTest;


public class SelectAnotherCityTest extends BaseTest {

    @Test
    public void selectAnotherCity() {
        mainPage.selectCity("Clinton");
    }


}
