package core.conditions.element;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class ExactText extends Text {

    public ExactText(String text) {
        super(text);
    }

    protected WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        currentText = element.getText();
        if (!currentText.equals(text)) {
            return null;
        }
        return element;
    }
}
