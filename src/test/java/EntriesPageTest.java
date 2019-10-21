import am.testing.qe.factory.pages.admin.AdminPage;
import am.testing.qe.factory.pages.entrie.EntriesPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EntriesPageTest {

    private EntriesPage entriesPage;

    @Before
    public void beforeEach(){
        entriesPage =  new AdminPage()
                .open()
                .fillEmailField("selenium")
                .fillPasswordField("super_password")
                .clickOnLoginButton()
                .shouldBeSuccessful()
                .clickOnTheAddEntriesButton();
    }

    @After
    public void afterEach(){
        entriesPage.closeBrowser();
    }

    @Test
    public void first(){
        entriesPage
                .withAddEntryElement(e -> e.isDisplayed().withText("Добавить entry"))
                .fillEntryTitle("Title43565463456")
                .fillEntrySlug("Slug43565463456")
                .fillEntryTextMarkDown("Slug43565463456)")
                .fillEntryText("Slug43565463456)")
                .clickOnSaveButton();
    }

}
