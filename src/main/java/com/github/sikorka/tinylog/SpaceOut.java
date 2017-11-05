package com.github.sikorka.tinylog;

/**
 * Space size between log msgs.
 */
public enum SpaceOut {
    SCREEN(50),
    HUGE(10),
    MEDIUM(4),
    ONE_LINE(1),
    NONE(0);

    String emptyLines;

    /**
     * Creates a string for each enum with as many
     * empty lines as in #amountOfEmptyLines.
     * */
    private SpaceOut(int amountOfEmptyLines) {
        emptyLines = new String(new char[amountOfEmptyLines]).
                replace("\0", System.lineSeparator());
    }

    public String getSpace() {
        return emptyLines;
    }
}
