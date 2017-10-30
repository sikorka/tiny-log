Never miss a log message.

     |_ .  _       |  _   _    
     |_ | | ) \/   | (_) (_)   
              /          _/   

Tiny Log solves the problem of unreadable messages in command line window - it highlights messages using <font color="red">colors</font>, **styles**, SIZES & *fonts*. 


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

Terminal size for `highlight` and `shout` ASCII art texts' needs to be of width 85. 

Tested with: 

- Mac OSX Terminal 
- IntelliJ on Mac
- IntelliJ on Windows 
- GIT Bash on Mac 
- GIT Bash on Windows 

Probably does not work with (to be checked): 

- Windows `cmd` 
- Windows PowerShell 



TODO
====

- implement a builder 
- refactor code to add proper Unit tests 
- make a font enum (name + max size in terminal) 
- make colors enum 

