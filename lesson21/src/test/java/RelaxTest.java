import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.PhotoOtchetPage;;

public class RelaxTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "#musical, Мюзикл в Минске",
            "#balet, Балет в Минске",
            "#comedia, Спектакль-комедия в Минске"
    })
    void checkTitle(String category, String expectedTitle) {
        String actualTitle = new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .getNavigationMenu()
                .clickAfishaKino()
                .clickSpectakliPage()
                .selectCategory(category)
                .getTitleElement().getText();
        Assertions.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void checkPhotoFormat() {
        PhotoOtchetPage photoOtchetPage = new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .getNavigationMenu()
                .clickPhotoOtchet();
        String imageSource = photoOtchetPage.getImageSource();
        Assertions.assertTrue(imageSource.contains(".svg"));
    }

    @Test
    void checkButtonAndTextVsePhotoOtcheti() {
        String buttonText = new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .getNavigationMenu()
                .clickPhotoOtchet()
                .getPhotoOtchetButton()
                .getText();

        Assertions.assertTrue(new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .getNavigationMenu()
                .clickPhotoOtchet()
                .getPhotoOtchetButton()
                .isDisplayed());

        Assertions.assertEquals("Все фотоотчеты", buttonText);
    }
}
