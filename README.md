Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

**The rest of the documentation is left for the users of this template to complete**

[comment]: <> (What should the README contain?
1. All instructions that you'd need in order to run the program.
2. All the assumptions that I made.
3. Brief explanation of the functioning and logic of the program.)
---
How to run the program?
------- 
In the "finalreality" package, you'll find an archive called "Main.java". 
This archive will cointain several functions that will instantiate the
classes on this program. Those include, the 5 types of playable characters (Engineer, 
BlackMage, Knight, Thief and WhiteMage), an enemy and the several weapons. If you 
run this Main, you will see in the output all the parameters printed according to
its method, that way you'll see a demonstrating of the program.

In order to play the game Final Fantacy, you need to follow the turns. Those turns will 
be managed by a sheduler. To see the functioning of the scheduler, you can also 
run the class "TimerExample".

This program was made under the assumptions...

Functioning and logic of the program
-------
To develop this simplified clone of Final Fantasy's combat, the architectural pattern 
Model-View-Controller was followed. 

The model of the program contains all the necessary classes and entities which work as 
the basic structure of the project and its possible intractions. In this model, you'll
find that there's an interface GameCharacter which is implemented by all the characters 
guides their behaviour in the game. Also, all the characters (including the enemies) 
extends the abstract class AbstractCharacters. 

The View and the Controller are yet to be developed.