package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.FleetPage;
import page.RiderPage;

public class ToolsDropDown {
    private WebDriver driver;

    private By riderLocator = By.xpath("//div[@data-test='main-submenu']//a[@href='/rider/']");

    private By fleetLocator = By.xpath("//div[@data-test='main-submenu']//a[@href='/fleet/']");
    public ToolsDropDown(WebDriver driver){
        this.driver = driver;
    }

    public RiderPage clickMenuRider() {
        driver.findElement(riderLocator).click();
        return new RiderPage(driver);
    }

    public FleetPage clickMenuFleet() {
        driver.findElement(fleetLocator).click();
        return new FleetPage(driver);
    }
}
