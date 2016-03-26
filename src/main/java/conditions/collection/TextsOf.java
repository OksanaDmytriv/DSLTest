package conditions.collection;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextsOf extends CustomCollectionConditions {

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
        currentTexts = new ArrayList<String>();
        for (int i = 0; i < elements.size(); ++i) {
            currentTexts.add(i, elements.get(i).getText());
        }
        if (currentTexts.size() != texts.length) {
            return null;
        } else {
            for (int i = 0; i < texts.length; ++i) {
                if (!currentTexts.get(i).contains(texts[i])) {
                    return null;
                }
            }
            return elements;
        }
    }
}
