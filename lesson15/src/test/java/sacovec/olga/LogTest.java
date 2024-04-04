package sacovec.olga;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogTest {

    static ChromeOptions options;
    static WebDriver driver;

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver.manage().window().maximize();
        options = new ChromeOptions();
    }
    @BeforeEach
    void prepareBrowser(){
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void closeBrowser(){
        driver.close();
    }

    @Test
    void loginTest(){
        String userDir = System.getProperty("user.dir");
        driver.get("file:///" + userDir + "/src/test/java/sacovec/olga/Variant3.html");

        WebElement inputField = driver.findElement(By.id("field1"));
        inputField.sendKeys("55555");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(inputField, "value", "555"));

        WebElement passwordField = driver.findElement(By.id("field2"));
        String expectedText = "123qwerty";
        passwordField.sendKeys(expectedText);

        String actualText = passwordField.getAttribute("value");
        Assertions.assertEquals(expectedText, actualText);

        String fieldType = passwordField.getAttribute("type");
        Assertions.assertEquals("password", fieldType);

        WebElement numberField = driver.findElement(By.id("field3"));
        String letters = "text";
        numberField.sendKeys(letters);

        String textInField = numberField.getAttribute("value");
        Assertions.assertTrue(textInField.isEmpty());

        String numbers = "12345";
        numberField.sendKeys(numbers);

        String numberInField = numberField.getAttribute("value");
        Assertions.assertEquals(numbers, numberInField);
    }

    @Test
    public void testPageTitle() {
        String userDir = System.getProperty("user.dir");
        driver.get("file:///" + userDir + "/src/test/java/sacovec/olga/Variant3.html");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Expected title";
        Assertions.assertEquals(expectedTitle, actualTitle);

        String labelText = driver.findElement(By.className("btn")).getText();
        Assertions.assertEquals("Expected label Text", labelText);

        String buttonTextColor = driver.findElement(By.className("btn")).getCssValue("color");
        Assertions.assertEquals("orange", buttonTextColor);

        WebElement image = driver.findElement(By.name("Git"));
        int imageWidth = image.getSize().getWidth();
        int imageHeight = image.getSize().getHeight();
        Assertions.assertEquals(100, imageWidth);
        Assertions.assertEquals(55, imageHeight);

        String imageSrc = image.getAttribute("src");
        Assertions.assertTrue(imageSrc.endsWith(".png"));
    }

    @Test
    public void testLastButton() {
        WebElement lastField = driver.findElement(By.id("field3"));
        String lastFieldText = "12345";
        lastField.sendKeys(lastFieldText);

        WebElement firstField = driver.findElement(By.id("field1"));
        String firstFieldText = "Yes";
        firstField.sendKeys(firstFieldText);

        Assertions.assertEquals(lastFieldText, lastField.getAttribute("value"));
        Assertions.assertEquals(firstFieldText, firstField.getAttribute("value"));
        WebElement secondFile = driver.findElement(By.name("field2"));
        Assertions.assertEquals("", secondFile.getAttribute("value"));

        WebElement buttonSend = driver.findElement(By.xpath("//button[text()='Send']"));
        Assertions.assertTrue(buttonSend.isEnabled());
        buttonSend.click();
        Assertions.assertEquals(driver.getCurrentUrl(), "file:///D:/course/lesson15/src/test/java/sacovec/olga/Variant3.html" );

        WebElement buttonCancel = driver.findElement(By.xpath("//button[text()='Cancel']"));
        Assertions.assertTrue(buttonCancel.isEnabled());

        WebElement redirectButton = driver.findElement(By.className("btn"));
        redirectButton.click();
        Assertions.assertEquals(driver.getCurrentUrl(), "file:///D:/course/lesson15/src/test/java/sacovec/olga/Variant3.html");
    }
}
