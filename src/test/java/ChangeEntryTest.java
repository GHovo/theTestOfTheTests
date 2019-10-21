import am.testing.qe.factory.pages.admin.AdminPage;
import am.testing.qe.factory.pages.changeentry.ChangeEntries;
import am.testing.qe.factory.pages.delete.DeletePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeEntryTest {
    private  ChangeEntries changeEntryPage;

    @Before
    public void beforeEach(){
        changeEntryPage =  new AdminPage()
                .open()
                .fillEmailField("selenium")
                .fillPasswordField("super_password")
                .clickOnLoginButton()
                .shouldBeSuccessful()
                .clickOnTheAddEntriesButton()
                .fillEntryTitle("Title43565463456")
                .fillEntrySlug("Slug43565463456")
                .fillEntryTextMarkDown("Slug43565463456)")
                .fillEntryText("Slug43565463456)")
                .clickOnSaveButton()
                .clickOnEntryItem("Title43565463456");
                ChangeEntries.open().init();

    }
    @After
    public void afterEach(){
        changeEntryPage.closeBrowser();
    }

    @Test
    public void first(){
        changeEntryPage
                .clickDeleteEntryButton()
                .clickOnYesDeleteButton();
    }

}
