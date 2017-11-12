package com.github.sikorka.tinylog;

import static com.github.sikorka.tinylog.Color.ANSIColorCode.*;

/**
 * Represents PS1 colors / styles. It uses ANSI escape sequences.
 */
public enum Color {

    /** Used in the end of a string to cancel coloring / background / bold / underline. */
    RESET_CURRENT_COLOR(START.code + "[0" + END.code),

    NO_COLOR(RESET_CURRENT_COLOR.colorCode),

    YELLOW                      (START.code + REGULAR + SUN + END),
    BOLD_YELLOW                 (START.code + BOLD + SUN + END),
    UNDERLINED_YELLOW           (START.code + UNDERLINED + SUN + END),
    INTENSE_YELLOW              (START.code + REGULAR + SUN_BRIGHT + END),
    BOLD_INTENSE_YELLOW         (START.code + BOLD + SUN_BRIGHT + END),
    BACKGROUND_YELLOW                   (START.code + "["   + SUN_BG + END),
    BACKGROUND_YELLOW_BLUE_FOREGROUND   (START.code + BOLD + SUN_BG + ";" + SKY_AT_NIGHT + END),
    BACKGROUND_INTENSE_YELLOW_BLUE_FOREGROUND   (START.code + BOLD + SUN_BG_BRIGHT + ";" + SKY_AT_NIGHT + END),
    BACKGROUND_INTENSE_YELLOW           (START.code + REGULAR + SUN_BG_BRIGHT + END),

    PURPLE          (START.code + REGULAR + ROSE + END),
    BOLD_PURPLE     (START.code + ROSE_BOLD + END),

    BLUE                (START.code + REGULAR + SKY_AT_NIGHT + END),
    BACKGROUND_BLUE_YELLOW_FOREGROUND   (START.code + BOLD + SKY_AT_NIGHT + ";" + SUN_BG + END),
    BACKGROUND_BLUE_YELLOW_INTENSE_FOREGROUND   (START.code + BOLD + SKY_AT_NIGHT_BG + ";" + SUN_BRIGHT + END),

    CYAN                (START.code + REGULAR + SEA + END),

    BOLD_RED            (START.code + BOLD + BLOOD + END),
    BOLD_INTENSE_RED    (START.code + BOLD + BLOOD_BRIGHT + END);


    private final String colorCode;

    private Color(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return colorCode;
    }


    /** ANSI color codes. */
    enum ANSIColorCode {

        /** Escape is always the start of sequence. */
        START("\033"),
        /** Marker for end of color code. */
        END("m"),

        REGULAR("[0;"),
        BOLD("[1;"),
        UNDERLINED("[4;"),

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

        COAL_BOLD(BOLD + COAL.code),
        BLOOD_BOLD(BOLD + BLOOD.code),
        GRASS_BOLD(BOLD + GRASS.code),
        SUN_BOLD(BOLD + SUN.code),
        SKY_AT_NIGHT_BOLD(BOLD + SKY_AT_NIGHT.code),
        ROSE_BOLD(BOLD + ROSE.code),
        SEA_BOLD(BOLD + SEA.code),
        SNOW_BOLD(BOLD + SNOW.code),

        COAL_BRIGHT(Integer.valueOf(COAL.code) + 60),
        BLOOD_BRIGHT(Integer.valueOf(BLOOD.code) + 60),
        GRASS_BRIGHT(Integer.valueOf(GRASS.code) + 60),
        SUN_BRIGHT(Integer.valueOf(SUN.code) + 60),
        SKY_AT_NIGHT_BRIGHT(Integer.valueOf(SKY_AT_NIGHT.code) + 60),
        ROSE_BRIGHT(Integer.valueOf(ROSE.code) + 60),
        SEA_BRIGHT(Integer.valueOf(SEA.code) + 60),
        SNOW_BRIGHT(Integer.valueOf(SNOW.code) + 60),

        COAL_BG_BRIGHT(100),
        BLOOD_BG_BRIGHT(101),
        GRASS_BG_BRIGHT(102),
        SUN_BG_BRIGHT(103),
        SKY_AT_NIGHT_BG_BRIGHT(104),
        ROSE_BG_BRIGHT(105),
        SEA_BG_BRIGHT(106),
        SNOW_BG_BRIGHT(107);

        private String code;

        ANSIColorCode(String code) {
            this.code = code;
        }

        ANSIColorCode(int code) {
            this(String.valueOf(code));
        }

        @Override
        public String toString() {
            return code;
        }
    }

}
