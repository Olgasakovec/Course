package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    private WebDriver driver;

    private By riderLocator = By.xpath("//div[@data-test='main-submenu']//a[@href='/rider/']");
    private By jetBrainsAiLocator = By.xpath("//div[@data-test='main-submenu']//a[@href='/ai/']");

    public DropDown(WebDriver driver){
    this.driver = driver;
    }

    public DropDown clickMenuRider() {
        driver.findElement(riderLocator).click();
        return new DropDown(driver);
    }

    public DropDown clickJetBrainsAi() {
        driver.findElement(jetBrainsAiLocator).click();
        return new DropDown(driver);
    }

}
