package core.wrappers.forElement;

import core.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.conditions.element.ElementConditions.present;

public class LazyElementInnerElement extends AbstractLazyElement {

    private By innerLocator;
    private AbstractLazyElement parentElement;

    public LazyElementInnerElement(AbstractLazyElement parentElement, By innerLocator) {
        this.parentElement=parentElement;
        this.innerLocator=innerLocator;
    }

    public String toString() {
        return parentElement.toString() + " " + innerLocator + "";
    }

    public WebElement getWrappedEntity() {
        WaitFor.until(parentElement, present());
        return parentElement.getWrappedEntity().findElement(innerLocator);
    }

}
