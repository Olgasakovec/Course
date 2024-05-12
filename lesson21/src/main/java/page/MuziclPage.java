package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MuziclPage {
    private WebDriver driver;

    private By muziclLocator = By.xpath("//li[@class='afisha-links__item js-afisha-links-item']/a[@href='https://afisha.relax.by/theatre/minsk/musical/']");

    private By titleMuziclVMinskeLocator = By.xpath("//div[@class='flex-box flex-row flex-ai-center']/div[@class='flex-stretch search-flex-wrap search-flex-wrap_afisha']/div[@class='b-search_wrap b-search-afisha has_title']/h1[text()='Мюзикл в Минске']");


    public MuziclPage(WebDriver driver) {
        this.driver = driver;
    }

    public MuziclPage clickMuzicl() {
        driver.findElement(muziclLocator).click();
        return new MuziclPage(driver);
    }

    public String checkTitleMuziclVMinske() {
        String title = driver.findElement(titleMuziclVMinskeLocator).getText();
        return title;
    }
}
