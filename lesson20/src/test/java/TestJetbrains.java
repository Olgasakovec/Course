import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class TestJetbrains extends BaseTest{

    @Test
    void checkThatLinkHaveText() {
        String linkTextCorrect = new MainPage(getDriver())
                .navigateTo("https://www.jetbrains.com/")
                .clickDeveloperTools()
                .getDropDown()
                .clickMenuRider()
                .getTittle()
                .checkLinkTextCorrect();
        Assertions.assertEquals( linkTextCorrect, "part of dotUltimate");
    }

    @Test
    void checkVideoTitle() {
        String title = new MainPage(getDriver())
                .navigateTo("https://www.jetbrains.com/")
                .clickStore()
                .getDropDown()
                .clickJetBrainsAi()
                .getButton()
                .clickWatchVideo()
                .getVideo()
                .iFrame()
                .checkVideoTitle();
    }
}


