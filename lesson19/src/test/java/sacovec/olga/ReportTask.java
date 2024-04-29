package sacovec.olga;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import step.BaseTest;

import java.time.Duration;

public class ReportTask {
    private ChromeOptions options;
    private WebDriver driver;

    @BeforeClass
    public void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void checkdeveloperTools() {
        driver.get("https://www.jetbrains.com/");
        WebElement developerTools = BaseTest.getDriver().findElement(By.xpath("//button[@aria-label='Developer Tools: Open submenu' and @data-test='main-menu-item-action']"));
        developerTools.click();

        WebElement pyCharmClick = BaseTest.getDriver().findElement(By.xpath("//a[@href='/pycharm']"));
        pyCharmClick.click();

        WebElement downloadButton = BaseTest.getDriver().findElement(By.xpath("//a[@data-test='button' and @href='/pycharm/download/' and @type='button')]"));
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));

        if (downloadButton.isEnabled()) {
            System.out.println("The 'Download' button is enabled. Proceeding to click.");
            downloadButton.click();
        } else {
            System.out.println("The 'Download' button is disabled. Cannot proceed.");
        }
    }
}

