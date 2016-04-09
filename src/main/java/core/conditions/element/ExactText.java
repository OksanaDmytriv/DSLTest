package core.conditions.element;

import org.openqa.selenium.WebElement;

public class ExactText extends Text {

    public ExactText(String text) {
        super(text);
    }

    public WebElement check(WebElement element) {
        currentText = element.getText();
        if (!currentText.equals(text)) {
            return null;
        }
        return element;
    }
}
