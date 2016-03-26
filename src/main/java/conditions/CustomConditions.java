package conditions;


import wrappers.LazyEntity;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public abstract class CustomConditions<V> {

    public void fail() {
        throw new AssertionError(toString());
    }

    public abstract String toString();

    protected abstract <V> V check(LazyEntity lazyEntity);

    public <V> V apply(LazyEntity lazyEntity) {
        try {
            return check(lazyEntity);
        } catch (StaleElementReferenceException e) {
            return null;
        } catch (ElementNotVisibleException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
