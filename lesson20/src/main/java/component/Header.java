package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Header {

    private WebDriver driver;

    private By developerToolsLocator = By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void developerToolsClick(){
        driver.findElement(developerToolsLocator).click();
    }


}