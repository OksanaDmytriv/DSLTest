package conditions.collection;

public class Helpers {
    public static CustomCollectionCondition textsOf(final String... texts) {
        return new TextsOf(texts);
    }

    public static CustomCollectionCondition sizeOf(final int expectedSize) {
        return new SizeOf(expectedSize);
    }

    public static CustomCollectionCondition minimumSizeOf(final int minimumSize) {
        return new MinimumSizeOf(minimumSize);
    }

    public static CustomCollectionCondition listNthElementHasText(
            final int index, final String text) {
        return new ListNthElementHasText(index, text);
    }

    public static CustomCollectionCondition listOfVisibleElementsIsEmpty() {
        return new ListOfVisibleElementsIsEmpty();
    }

    public static CustomCollectionCondition visibleTextsOf(final String... texts) {
        return new VisibleTextsOf(texts);
    }

    public static CustomCollectionCondition empty() {
        return new SizeOf(0);
    }

}
