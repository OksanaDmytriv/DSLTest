package collection;

import conditions.collection.CustomConditionsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static conditions.collection.CustomConditionsCollection.minimumSizeOf;
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

    public LazyCollection should(CustomConditionsCollection... conditions) {
        assertThat(conditions);
        return this;
    }

    public LazyCollection shouldBe(CustomConditionsCollection... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CustomConditionsCollection... conditions) {
        return should(conditions);
    }
}


