package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotoOtchetPage {
    private WebDriver driver;

    private By photoFormatLocator = By.xpath("//div[@title='Фотоотчеты' and contains(div[@class='CategoriesMainMenu__itemIcon']/@style, '.svg')]");

    public PhotoOtchetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getImageSource() {
        WebElement imageElement = driver.findElement(photoFormatLocator);
        String backgroundImageUrl = imageElement.getCssValue("background-image");
        return backgroundImageUrl;
    }

    @FindBy(xpath = "//a[@class='List__item CategoriesSubMenu__title h6' and text()='Все фотоотчеты']")
    private WebElement photoOtchetButton;

    public WebElement getPhotoOtchetButton() {
        return photoOtchetButton;
    }
}
