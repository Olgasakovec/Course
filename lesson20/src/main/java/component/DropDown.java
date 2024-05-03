package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDown {
    private WebDriver driver;

    private By riderLocator = By.xpath("//div[@data-test='main-submenu']//a[@href='/rider/']");

    public DropDown(WebDriver driver){
    this.driver = driver;
    }

    public DropDown clickRider(){
        driver.findElement(riderLocator).click();
        return new
    }

}
