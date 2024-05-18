package page;

import component.Button;
import component.util.ExtendedFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotoOtchetPage {
    private WebDriver driver;

    private By photoFormatLocator = By.xpath("//div[contains(@class, 'CategoriesMainMenu__itemIcon') and contains(@style, '.svg') and ancestor::div[@title='Фотоотчеты']]");

    public PhotoOtchetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
     }

    public String getImageSource() {
        WebElement imageElement = driver.findElement(photoFormatLocator);
        return imageElement.getCssValue("background-image");
    }

    @FindBy(xpath = "//a[@class='List__item CategoriesSubMenu__title h6' and text()='Все фотоотчеты']")
    private Button photoOtchetButton;

    public Button getPhotoOtchetButton() {
        return photoOtchetButton;
    }
}

