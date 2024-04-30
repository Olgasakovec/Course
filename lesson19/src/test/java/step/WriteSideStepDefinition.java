package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class WriteSideStepDefinition {
        public WriteSideStepDefinition() {
        }

        @And("Turn on the 'Play' button")
        public void turnOnThePlayButton() {
            WebElement playButton = BaseTest.getDriver().findElement(By.xpath("//button[@data-test='youtube-player-button']"));
            WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10L));
            wait.until(ExpectedConditions.elementToBeClickable(playButton));
            playButton.click();
        }

        @Then("Verify that 'Getting Started With Writerside' tittle is displayed")
        public void verifyThatGettingStartedWithWritersideTittle() {
            WebElement linkElement = BaseTest.getDriver().findElement(By.xpath("//a[contains(text(), 'Getting Started With Writerside')]"));
            Assertions.assertEquals("Getting Started With Writerside", linkElement);
        }
    }
}
