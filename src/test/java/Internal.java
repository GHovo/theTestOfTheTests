import am.testing.qe.factory.pages.admin.AdminPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;  // main one

public class Internal {

    private static AdminPage adminPage;

    @Before
    public void beforeEach(){
        adminPage = new AdminPage().open();
    }

    @AfterClass
    public static void afterEach(){
        adminPage.closeBrowser();
    }

    @Test
    public void first(){

        adminPage
                .fillEmailField("selenium")
                .fillPasswordField("super_password")
                .clickOnLoginButton()
                .shouldBeSuccessful()
                .lookAtControlPanel().assertThat().isDisplayed().withText("Control panel").hard();


    }

}

