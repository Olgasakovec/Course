package sacovec.olga;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class jetbraince extends BaseTest {

    @Test
    void checkRoboPoJoGenerator() {
        getDriver().get("https://www.jetbrains.com/");
        WebElement developerTools = getDriver().findElement(By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']"));
        developerTools.click();
        WebElement clickallPlugins = getDriver().findElement(By.xpath("//div[@class='wt-offset-top-12']//a[@href='/https://plugins.jetbrains.com/"));
        clickallPlugins.click();
        WebElement roboPoJoGenerator = getDriver().findElement(By.xpath("//div[@data-test='input__inner']"));
        roboPoJoGenerator.sendKeys("RoboPoJoGenerator");
        WebElement searchIcon = getDriver().findElement(By.xpath("//button[@data-test='search-icon']"));
        searchIcon.click();
        WebElement cardrobo = getDriver().findElement(By.xpath("//div[@data-testid='plugin-card']//a[@href='/plugin/8634-robopojogenerator']"));
        cardrobo.isDisplayed();

    }
}



