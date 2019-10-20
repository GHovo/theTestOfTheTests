package am.testing.qe.factory.pages.admin;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.factory.pages.home.HomePage;

public class SignInResult {

    static class Success extends SignInResult {
        public Success(HomePage homePage) {
            this.homePage = homePage;
        }

        HomePage homePage;
    }

    static class Failure extends SignInResult {
        public Failure(AdminPage adminPage) {
            this.adminPage = adminPage;
        }

        AdminPage adminPage;
    }

    @SuppressWarnings("unchecked")
    public HomePage shouldBeSuccessful(){
        if(this instanceof Success){
            return ((Success) this).homePage;
        }
        throw new RuntimeException("SING IN RESULT IS NOT SUCCESS");
    }

    @SuppressWarnings("unchecked")
    public AdminPage shouldBeFailure(){
        if(this instanceof Failure){
            return ((Failure) this).adminPage;
        }
        throw new RuntimeException("SING IN RESULT IS SUCCESS");
    }
}
