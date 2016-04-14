package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Text extends ElementCondition {

    public String currentText;
    public final String text;
    public WebElement element;

    public Text(String text) {
        this.text = text;
    }

    public WebElement check(WebElement element) {
        currentText = element.getText();
        if (!checkList()) {
            return null;
        }
        return element;
    }

    public boolean checkList() {
        return currentText.contains(text);
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
