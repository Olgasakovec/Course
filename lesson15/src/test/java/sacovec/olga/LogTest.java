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
    private final static String url = "file:///"+System.getProperty("user.dir")+"/src/test/java/sacovec/olga/Variant3.html";

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser(){
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String userDir = System.getProperty("user.dir");
        driver.get("file:///" + userDir + "/src/test/java/sacovec/olga/Variant3.html");
    }

    @AfterEach
    void closeBrowser(){
        driver.close();
    }

    @Test
    void loginTest(){
        WebElement inputField = driver.findElement(By.id("field1"));
        inputField.sendKeys("55555");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(inputField, "value", "555"));
        String fieldValue = inputField.getAttribute("value");
        Assertions.assertTrue(fieldValue.length()<=3);

        WebElement passwordField = driver.findElement(By.id("field2"));
        String expectedText = "123qwerty";
        passwordField.sendKeys(expectedText);

        String actualText = passwordField.getAttribute("value");
        Assertions.assertEquals(expectedText, actualText);

        String fieldType = passwordField.getAttribute("type");
        Assertions.assertEquals("password", fieldType);

        WebElement textField = driver.findElement(By.id("field3"));
        String letters = "text";
        textField.sendKeys(letters);
        String textInField = textField.getAttribute("value");
        Assertions.assertTrue(textInField.isEmpty(), "Поле должно оставаться пустым после ввода букв");
        textField.clear();

        WebElement numberField = driver.findElement(By.id("field3"));
        String numbers = "12345";
        numberField.sendKeys(numbers);
        String numberInField = numberField.getAttribute("value");
        Assertions.assertEquals(numbers, numberInField, "Цифры в поле не соответствуют");
    }

    @Test
    public void testPageTitle() {
        String expectedTitle = "Varian3";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

        WebElement labelField2 = driver.findElement(By.cssSelector("label[for='field2']"));
        String expectedLabelText = "Введите пароль:";
        String actualLabelText = labelField2.getText();
        Assertions.assertEquals(expectedLabelText, actualLabelText);

        String buttonTextColor = driver.findElement(By.className("btn")).getCssValue("color");
        Assertions.assertEquals("rgba(255, 165, 0, 1)", buttonTextColor);

        WebElement image = driver.findElement(By.cssSelector("img[alt='Git']"));
        int imageWidth = image.getSize().getWidth();
        int imageHeight = image.getSize().getHeight();
        Assertions.assertEquals(100, imageWidth);
        Assertions.assertEquals(55, imageHeight);

        String imageSrc = image.getAttribute("src");
        Assertions.assertTrue(imageSrc.endsWith(".png"));
    }

    @Test
    public void testLastButton() {
        WebElement firstField = driver.findElement(By.id("field1"));
        String firstFieldText = "Yes";
        firstField.sendKeys(firstFieldText);
        Assertions.assertEquals(firstFieldText, firstField.getAttribute("value"));

        WebElement lastField = driver.findElement(By.id("field3"));
        String lastFieldText = "12345";
        lastField.sendKeys(lastFieldText);
        Assertions.assertEquals(lastFieldText, lastField.getAttribute("value"));

        WebElement secondFile = driver.findElement(By.name("field2"));
        Assertions.assertEquals("", secondFile.getAttribute("value"));

        WebElement buttonSend = driver.findElement(By.xpath("//button[text()='Send']"));
        Assertions.assertTrue(buttonSend.isEnabled());
        buttonSend.click();
        Assertions.assertEquals(driver.getCurrentUrl(), url, "URL не совпадает");

        WebElement buttonCancel = driver.findElement(By.xpath("//button[text()='Cancel']"));
        Assertions.assertTrue(buttonCancel.isEnabled());

        WebElement redirectButton = driver.findElement(By.className("btn"));
        redirectButton.click();
        Assertions.assertEquals(driver.getCurrentUrl(), url, "URL совпадает");
    }
}
