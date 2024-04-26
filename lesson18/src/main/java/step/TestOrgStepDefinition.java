package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static step.CommonStep.getDriver;

public class TestOrgStepDefinition {

    @Given("Navigate to the webpage {string} url")
    public void navigateToTheWebpageUrl(String url) {
       getDriver().get(url);
    }

    @And("Click to the link in the left menu '13. The TestNG TextBook: Next Generation Java Testing'")
    public void clickToTheLinkInTheLeft() {
        getDriver().findElement(By.xpath("//div[@id='tocbot']//a[@href='#_the_testng_textbook_next_generation_java_testing']")).click();
    }

    @Then("Check that image format is .jpg")
    public void checkThatImageFormatIsJpg() {
        WebElement image = getDriver().findElement(By.xpath("//div[@class='imageblock']//img[@src='pics/book-cover.jpg']"));
        String imageSource = image.getAttribute("src");
        Assertions.assertTrue(imageSource.endsWith(".jpg"));
    }
}
