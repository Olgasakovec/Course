package page;

import component.DropDown;
import component.Tittle;
import org.openqa.selenium.WebDriver;


public class JetbrainsPage {

    public JetbrainsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public DropDown getDropDown() {
        return new DropDown(driver);
    }

    public Tittle getTittle() {
        return new Tittle(driver);
    }
}
