package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class TestNGDocumentationStepDefinition {
    private static WebDriver driver;

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Given("Navigate to the page {string} url")
    public void navigateToThePageUrl(String url) {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @When("Maximize window")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @And("Click to the link '3. TestNG Documentation'")
    public void clickToTheLink() {
        driver.findElement(By.xpath("//div[@id='toc']//a[@href='#_testng_documentation']")).click();
    }

    @And("Navigate to the menu '3.2. Annotations'")
    public void navigateToTheMenu() {
        driver.findElement(By.xpath("//div[@id='tocbot']//a[@href='#_annotations']")).click();
    }

    @Then("Check that table consist 3 columns")
    public void checkThatTableConsistThreeColumns() {
        List<WebElement> colTags = driver.findElements(By.xpath("//div[@class='sect2']//table[@class='tableblock frame-all grid-all stretch']/colgroup/col"));
        int numberOfColTags = colTags.size();
        Assertions.assertEquals(3, numberOfColTags);
    }
}
