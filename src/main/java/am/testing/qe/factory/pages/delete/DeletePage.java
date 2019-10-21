package am.testing.qe.factory.pages.delete;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.factory.pages.entrie.EntriesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DeletePage  extends BasePage<DeletePage> {


    @FindBy(xpath = "//*[@id=\"content\"]/form/div/input[2]")
    private WebElement yesDeleteButton;

    public static DeletePage open(){
        return new DeletePage().open("admin/blog/entry/435/delete/");
    }

    public EntriesPage clickOnYesDeleteButton(){
        yesDeleteButton.click();
        return new EntriesPage().init();
    }
}
