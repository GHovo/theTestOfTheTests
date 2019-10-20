package am.testing.qe.factory.pages.home;

import am.testing.qe.factory.pages.BasePage;
import am.testing.qe.factory.pages.entrie.EntriesPage;
import am.testing.qe.util.AssertableWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage<HomePage> {

    @FindBy(xpath = "//*[@id=\"navigation-menu\"]/li[1]/a")
    private WebElement controlPanel;

    @FindBy(xpath = "//*[@id=\"module_2\"]/div/ul[1]/li[1]/ul/li[1]/a")
    private static WebElement addEntries;

    public AssertableWebElement<HomePage> getControlPanel() {
        return new AssertableWebElement<>(controlPanel, this);
    }

    public static EntriesPage clickOnTheAddEntriesButton(){
        addEntries.click();
        return new EntriesPage();

    }
}
