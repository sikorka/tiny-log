[![Build Status](https://github.com/sikorka/tiny-log/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/sikorka/tiny-log/actions/workflows/maven.yml)
[![Coverage Status](https://coveralls.io/repos/github/sikorka/tiny-log/badge.svg)](https://coveralls.io/github/sikorka/tiny-log)

Never miss a log message.

          ____    _       _                             
         |  _ \  (_)   __| |    _   _    ___    _   _   
         | | | | | |  / _` |   | | | |  / _ \  | | | |  
         | |_| | | | | (_| |   | |_| | | (_) | | |_| |  
         |____/  |_|  \__,_|    \__, |  \___/   \__,_|  
                                |___/                   
                _                    _     
          ___  | |_    __ _   _ __  | |_   
         / __| | __|  / _` | | '__| | __|  
         \__ \ | |_  | (_| | | |    | |_   
         |___/  \__|  \__,_| |_|     \__|  
                                           
             _                      _                       ___   
            / \     _ __    _ __   (_)  _   _   _ __ ___   |__ \  
           / _ \   | '_ \  | '_ \  | | | | | | | '_ ` _ \    / /  
          / ___ \  | |_) | | |_) | | | | |_| | | | | | | |  |_|   
         /_/   \_\ | .__/  | .__/  |_|  \__,_| |_| |_| |_|  (_)   
                   |_|     |_|                                    


Tiny Log solves the problem of unnoticed and unreadable messages in command line window: it highlights 
messages using <font color="red">colors</font>, **styles**, SIZES, *ASCII art fonts* and added space 
between lines. 


Inspiration
===========

How many times have you scrolled through logs yet have not seen your important message? 
What if an error line would be RED? What if an important message was HUGE in size? 

Tiny Log is a lightweight dependency using only one other lightweight dependency. 
Tiny API prints easy to spot messages to standard out. 


How to use
==========

Add a dependency into your `pom.xml`:

    <dependency>
        <groupId>com.github.sikorka</groupId>
        <artifactId>tiny-log</artifactId>
        <version>2.2</version>
    </dependency>

In the class that's about to log msgs add on top (import statically): 

    import static com.github.sikorka.TinyLog.*;

You can now add in your class:
    
    say("Hello!");
    sayLoud("Loud hello!");
    highlight("Highlighted hello.");
    shout("Shouting!");

To add several lines in between log msgs use: 

    spaceOut();


Customize colors
----------------

* Safe colors are: `yellow`, `green bold`, `red`, `blue`, `purple`, `cyan`.

  White and black font / background colors will not display everywhere - terminal 
  backgrounds are either white or black. On Mac OSX the default font color is 
  green, hence the proposed boldness on green. Bright colors will not display everywhere.

* Safe styles are `underlined` and `bold`.
  Blink will not display everywhere.
  
* Safe fonts (ASCII art) are `straight` for medium size fonts, and `standard` for huge fonts.

Anywhere in your app run code similar to this one: 

    Outfit bold = new Outfit()
            .sayColor(Color.YELLOW_BOLD)
            .loudColor(Color.GREEN_BOLD)
            .highlightColor(Color.RED_BOLD)
            .highlightFont(Font.NONE)
            .shoutColor(Color.RED_BOLD)
            .shoutFont(Font.STRAIGHT)
            .setSpaceOut(SpaceOut.ONE_LINE);

Next run one of these methods: 

    TinyLog.dressUp(bold);
    bold.applyLook();

Now you own your log's look!


Where to use
============

In various PS1 terminals. Or terminals interpreting ANSI color codes. 

Terminal size for `highlight` and `shout` ASCII art texts' needs to 
be of minimal width 85. Otherwise printed ASCII art is unreadable. 

Works with: 

- Mac OSX Terminal 
- IntelliJ on Mac
- IntelliJ on Windows 
- GIT Bash on Mac 
- GIT Bash on Windows 
- Travis CI's Job log (common colors)
- Jenkins with [ANSI Color plugin](https://wiki.jenkins.io/display/JENKINS/AnsiColor+Plugin) (turn ANSI Coloring on your job) 

Does not work with: 

- Windows `cmd` 
- Windows PowerShell 


How it works
------------

1. Simply by adding ANSI Color codes before text and resetting them after text: 

    Test it out in your terminal to see if it'll work for you: 

        echo -e "test colors: \033[1;33;44mblue background and yellow bold text\033[m"
        
    If it works, you'll see colors.

2. By using ASCII art for highlighting VERY IMPORTANT messages, like so: 

```
   _____                                         _   _   _             _         
  / ____|                                       | | (_) | |           | |        
 | (___     ___   _ __  __   __   ___   _ __    | |  _  | | __   ___  | |  _   _ 
  \___ \   / _ \ | '__| \ \ / /  / _ \ | '__|   | | | | | |/ /  / _ \ | | | | | |
  ____) | |  __/ | |     \ V /  |  __/ | |      | | | | |   <  |  __/ | | | |_| |
 |_____/   \___| |_|      \_/    \___| |_|      |_| |_| |_|\_\  \___| |_|  \__, |
                                                                            __/ |
                                                                           |___/ 
                                _                       _              _   _ 
                               | |                     | |            | | | |
   ___   __   __   ___   _ __  | |   ___     __ _    __| |   ___    __| | | |
  / _ \  \ \ / /  / _ \ | '__| | |  / _ \   / _` |  / _` |  / _ \  / _` | | |
 | (_) |  \ V /  |  __/ | |    | | | (_) | | (_| | | (_| | |  __/ | (_| | |_|
  \___/    \_/    \___| |_|    |_|  \___/   \__,_|  \__,_|  \___|  \__,_| (_)
```


TODO
====

- enable multiline printing: `say("response:", response, headers)` would print in separate lines with one call
- refactor code to add more & proper Unit tests
- add FG / BG color combinations
- add javadoc for basic usage
- create predefined, lazy outfits
- perhaps rename to color-log (?)


With love,
```
 |_ .  _       |  _   _    
 |_ | | ) \/   | (_) (_)   
          /          _/   
```