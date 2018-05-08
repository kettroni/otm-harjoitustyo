# Manual
First of all download the files and **follow instructions** from [here](https://github.com/kettroni/otm-harjoitustyo/releases/tag/loppupalautus)  
## Configuration
The program doesn't work without the _config.properties_ file in the same file as the executable .jar file, because it defines where to save the data. 
The file looks like this:
```
scoreFile=LocalData.txt
```

If you don't have a _LocalData.txt_ file in the same file as the other two files, the program throws an java.io.FileNotFoundException but doesn't crash and will make a _LocalData.txt_ file where it should be when adding data to it.

## Starting the program
Simply use the command
```
java -jar Seven-1.2.jar
```

## MenuView
This is the first view that will pop up.

<img src="https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Pictures/MenuView.png">

## HelpView
Can be accessed from menu view.
Explains the rules and how the game works.

<img src="https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Pictures/HelpView.png">

## HighscoreView
Appears after you submit your result in the lose view or can be accessed from the menu.
Shows the top three users and points retrieved from _LocalData.txt_

<img src="https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Pictures/HighscoreView.png">

## GameView
When choosing 'Start the game' from menu view.

<img src="https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Pictures/GameView.png">

## LoseView
Appears after failing in the game.

<img src="https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Pictures/LoseView.png">

## Quit
You can close the program by simply closing the window or you can press the 'Quit' button from menu/lose view
