package step;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JetbrainsSecondTaskStepDefinition {

    @Then("Turn on the 'Play' button")
    public void turnOnThePlayButton() {
        WebElement playButton = BaseTest.getDriver().findElement(By.xpath("//div[@class='wt-youtube-player__link' and @data-test='youtube-player-button'])"));
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(playButton));
        playButton.click();
    }

    @Then("Verify that 'Getting Started With Writerside' tittle is displayed")
    public void verifyThatGettingStartedWithWritersideTittleIsIisplayed() {
        WebElement videoTitle = BaseTest.getDriver().findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']"));
        String titleText = videoTitle.getText();

        if (titleText.contains("Getting Started With Writerside")) {
            System.out.println("Video title 'Getting Started With Writerside' is visible.");
        } else {
            System.out.println("Video title 'Getting Started With Writerside' is not visible.");
        }
    }
}
