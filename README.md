[![Build Status](https://travis-ci.org/sikorka/tiny-log.svg?branch=master)](https://travis-ci.org/sikorka/tiny-log)

Never miss a log message again.

     |_ .  _       |  _   _    
     |_ | | ) \/   | (_) (_)   
              /          _/   

Tiny Log solves the problem of unreadable messages in command line window - it highlights 
messages using <font color="red">colors</font>, **styles**, SIZES & *fonts*, split lines. 


Inspiration
-----------

How many times have you scrolled through logs yet have not seen your important message? 
Tiny Log is a lightweight dependency using only one other lightweight dependency. 
Tiny API prints easy to spot messages to standard out. 


How to use
----------

Add a dependency into your `pom.xml`:

    <dependency>
        <groupId>com.github.sikorka</groupId>
        <artifactId>tiny-log</artifactId>
        <version>1.0</version>
    </dependency>

In the class that's about to log msgs add on top (import statically): 

    import static com.github.sikorka.TinyLog.*;

You can now add in your class:

    String something = "Hello there!";
    
    say(something);
    sayLouder(something);
    highlight(something);
    shout(something);

To add several lines in between log msgs use: 

    spaceOut()


Where to use
------------

In various PS1 terminals. 

Terminal size for `highlight` and `shout` ASCII art texts' needs to 
be of minimal width 85. Otherwise printed ASCII art is unreadable. 

Works with: 

- Mac OSX Terminal 
- IntelliJ on Mac
- IntelliJ on Windows 
- GIT Bash on Mac 
- GIT Bash on Windows 
- Travis CI's Job log
- Jenkins with [ANSI Color plugin](https://wiki.jenkins.io/display/JENKINS/AnsiColor+Plugin) (turn ANSI Coloring on your job) 

Does not work with: 

- Windows `cmd` 
- Windows PowerShell 


How it works
------------

1. Simply by adding ANSI Color codes before text and resetting them after text: 

    Test it out in your terminal to see if it'll work: 

        echo -e "test colors: \033[1;33;44mblue background and yellow bold text\033[m"
        
    If it works, you'll see colors.

2. By using ASCII art for highlighting VERY IMPORTANT messages, like so: 

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


TODO
====

- refactor code to add proper Unit tests
- use `Case` class
- add fg / bg color combinations
- add javadoc for basic usage
- create predefined, lazy outfits
- perhaps rename to color-log (?)