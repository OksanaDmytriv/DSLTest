package conditions.collection;


import wrappers.LazyEntity;

import java.util.List;

public class PresenceOfAllElements extends CustomCollectionConditions {

    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return String.format("For all elements located by %s\n should be presence", lazyEntity.getLocatorDescription());
    }

    @Override
    protected List check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List elements = (List) lazyEntity.getWrappedEntity();
        return elements.size() >= 0 ? elements : null;
    }


}
