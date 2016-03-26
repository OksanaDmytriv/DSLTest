package conditions.element;

import conditions.CustomConditions;
import org.openqa.selenium.WebElement;

public abstract class CustomElementCondition extends CustomConditions<WebElement> {

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
