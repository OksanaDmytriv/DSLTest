package wrappers;

public interface LazyEntity<TypeOfWrappedEntity> {

    <TypeOfWrappedEntity> TypeOfWrappedEntity getWrappedEntity();

    String getLocatorDescription();
}
