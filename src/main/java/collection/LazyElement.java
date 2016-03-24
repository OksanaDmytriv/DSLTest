package collection;

import conditions.CustomConditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static conditions.CustomConditions.elementVisible;
import static core.ConciseAPI.byCSS;
import static core.ConciseAPI.getDriver;

public class LazyElement extends LazyEntity {

    public LazyElement(LazyEntity lazyEntity) {
        super(lazyEntity);
    }

    public String getLocatorDescription() {
        return lazyEntity.toString();
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElement(byCSS(getLocatorDescription()));
    }

    public LazyFoundElement find(String innerLocator) {
        assertThat(elementVisible);
        return new LazyFoundElement(new LazyElement(lazyEntity), innerLocator);
    }

    public LazyElement click() {
        assertThat(elementVisible);
        getWrappedEntity().click();
        return this;
    }

    public LazyElement setValue(String text) {
        assertThat(elementVisible);
        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public LazyElement sendKeys(String text) {
        assertThat(elementVisible);
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public LazyElement clear() {
        assertThat(elementVisible);
        getWrappedEntity().clear();
        return this;
    }

    public LazyElement pressEnter() {
        assertThat(elementVisible);
        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        assertThat(elementVisible);
        getWrappedEntity().sendKeys(Keys.ESCAPE);
        return this;
    }

    public LazyElement hover() {
        getActions().moveToElement(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement doubleClick() {
        getActions().doubleClick(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement should(CustomConditions... conditions) {
        assertThat(conditions);
        return this;
    }

    public LazyElement shouldBe(CustomConditions... conditions) {
        return should(conditions);
    }

    public LazyElement shouldHave(CustomConditions... conditions) {
        return should(conditions);
    }

}
