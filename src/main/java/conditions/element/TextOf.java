package conditions.element;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

public class TextOf extends CustomElementCondition {

    private String currentText;
    protected final String text;
    private LazyEntity lazyEntity;

    public TextOf(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("text contains: %s", text);
    }

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        String currentText = element.getText();
        if (!currentText.contains(text)) {
            return null;
        }
        return element;
    }

    @Override
    public String getActualValuesDescription() {
        return currentText;
    }
}
