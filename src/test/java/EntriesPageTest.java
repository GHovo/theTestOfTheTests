import am.testing.qe.factory.pages.admin.AdminPage;
import am.testing.qe.factory.pages.blog.BlogPage;
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
                .lookAtAddEntryElement().assertThat().isDisplayed().withText("Добавить entry").hard()
                .fillEntryTitle("Title43565463456")
                .fillEntrySlug("Slug43565463456")
                .fillEntryTextMarkDown("Slug43565463456)")
                .fillEntryText("Slug43565463456)")
                .clickOnSaveButton();

        BlogPage.open().lookAtEntryWithText("Title43565463456").assertThat().isDisplayed().softly();
        // todo go to entries page
        //  remove created entry
    }

}
