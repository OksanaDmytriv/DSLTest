package core.conditions.collection;

public class Core {
    public static CustomCollectionConditions texts(final String... texts) {
        return new Texts(texts);
    }

    public static CustomCollectionConditions exactTexts(final String... texts) {
        return new ExactTexts(texts);
    }

    public static CustomCollectionConditions size(final int expectedSize) {
        return new Size(expectedSize);
    }

    public static CustomCollectionConditions minimumSize(final int minimumSize) {
        return new MinimumSize(minimumSize);
    }

    public static CustomCollectionConditions listNthElementHasText(
            final int index, final String text) {
        return new ListNthElementHasText(index, text);
    }

    public static CustomCollectionConditions empty() {
        return new Size(0);
    }

}
