package am.testing.qe.factory.pages.home;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.factory.pages.entrie.EntriesPage;
import am.testing.qe.util.Assertable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.function.Consumer;

public class HomePage extends BasePage<HomePage> {

    @FindBy(xpath = "//*[@id=\"navigation-menu\"]/li[1]/a")
    private WebElement controlPanel;

    @FindBy(xpath = "//*[@id=\"module_2\"]/div/ul[1]/li[1]/ul/li[1]/a")
    private static WebElement addEntries;

    public HomePage withControlPanel(Consumer<Assertable> action) {
        action.accept(assertableOf(controlPanel));
        return this;
    }

    public EntriesPage clickOnTheAddEntriesButton(){
        addEntries.click();
        return new EntriesPage().init();
    }
}
