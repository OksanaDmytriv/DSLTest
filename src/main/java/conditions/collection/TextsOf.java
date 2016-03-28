package conditions.collection;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.Arrays;
import java.util.List;

public class TextsOf extends CustomCollectionCondition {

    private List<String> currentTexts;
    protected final String[] texts;
    private LazyEntity lazyEntity;

    public TextsOf(String... texts) {
        if (texts.length == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty.");
        }
        this.texts = texts;
    }

    @Override
    public String toString() {
        return String.format("\n For elements located by %s\n actual texts is: %s\n while expected texts contains: %s\n", lazyEntity.getLocatorDescription(), Arrays.toString(currentTexts.toArray()), Arrays.toString(texts));
    }

    @Override
    protected List<WebElement> check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        currentTexts = getTexts(elements);
        return listHasTexts(elements, texts);
    }
}
