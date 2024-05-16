package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.PhotoOtchetPage;
import page.SpectakliPage;

public class NavigationMenu {
    private WebDriver driver;

    private By afishaKinoLocator = By.xpath("//div[@class='Gallery__list CategoriesMainMenu__list']/a[@href='https://afisha.relax.by/minsk/']");
    private By photoOtchetLocator = By.xpath("//div[@class='CategoriesMainMenu__item' and @title='Фотоотчеты']");
    private By vsePhotoOtcheti = By.xpath("//a[@class='List__item CategoriesSubMenu__title h6' and text()='Все фотоотчеты']");

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
    }

    public SpectakliPage clickAfishaKino() {
        driver.findElement(afishaKinoLocator).click();
        return new SpectakliPage(driver);
    }

    public PhotoOtchetPage clickPhotoOtchet() {
        driver.findElement(photoOtchetLocator).click();
        return new PhotoOtchetPage(driver);
    }

}
