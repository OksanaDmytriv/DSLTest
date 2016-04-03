package core.conditions.collection;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static core.Helpers.listHasExactTexts;

public class ExactTexts extends Texts {

    public ExactTexts(String... texts) {
        super(texts);
    }

    @Override
    public String toString() {
        return String.format("texts equals: %s", Arrays.toString(texts));
    }

    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        return listHasExactTexts(elements, currentTexts, texts);
    }

}
