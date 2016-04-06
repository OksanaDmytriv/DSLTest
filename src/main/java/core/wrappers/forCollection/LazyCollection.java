package core.wrappers.forCollection;

import core.conditions.collection.CollectionCondition;
import core.conditions.element.ElementCondition;
import core.wrappers.LazyEntity;
import core.wrappers.forElement.LazyCollectionElementByCondition;
import core.wrappers.forElement.LazyCollectionElementByIndex;
import core.wrappers.forElement.LazyElement;
import core.wrappers.forElement.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static core.ConciseAPI.waitFor;

public abstract class LazyCollection implements LazyEntity, Iterable<LazyElement> {

    public abstract List<WebElement> getWrappedEntity();

    public LazyCollectionElementByIndex get(int index) {

        return new LazyCollectionElementByIndex(this, index);
    }

    public LazyFilteredCollection filter(ElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyCollectionElementByCondition find(ElementCondition condition) {
        return new LazyCollectionElementByCondition(this, condition);
    }

    public LazyCollection should(CollectionCondition... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public LazyCollection shouldBe(CollectionCondition... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CollectionCondition... conditions) {
        return should(conditions);
    }

    @Override
    public Iterator<LazyElement> iterator() {
        List<WebElement> elements = this.getWrappedEntity();
        List<LazyElement> newList = new ArrayList<>();
        for (WebElement element : elements) {
            newList.add((new LazyWrappedWebElement(this, element)));
        }
        return newList.iterator();
    }
}
