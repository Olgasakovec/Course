package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WriteSideStepDefinition {
    public WriteSideStepDefinition() {
    }

    @And("Turn on the 'Play' button")
    public void turnOnThePlayButton() {
        WebElement playButton = BaseTest.getDriver().findElement(By.xpath("//button[@data-test='youtube-player-button']"));
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(playButton));
        playButton.click();
    }

    @Then("Verify that 'Getting Started With Writerside' tittle is displayed")
    public void verifyThatGettingStartedWithWritersideTittle() {
        By iFrameLocator = By.xpath("//iframe[@class='wt-youtube-player__player']");
        WebElement iFrame = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(iFrameLocator));
        BaseTest.getDriver().switchTo().frame(iFrame);

        By videoTitleLocator = By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink' and text()='Getting Started With Writerside']");
        WebElement videoTitle = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(videoTitleLocator));
        Assertions.assertEquals("Getting Started With Writerside", videoTitle.getText());
    }
}

