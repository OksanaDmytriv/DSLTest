package core.wrappers.forElement;

import core.conditions.element.CustomElementConditions;
import core.wrappers.LazyEntity;
import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.*;
import static core.conditions.element.Core.visible;

public class LazyElement implements LazyEntity, WebElement {

    protected By locator;

    public LazyElement(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }

    public LazyCollectionElementByInnerLocator find(By innerLocator) {
        waitFor(this, visible());
        return new LazyCollectionElementByInnerLocator(this, innerLocator);
    }

    public LazyCollectionElementByInnerLocator find(String cssSelector) {
        return find(byCSS(cssSelector));
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

    public void clear() {
        waitFor(this, visible());
        getWrappedEntity().clear();
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
        getWrappedEntity().submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        getWrappedEntity().sendKeys();
    }

    public String getTagName() {
        return getWrappedEntity().getTagName();
    }

    public String getAttribute(String s) {
        return getWrappedEntity().getAttribute(s);
    }

    public boolean isSelected() {
        return getWrappedEntity().isSelected();
    }

    public boolean isEnabled() {
        return getWrappedEntity().isEnabled();
    }

    public String getText() {
        return getWrappedEntity().getText();
    }

    public List<WebElement> findElements(By by) {
        return getWrappedEntity().findElements(by);
    }

    public WebElement findElement(By by) {
        return getWrappedEntity().findElement(by);
    }

    public boolean isDisplayed() {
        return getWrappedEntity().isDisplayed();
    }

    public Point getLocation() {
        return getWrappedEntity().getLocation();
    }

    public Dimension getSize() {
        return getWrappedEntity().getSize();
    }

    public Rectangle getRect() {
        return getWrappedEntity().getRect();
    }

    public String getCssValue(String s) {
        return getWrappedEntity().getCssValue(s);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}