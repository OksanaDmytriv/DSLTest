package core.conditions;

import core.wrappers.LazyEntity;

public abstract class CustomCondition<V> implements CustomConditionInterface<V> {

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
}
