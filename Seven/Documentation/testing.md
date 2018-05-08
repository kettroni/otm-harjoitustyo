# Testing document

Program is tested with JUnit tests, UI is left out from testing all together. System level testing is done manually.

## Unit and Integration tests
### Data storage  
Tests made for data storage covers all methods in HighscoreData.java, using JUnits TemporaryFolder rules.

### Program logic
GameMechanics.java is tested with GameMechanicsTest.java which tests all different kinds of inputs 
and scenarios what can happen in-game.

User class is tested by testing each of its methods and constructor to insure it works properly.

### Test coverage
Test coverage excluded UI is 98% for row coverage and 86% for branch coverage. 
Branch coverage is "low" mostly because two Error handles in database tests (The errors come in when not able to find a file to read).

<img src="https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Pictures/TestCoverage.png">

## System testing
These tests are executed manually.

### Installation and configuration

Program is tested with following the instructions in [manual](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/manual.md)
 inside Windows environment.

Program is tested with and without the _LocalData.txt_ file and works properly either way.

### Functionalities
All the functionalities in [requirements analysis](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Requirements%20analysis.md)
 are tested and everything worked in the way designed. Multiple different scenarios are tested for example testing the "cause" of loss.
