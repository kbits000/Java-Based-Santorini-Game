# Java-Based Santorini Game
## Description<br>
This project is a Java console game called Santorini. It was developed as part of the project requirement of the ICS102 (Introduction to Computing I) course at King Fahd University of Petroleum and Minerals (KFUPM). The project's primary goal is to implement programming concepts learned in the course, implement Object-Oriented Programming (OOP) concepts, and learn how to work in a team.
This version of the game is a grading-based version.

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* Install Java Runtime Environment (JRE)

* Install Eclipse IDE for Java Developers at [Eclipse's website](https://www.eclipse.org/downloads/packages/release/2024-09/r/eclipse-ide-java-developers)

### How to Run

1. Import SantoriniGame.java, Worker.java, trapped_file.txt and winning_file.txt files to Eclipse IDE.
2. Replace "game.txt" at 
   ```
   line 364: Scanner file = new Scanner(new FileInputStream("game.txt"));
   ```
   to either "trapped_file.txt" for a gameplay where a player gets trapped or to "winning_file.txt" for a gameplay where there is a winner with no trap.
3. Run SantoriniGame.java. Output of the gameplay will be printed to the console.

## Credits

It has been done by three students (including me).

## License

This project is licensed under GNU General Public License v3.0 license.
