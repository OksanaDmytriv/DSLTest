package collection;

import conditions.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static conditions.CustomConditions.minimumSizeOf;
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

    public LazyCollection should(CustomConditions... conditions) {
        assertThat(conditions);
        return this;
    }

    public LazyCollection shouldBe(CustomConditions... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CustomConditions... conditions) {
        return should(conditions);
    }
}


