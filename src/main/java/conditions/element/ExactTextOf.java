package conditions.element;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

public class ExactTextOf extends TextOf {

    private LazyEntity lazyEntity;

    public ExactTextOf(String text) {
        super(text);
    }

    public String toString() {
        return String.format("text equals: %s", text);
    }

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        String currentText = element.getText();
        if (!currentText.equals(text)) {
            return null;
        }
        return element;
    }
}
