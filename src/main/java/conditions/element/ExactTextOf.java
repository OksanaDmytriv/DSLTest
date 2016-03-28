package conditions.element;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

public class ExactTextOf extends CustomElementCondition {

    private String currentText;
    protected final String text;
    private LazyEntity lazyEntity;

    public ExactTextOf(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("\nFor element located by %s\n actual text is: %s\n while expected text equals: %s\n", lazyEntity.getLocatorDescription(), currentText, text);
    }

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        currentText = element.getText();
        if (!currentText.equals(text)) {
            return null;
        }
        return element;
    }
}
