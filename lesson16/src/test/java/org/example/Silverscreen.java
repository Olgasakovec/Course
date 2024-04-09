package org.example;

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

public class Silverscreen {
    static ChromeOptions options;
    static WebDriver driver;
    private final static String url = "https://silverscreen.by/";

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
        driver.get(url);
    }

    @AfterEach
    void closeBrowser(){
        driver.close();
    }

    @Test
    public void afisha() {
        driver.get(url);
        WebElement afishaElement = driver.findElement(By.cssSelector("span.sc-ckVGcZ.hXNtTL"));
        afishaElement.click();

        WebElement clickKino = driver.findElement(By.xpath("//a[contains(@href, '/afisha/#now')]"));
        clickKino.click();


        WebElement textAfisha = driver.findElement(By.xpath("//*[contains(text(), 'Афиша кино')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(textAfisha, "attributeName", "expectedValue"));
        Assertions.assertTrue(textAfisha.isDisplayed(), "Афиша кино");

        WebElement textSkoro = driver.findElement(By.xpath("//*[contains(text(), 'Скоро')]"));
        wait.until(ExpectedConditions.visibilityOf(textSkoro));
        Assertions.assertTrue(textSkoro.isDisplayed(), "Скоро");



    }

}
