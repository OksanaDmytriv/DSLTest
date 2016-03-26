package conditions.collection;


import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.Arrays;
import java.util.List;

public class VisibleTextsOf extends CustomCollectionConditions {

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
        return String.format("\n For elements located by %s\n actual visible texts is: %s\n while expected visible texts contains: %s\n", lazyEntity.getLocatorDescription(), Arrays.toString(currentTexts.toArray()), Arrays.toString(texts));
    }
    @Override
    protected List<WebElement> check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        List<WebElement> visibleElements = listOfVisibleElements(elements);
        currentTexts = getTexts(visibleElements);
        return listHasTexts(visibleElements, texts);
    }
}