package wrappers.forElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyFoundByLocatorElement extends LazyElement {

    private By innerLocator;
    private LazyElement parentElement;

    public LazyFoundByLocatorElement(LazyElement parentElement, By innerLocator) {
        super(null);
        this.parentElement=parentElement;
        this.innerLocator=innerLocator;
    }

    public String getLocatorDescription() {
        return parentElement.getLocatorDescription().concat(" "+innerLocator+"");
    }

    public WebElement getWrappedEntity() {
        return parentElement.getWrappedEntity().findElement(innerLocator);
    }

}
