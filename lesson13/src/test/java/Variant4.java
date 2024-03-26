import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
       Создайте отдельный класс, гду у вас будут запускаться ваши тесты.
       В классе для тестов скачайте драйвер браузера через WebDriverManager, драйвер может быть Chrome, Firefox или Safari если у вас Mac.
       В классе для тестов создайте отдельный метод, для скачивания драйвера. Этот метод должен выполняться до запуска всех тестов в тестовом классе.
       Для вызова метода скачивания драйвера до всех тестов в текущей классе используйте необходимую аннотацию из Junit5.

       В классе для тестов создайте отдельный метод, для открытия браузера с помощью АПИ интерфейса WebDriver.
       Этот метод должен выполняться до запуска каждого теста в тестовом классе.
       Для вызова метода открытия браузера до каждого теста в текущей классе используйте необходимую аннотацию из Junit5.
        */

public class Variant4 {
    private WebDriver driver;

    @BeforeAll
    public static void downloadDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void test1() {
        WebDriver driver = new ChromeDriver();
    }

    @BeforeEach
    void openBrowser(){
        driver = new ChromeDriver();
    }
}