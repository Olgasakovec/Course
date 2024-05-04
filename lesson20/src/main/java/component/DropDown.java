package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.JetbrainsPage;
import page.PhpStorm;

public class DropDown {
    private WebDriver driver;

    private By riderLocator = By.xpath("//div[@data-test='main-submenu']//a[@href='/rider/']");
private By phpStormLocator = By.xpath("//div[@data-test='main-submenu']//a[@href='/phpstorm/']");

    public DropDown(WebDriver driver){
    this.driver = driver;
    }

    public JetbrainsPage clickRider() {
        driver.findElement(riderLocator).click();
        return new JetbrainsPage(driver);
    }

    public PhpStorm clickPhpStorm() {
        driver.findElement(phpStormLocator).click();
        return  new PhpStorm(driver);
    }
}
