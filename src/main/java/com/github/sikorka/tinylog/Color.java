package com.github.sikorka.tinylog;

/**
 * Represents PS1 colors / styles.
 */
public enum Color {

    /** Used in the end of a string to cancel coloring / background / bold / underline. */
    RESET_CURRENT_COLOR("\033[0m"),

    YELLOW                  ("\033[0;33m"),
    UNDERLINED_YELLOW       ("\033[4;33m"),
    BOLD_YELLOW             ("\033[1;33m"),
    INTENSE_YELLOW          ("\033[0;93m"),
    BOLD_INTENSE_YELLOW     ("\033[1;93m"),
    BACKGROUND_YELLOW       ("\033[43m"),
    BACKGROUND_INTENSE_YELLOW ("\033[0;103m"),

    PURPLE          ("\033[0;35m"),
    BOLD_PURPLE ("\033[1;35m"),
    BLUE        ("\033[0;34m"),
    BOLD_RED    ("\033[1;31m");



    private final String color;

    private Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }

}
