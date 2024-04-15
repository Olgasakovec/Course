package sacovec.olga;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Silverscreen {
    static ChromeOptions options;
    static WebDriver driver;
    private final By afishaButtoLocator = By.xpath("//span[text()='Афиша']");
    private final By currentAfishaLocator = By.xpath("//a[@href='/afisha/#now' and div[text()='Сейчас в кино']]");

    private By afishaKinoLocator = By.xpath("//h1[text()='Афиша кино']");
    private By skoroLokator = By.xpath("//a[@href='#soon']");
    private By vseMesytciLocator = By.xpath("//div[@placeholder = 'Все месяцы']//div[@class='btn-text' and text()='Все месяцы']");
    private By filterLocator = By.xpath("//div[@class='btn-text' and contains(text(), 'сегодня')]");

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
        String expectedText4 = "сегодня";
        String actualText4 = filter.getText();
        Assertions.assertTrue(actualText4.contains(expectedText4),"сегодня");
    }
}
