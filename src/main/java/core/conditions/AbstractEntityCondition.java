package core.conditions;

import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractEntityCondition<T> implements EntityCondition<T>, DescribesResult {

    private LazyEntity lazyEntity;

    public String toString(){
        return "\n" + this.getClass() + "\n" +
                "for " + identity() + "\n" +
                "found by: " + lazyEntity + "\n" +
                "expected: " + expected()+ "\n" +
                "actual: " + actual();
    }

    public T apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        try {
            return check((T) lazyEntity.getWrappedEntity());
        } catch (WebDriverException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    public abstract T check(T entity);
}
