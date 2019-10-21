package am.testing.qe.factory.pages.entrie;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.util.Assertable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.function.Consumer;

public class EntriesPage extends BasePage<EntriesPage> {

    @FindBy(xpath ="//*[@id=\"content\"]/h1")
    private WebElement addEntryText;

    @FindBy(xpath ="//*[@id=\"id_title\"]")
    private WebElement entryTitle;

    @FindBy(xpath ="//*[@id=\"id_slug\"]")
    private WebElement entrySlug;

    @FindBy(xpath ="//*[@id=\"entry_form\"]/div/div/input[1]")
    private WebElement entrySaveButton;

    @FindBy(xpath ="//*[@id=\"id_text_markdown\"]")
    private WebElement entryTextMarkDown;

    @FindBy(xpath ="//*[@id=\"id_text\"]")
    private WebElement entryText;

    public final EntriesPage open(){
        return super.open("admin/entry/");
    }

    public EntriesPage withAddEntryElement(Consumer<Assertable> action) {
        action.accept(assertableOf(addEntryText));
        return this;
    }

    public EntriesPage fillEntryTitle(String title) {
        entryTitle.sendKeys(title);
        return this;
    }

    public EntriesPage fillEntrySlug(String slug) {
        entrySlug.sendKeys(slug);
        return this;
    }

    public EntriesPage fillEntryTextMarkDown(String text) {
        entrySlug.sendKeys(text);
        return this;
    }

    public EntriesPage fillEntryText(String text) {
        entrySlug.sendKeys(text);
        return this;
    }

    public EntriesPage clickOnSaveButton(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        entrySaveButton.click();
        return new EntriesPage().init();
    }
}
