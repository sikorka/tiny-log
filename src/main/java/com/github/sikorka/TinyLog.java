package com.github.sikorka;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Tiny logger.
 *
 * Delivers verbose, tiny API for printing msgs to standard out.
 */
public class TinyLog {

    static final PrintStream OUT = System.out;

    static final int SHOUT_MAX_LENGTH     = 10;
    static final int HIGHLIGHT_MAX_LENGTH = 16;

    /**
     * Logs object to standard out.
     *
     * @param ob any object
     * */
    public static void say(Object ob) {
        plainNoLine(SAY_COLOR + ob + RESET);
        newLine();
    }

    /**
     * Logs array to standard out.
     *
     * @param array any object
     * */
    public static void say(Object[] array) {
        say(Arrays.toString(array));
    }

    /**
     * Adds significant space between log msgs to standard out.
     * */
    public static void spaceOut() {
        plainNoLine(SPACE_OUT);
    }

    /**
     * Highlights object at standard out.
     *
     * Prints string of any length to standard out in BOLD RED.
     *
     * @param ob any object
     * */
    public static void sayLoud(Object ob) {
        sayLoudNoLine(ob);
        newLine();
    }

    private static void sayLoudNoLine(Object ob) {
        plainNoLine(LOUD_COLOR + ob + RESET);
    }

    /**
     * Prints plain object to standard out - no colors, no highlight, no new line.
     *
     * @param ob any object
     * */
    private static void plainNoLine(Object ob) {
        OUT.print(ob);
    }

    /**
     * Prints plain object to standard out (no colors, no highlight) + new line.
     *
     * @param ob any object
     * */
    static void blendIn(Object ob) {
        plainNoLine(ob);
        newLine();
    }

    /**
     * Prints new line to standard out.
     * */
    private static void newLine() {
        OUT.println();
    }

    /**
     * Can't stay unnoticed. Draws big string to standard out.
     *
     * @param ob any object
     * */
    public static void highlight(Object ob) {
        Object[] brokenString = Wrapper.breakAfter(String.valueOf(ob), HIGHLIGHT_MAX_LENGTH);

        try {
            for (Object s : brokenString)
                sayLoudNoLine(FigletFont.convertOneLine(HIGHLIGHT_FONT, String.valueOf(s)));
        } catch (Exception e) {
            handleException(e, brokenString);
        }

    }

    private static void handleException(Exception e, Object ob) {
        plainNoLine("Problem with font! " + e.getCause());
        e.printStackTrace();

        sayLoud(ob);
    }

    /**
     * Can't stay unnoticed. Draws huge string to standard out.
     *
     * Uses object's <code>toString()</code> method to draw its representations.
     * Wraps the string at
     *
     * @param ob any object
     * */
    public static void shout(Object ob) {
        Object[] brokenString = Wrapper.breakAfter(String.valueOf(ob), SHOUT_MAX_LENGTH);

        try {
            for (Object s : brokenString)
                sayLoudNoLine(FigletFont.convertOneLine(String.valueOf(s)));
        } catch (Exception e) {
            handleException(e, brokenString);
        }

    }

    public static void clearScreen() {
        plainNoLine(CLEAR_SCREEN);
    }


    private static final String SPACE_OUT = "\n\n\n\n";
    private static final String CLEAR_SCREEN = SPACE_OUT.concat(SPACE_OUT).concat(SPACE_OUT).concat(SPACE_OUT);


    private static final String URL = "http://www.figlet.org/fonts/";
    private static final String CLASSPATH = "classpath:/";

    //NICE, OVAL, INTERESTING, BEAUTIFUL
    private static final String STRAIGHT_FONT_NAME = "straight.flf";
    //GOOD, wider than stampatello though
    private static final String MINI_FONT_NAME = "mini.flf";
    //can't be used with uppercase
    private static final String THREEPOINT_FONT_NAME = "threepoint.flf";

    /** Can be changed to {@link #MINI_FONT_NAME} {@link #STRAIGHT_FONT_NAME} or {@link #THREEPOINT_FONT_NAME}. */
    private static String HIGHLIGHT_FONT_NAME = STRAIGHT_FONT_NAME;
    private static final String HIGHLIGHT_FONT = CLASSPATH + HIGHLIGHT_FONT_NAME;


    public static final String RESET = "\033[0m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String YELLOW="\033[0;33m";

    private static final String LOUD_COLOR = RED_BOLD;
    private static final String SAY_COLOR = YELLOW;

}