package com.github.sikorka

import spock.lang.Specification
import spock.lang.Unroll

import static com.github.sikorka.TinyLog.writePlain
import static com.github.sikorka.TinyLog.say

/**
 * Tests {@Wrapper}.
 */
class WrapperSpec extends Specification {

    String[] lines;
    String textToWrap;
    int maxInLine;

    @Unroll
    def "should split text to #maxLineLength chars by whole words"() {

        when:
        textToWrap = text
        maxInLine = maxLineLength
        lines = Wrapper.breakText(text, maxLineLength)

        then:
        lines - expected == [] as String[]

        where:
        text                    | maxLineLength | expected
        "aa bb cc"              | 1             | ["aa", "bb", "cc"]
        "a b c"                 | 1             | ["a", "b", "c"]
        ", b op."               | 1             | [",", "b", "op."]
        ", b  op."              | 2             | [",", "b", "op."]
        ", b  op."              | 3             | [", b", "op."]
        ", bb  op."             | 3             | [", bb", "op."]
        "Did you start Appium?" | 10            | ["Did you start", "Appium?"]
        "Did you start Appium?" | 6             | ["Did you", "start", "Appium?"]
        "Did you start Appium?" | 7             | ["Did you", "start Appium?"]
        "Did you start Appium?" | 8             | ["Did you", "start Appium?"]
    }

    @Unroll
    def "for #maxLengthInLine should break text into #linesAmount lines"() {

        given:
        textToWrap = "I am highlighting a problem here, so you notice. "
        maxInLine = maxLengthInLine

        when:
        lines = Wrapper.breakText(textToWrap, maxLengthInLine);

        then:
        lines.size() == linesAmount;

        where:
        maxLengthInLine | linesAmount
        100             | 1
        14              | 3
        13              | 3
        12              | 3
        11              | 3
        10              | 4
        9               | 4
        8               | 4
        7               | 4
        6               | 5
        5               | 6
        4               | 6
        3               | 7
        2               | 9
        1               | 9
    }

    @Unroll
    def "when text is '#text' and maxLengthInLine is #maxLengthInLine, then breaking does not work - null returned"() {

        when:
        textToWrap = text
        maxInLine = maxLengthInLine

        lines = Wrapper.breakText(text, maxLengthInLine);

        then:
        lines == null

        where:
        text       | maxLengthInLine
        null       | 100
        null       | 0
        null       | -1
        null       | -100
        "a bb c"   | 0
        "aaa bb c" | -1
        "a b c"    | -100
    }

    def "should return size 0 for empty and blank strings"() {

        when:
        textToWrap = text
        maxInLine = maxLineLength

        lines = Wrapper.breakText(text, maxLineLength);

        then:
        lines.size() == 0

        where:
        text             | maxLineLength
        ""               | 100
        " "              | 100
        "\t\n   "        | 100
        "   \t\t  \n   " | 100
        ""               | 2
        " "              | 2
        "\t\n   "        | 2
        "   \t\t  \n   " | 2
        ""               | 1
        " "              | 1
        "\t\n   "        | 1
        "   \t\t  \n   " | 1
    }

    def cleanup() {
        writePlain("Text to wrap (" + maxInLine + "): \"" + textToWrap + "\"");
        say("Lines after wrap: " + lines);
    }

}
