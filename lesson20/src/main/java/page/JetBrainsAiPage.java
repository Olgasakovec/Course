package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JetBrainsAiPage {

    private WebDriver driver;

    private By watchVideoLocator = By.xpath("//button[@aria-label='Play video' and contains(@class, 'video-preview__button')]");
    private By videoTitleLocator = By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink' and text()='JetBrains AI Assistant']");
    private By iFrameLocator = By.xpath("//iframe[@class='wt-youtube-player__player']");

    public JetBrainsAiPage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkVideoTitle() {
        WebElement iframeElement = driver.findElement(iFrameLocator);
        driver.switchTo().frame(iframeElement);
        String videoTitle = driver.findElement(videoTitleLocator).getText();
        driver.switchTo().defaultContent();
        return videoTitle;
    }

    public JetBrainsAiPage clickWatchVideo() {
        driver.findElement(watchVideoLocator).click();
        return new JetBrainsAiPage(driver);
    }
}
