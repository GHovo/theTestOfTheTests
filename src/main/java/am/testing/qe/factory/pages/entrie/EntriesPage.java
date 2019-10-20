package am.testing.qe.factory.pages.entrie;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.util.AssertableWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntriesPage extends BasePage<EntriesPage> {

    @FindBy(xpath ="//*[@id=\"content\"]/h1")
    private WebElement addEntryText;

    @FindBy(xpath ="//*[@id=\"id_title\"]")
    private WebElement entryTitle;

    @FindBy(xpath ="//*[@id=\"id_slug\"]")
    private WebElement entrySluge;

    @FindBy(xpath ="//*[@id=\"entry_form\"]/div/div/input[1]")
    private WebElement entrySaveButton;

    @FindBy(xpath ="//*[@id=\"id_text_markdown\"]")
    private WebElement entryTextMarkDown;

    @FindBy(xpath ="//*[@id=\"id_text\"]")
    private WebElement entryText;

    public final EntriesPage open(){
        return super.open("admin/entry/");
    }

    public AssertableWebElement<EntriesPage> getAddEntryText() {
        return new AssertableWebElement<>(addEntryText, this);
    }

    public EntriesPage fillEntryTitle(String title) {
        entryTitle.sendKeys(title);
        return this;
    }

    public EntriesPage fillEntrySluge(String sluge) {
        entrySluge.sendKeys(sluge);
        return this;
    }

    public EntriesPage fillEntryTextMarkDown(String text) {
        entrySluge.sendKeys(text);
        return this;
    }

    public EntriesPage fillEntryText(String text) {
        entrySluge.sendKeys(text);
        return this;
    }

    public EntriesPage clickOnSaveButoon(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        entrySaveButton.click();
        return new EntriesPage();
    }
}
