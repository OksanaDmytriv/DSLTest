package core.wrappers.forCollection;

import core.WaitFor;
import core.conditions.collection.CollectionCondition;
import core.conditions.element.ElementCondition;
import core.wrappers.forElement.*;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractLazyCollection implements LazyCollection {

    public abstract List<WebElement> getWrappedEntity();

    public LazyElement get(int index) {
        return new LazyCollectionNthElement(this, index);
    }

    public LazyCollection filter(ElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyElement find(ElementCondition condition) {
        return new LazyCollectionFoundByConditionElement(this, condition);
    }

    public LazyCollection should(CollectionCondition... conditions) {
        WaitFor.until(this, conditions);
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
