package page;

import component.DropDown;
import component.Header;
import component.Tittle;
import component.Video;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

     private WebDriver driver;

    private By developerToolsLocator = By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']");

    private By storeLocator = By.xpath("//button[@type='button' and @aria-label='Store: Open submenu']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo(String url) {
        driver.get(url);
        return  this;
    }

    public MainPage clickDeveloperTools() {
        driver.findElement(developerToolsLocator).click();
        return new MainPage(driver);
    }

    public MainPage clickStore() {
        driver.findElement(storeLocator).click();
        return new MainPage(driver);
    }

    public DropDown getDropDown() {
        return new DropDown(driver);
    }

    public Header getHeader() {
        return new Header(driver);
    }
}
