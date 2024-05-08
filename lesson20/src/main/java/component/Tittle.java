package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.RiderPage;

public class Tittle {
    private WebDriver driver;

    private By linkTextLocator = By.xpath("//a[@class='rider-header-section__hero-text__link' and text()='part of dotUltimate']");

    public Tittle(WebDriver driver) {
        this.driver = driver;
    }

    public RiderPage checkLinkTextCorrect() {
       driver.findElement(linkTextLocator).getText();
        return new RiderPage(driver);
    }
}