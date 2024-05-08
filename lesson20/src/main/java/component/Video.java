package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Video {

    private WebDriver driver;

    private By videoTitleLocator = By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink' and text()='JetBrains AI Assistant']");
    private By iFrameLocator = By.xpath("//iframe[@class='wt-youtube-player__player']");
    public Video(WebDriver driver){
        this.driver = driver;
    }

    public Video checkVideoTitle() {
        driver.findElement(videoTitleLocator).click();
        return new Video(driver);
    }

    public Video iFrame() {
        driver.findElement(iFrameLocator).click();
        return new Video(driver);
    }
}
