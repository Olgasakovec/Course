package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComediaPage {

    private WebDriver driver;

    private By comediaLocator = By.xpath("//li[@class='afisha-links__item js-afisha-links-item']/a[@href='https://afisha.relax.by/theatre/minsk/comedia/']");

    private By titleComediaVMinskeLocator = By.xpath("//div[@class='flex-box flex-row flex-ai-center']/div[@class='flex-stretch search-flex-wrap search-flex-wrap_afisha']/div[@class='b-search_wrap b-search-afisha has_title']/h1[text()='Спектакль-комедия в Минске']");


    public ComediaPage(WebDriver driver) {
        this.driver = driver;
    }

    public ComediaPage clickComedia() {
        driver.findElement(comediaLocator).click();
        return new ComediaPage(driver);
    }

    public String checkTitleComediaVMinske() {
        String title = driver.findElement(titleComediaVMinskeLocator).getText();
        return title;
    }
}

