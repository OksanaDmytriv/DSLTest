package wrappers;


import conditions.element.CustomElementCondition;
import org.openqa.selenium.*;
import wrappers.forElement.LazyElement;

import java.util.List;

public class LazyWrappedWebElement extends WebElement{

    private LazyElement parentElement;
    private WebElement element;
    private CustomElementCondition condition;

    public LazyWrappedWebElement(WebElement element, LazyElement parentElement) {
        this.element=element;
        this.parentElement=parentElement;
    }

    public String getLocatorDescription() {
        return parentElement.getLocatorDescription();
    }

    public WebElement getWrappedEntity() {
        return parentElement.getWrappedEntity();
    }

    public boolean isValid(CustomElementCondition condition){
        //и тут нехорошо
        if (condition.apply(this) != null){
            return true;
        }
        return false;
    }

    public void click() {
    }

    public void submit() {
    }

    public void sendKeys(CharSequence... charSequences) {
    }

    public void clear() {
    }

    public String getTagName() {
        return null;
    }

    public String getAttribute(String s) {
        return null;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public String getText() {
        return null;
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return false;
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return null;
    }

    public Rectangle getRect() {
        return null;
    }

    public String getCssValue(String s) {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
