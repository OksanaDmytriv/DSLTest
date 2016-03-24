package collection;

import conditions.CustomConditions;
import org.openqa.selenium.WebElement;

import java.util.List;

import static conditions.CustomConditions.minimumSizeOf;
import static core.ConciseAPI.byCSS;
import static core.ConciseAPI.getDriver;

public class LazyCollection extends LazyEntity {

    public LazyCollection(LazyEntity lazyEntity) {
        super(lazyEntity);
    }

    public String getLocatorDescription() {
        return lazyEntity.toString();
    }

    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(byCSS(getLocatorDescription()));
    }

    public LazyCollectionElementByIndex get(int index) {
        assertThat(minimumSizeOf(index+1));
        return new LazyCollectionElementByIndex((LazyCollection) getWrappedEntity(), index);
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


