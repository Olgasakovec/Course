package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BalletPage {

    private WebDriver driver;

    private By balletLocator = By.xpath("//li[@class='afisha-links__item js-afisha-links-item']/a[@href='https://afisha.relax.by/theatre/minsk/balet/']");

    private By titleBalletVMinskeLocator = By.xpath("//div[@class='b-search b-search__afisha']//h1[text()='Балет в Минске']");

    public BalletPage(WebDriver driver) {
        this.driver = driver;
    }

    public BalletPage clickBallet() {
        driver.findElement(balletLocator).click();
        return new BalletPage(driver);
    }

    public String checkTitleBalletVMinske() {
        String title = driver.findElement(titleBalletVMinskeLocator).getText();
        return title;
    }
}
