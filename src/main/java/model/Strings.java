package model;

/**
 * @author Korwin Bieniek
 */
public enum Strings {
    FIRST_MESSAGE("There should be 2 arguments and 3 were passed"),
    SECOND_MESSAGE("There should be 4 arguments and 3 were passed");

    private final String text;

    /**
     * @param text - the text that will be returned from enum
     */
    Strings(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
