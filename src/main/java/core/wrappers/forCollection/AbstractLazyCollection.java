package core.wrappers.forCollection;

import core.conditions.collection.CollectionCondition;
import core.conditions.element.ElementCondition;
import core.wrappers.LazyEntity;
import core.wrappers.forElement.LazyCollectionFoundByConditionElement;
import core.wrappers.forElement.LazyCollectionNthElement;
import core.wrappers.forElement.AbstractLazyElement;
import core.wrappers.forElement.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static core.ConciseAPI.waitFor;

public abstract class AbstractLazyCollection implements LazyEntity, Iterable<AbstractLazyElement> {

    public abstract List<WebElement> getWrappedEntity();

    public LazyCollectionNthElement get(int index) {
        return new LazyCollectionNthElement(this, index);
    }

    public LazyFilteredCollection filter(ElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyCollectionFoundByConditionElement find(ElementCondition condition) {
        return new LazyCollectionFoundByConditionElement(this, condition);
    }

    public AbstractLazyCollection should(CollectionCondition... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public AbstractLazyCollection shouldBe(CollectionCondition... conditions) {
        return should(conditions);
    }

    public AbstractLazyCollection shouldHave(CollectionCondition... conditions) {
        return should(conditions);
    }

    @Override
    public Iterator<AbstractLazyElement> iterator() {
        List<WebElement> elements = this.getWrappedEntity();
        List<AbstractLazyElement> newList = new ArrayList<>();
        for (WebElement element : elements) {
            newList.add((new LazyWrappedWebElement(this, element)));
        }
        return newList.iterator();
    }
}
