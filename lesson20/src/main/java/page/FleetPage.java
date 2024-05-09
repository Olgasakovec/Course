package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FleetPage {
    private WebDriver driver;
    private By downloadButtonLocator = By.xpath("//div[@class='wt-col-12']//a[@data-test='button' and @href='/fleet/download/']");

    public FleetPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDownloadButtonEnabled() {
        WebElement downloadButton = driver.findElement(downloadButtonLocator);
        return downloadButton.isEnabled();
    }
}

