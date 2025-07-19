package MiscLessonPractice.src;
import java.util.NoSuchElementException;

public class ImplementStack implements StackInterface {
    public static void main(String[] args) {
        int plate;
        ImplementStack dirtyDishes = new ImplementStack();
        plate = 1;
        // Loop to push (add) plates onto the stack
        for (int i = plate; i <= 150; i++) {
            dirtyDishes.push(i);
        }
        if (dirtyDishes.isEmpty()) {
            // Message to print if the stack is empty
            System.out.println("No dirty dishes!");
        } else {
            // If stack is not empty, print information about the top plate, size, and pop one
            System.out.println("The top plate is " + dirtyDishes.peek() + "!");
            System.out.println("There are " + dirtyDishes.size() + " dirty plates to wash!");
            System.out.println("Congratulations! You washed plate " + dirtyDishes.pop());

        }

    }

    private class Node {
        int plate;
        Node next;
        // constructor for the Node class
        public Node(int current) {
            plate = current;
        }
    }

    private Node top;

    public ImplementStack() {
        top = null;
    }

    public void push(int current) {
        Node c = new Node(current);
        c.next = top;
        top = c;
    }

    public int pop() {
        int returnPlate;
        returnPlate = top.plate;
        top = top.next;
        return returnPlate;
    }

    public boolean isEmpty() {
        // The stack is empty if 'top' is null
        return top == null;
    }

    public int size() {
        int counter = 0;
        for (Node node = top; node != null; node = node.next) {
            counter++;
        }
        return counter;
    }

    public int peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.plate;
    }
}
