package step;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

public class TestNGDocumentationStepDefinition {
    @After
    public void closeDriver(){
        driver.quit();
    }
    private WebDriver driver;
    @Given("Navigate to the page {string} url")
    public void navigateToThePageUrl(String url){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @When("Maximize window")
    public void MaximizeWindow(){
        driver.manage().window().maximize();
    }

    @And("Click to the link '3. TestNG Documentation'")
    public void clickToTheLink (){
        driver.findElement(By.xpath("//div[@id='toc']//a[@href='#_testng_documentation']")).click();
    }

    @And("Navigate to the menu '3.2. Annotations'")
    public void navigateToTheMenu (){
        driver.findElement(By.xpath("//ul[@class='toc-list']//a[@href='#_annotations']")).click();
    }

    @Then("Check that table consist 3 columns")
    public void checkThatTableConsistThreeColumns (){
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='your-table-class']//td"));
        int numberOfColumns = columns.size();
        Assertions.assertEquals(3, numberOfColumns, "The table does not consist of 3 columns");
    }
}
