package conditions.element;

import conditions.CustomCondition;
import org.openqa.selenium.WebElement;

public abstract class CustomElementCondition implements CustomCondition<WebElement> {

    public static CustomElementCondition textOf(final String text) {
        return new TextOf(text);
    }

    public static CustomElementCondition exactTextOf(final String text) {
        return new ExactTextOf(text);
    }

    public static CustomElementCondition elementVisible = new ElementVisible();

    public static CustomElementCondition listElementWithCssClass(final String cssClass) {
        return new ListElementWithCssClass(cssClass);
    }
}
