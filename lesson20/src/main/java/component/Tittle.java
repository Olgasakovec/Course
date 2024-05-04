package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tittle {
    private WebDriver driver;

    private By linkTextLocator = By.xpath("//a[@class='rider-header-section__hero-text__link' and text()='part of dotUltimate']");

    public Tittle(WebDriver driver) {
        this.driver = driver;
    }

    public boolean linkTextCorrect() {
        WebElement linkElement = driver.findElement(linkTextLocator);
        String linkText = linkElement.getText();
        return linkText.equals("part of dotUltimate");
    }
}