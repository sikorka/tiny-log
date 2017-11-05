package com.github.sikorka.tinylog;

/**
 * Represents ASCII art fonts.
 */
public enum Font {

    //NICE, OVAL, INTERESTING, BEAUTIFUL, bit cranky
    STRAIGHT("straight", 16),
    //GOOD, wider than straight though
    MINI("mini", 16),
    //can't be used with uppercase
    THREEPOINT("threepoint", 16),
    //the nicest, huge font
    STANDARD("standard", 10),
    //standard in cursive
    SLANT("slant", 10);

    final static String URL = "http://www.figlet.org/fonts/";
    final static String CLASSPATH = "classpath:/";
    final static String EXTENSION = "flf";

    /** FLF font file name. */
    private final String fontName;
    /**
     * Not final, can be changed for specific purpose.
     * Represents max characters that can go into a one liner.
     * */
    int maxOneLinerChars;

    private Font(String fontName, int maxOneLinerChars) {
        this.fontName = fontName;
        this.maxOneLinerChars = maxOneLinerChars;
    }

    @Override
    public String toString() {
        return fontName + " (" + maxOneLinerChars + ")";
    }

    public String getFontName() {
        return fontName;
    }

    public int getMaxOneLinerChars() {
        return maxOneLinerChars;
    }

    public String getFontFileName() {
        return fontName + "." + EXTENSION;
    }

    public String getFontPathForFiglet() {
        return CLASSPATH + fontName + "." + EXTENSION;
    }
}
