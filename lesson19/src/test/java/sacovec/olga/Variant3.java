package sacovec.olga;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Variant3 extends BaseTest{

    @Test
    public void checkSdcDocsText() {
        driver.get("https://www.jetbrains.com");
        WebElement developerToolClick = driver.findElement(By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']"));
        developerToolClick.click();

        WebElement writerSide = driver.findElement(By.xpath("a[@href='/writerside']"));
        writerSide.click();
    }

    @Test
    public void tittleGettingStartedWithWriterside(){
        driver.get(url);
        WebElement developerToolClick = driver.findElement(By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']"));
        developerToolClick.click();

        }


}
