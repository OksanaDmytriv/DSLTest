package core.conditions.element;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class Text extends CustomElementConditions {

    protected String currentText;
    protected final String text;
    protected LazyEntity lazyEntity;

    public Text(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("text contains: %s", text);
    }

    @Override
    public String getActualValuesDescription() {
        return currentText;
    }

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        currentText = element.getText();
        if (!currentText.contains(text)) {
            return null;
        }
        return element;
    }
}
