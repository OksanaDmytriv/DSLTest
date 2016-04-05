package core.conditions;

import core.wrappers.LazyEntity;

public interface CustomConditionInterface<V> {

    <V> V apply(LazyEntity lazyEntity);

    <V> V actual();

    String identity();

    <V> V expected();

    LazyEntity entity();
}
