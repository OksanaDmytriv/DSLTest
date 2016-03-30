package conditions.collection;


import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.Arrays;
import java.util.List;

import static conditions.Helpers.getTexts;
import static conditions.Helpers.listHasTexts;
import static conditions.Helpers.listOfVisibleElements;

public class VisibleTextsOf extends CustomCollectionCondition {

    private List<String> currentTexts;
    protected final String[] texts;
    private LazyEntity lazyEntity;

    public VisibleTextsOf(String... texts) {
        if (texts.length == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty.");
        }
        this.texts = texts;
    }

    @Override
    public String toString() {
        return String.format("visible texts contains: %s", Arrays.toString(texts));
    }

    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        List<WebElement> visibleElements = listOfVisibleElements(elements);
        currentTexts = getTexts(visibleElements);
        return listHasTexts(visibleElements, texts);
    }

    @Override
    public String getActualValuesDescription() {
        return currentTexts.toString();
    }
}