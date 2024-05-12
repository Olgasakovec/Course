import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PhotoOtchetPage;

public class RelaxTest extends BaseTest {

    @Test
    void checkMusicTitle() {
        String actualTitle = new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .getNavigationMenu()
                .clickAfishaKino()
                .clickSpectakliToMuziclPage()
                .clickMuzicl()
                .checkTitleMuziclVMinske();
        String expectedTitle = "Мюзикл в Минске";
        Assertions.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void checkBalletTitle() {
        String actualTitle = new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .getNavigationMenu()
                .clickAfishaKino()
                .clickSpectakliToBalletPage()
                .clickBallet()
                .checkTitleBalletVMinske();
        String expectedTitle = "Балет в Минске";
        Assertions.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void checkComediTitle() {
        String actualTitle = new MainPage(getDriver())
                .navigateTo("https://www.relax.by/")
                .getNavigationMenu()
                .clickAfishaKino()
                .clickSpectakliToComeediPage()
                .clickComedia()
                .checkTitleComediaVMinske();
        String expectedTitle = "Спектакль-комедия в Минске";
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
