package core.conditions.element;

import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

public class Text extends CustomElementCondition {

    protected String currentText;
    protected final String text;
    protected LazyEntity lazyEntity;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String actual() {
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

    @Override
    public String identity() {
        return "element";
    }

    @Override
    public String expected() {
        return text;
    }

    @Override
    public LazyEntity entity() {
        return lazyEntity;
    }
}
