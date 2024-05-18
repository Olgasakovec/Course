import page.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class DevByTest extends BaseTest {

    @DataProvider(name="query")
    public Object[][] query() {
        return new Object[][] {
                {"bit", "Fitbit"},
                {"solution", "BIMSOLUTIONS"}
        };
    }

    @Test(dataProvider = "query")
    void testCompanySearch(String query, String expectedCompany) {
        new MainPage(getDriver())
                .navigateTo("https://devby.io/")
                .getNavBar()
                .clickMenu()
                .clickCompany()
                .inputCompany(query)
                .isCompanyFound(expectedCompany)
                .isQuantityMoreThanZero(expectedCompany)
                .aboveQuantityMoreThanZero(expectedCompany)
                .belowQuantityMoreThanZero(expectedCompany);
    }

    @Test
    void testTitleOProekte() {
        String actualTitle = new MainPage(getDriver())
                .navigateTo("https://devby.io/")
                .getNavBar()
                .clickMenu()
                .clickOProekte()
                .getTitleOProekte();
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
