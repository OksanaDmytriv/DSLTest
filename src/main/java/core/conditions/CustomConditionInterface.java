package core.conditions;

import core.wrappers.LazyEntity;

public interface CustomConditionInterface<V> {

    <V> V apply(LazyEntity lazyEntity);

    String actual();

    String identity();

    String expected();

    LazyEntity entity();
}
