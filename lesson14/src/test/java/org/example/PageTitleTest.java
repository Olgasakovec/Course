package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
        С помощью DOM спарсите client.xml и получите companySite предпоследнего клиента
        Напишите тест, который будет переходит по url из параметра companySite предпоследнего клиента и проверять,
        что заголовок сайта на который был переход имеет значения EPAM | Software Engineering & Product Development Services
        Проверку выполнить через jUnit5.
         */
public class PageTitleTest {

    @Test
    void task(){
        WebDriver driver = new ChromeDriver();
        driver.get(companySite);

    }
}
