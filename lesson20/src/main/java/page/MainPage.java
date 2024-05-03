package page;

import component.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private By developerToolsLocator = By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']");
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo(String url) {
        driver.get(url);
        return  this;
    }

    public JetbrainsPage developerToolsClick() {
        driver.findElement(developerToolsLocator).click();
        return new JetbrainsPage(driver);
    }



}
