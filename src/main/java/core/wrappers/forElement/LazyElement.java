package core.wrappers.forElement;

import core.conditions.element.CustomElementCondition;
import core.wrappers.LazyEntity;
import core.wrappers.forCollection.LazyCollectionByElementLocator;
import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.*;
import static core.conditions.element.CustomElementConditions.present;
import static core.conditions.element.CustomElementConditions.visible;

public abstract class LazyElement implements LazyEntity, WebElement {

    public abstract WebElement getWrappedEntity();

    public LazyCollectionElementByInnerLocator find(By innerLocator) {
        return new LazyCollectionElementByInnerLocator(this, innerLocator);
    }

    public LazyCollectionElementByInnerLocator find(String cssSelector) {
        return find(byCSS(cssSelector));
    }

    public LazyCollectionByElementLocator findAll(By locator) {
        return new LazyCollectionByElementLocator(this, locator);
    }

    public LazyCollectionByElementLocator findAll(String cssSelector) {
        return new LazyCollectionByElementLocator(this, byCSS(cssSelector));
    }

    public void clear() {
        waitFor(this, visible());
        getWrappedEntity().clear();
    }

    public void click() {
        waitFor(this, visible());
        getWrappedEntity().click();
    }

    public LazyElement setValue(String text) {
        waitFor(this, visible());
        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public LazyElement sendKeys(String text) {
        waitFor(this, visible());
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public LazyElement pressEnter() {
        waitFor(this, visible());
        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        waitFor(this, visible());
        getWrappedEntity().sendKeys(Keys.ESCAPE);
        return this;
    }

    public LazyElement hover() {
        waitFor(this, visible());
        actions().moveToElement(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement doubleClick() {
        waitFor(this, visible());
        actions().doubleClick(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement should(CustomElementCondition... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public LazyElement shouldBe(CustomElementCondition... conditions) {
        return should(conditions);
    }

    public LazyElement shouldHave(CustomElementCondition conditions) {
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
        waitFor(this, present());
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
        waitFor(this, present());
        return getWrappedEntity().getLocation();
    }

    public Dimension getSize() {
        waitFor(this, present());
        return getWrappedEntity().getSize();
    }

    public Rectangle getRect() {
        waitFor(this, present());
        return getWrappedEntity().getRect();
    }

    public String getCssValue(String s) {
        waitFor(this, present());
        return getWrappedEntity().getCssValue(s);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        waitFor(this, present());
        return getWrappedEntity().getScreenshotAs(outputType);
    }
}
