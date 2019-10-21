package am.testing.qe.factory.pages.entrie;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.factory.pages.blog.BlogPage;
import am.testing.qe.util.Assertable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public Assertable<EntriesPage> lookAtAddEntryElement() {
        return assertableOf(addEntryText);
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
        entryTextMarkDown.sendKeys(text);
        return this;
    }

    public EntriesPage fillEntryText(String text) {
        entryText.sendKeys(text);
        return this;
    }

    public BlogPage clickOnSaveButton(){
        entrySaveButton.click();
        return new BlogPage().init();
    }
}
