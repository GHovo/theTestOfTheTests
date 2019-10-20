package am.testing.qe.util;

import am.testing.qe.factory.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertableWebElement <T extends BasePage<T>>{

    private WebElement element;
    private ExpectedCondition condition;
    private T page;

    public AssertableWebElement(WebElement element, T page){
        this.element = element;
        this.page = page;
    }

    public T shouldHaveText(String text) {
        String actual = element.getText();
        System.out.println("TEXT -> " + text);
        System.out.println("ACTUAL -> " + actual);
        assertThat(actual).isEqualTo(text);
        return page;
    }
}
