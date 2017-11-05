package com.github.sikorka.tinylog;

/**
 * Represents PS1 colors.
 */
public enum Color {
    RESET_CURRENT_COLOR("\033[0m"),

    BLUE        ("\033[0;34m"),
    BOLD_RED    ("\033[1;31m"),
    PURPLE_BOLD ("\033[1;35m"),
    YELLOW      ("\033[0;33m"),
    PURPLE      ("\033[0;35m");

    private final String color;

    private Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }

}
