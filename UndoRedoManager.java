/**
 * Implements an application that supports undo and redo functionality using a
 * doubly linked list.
 * Each state change is represented as a node in the list, enabling efficient
 * navigation through
 * the history of states. The doubly linked list allows for easy traversal both
 * forwards (redo)
 * and backwards (undo) through the sequence of states.
 * 
 * Example: 1 <> 2 <> 3 <> 4 <> 5 (current state being 5, where 4 is the
 * previous state and 6 could be the next state if added).
 * 
 * The application maintains two main operations:
 * 1. **Undo**: Moves backwards to the previous state in the sequence.
 * 2. **Redo**: Moves forward to the next state in the sequence.
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    // Undo operation
    public T undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("Cannot undo. Currently at earliest state.");
            return null;
        }
        currentState = currentState.prev;
        return currentState.state;
    }

    // perform an operation
    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState == null) {
            currentState = newNode;
        } else {
            currentState.next = newNode;
            newNode.prev = currentState;
            currentState = newNode;
        }
        System.out.println("Added new state: " + newState);
    }

    // Redo Operation
    public T redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("Cannot redo. Currently at latest state.");
            return null;
        }
        currentState = currentState.next;
        return currentState.state;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();
        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");
        manager.addState("State 4");

        System.out.println("Current state: " + manager.currentState.state);
        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());
        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
    }
}
