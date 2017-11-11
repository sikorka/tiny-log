package com.github.sikorka.tinylog;

import static com.github.sikorka.tinylog.Color.ANSIColorCode.*;

/**
 * Represents PS1 colors / styles. It uses ANSI escape sequences.
 */
public enum Color {

    /** Used in the end of a string to cancel coloring / background / bold / underline. */
    RESET_CURRENT_COLOR(ESC.code + "[0m"),

    YELLOW                      (ESC.code + "[0;" + SUN.code + "m"),
    BOLD_YELLOW                 (ESC.code + "[1;" + SUN.code + "m"),
    UNDERLINED_YELLOW           (ESC.code + "[4;" + SUN.code + "m"),
    INTENSE_YELLOW              (ESC.code + "[0;" + SUN_BRIGHT.code + "m"),
    BOLD_INTENSE_YELLOW         (ESC.code + "[1;" + SUN_BRIGHT.code + "m"),
    BACKGROUND_YELLOW           (ESC.code + "[" +   SUN_BG.code + "m"),
    BACKGROUND_INTENSE_YELLOW   (ESC.code + "[0;" + SUN_BG_BOLD.code + "m"),

    PURPLE          (ESC.code + "[0;" + ROSE.code + "m"),
    BOLD_PURPLE     (ESC.code + "[" +   ROSE_BOLD.code + "m"),

    BLUE                (ESC.code + "[0;" + SKY_AT_NIGHT.code + "m"),
    BOLD_RED            (ESC.code + "[1;" + BLOOD.code + "m"),
    BOLD_INTENSE_RED    (ESC.code + "[1;" + BLOOD_BRIGHT.code + "m");

    private final String color;

    private Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }


    enum ANSIColorCode {
        ESC("\033"),

        COAL(30),
        BLOOD(31),
        GRASS(32),
        SUN(33),
        SKY_AT_NIGHT(34),
        ROSE(35),
        SEA(36),
        SNOW(37),

        COAL_BG(40),
        BLOOD_BG(41),
        GRASS_BG(42),
        SUN_BG(43),
        SKY_AT_NIGHT_BG(44),
        ROSE_BG(45),
        SEA_BG(46),
        SNOW_BG(47),

        COAL_BOLD("1;" + COAL.code),
        BLOOD_BOLD("1;" + BLOOD.code),
        GRASS_BOLD("1;" + GRASS.code),
        SUN_BOLD("1;" + SUN.code),
        SKY_AT_NIGHT_BOLD("1;" + SKY_AT_NIGHT.code),
        ROSE_BOLD("1;" + ROSE.code),
        SEA_BOLD("1;" + SEA.code),
        SNOW_BOLD("1;" + SNOW.code),

        COAL_BRIGHT(Integer.valueOf(COAL.code) + 60),
        BLOOD_BRIGHT(Integer.valueOf(BLOOD.code) + 60),
        GRASS_BRIGHT(Integer.valueOf(GRASS.code) + 60),
        SUN_BRIGHT(Integer.valueOf(SUN.code) + 60),
        SKY_AT_NIGHT_BRIGHT(Integer.valueOf(SKY_AT_NIGHT.code) + 60),
        ROSE_BRIGHT(Integer.valueOf(ROSE.code) + 60),
        SEA_BRIGHT(Integer.valueOf(SEA.code) + 60),
        SNOW_BRIGHT(Integer.valueOf(SNOW.code) + 60),

        COAL_BG_BOLD(100),
        BLOOD_BG_BOLD(101),
        GRASS_BG_BOLD(102),
        SUN_BG_BOLD(103),
        SKY_AT_NIGHT_BG_BOLD(104),
        ROSE_BG_BOLD(105),
        SEA_BG_BOLD(106),
        SNOW_BG_BOLD(107);

        private String code;

        ANSIColorCode(String code) {
            this.code = code;
        }

        ANSIColorCode(int code) {
            this(String.valueOf(code));
        }

    }

}
