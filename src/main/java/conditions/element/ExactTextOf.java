package conditions.element;

import collection.LazyEntity;
import org.openqa.selenium.WebElement;

public class ExactTextOf extends CustomConditionsElement {

    private static String currentText;
    protected final String text;
    private LazyEntity lazyEntity;

    public ExactTextOf(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("\nFor element located by %s\n actual text is: %s\n while expected text contains: %s\n", lazyEntity.getLocatorDescription(), currentText, text);
    }

    protected WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        currentText = element.getText();
        if (!currentText.contains(text)) {
            return null;
        }
        return element;
    }
}
