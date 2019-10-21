package am.testing.qe.factory.pages.admin;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.factory.pages.home.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage<AdminPage> {

    @FindBy(id = "id_username")
    private WebElement emailField;

    @FindBy(id = "id_password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    private WebElement loginButton;

    public final AdminPage open(){
        return super.open("admin/");
    }

    public AdminPage fillEmailField(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public AdminPage fillPasswordField(String super_password) {
        passwordField.sendKeys(super_password);
        return this;
    }

    public SignInResult clickOnLoginButton() {
        loginButton.click();
        HomePage homePage;
        try {
            homePage = new HomePage().init();
            homePage.lookAtControlPanel().assertThat().isDisplayed();
            return new SignInResult.Success(homePage);
        } catch (Throwable e){
            return new SignInResult.Failure(this);
        }
    }

}
