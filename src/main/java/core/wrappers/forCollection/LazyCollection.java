package core.wrappers.forCollection;

import core.conditions.collection.CustomCollectionConditions;
import core.conditions.element.CustomElementConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;
import core.wrappers.forElement.LazyCollectionElementByCondition;
import core.wrappers.forElement.LazyCollectionElementByIndex;

import java.util.List;

import static core.conditions.collection.Core.minimumSize;
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
        waitFor(this, minimumSize(index + 1));
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
}


