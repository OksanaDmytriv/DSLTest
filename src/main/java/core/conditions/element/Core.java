package core.conditions.element;

public class Core {

    public static CustomElementConditions text(final String text) {
        return new Text(text);
    }

    public static CustomElementConditions exactText(final String text) {
        return new ExactText(text);
    }

    public static CustomElementConditions visible() {
        return new Visible();
    }

    public static CustomElementConditions cssClass(final String cssClass) {
        return new CSSClass(cssClass);
    }

    public static CustomElementConditions elementPresent(){return new ElementPresent();}
}
