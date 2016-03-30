package conditions.collection;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.Arrays;
import java.util.List;

import static conditions.Helpers.getTexts;
import static conditions.Helpers.listHasTexts;

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
        return String.format("texts contains: %s", Arrays.toString(texts));
    }

    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        currentTexts = getTexts(elements);
        return listHasTexts(elements, texts);
    }

    @Override
    public String getActualValuesDescription() {
        return currentTexts.toString();
    }
}
