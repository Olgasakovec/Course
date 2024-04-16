package sacovec.olga;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Junit {
    static ChromeOptions options;
    static WebDriver driver;

    private By userGuideLocator = By.xpath("a[href='/junit5/docs/current/user-guide']//");

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser(){
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void closeBrowser(){
        driver.close();
    }

    @Test
    public void runner(){
        driver.get("https://junit.org/junit5/");
        driver.manage().window().maximize();

        WebElement userGuided = driver.findElement(userGuideLocator);


    }
}
