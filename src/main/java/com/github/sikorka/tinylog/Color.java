package com.github.sikorka.tinylog;

import static com.github.sikorka.tinylog.Color.ANSIColorCode.*;

/**
 * Represents PS1 colors / styles. It uses ANSI escape sequences.
 */
public enum Color {

    //TODO add background / foreground colors

    /** Used in the end of a string to cancel coloring / background / bold / underline. */
    RESET_CURRENT_COLOR(REGULAR),

    NO_COLOR(REGULAR),

    YELLOW                      (REGULAR, SUN),
    BOLD_YELLOW                 (BOLD, SUN),
    UNDERLINED_YELLOW           (UNDERLINED, SUN),
    INTENSE_YELLOW              (REGULAR, SUN_BRIGHT),
    BOLD_INTENSE_YELLOW         (BOLD, SUN_BRIGHT),
    BG_YELLOW                   (REGULAR, SUN_BG),
    BG_YELLOW_BLUE_FG           (BOLD, SUN_BG, SKY_AT_NIGHT),
    BG_INTENSE_YELLOW_BLUE_FG   (BOLD, SUN_BG_BRIGHT, SKY_AT_NIGHT),
    BG_INTENSE_YELLOW           (REGULAR, SUN_BG_BRIGHT),

    PURPLE          (REGULAR, ROSE),
    BOLD_PURPLE     (BOLD, ROSE),

    BLUE                        (REGULAR, SKY_AT_NIGHT),
    BG_BLUE_YELLOW_FG           (BOLD, SKY_AT_NIGHT, SUN_BG),
    BG_BLUE_YELLOW_INTENSE_FG   (BOLD, SKY_AT_NIGHT_BG, SUN_BRIGHT),

    CYAN                (REGULAR, SEA),

    BOLD_RED            (BOLD, BLOOD),
    BOLD_INTENSE_RED    (BOLD, BLOOD_BRIGHT);


    private final String colorCode;

    private Color(ANSIColorCode style) {
        this.colorCode = START.code + style + END;
    }

    private Color(ANSIColorCode style, ANSIColorCode background, ANSIColorCode foreground) {
        colorCode = START.code + style + ";" + background + ";" + foreground + END;
    }

    private Color(ANSIColorCode style, ANSIColorCode backgroundOrForeground) {
        colorCode = START.code + style + ";" + backgroundOrForeground + END;
    }

    @Override
    public String toString() {
        return colorCode;
    }


    /** ANSI color codes. */
    enum ANSIColorCode {

        /** Escape is always the start of sequence. */
        START("\033["),
        /** Marker for end of color code. */
        END("m"),

        REGULAR("0"),
        BOLD("1"),
        UNDERLINED("4"),

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

//        COAL_BOLD(BOLD + COAL.code),
//        BLOOD_BOLD(BOLD + BLOOD.code),
//        GRASS_BOLD(BOLD + GRASS.code),
//        SUN_BOLD(BOLD + SUN.code),
//        SKY_AT_NIGHT_BOLD(BOLD + SKY_AT_NIGHT.code),
//        ROSE_BOLD(BOLD + ROSE.code),
//        SEA_BOLD(BOLD + SEA.code),
//        SNOW_BOLD(BOLD + SNOW.code),

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
