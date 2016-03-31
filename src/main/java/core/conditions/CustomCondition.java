package core.conditions;


import core.wrappers.LazyEntity;

public interface CustomCondition<V> {

    <V> V apply(LazyEntity lazyEntity);

    <V> V getActualValuesDescription();
}
