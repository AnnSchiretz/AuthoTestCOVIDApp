package pages.object;

import io.appium.java_client.MobileElement;

public class ExpectedObject {
    public String name;
    public String value;
    public MobileElement element;

    public ExpectedObject(MobileElement element) {
        this.name = element.getAttribute("name");
        this.value = element.getAttribute("enabled");
        this.element = element;
    }
}
