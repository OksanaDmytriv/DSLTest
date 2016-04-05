package core.conditions.element;

public class CustomElementConditions {

    public static CustomElementCondition text(final String text) {
        return new Text(text);
    }

    public static CustomElementCondition exactText(final String text) {
        return new ExactText(text);
    }

    public static CustomElementCondition visible() {
        return new Visible1();
    }

    public static CustomElementCondition cssClass(final String cssClass) {
        return new CSSClass1(cssClass);
    }

    public static CustomElementCondition present(){return new Present();}
}
