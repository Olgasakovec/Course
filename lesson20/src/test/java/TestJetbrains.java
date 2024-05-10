import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class TestJetbrains extends BaseTest{

    @Test
    void checkThatLinkHaveText() {
        String actualText = new MainPage(getDriver())
                .navigateTo("https://www.jetbrains.com/")
                .getHeader()
                .clickDeveloperTools()
                .clickMenuRider()
                .getLinkText();
                 String expectedText = "part of dotUltimate";
        Assertions.assertEquals( expectedText, actualText);
    }

    @Test
    void checkVideoTitle() {
        String actualTitle = new MainPage(getDriver())
                .navigateTo("https://www.jetbrains.com/")
                .getHeader()
                .clickStore()
                .clickJetBrainsAi()
                .clickWatchVideo()
                .getVideoTitle();
        String expectedTitle = "JetBrains AI Assistant";
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void checkButtonIsActive() {
        boolean isButtonEnabled = new MainPage(getDriver())
                .navigateTo("https://www.jetbrains.com/")
                .getHeader()
                .clickDeveloperTools()
                .clickMenuFleet()
                .isDownloadButtonEnabled();
        Assertions.assertTrue(isButtonEnabled);
    }
}


