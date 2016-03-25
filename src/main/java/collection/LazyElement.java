package collection;

import conditions.element.CustomConditionsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static conditions.collection.CustomConditionsCollection.elementVisible;
import static core.ConciseAPI.byCSS;
import static core.ConciseAPI.getDriver;

public class LazyElement extends LazyEntity {

    public LazyElement(By locator) {
        super(locator);
    }

    public String getLocatorDescription() {
        return locator.toString();
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }

    public LazyFoundElement find(By innerLocator) {
        assertThat(elementVisible);
        return new LazyFoundElement(this, innerLocator);
    }

    public LazyFoundElement find(String cssSelector) {
        return find(byCSS(cssSelector));
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
        assertThat(elementVisible);
        actions().moveToElement(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement doubleClick() {
        assertThat(elementVisible);
        actions().doubleClick(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement should(CustomConditionsElement... conditions) {
        assertThat(conditions);
        return this;
    }

    public LazyElement shouldBe(CustomConditionsElement... conditions) {
        return should(conditions);
    }

    public LazyElement shouldHave(CustomConditionsElement conditions) {
        return should(conditions);
    }

}
