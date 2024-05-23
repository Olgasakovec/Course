import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import component.SearchResult;
import java.time.Duration;
import java.util.stream.Stream;

public class DevByTest extends BaseTest {

    public static Stream<Arguments> queryData() {
        return Stream.of(
                Arguments.of("bit", "Fitbit"),
                Arguments.of("solution", "BIMSOLUTIONS")
        );
    }

    @ParameterizedTest(name = "Check that Company is found")
    @MethodSource("queryData")
    void testCompanySearch(String query, String expectedCompany) {
        SearchResult searchResult = new MainPage(getDriver())
                .navigateTo("https://devby.io/")
                .getNavBar()
                .clickMenu()
                .clickCompany()
                .getSearchResult()
                .inputCompany(query)
                .isCompanyFound(expectedCompany);


        int targetIndex = searchResult.findCompanyRowIndex(expectedCompany);

        int currentCompanyEmployeeCount = searchResult.getEmployeeCount(targetIndex);
        Assertions.assertTrue(currentCompanyEmployeeCount > 0, "Количество сотрудников в компании " + expectedCompany + " должно быть больше 0.");

        int aboveCompanyIndex = targetIndex - 1;
        if (aboveCompanyIndex >= 0) {
            int aboveCompanyEmployeeCount = searchResult.getEmployeeCount(aboveCompanyIndex);
            Assertions.assertTrue(aboveCompanyEmployeeCount > 0, "Количество сотрудников в компании выше " + expectedCompany + " должно быть больше 0.");
        }

        int totalCompanyCount = searchResult.getCompanyCount();
        int belowCompanyIndex = targetIndex + 1;
        if (belowCompanyIndex < totalCompanyCount) {
            int belowCompanyEmployeeCount = searchResult.getEmployeeCount(belowCompanyIndex);
            Assertions.assertTrue(belowCompanyEmployeeCount > 0, "Количество сотрудников в компании ниже " + expectedCompany + " должно быть больше 0.");
        }
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
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'РУС') and contains(@class, 'navbar__button') and contains(@class, 'mr-4') and contains(@class, 'mr-lg-3')]")));
        } else {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'navbar__button mr-4 mr-lg-3']")));
        }
    }
}
