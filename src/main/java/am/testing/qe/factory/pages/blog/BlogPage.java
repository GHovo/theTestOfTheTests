package am.testing.qe.factory.pages.blog;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.factory.pages.admin.AdminPage;
import am.testing.qe.factory.pages.changeentry.ChangeEntries;
import am.testing.qe.util.Assertable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.function.Consumer;

public class BlogPage extends BasePage<BlogPage> {


    @FindBy(id = "entries")
    List<WebElement> entriesList;

    public static BlogPage open(){
        return new BlogPage().open("blog");
    }

    public BlogPage withEntriesList(Consumer<Assertable<BlogPage>> action) {
        for (WebElement webElement : entriesList) {
            action.accept(assertableOf(webElement));
        }
        return this;
    }

    private List<WebElement> getEntriesList() {
        return entriesList;
    }

    public Assertable<BlogPage> lookAtEntryWithText(String text){
        getEntriesList().forEach(element -> System.out.println(element.getText()));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return assertableOf(getEntriesList().stream().filter(e -> e.getText().contains(text)).findAny().get());
    }

    public ChangeEntries clickOnEntryItem(String text){
        for (WebElement webElement : entriesList) {
            if (webElement.equals(text)) {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                webElement.click();
            }
        }
        return new ChangeEntries().init();
    }



}
