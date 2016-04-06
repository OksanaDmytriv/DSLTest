package core.conditions;

import core.wrappers.LazyEntity;

public interface Condition<V> {

    <V> V apply(LazyEntity lazyEntity);

    String actual();

    String identity();

    String expected();

    LazyEntity entity();
}
