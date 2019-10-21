package am.testing.qe.util;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class Assertable extends AbstractAssert<Assertable, WebElement> {

    public Assertable(WebElement webElement) {
        super(webElement, Assertable.class);
    }

    public static Assertable assertThat(WebElement webElement){
        return new Assertable(webElement);
    }

    public Assertable isDisplayed(){
        isNotNull();

        //check condition
        if(!actual.isDisplayed()){
            failWithMessage("Expected element to be displayed. But was not!!");
        }

        return this;
    }

    public Assertable isEnabled(){
        isNotNull();

        //check condition
        if(!actual.isEnabled()){
            failWithMessage("Expected element to be enabled. But was not!!");
        }

        return this;
    }

    public Assertable withText(String text){
        isNotNull();

        //check condition

        String actualText = actual.getText();

        if(!actualText.equals(text)){
            failWithMessage("Expected "+text+". But was " + actualText);
        }

        return this;
    }
    public Assertable hasAttributeValue(String attr, String value){
        isNotNull();

        //check condition
        if(!actual.getAttribute(attr).equals(value)){
            failWithMessage("Expected element to have attr <%s> value as <%s>. But was not!!", attr, value);
        }

        return this;
    }

}