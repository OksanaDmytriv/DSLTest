package wrappers.forCollection;

import conditions.collection.CustomCollectionCondition;
import conditions.element.CustomElementCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;
import wrappers.forElement.LazyCollectionElementByCondition;
import wrappers.forElement.LazyCollectionElementByIndex;

import java.util.List;

import static conditions.collection.Helpers.minimumSizeOf;
import static core.ConciseAPI.getDriver;
import static core.ConciseAPI.waitFor;

public class LazyCollection implements LazyEntity {

    protected By locator;

    public LazyCollection(By locator){
        this.locator=locator;
    }

    public String toString() {
        return locator.toString();
    }

    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }

    public LazyCollectionElementByIndex get(int index) {
        waitFor(this, minimumSizeOf(index + 1));
        return new LazyCollectionElementByIndex(this, index);
    }

    public LazyFilteredCollection filter(CustomCollectionCondition condition) {
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
}


