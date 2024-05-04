import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class JetbrainsTest extends BaseTest {

    @Test
    void checkThatLinkHaveText() {
        boolean linkTextCorrect = new MainPage(getDriver())
                .navigateTo("https://www.jetbrains.com/")
                .developerToolsClick()
                .getDropDown()
                .clickRider()
                .getTittle()
                .linkTextCorrect();
        Assertions.assertTrue( linkTextCorrect,"part of dotUltimate");
    }

    @Test
    void checkUrlOverview(){
        boolean urlOverview = new MainPage(getDriver())
                .navigateTo("https://www.jetbrains.com/")
                .developerToolsClick()
                .getDropDown()
                .clickPhpStorm()

    }
}
