package com.github.sikorka;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Wraps a string at given length into multiline array.
 */
public class Wrapper {

    /**
     * Breaks <code>text</code> after <code>maxLineLength</code>.
     * In case a long word cannot be broken it leaves it as it is.
     *
     * Trimms contents and changes multiple whitespace characters to space.
     *
     * @param text the text to be broken
     * @param maxLineLength maximum length of one line
     * @return broken lines as array of strings, or <code>null</code>
     * if <code>text</code> is empty or <code>maxLength</code> too small for split
     */
    public static Object[] breakAfter(String text, int maxLineLength) {
        if (text == null || maxLineLength <= 0)
            return null;

        text = text.trim().replaceAll("\\s+", " ");

        if (text.isEmpty() || text.matches("\\s+"))
            return new String[] {  };

        if (text.length() <= maxLineLength)
            return new String[] { text };

        List<String> brokenLines = new ArrayList<String>();

        StringTokenizer tokenizer = new StringTokenizer(text, " ");
        StringBuilder line = new StringBuilder(text.length());
        boolean breakLine = false;
        String nextWord = null;

        int SPACE = 1;

        while (tokenizer.hasMoreTokens()) {
            nextWord = tokenizer.nextToken();

            if (line.length() + SPACE <= maxLineLength) {
                line.append(nextWord);
            } else {
                brokenLines.add(line.toString());
                line.delete(0, line.length());
                line.append(nextWord);
            }

            if (line.length() + SPACE >= maxLineLength) {
                brokenLines.add(line.toString());
                line.delete(0, line.length());
            } else {
                line.append(" ");
            }
        }

        return brokenLines.toArray();
    }

}
