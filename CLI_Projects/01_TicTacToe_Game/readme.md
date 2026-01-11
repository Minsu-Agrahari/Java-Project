````markdown
# Tic Tac Toe Game (CLI – Java)

![Java](https://img.shields.io/badge/Java-8%2B-blue)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen)
![License](https://img.shields.io/badge/License-MIT-lightgrey)
![Platform](https://img.shields.io/badge/Platform-CLI-important)

A simple and clean **command-line Tic-Tac-Toe game** built using Java.  
This project demonstrates core programming concepts such as control flow, arrays, user input handling, and game-state management.

---

## Table of Contents
- About
- Features
- Prerequisites
- Project Structure
- How to Run
- Gameplay
- Contributing
- Future Enhancements
- License

---

## About
This project implements the classic **Tic-Tac-Toe** game in a terminal environment.  
It is designed as a beginner-friendly Java project to practice:

- Logical problem solving  
- Game flow control  
- Input validation  
- Basic software design  

---

## Features
- Two-player turn-based gameplay  
- 3×3 board display in console  
- Automatic win detection  
- Draw detection  
- Input validation for invalid moves  
- Clean and readable CLI interface  

---

## Prerequisites
Ensure the following are installed:

- **Java JDK 8 or higher**
- Command Prompt / Terminal

Verify installation:
```bash
java -version
````

---

## Project Structure

```
01_TicTacToe_Game/
│
├── src/
│   └── Main.java        # Game entry point and logic
│
├── .gitignore
└── README.md
```

---

## How to Run

### Step 1 — Navigate to project

```bash
cd CLI_Projects/01_TicTacToe_Game
```

### Step 2 — Compile

```bash
javac src/Main.java
```

### Step 3 — Run

```bash
java -cp src Main
```

---

## Gameplay

* Player 1 uses **X**
* Player 2 uses **O**
* Players select positions from **1 to 9**
* First player to align three marks wins
* If all positions are filled without a winner, the game ends in a draw

### Sample Output

```
Welcome to Tic Tac Toe!

 X | O | X
-----------
 O | X |  
-----------
 X | O |  

Player X wins!
```

---

## Contributing

Contributions are welcome and appreciated.

### How to Contribute

1. Fork this repository
2. Create a new branch

   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Make your changes
4. Commit your work

   ```bash
   git commit -m "Add: your feature description"
   ```
5. Push to your fork
6. Open a Pull Request

Please ensure:

* Code is clean and readable
* Logic is well-structured
* No breaking changes without explanation

---

## Future Enhancements

Planned improvements for this project:

* Single-player mode with AI
* Difficulty levels
* Replay option after game ends
* Score tracking
* GUI version using Java Swing / JavaFX

---

## License

This project is licensed under the **MIT License**.
You are free to use, modify, and distribute this software with proper attribution.

---

## Author

**Minsu Agrahari**
GitHub: [https://github.com/Minsu-Agrahari](https://github.com/Minsu-Agrahari)

---