package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyFoundElement extends LazyElement {

    private By innerLocator;
    private LazyElement parentElement;

    public LazyFoundElement(LazyElement parentElement, By innerLocator) {
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
