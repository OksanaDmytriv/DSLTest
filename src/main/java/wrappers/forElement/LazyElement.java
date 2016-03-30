package wrappers.forElement;

import conditions.element.CustomElementCondition;
import org.openqa.selenium.*;
import wrappers.LazyEntity;

import java.util.List;

import static conditions.element.Helpers.elementVisible;
import static core.ConciseAPI.*;

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
        waitFor(this, elementVisible());
        return new LazyCollectionElementByInnerLocator(this, innerLocator);
    }

    public LazyCollectionElementByInnerLocator find(String cssSelector) {
        return find(byCSS(cssSelector));
    }

    public void click() {
        waitFor(this, elementVisible());
        getWrappedEntity().click();
    }

    public void submit() {
        getWrappedEntity().submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        getWrappedEntity().sendKeys();
    }

    public LazyElement setValue(String text) {
        waitFor(this, elementVisible());
        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public LazyElement sendKeys(String text) {
        waitFor(this, elementVisible());
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public void clear() {
        waitFor(this, elementVisible());
        getWrappedEntity().clear();
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

    public LazyElement pressEnter() {
        waitFor(this, elementVisible());
        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        waitFor(this, elementVisible());
        getWrappedEntity().sendKeys(Keys.ESCAPE);
        return this;
    }

    public LazyElement hover() {
        waitFor(this, elementVisible());
        actions().moveToElement(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement doubleClick() {
        waitFor(this, elementVisible());
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

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
