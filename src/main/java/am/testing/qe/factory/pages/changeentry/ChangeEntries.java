package am.testing.qe.factory.pages.changeentry;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.factory.pages.delete.DeletePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ChangeEntries extends BasePage<ChangeEntries> {


    @FindBy(xpath = "//*[@id=\"entry_form\"]/div/div/p/a")
    private WebElement deleteEntry;

    public static ChangeEntries open(){
        return new ChangeEntries().open("admin/blog/entry/432/");
    }


    public DeletePage clickDeleteEntryButton() {
        deleteEntry.click();
        return new DeletePage().init();
    }
}
