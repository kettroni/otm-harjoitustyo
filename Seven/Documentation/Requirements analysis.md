# 'Seven' - The Game, Requirements analysis

## Description
'Seven' is a number based game which usually includes multiple players in a ring. The goal of the game is to count integers ascending starting with 1 until the game ends. Counting is done by one number at a time and once a player has said out loud the next number, turn progresses to the next person and so on.  
The catch of the game is that certain numbers are 'prohibited' and if they are said aloud, the game will end and the player who messed up loses.  
Instead players should isntead say "Skip" and the game continues to the opposite direction which it was going.  
Now we come to the variation of the game 'Seven', which is my project. Basically the game is arcade-style and it keeps track of user inputs and assures that the user types out the answers, and will give points according to how far the player will get.

## Users
* There will be only one types of users, giving a username after losing to submit a high score.  
* No logging in.

## Functionality
* User will be able to play the game solo mode only.  
* Player has to type in all the answers one at a time, until fail to provide the right answer.  
* Uses long-term data storage locally inside a text file.  
* Includes a view for the top three scores retrived from the text file.  
* Includes a view for explaining the rules of the game and how to play it.
* Includes a view after the player loses and explains why that happened, this view also includes the possibility of saving results.

## For Future
* Multiplayer mode, mode against n number of bots.
* Login feature for global scores.
* Time mode: player has a time limit to get as far as possible in the restricted time.
