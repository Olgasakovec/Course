package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static step.CommonStep.getDriver;

public class TestNGDocumentationStepDefinition {

    @When("Click to the link '3. TestNG Documentation'")
    public void clickToTheLink() {
        getDriver().findElement(By.xpath("//div[@id='toc']//a[@href='#_testng_documentation']")).click();
    }

    @And("Navigate to the menu '3.2. Annotations'")
    public void navigateToTheMenu() {
        getDriver().findElement(By.xpath("//div[@id='tocbot']//a[@href='#_annotations']")).click();
    }

    @Then("Check that table consist 3 columns")
    public void checkThatTableConsistThreeColumns() {
        List<WebElement> colTags = getDriver().findElements(By.xpath("//h3[@id='_annotations']//parent::div//col"));
        int numberOfColTags = colTags.size();
        Assertions.assertEquals(3, numberOfColTags);
    }
}
