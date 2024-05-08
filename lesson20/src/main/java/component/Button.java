package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    private WebDriver driver;

    private By watchVideoLocator = By.xpath("//button[@aria-label='Play video' and contains(@class, 'video-preview__button')]");
    public Button(WebDriver driver){
        this.driver = driver;
    }

    public Button clickWatchVideo() {
        driver.findElement(watchVideoLocator).click();
        return new Button(driver);
    }


}
