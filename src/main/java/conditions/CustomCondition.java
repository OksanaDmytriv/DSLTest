package conditions;


import wrappers.LazyEntity;

public interface CustomCondition<V> {

    <V> V apply(LazyEntity lazyEntity);

    String getActualValuesDescription();
}
