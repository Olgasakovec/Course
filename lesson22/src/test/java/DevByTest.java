import Page.MainPage;
import Page.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DevByTest extends BaseTest {

    @Test
    void testFitbit() {
        new MainPage(getDriver())
                .navigateTo("https://devby.io/")
                .getNavBar()
                .clickMenu()
                .clickCompany()
                .inputCompany("bit")
                .isCompanyFound("Fitbit")
                .isQuantityMoreThanZero("Fitbit")
                .aboveQuantityMoreThanZero("Fitbit")
                .belowQuantityMoreThanZero("Fitbit");
    }

    @Test
    void testBimSolutions() {
        new MainPage(getDriver())
                .navigateTo("https://devby.io/")
                .getNavBar()
                .clickMenu()
                .clickCompany()
                .inputCompany("solution")
                .isCompanyFound("BIMSOLUTIONS")
                .isQuantityMoreThanZero("BIMSOLUTIONS")
                .aboveQuantityMoreThanZero("BIMSOLUTIONS")
                .belowQuantityMoreThanZero("BIMSOLUTIONS");
    }

    @Test
    void testTitleOProekte() {
        String actualTitle = new MainPage(getDriver())
                .navigateTo("https://devby.io/")
                .getNavBar()
                .clickMenu()
                .clickOProekte()
                .checkTitleOProekte();
        String expectedTitle = "О проекте";
        Assertions.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void changeLangTest() {
        switchLang();
    }

    void switchLang() {
        String lang = System.getProperty("lang");
        if (lang.equals("rus")) {
            getDriver().findElement(By.xpath("//div[@class='navbar__nav navbar__nav_aside']//button[contains(text(),'РУС')]"));
        } else {
            getDriver().findElement(By.xpath("//div[@class='navbar__nav navbar__nav_aside']//button[contains(text(),'БЕЛ')]"));
        }
    }
}
