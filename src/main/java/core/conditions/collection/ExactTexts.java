package core.conditions.collection;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.Helpers.getTexts;
import static core.Helpers.listHasExactTexts;

public class ExactTexts extends Texts {

    public ExactTexts(String... texts) {
        super(texts);
    }

    @Override
    protected List<WebElement> check() {
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        currentTexts = getTexts(elements);
        return listHasExactTexts(currentTexts, texts) ? elements : null;
    }
}
