# Architecture description

## Package Structure  
<img src="https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Pictures/PackageStructure.png" style="width: 200px,height: 100px;">

Seven.main includes Main class which starts the UI.

Seven.ui includes all different views in the game and sends data to GameMechanics.java which processes it.

Seven.utilities includes GameMechanics.java and executes functionality in the program.

Seven.database includes HighscoreData.java which is responsible for storing high scores and processing all saved data.


## User Interface  
The UI has five different views:
* Menu
* Game
* Lose
* Help
* Highscore

All of them are implemented as their own classes respectively, for example ui.MenuView.java, ui.GameView.java and so on.

UIController is responsible for switching between Views and this is done by UIControllers different method calls.

## Long-term data storage
Like mentioned above, the package Seven.database (HighscoreData.java in particular) is resposible of storing information in form of a file.

### File format
Since there isn't much information to store all data is stored into a single _.txt_ file.

Software uses a configuration file _config.properties_ to define the name(s) of the file(s).

The _.txt_ file is formatted as follows:

```
username1;highscore1
username2;highscore2
username3;highscore3
```

where a single User is in a single line and the two different fields are separated by ';'.

### Main functionalities

#### Sequence Diagram, session from menu to playing the game.  
<img src="https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Pictures/SequenceDiagram1.png">
