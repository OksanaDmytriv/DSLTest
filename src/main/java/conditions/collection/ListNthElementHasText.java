package conditions.collection;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.List;

public class ListNthElementHasText extends CustomCollectionConditions {

    private String currentText;
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
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        WebElement element = elements.get(index);
        currentText = element.getText();
        return (currentText.contains(text)) ? element : null;
    }
}
