package core.conditions;

import core.exceptions.WebDriverAssertionException;
import core.wrappers.LazyEntity;

public abstract class AbstractCondition<T> implements Condition<Boolean>, DescribesResult {

    private LazyEntity lazyEntity;

    public String toString() {
        return "\n" + this.getClass() + "\n" +
                "for " + identity() + "\n" +
                "found by: " + lazyEntity + "\n" +
                "expected: " + expected() + "\n" +
                "actual: " + actual();
    }

    public Boolean apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        if (!check((T) lazyEntity.getWrappedEntity())) {
            throw new WebDriverAssertionException();
        }
        return check((T) lazyEntity.getWrappedEntity());
    }

    public abstract boolean check(T entity);
}
