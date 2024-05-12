package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpectakliPage {
    private WebDriver driver;

    private By spectakliLocator = By.xpath("//div[@class='b-cityes_item_block']/a[@href='https://afisha.relax.by/theatre/minsk/']");

    public SpectakliPage(WebDriver driver) {
        this.driver = driver;
    }

    public MuziclPage clickSpectakliToMuziclPage() {
        driver.findElement(spectakliLocator).click();
        return new MuziclPage(driver);
    }

    public BalletPage clickSpectakliToBalletPage() {
        driver.findElement(spectakliLocator).click();
        return new BalletPage(driver);
    }

    public ComediaPage clickSpectakliToComeediPage() {
        driver.findElement(spectakliLocator).click();
        return new ComediaPage(driver);
    }
}
