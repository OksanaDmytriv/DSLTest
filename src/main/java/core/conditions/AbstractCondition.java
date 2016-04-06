package core.conditions;

import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractCondition<V> implements Condition<V> {

    protected LazyEntity lazyEntity;

    public LazyEntity entity(){
        return lazyEntity;
    }

    public String toString(){
        return "\n" + this.getClass() + "\n" +
                "for " + identity() + "\n" +
                "found by: " + entity() + "\n" +
                "expected: " + expected()+ "\n" +
                "actual: " + actual();
    }

    public <V> V apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        try {
            return check();
        } catch (WebDriverException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    protected abstract <V> V check();
}
