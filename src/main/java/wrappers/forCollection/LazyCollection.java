package wrappers.forCollection;

import conditions.collection.CustomCollectionConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;
import wrappers.forElement.LazyCollectionElementByIndex;
import wrappers.forElement.LazyFoundElement;

import java.util.List;

import static conditions.collection.CustomCollectionConditions.minimumSizeOf;
import static conditions.collection.CustomCollectionConditions.presenceOfAllElements;
import static core.ConciseAPI.getDriver;

public class LazyCollection extends LazyEntity {

    public LazyCollection(By locator) {
        super(locator);
    }

    public String getLocatorDescription() {
        return locator.toString();
    }

    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }

    public LazyCollectionElementByIndex get(int index) {
        assertThat(minimumSizeOf(index + 1));
        return new LazyCollectionElementByIndex(this, index);
    }

    public LazyFilteringElements filter(CustomCollectionConditions condition) {
        assertThat(presenceOfAllElements);
        List<WebElement> newList = null;
        List<WebElement> element = getWrappedEntity();
        for (int i=0; i<element.size(); ++i){
            if (condition.apply(element.get(i)) != null){
                newList.add(i, element.get(i));
            }
        }
        return new LazyFilteringElements(this, condition);
    }

    public LazyFoundElement find(CustomCollectionConditions condition) {
        assertThat(presenceOfAllElements);
        //тут нехорошо
        return new LazyFoundElements(this).filter(condition).get(0);
    }

    public LazyCollection should(CustomCollectionConditions... conditions) {
        assertThat(conditions);
        return this;
    }

    public LazyCollection shouldBe(CustomCollectionConditions... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CustomCollectionConditions... conditions) {
        return should(conditions);
    }
}


