package core.conditions.collection;

import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static core.Helpers.getTexts;
import static core.Helpers.listHasTexts;

public class Texts extends CustomCollectionConditions {

    protected List<String> currentTexts;
    protected final String[] texts;
    protected LazyEntity lazyEntity;

    public Texts(String... texts) {
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
    public String getActualValuesDescription() {
        return Arrays.toString(currentTexts.toArray());
    }

    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        currentTexts = getTexts(elements);
        return listHasTexts(elements, texts);
    }
}
