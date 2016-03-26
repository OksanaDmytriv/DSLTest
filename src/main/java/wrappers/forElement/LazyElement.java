package wrappers.forElement;

import conditions.element.CustomElementCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import static conditions.element.CustomElementCondition.elementVisible;
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

    public LazyFoundByLocatorElement find(By innerLocator) {
        assertThat(elementVisible);
        return new LazyFoundByLocatorElement(this, innerLocator);
    }

    public LazyFoundByLocatorElement find(String cssSelector) {
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

    public LazyElement should(CustomElementCondition... conditions) {
        assertThat(conditions);
        return this;
    }

    public LazyElement shouldBe(CustomElementCondition... conditions) {
        return should(conditions);
    }

    public LazyElement shouldHave(CustomElementCondition conditions) {
        return should(conditions);
    }

}
