package sacovec.olga;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Silverscreen {
    static ChromeOptions options;
    static WebDriver driver;
    private final By afishaButtoLocator = By.xpath("//div[@class='sc-iNhVCk iUChfV']");
    private final By currentAfishaLocator = By.xpath("//a[@href='/afisha/#now' and div[text()='Сейчас в кино']]");

    private By afishaKinoLocator = By.cssSelector("#root > div > section > div.sc-gPWkxV.iwdBzY > div > h1");
    private By skoroLokator = By.cssSelector("#root > div > section > div.sc-gPWkxV.iwdBzY > div > div > div.sc-lnrBVv.OWfMz > a");
    private By vseMesytciLocator = By.cssSelector("#root > div > section > div.sc-bZQynM.MMlga > div.sc-gzVnrw.kjntmi > div > div.sc-eNQAEJ.gewano");
    private By filterLocator = By.xpath("//*[@id='root']/div/section/div[2]/div[2]/div/div[1]/div[2]");

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
    public void afisha() {
        driver.get("https://silverscreen.by/");
        driver.manage().window().maximize();

        WebElement afishaElement = driver.findElement(afishaButtoLocator);
        afishaElement.click();

        Actions actions = new Actions(driver);
        WebElement currentAfishaElement = driver.findElement(currentAfishaLocator);
        actions.moveToElement(currentAfishaElement).perform();

        driver.get("https://silverscreen.by/afisha/");
        WebElement afishaKino = driver.findElement(afishaKinoLocator);
        String expectedText = "Афиша кино";
        String actualText = afishaKino.getText();
        Assertions.assertEquals(expectedText, actualText);
        WebElement skoro = driver.findElement(skoroLokator);
        String expectedText2 = "Скоро";
        String actualText2 = skoro.getText();
        Assertions.assertEquals(expectedText2, actualText2);
    }

    @Test
    public void monthCheck(){
        driver.get("https://silverscreen.by/");
        driver.manage().window().maximize();

        WebElement afishaElement = driver.findElement(afishaButtoLocator);
        afishaElement.click();

        Actions actions = new Actions(driver);
        WebElement currentAfishaElement = driver.findElement(currentAfishaLocator);
        actions.moveToElement(currentAfishaElement).perform();

        driver.get("https://silverscreen.by/afisha/");
        WebElement skoro = driver.findElement(skoroLokator);
        skoro.click();

        WebElement vseMesytci = driver.findElement(vseMesytciLocator);
        String expectedText3 = "Все месяцы";
        String actualText3 = vseMesytci.getText();
        Assertions.assertEquals(expectedText3, actualText3);
    }

    @Test
    public void filter(){
        driver.get("https://silverscreen.by/");
        driver.manage().window().maximize();

        WebElement afishaElement = driver.findElement(afishaButtoLocator);
        afishaElement.click();

        Actions actions = new Actions(driver);
        WebElement currentAfishaElement = driver.findElement(currentAfishaLocator);
        actions.moveToElement(currentAfishaElement).perform();

        driver.get("https://silverscreen.by/afisha/");
        WebElement filter = driver.findElement(filterLocator);
        Assertions.assertTrue(filter.isDisplayed());
        String actualText4 = filter.getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM", new Locale("ru", "RU"));
        LocalDate currentDate = LocalDate.now();
        String currentDateString = "сегодня, " + dtf.format(currentDate);
        String expectedText4 = currentDateString;
        Assertions.assertEquals(expectedText4, actualText4);
    }
}
