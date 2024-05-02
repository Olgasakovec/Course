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
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        By iframeElementLocator = By.xpath("//div[@class='wt-youtube-player wt-youtube-player_show-video']//iframe[@class='wt-youtube-player__player' and @title='Getting Started With Writerside']");
        boolean result = wait.until(ExpectedConditions.textToBePresentInElementLocated(iframeElementLocator, "Getting Started With Writerside"));
        Assertions.assertTrue(result, "Expected text is not present in the element");
    }
}

