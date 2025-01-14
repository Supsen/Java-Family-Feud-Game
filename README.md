
# Family Feud Game

This is a Java-based Family Feud game designed for educational purposes. The game allows two players to answer a series of random questions and score points based on their answers.

## Features
- Two-player quiz game.
- Random question generation using `SecureRandom`.
- CSV-based question storage.
- Automatic score calculation and result recording in a text file.

## Project Structure
- **Main.java**: Entry point of the application. Manages the overall game flow and user interaction.
- **Game.java**: Manages the game mechanics, question selection, and scoring system.
- **FileHelper.java**: Responsible for reading questions from a CSV file and writing game results to a text file.
- **Question.java**: Represents a single question with multiple answers and point values.
- **Readfile.java**: (Legacy) Contains similar functionality to `FileHelper` but appears redundant.

## How to Run
1. Compile all Java files using:
   ```
   javac *.java
   ```
2. Run the main class:
   ```
   java Main
   ```
3. Follow the prompts to play the game.

## File Handling
- **Input File**: The game uses a CSV file named `Questions1.csv` to load questions.
- **Output File**: The results are saved to `redbird.txt`.

## Improvements Needed
- Consolidate the functionality of `Readfile.java` and `FileHelper.java`.
- Improve error handling with proper exception management.

## License
This project is licensed under the MIT License.

## Author
- Suphasit Sribuaai
