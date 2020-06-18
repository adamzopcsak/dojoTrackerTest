import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DojosPage;
import pages.ProfilePage;
import pages.RankingPage;

public class NavigationTest extends BaseTest {

    @BeforeEach
    public void login() {
        homePage.login(this.email, this.password);
    }

    @Test
    public void navigateToDojosPage() {
        DojosPage dojosPage = homePage.navigateToDojosPage();
        Assertions.assertFalse(dojosPage.isDojosListEmpty());
    }

    @Test
    public void navigateToRankingPage() {
        RankingPage rankingPage = homePage.navigateToRankingPage();
        Assertions.assertTrue(rankingPage.areUsersVisible());
    }

    @Test
    public void navigateToProfilePage() {
        ProfilePage profilePage = homePage.navigateToProfilePage();
        Assertions.assertEquals("DojoTracker Student", profilePage.getUsername());
    }

}
