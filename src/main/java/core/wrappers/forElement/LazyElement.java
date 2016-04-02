package core.wrappers.forElement;

import core.conditions.element.CustomElementConditions;
import core.wrappers.LazyEntity;
import core.wrappers.forCollection.LazyCollectionByLocator;
import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.*;
import static core.conditions.element.Core.elementPresent;
import static core.conditions.element.Core.visible;

public abstract class LazyElement implements LazyEntity, WebElement {

    public abstract WebElement getWrappedEntity();

    public LazyCollectionElementByInnerLocator find(By innerLocator) {
        return new LazyCollectionElementByInnerLocator(this, innerLocator);
    }

    public LazyCollectionElementByInnerLocator find(String cssSelector) {
        return find(byCSS(cssSelector));
    }

    public LazyCollectionByLocator findAll(By locator) {
        return new LazyCollectionByLocator(this, locator);
    }

    public LazyCollectionByLocator findAll(String cssSelector) {
        return new LazyCollectionByLocator(this, byCSS(cssSelector));
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

    public LazyElement should(CustomElementConditions... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public LazyElement shouldBe(CustomElementConditions... conditions) {
        return should(conditions);
    }

    public LazyElement shouldHave(CustomElementConditions conditions) {
        return should(conditions);
    }

    public void submit() {
        waitFor(this, elementPresent());
        getWrappedEntity().submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        waitFor(this, elementPresent());
        getWrappedEntity().sendKeys();
    }

    public String getTagName() {
        waitFor(this, elementPresent());
        return getWrappedEntity().getTagName();
    }

    public String getAttribute(String s) {
        waitFor(this, elementPresent());
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
        waitFor(this, elementPresent());
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
        waitFor(this, elementPresent());
        return getWrappedEntity().getLocation();
    }

    public Dimension getSize() {
        waitFor(this, elementPresent());
        return getWrappedEntity().getSize();
    }

    public Rectangle getRect() {
        waitFor(this, elementPresent());
        return getWrappedEntity().getRect();
    }

    public String getCssValue(String s) {
        waitFor(this, elementPresent());
        return getWrappedEntity().getCssValue(s);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        waitFor(this, elementPresent());
        return getWrappedEntity().getScreenshotAs(outputType);
    }
}
