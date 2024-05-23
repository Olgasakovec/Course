package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpectakliPage {
    private WebDriver driver;

    private By spectakliLocator = By.xpath("//div[@class='b-cityes_item_block']/a[@href='https://afisha.relax.by/theatre/minsk/']");

    public SpectakliPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SpectakliPage clickSpectakliPage() {
        driver.findElement(spectakliLocator).click();
        return new SpectakliPage(driver);
    }
    public SpectakliPage selectCategory(String category) {
        String categoryLocator = String.format("//li[@class='afisha-links__item js-afisha-links-item']/a[@href='https://afisha.relax.by/theatre/minsk/%s/']", category);
        driver.findElement(By.xpath(categoryLocator)).click();
        return new SpectakliPage(driver);
    }

    @FindBy(xpath = "//div[@id='searchWrap']//h1")
    private WebElement title;

    public WebElement getTitleElement() {
        return title;
    }
}
