package conditions.element;

public class Helpers {

    public static CustomElementCondition textOf(final String text) {
        return new TextOf(text);
    }

    public static CustomElementCondition exactTextOf(final String text) {
        return new ExactTextOf(text);
    }

    public static CustomElementCondition elementVisible() {
        return new ElementVisible();
    }

    public static CustomElementCondition listElementWithCssClass(final String cssClass) {
        return new ListElementWithCssClass(cssClass);
    }
}
