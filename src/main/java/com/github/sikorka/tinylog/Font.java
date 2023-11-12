package com.github.sikorka.tinylog;

/**
 * Represents ASCII art fonts.
 */
public enum Font {

    NONE(),

    //NICE, OVAL, INTERESTING, BEAUTIFUL, bit cranky
    THIN_STRAIGHT("straight", 16),
    //GOOD, wider than straight though
    THIN_MINI("mini", 16),
    //the nicest, huge font
    BIG("standard", 10),
    //standard in cursive
    BIG_CURSIVE("slant", 10),
    //like standard, but taller
    BIG_TALL("big", 10),
    //big, bulky, bold, wide
    BIG_BLOCK("block", 10);


    static final String URL = "http://www.figlet.org/fonts/";
    static final String CLASSPATH = "classpath:/";
    static final String EXTENSION = "flf";

    /** FLF font file name. */
    private final String fontName;

    /**
     * Not final, can be changed for specific purpose.
     * Represents max characters that can go into a one liner.
     * */
    int maxCharsInOneLine;

    private Font(String fontName, int maxOneLinerChars) {
        this.fontName = fontName;
        this.maxCharsInOneLine = maxOneLinerChars;
    }

    private Font() {
        this.fontName = null;
        this.maxCharsInOneLine = -1;
    }

    @Override
    public String toString() {
        return fontName + " (" + maxCharsInOneLine + ")";
    }

    public String getFontName() {
        return fontName;
    }

    public int getMaxCharsInOneLine() {
        return maxCharsInOneLine;
    }

    public String getFontFileName() {
        return fontName + "." + EXTENSION;
    }

    /**
     * Returns Figlet's specific path to font.
     *
     * @return Figlet's path string
     * */
    public String getFontPath() {
        return CLASSPATH + fontName + "." + EXTENSION;
    }
}
