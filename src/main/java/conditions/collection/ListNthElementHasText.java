package conditions.collection;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.List;

public class ListNthElementHasText extends CustomCollectionCondition {

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
        return String.format("text contains: %s", text);
    }

    @Override
    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        WebElement element = elements.get(index);
        currentText = element.getText();
        return (currentText.contains(text)) ? element : null;
    }

    @Override
    public String getActualValuesDescription() {
        return currentText;
    }
}
