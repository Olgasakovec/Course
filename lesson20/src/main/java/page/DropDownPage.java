package page;

import component.DropDown;
import org.openqa.selenium.WebDriver;

public class DropDownPage {
    private WebDriver driver;
    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public DropDown getDropDown() {
        return new DropDown(driver);
    }

}
