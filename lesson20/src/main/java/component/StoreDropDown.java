package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.JetBrainsAiPage;


public class StoreDropDown {
    private WebDriver driver;

    private By jetBrainsAiLocator = By.xpath("//div[@data-test='main-menu-item' and @data-test-marker='Store']//span[contains(text(), 'JetBrains AI')]");


    public StoreDropDown(WebDriver driver) {
        this.driver = driver;
    }

    public JetBrainsAiPage clickJetBrainsAi() {
        driver.findElement(jetBrainsAiLocator).click();
        return new JetBrainsAiPage(driver);
    }
}
