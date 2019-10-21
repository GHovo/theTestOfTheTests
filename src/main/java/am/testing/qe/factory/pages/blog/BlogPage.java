package am.testing.qe.factory.pages.blog;

import am.testing.qe.factory.pages.BasePage;
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
        for (int i = 0; i < entriesList.size(); i++) {
            action.accept(assertableOf(entriesList.get(i)));
        }
        return this;
    }

    public List<WebElement> getEntriesList() {
        return entriesList;
    }

    public Assertable<BlogPage> lookAtEntryWithText(String text){
        getEntriesList().forEach(element -> System.out.println(element.getText()));
        return assertableOf(getEntriesList().stream().filter(e -> e.getText().contains(text)).findAny().get());
    }


}
