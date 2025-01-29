
# DLL-Undo-Redo

The **DLL-Undo-Redo** repository contains a Java application that demonstrates undo and redo functionality using a Doubly Linked List (DLL). Each state change is represented as a node in the list, enabling efficient navigation between states. This project implements efficient undo/redo operations via a structured approach.

## Features

- **State Management**:  
  - Each state is stored as a node in the doubly linked list.  
  - States can be navigated both forwards (redo) and backwards (undo).  
  - Each state is stored in a `Node` object with a reference to the previous and next states.

- **Undo Functionality**:  
  - Reverts the application to the previous state by moving backward in the linked list.

- **Redo Functionality**:  
  - Reapplies the next state by moving forward in the linked list.

- **Edge Case Handling**:  
  - Prevents undo operations when already at the earliest state.
  - Prevents redo operations when at the latest state.

## Table of Contents

1. [Setup Instructions](#setup-instructions)
2. [Usage Instructions](#usage-instructions)
3. [Development Guidelines](#development-guidelines)
4. [Sample Output](#sample-output)
5. [License](#license)
6. [Author](#author)

## Setup Instructions

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk-downloads.html) installed on your machine.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or VSCode).

### Steps to Run

1. Clone the repository to your local machine:
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project folder:
   ```bash
   cd DLL-undo-redo
   ```

3. Open the project in your Java IDE or text editor.

4. Compile the program:
   ```bash
   javac UndoRedoManager.java
   ```

5. Run the program:
   ```bash
   java UndoRedoManager
   ```

## Usage Instructions

1. The application initializes with an empty state or a predefined state sequence.
2. Perform state-changing actions (e.g., adding or modifying a state).
3. Use the following operations:
   - **Undo**: Revert to the previous state.
   - **Redo**: Reapply the next state.
4. The program will display the current state after each operation.

## Development Guidelines

- **Core Structure**:  
  - Use a `Node` class to represent each state in the doubly linked list.
  - Implement methods for state navigation:
    - `undo()`: Move to the previous node.
    - `redo()`: Move to the next node.
  - Maintain a pointer to the current state.

- **Validation**: Ensure undo/redo operations are only performed when valid states are available.

- **Edge Cases**:  
  - Handle scenarios where no further undo or redo operations are possible.
  - Properly initialize and terminate the doubly linked list.

## Sample Output

```text
Added new state: State 1
Added new state: State 2
Added new state: State 3
Added new state: State 4

Current state: State 4
Undo: State 3
Undo: State 2
Redo: State 3
Redo: State 4
Redo: Cannot redo. Currently at latest state.
```

## License

This project is licensed for **educational purposes only**. Redistribution, modification, or commercial use requires prior written permission.

## Author

- **Stephen Crocker**  
- GitHub: [SearchingSteve](https://github.com/SearchingSteve)
