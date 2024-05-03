package page;

import component.Header;
import org.openqa.selenium.WebDriver;


public class JetbrainsPage {

    public JetbrainsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public Header getHeader() {
        return new Header(driver);
    }
}
