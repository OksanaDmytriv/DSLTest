package core.wrappers.forCollection;

import core.conditions.collection.CustomCollectionConditions;
import core.conditions.element.CustomElementConditions;
import core.wrappers.LazyEntity;
import core.wrappers.forElement.LazyCollectionElementByCondition;
import core.wrappers.forElement.LazyCollectionElementByIndex;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static core.ConciseAPI.waitFor;

public abstract class LazyCollection implements LazyEntity, Iterable<LazyCollection> {

    public abstract List<WebElement> getWrappedEntity();

    public LazyCollectionElementByIndex get(int index) {

        return new LazyCollectionElementByIndex(this, index);
    }

    public LazyFilteredCollection filter(CustomElementConditions condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyCollectionElementByCondition find(CustomElementConditions condition) {
        return new LazyCollectionElementByCondition(this, condition);
    }

    public LazyCollection should(CustomCollectionConditions... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public LazyCollection shouldBe(CustomCollectionConditions... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CustomCollectionConditions... conditions) {
        return should(conditions);
    }

    @Override
    public Iterator<LazyCollection> iterator() {
        List<LazyCollection> collections =new ArrayList<>();
        return collections.iterator();
    }
}
