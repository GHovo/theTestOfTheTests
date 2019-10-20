import am.testing.qe.factory.pages.admin.AdminPage;
import am.testing.qe.factory.pages.entrie.EntriesPage;
import am.testing.qe.factory.pages.home.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static am.testing.qe.factory.pages.home.HomePage.clickOnTheAddEntriesButton;


public class EntriesPageTest {

    private EntriesPage entriesPage;
    private AdminPage adminPage;

    @Before
    public void beforeEach(){
        adminPage = new AdminPage().open();
        adminPage.fillEmailField("selenium").fillPasswordField("super_password").clickOnLoginButton();
        clickOnTheAddEntriesButton();
        entriesPage = new EntriesPage().open();
    }

    @After
    public void afterEach(){
        entriesPage.closeBrowser();
    }

    @Test
    public void first(){

        entriesPage
                .getAddEntryText()
                .shouldHaveText("Добавить entry")
                .fillEntryTitle("Title43565463456")
                .fillEntrySluge("Slug43565463456")
                .fillEntryTextMarkDown("Slug43565463456)")
                .fillEntryText("Slug43565463456)")
                .clickOnSaveButoon();

    }

}
