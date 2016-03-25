package conditions;

import collection.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListNthElementHasText extends CustomConditions<WebElement> {

    private static String currentText;
    private static List<WebElement> elements;
    protected final String text;
    protected final int index;
    private LazyEntity lazyEntity;

    public ListNthElementHasText(int index, String text) {
        this.index = index;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("\nFor element located by %s\n actual text is: %s\n while expected text contains: %s\n", lazyEntity.getLocatorDescription(), currentText, text);
    }

    @Override
    protected WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        WebElement element = elements.get(index);
        currentText = element.getText();
        return (currentText.contains(text)) ? element : null;
    }
}
