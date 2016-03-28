package wrappers.forCollection;

import conditions.collection.CustomCollectionCondition;
import conditions.element.CustomElementCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;
import wrappers.forElement.LazyCollectionElementByIndex;
import wrappers.forElement.LazyFoundByConditionElement;

import java.util.List;

import static conditions.collection.CustomCollectionCondition.minimumSizeOf;
import static conditions.collection.CustomCollectionCondition.presenceList;
import static core.ConciseAPI.getDriver;
import static core.ConciseAPI.waitFor;

public class LazyCollection implements LazyEntity {

    protected By locator;

    public LazyCollection(By locator){
        this.locator=locator;
    }

    public String getLocatorDescription() {
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
        waitFor(this, presenceList);
        return new LazyFilteredCollection(this, condition);
    }

    public LazyFoundByConditionElement find(CustomElementCondition condition) {
        waitFor(this, presenceList);
        return new LazyFoundByConditionElement(this, condition);
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


