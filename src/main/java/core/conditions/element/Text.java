package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Text extends ElementCondition {

    protected String currentText;
    protected final String text;

    public Text(String text) {
        this.text = text;
    }

    protected WebElement check(WebElement element) {
        currentText = element.getText();
        if (!currentText.contains(text)) {
            return null;
        }
        return element;
    }

    @Override
    public String actual() {
        return currentText;
    }

    @Override
    public String expected() {
        return text;
    }
}
