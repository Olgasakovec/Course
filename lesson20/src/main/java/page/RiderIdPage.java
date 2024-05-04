package page;

import component.Tittle;
import org.openqa.selenium.WebDriver;


public class RiderIdPage {
    private WebDriver driver;
    public RiderIdPage(WebDriver driver) {
        this.driver = driver;
    }

    public Tittle getTittle() {
        return new Tittle(driver);
    }
}
