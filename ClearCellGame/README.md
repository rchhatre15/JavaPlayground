# Clear Cell Game 🎮

A Java Swing-based puzzle game where players clear cells from a grid through strategic clicking and pattern matching.

## Description
Clear Cell Game is an interactive grid-based game where cells fall from the top of the board. Players must strategically clear cells by clicking on groups of matching colors. The game combines elements of puzzle and strategy gaming, featuring:

- Dynamic grid-based gameplay
- Color-matching mechanics
- Score tracking
- Customizable board dimensions
- Adjustable game speed

## How to Run
1. Compile the game:
```bash
javac src/gui/GameGUI.java src/model/*.java
```

2. Run the game:
```bash
java -cp src gui.GameGUI
```

3. When prompted, enter:
   - Number of rows (recommended: 10)
   - Number of columns (recommended: 10)
   - Game speed in milliseconds (recommended: 3000)

## How to Play
1. Cells of different colors will fall from the top of the board
2. Click on a cell to clear it and any adjacent cells of the same color
3. Try to clear as many cells as possible to achieve a high score
4. The game ends when the board fills up

## Project Structure
'''
ClearCellGame/
├── src/
│   ├── gui/
│   │   └── GameGUI.java
│   ├── model/
│   │   ├── BoardCell.java
│   │   ├── ClearCellGame.java
│   │   └── Game.java
├── test/
│   ├── StudentTests.java
│   └── PublicTests.java
├── results/
│   ├── pub01EmptyBoardResults.txt
│   ├── pub02AnimationStepsResults.txt
│   ├── pub03HorizontalCellsResults.txt
│   └── pub04CollapseCellsResults.txt
├── expectedResults/
│   ├── pub01EmptyBoardExpectedResults.txt
│   ├── pub02AnimationStepsExpectedResults.txt
│   ├── pub03HorizontalCellsExpectedResults.txt
│   └── pub04CollapseCellsExpectedResults.txt
'''

## Controls
- **Mouse Click**: Clear selected cell and adjacent matching cells
- **Close Window**: Exit game
