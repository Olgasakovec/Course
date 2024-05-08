package page;

import component.Tittle;
import org.openqa.selenium.WebDriver;


public class RiderPage {
    private WebDriver driver;
    public RiderPage(WebDriver driver) {
        this.driver = driver;
    }

    public Tittle getTittle() {
        return new Tittle(driver);
    }
}
