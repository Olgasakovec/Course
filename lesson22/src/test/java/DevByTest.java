import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.SearchResultPage;

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
        SearchResultPage searchResultPage = new MainPage(getDriver())
                .navigateTo("https://devby.io/")
                .getNavBar()
                .clickMenu()
                .clickCompany()
                .inputCompany(query)
                .isCompanyFound(expectedCompany)
                .findCompanyNames(expectedCompany)
                .isQuantityMoreThanZero(expectedCompany)
                .aboveQuantityMoreThanZero(expectedCompany)
                .belowQuantityMoreThanZero(expectedCompany);

        Assertions.assertEquals(searchResultPage.isCompanyFound(expectedCompany), "Компания найдена");
        Assertions.assertEquals(searchResultPage.isQuantityMoreThanZero(expectedCompany), "Количество сотрудников компании больше 0");
        Assertions.assertEquals(searchResultPage.aboveQuantityMoreThanZero(expectedCompany), "Компания в списке что выше, имеет сотрудников больше 0");
        Assertions.assertEquals(searchResultPage.belowQuantityMoreThanZero(expectedCompany), "компания в списке что ниже, имеет сотрудников больше 0");
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
            getDriver().findElement(By.xpath("//button[contains(text(), 'РУС') and contains(@class, 'navbar__button') and contains(@class, 'mr-4') and contains(@class, 'mr-lg-3')]"));
        } else {
            getDriver().findElement(By.xpath("//button[contains(text(), 'БЕЛ') and contains(@class, 'navbar__button')]"));
        }
    }
}
