package core.wrappers.forCollection;

import core.conditions.collection.CustomCollectionCondition;
import core.conditions.element.CustomElementCondition;
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

    public LazyFilteredCollection filter(CustomElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyCollectionElementByCondition find(CustomElementCondition condition) {
        return new LazyCollectionElementByCondition(this, condition);
    }

    public LazyCollection should(CustomCollectionCondition... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public LazyCollection shouldBe(CustomCollectionCondition... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CustomCollectionCondition... conditions) {
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
