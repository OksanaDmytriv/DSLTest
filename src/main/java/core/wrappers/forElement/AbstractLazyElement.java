package core.wrappers.forElement;

import core.conditions.element.ElementCondition;
import core.wrappers.LazyEntity;
import core.wrappers.forCollection.LazyElementInnerCollection;
import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.*;
import static core.conditions.element.ElementConditions.present;
import static core.conditions.element.ElementConditions.visible;

public abstract class AbstractLazyElement implements LazyEntity, WebElement {

    public abstract WebElement getWrappedEntity();

    public LazyElementInnerElement find(By innerLocator) {
        return new LazyElementInnerElement(this, innerLocator);
    }

    public LazyElementInnerElement find(String cssSelector) {
        return find(byCSS(cssSelector));
    }

    public LazyElementInnerCollection findAll(By locator) {
        return new LazyElementInnerCollection(this, locator);
    }

    public LazyElementInnerCollection findAll(String cssSelector) {
        return new LazyElementInnerCollection(this, byCSS(cssSelector));
    }

    public void clear() {
        waitFor(this, visible());
        getWrappedEntity().clear();
    }

    public void click() {
        waitFor(this, visible());
        getWrappedEntity().click();
    }

    public AbstractLazyElement setValue(String text) {
        waitFor(this, visible());
        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public AbstractLazyElement sendKeys(String text) {
        waitFor(this, visible());
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public AbstractLazyElement pressEnter() {
        waitFor(this, visible());
        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public AbstractLazyElement pressEscape() {
        waitFor(this, visible());
        getWrappedEntity().sendKeys(Keys.ESCAPE);
        return this;
    }

    public AbstractLazyElement hover() {
        waitFor(this, visible());
        actions().moveToElement(getWrappedEntity()).perform();
        return this;
    }

    public AbstractLazyElement doubleClick() {
        waitFor(this, visible());
        actions().doubleClick(getWrappedEntity()).perform();
        return this;
    }

    public AbstractLazyElement should(ElementCondition... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public boolean is(ElementCondition condition) {
        return condition.apply(this) != null ? true : false;
    }

    public boolean has(ElementCondition condition) {
        return is(condition);
    }

    public AbstractLazyElement shouldBe(ElementCondition... conditions) {
        return should(conditions);
    }

    public AbstractLazyElement shouldHave(ElementCondition conditions) {
        return should(conditions);
    }

    public void submit() {
        waitFor(this, visible());
        getWrappedEntity().submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        waitFor(this, visible());
        getWrappedEntity().sendKeys();
    }

    public String getTagName() {
        waitFor(this, present());
        return getWrappedEntity().getTagName();
    }

    public String getAttribute(String s) {
        waitFor(this, present());
        return getWrappedEntity().getAttribute(s);
    }

    public boolean isSelected() {
        waitFor(this, visible());
        return getWrappedEntity().isSelected();
    }

    public boolean isEnabled() {
        waitFor(this, visible());
        return getWrappedEntity().isEnabled();
    }

    public String getText() {
        waitFor(this, visible());
        return getWrappedEntity().getText();
    }

    public List<WebElement> findElements(By by) {
        waitFor(this, visible());
        return getWrappedEntity().findElements(by);
    }

    public WebElement findElement(By by) {
        waitFor(this, visible());
        return getWrappedEntity().findElement(by);
    }

    public boolean isDisplayed() {
        waitFor(this, visible());
        return getWrappedEntity().isDisplayed();
    }

    public Point getLocation() {
        waitFor(this, visible());
        return getWrappedEntity().getLocation();
    }

    public Dimension getSize() {
        waitFor(this, visible());
        return getWrappedEntity().getSize();
    }

    public Rectangle getRect() {
        waitFor(this, visible());
        return getWrappedEntity().getRect();
    }

    public String getCssValue(String s) {
        waitFor(this, present());
        return getWrappedEntity().getCssValue(s);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        waitFor(this, visible());
        return getWrappedEntity().getScreenshotAs(outputType);
    }
}
