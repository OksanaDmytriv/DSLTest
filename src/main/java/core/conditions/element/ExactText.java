package core.conditions.element;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class ExactText extends Text {

    public ExactText(String text) {
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
