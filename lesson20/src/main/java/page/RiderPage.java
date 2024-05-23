package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RiderPage {
    private WebDriver driver;
    private By linkTextLocator = By.xpath("//a[@class='rider-header-section__hero-text__link' and text()='part of dotUltimate']");

    public RiderPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLinkText() {
        return driver.findElement(linkTextLocator).getText();
    }
}
