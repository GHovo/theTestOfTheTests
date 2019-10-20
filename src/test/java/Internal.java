import am.testing.qe.factory.pages.admin.AdminPage;
import org.assertj.core.util.Strings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;  // main one

public class Internal {

    private AdminPage adminPage;

    @Before
    public void beforeEach(){
        adminPage = new AdminPage().open();
    }

    @After
    public void afterEach(){
        adminPage.closeBrowser();
    }

    @Test
    public void first(){

        adminPage
                .fillEmailField("selenium")
                .fillPasswordField("super_password")
                .clickOnLoginButton()
                .shouldBeSuccessful()
                .getControlPanel().shouldHaveText("ПАНЕЛЬ УПРАВЛЕНИЯ");

    }

}

