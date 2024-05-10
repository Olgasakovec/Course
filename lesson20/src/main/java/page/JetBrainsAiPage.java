package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JetBrainsAiPage {

    private WebDriver driver;

    private By watchVideoLocator = By.xpath("//button[@aria-label='Play video' and contains(@class, 'video-preview__button')]");
    private By videoTitleLocator = By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink' and text()='JetBrains AI Assistant']");
    private By iFrameLocator = By.xpath("//iframe[@class='wt-youtube-player__player']");

    public JetBrainsAiPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getVideoTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iFrameLocator));
        driver.switchTo().frame(iframeElement);

        WebElement videoTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(videoTitleLocator));
        String videoTitle = videoTitleElement.getText();

        driver.switchTo().defaultContent();
        return videoTitle;
    }

    public JetBrainsAiPage clickWatchVideo() {
        driver.findElement(watchVideoLocator).click();
        return new JetBrainsAiPage(driver);
    }
}
