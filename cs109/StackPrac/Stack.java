import java.util.NoSuchElementException;

public class Stack {
    public static void main(String[] args) {
        int plate;
        Stack lottaPlates = new Stack();
        plate = 10;
        for (int i = plate; i <= 25; i++) { //for loop to add plates
            lottaPlates.push(i); // plates actually being added(push) to stack
            System.out.println("Number of plates in stack:" + lottaPlates.size());
            System.out.println("Value on the plate:" + lottaPlates.peek());
        }
        //System.out.println(lottaPlates.size());
    }

    private class Node { //good ol node class and its variables
        int plate;
        Node next; // this is a reference pointer to the next node in the list

        // Node Constructor
        public Node(int current) { // current comes from the push method
            plate = current; 
            next = null;
            // this was not expilicity set to null before, but it was set to null by default
        }
    }

    // list functions below
    // in a list the head is the 'top'
    // but this is a stack so let's call it top
    private Node top; // here we are declaring that we have a node variable called top. This is not an instance of the Node class. It will hold a reference to a Node object. Initially It is null.

    // constructor to start an empty stack
    public Stack() {
        top = null; // top is a reference to Node
    }

    public void push(int current) { // this current is from the main method
        Node addedNode = new Node(current);
        addedNode.next = top;  //aaahhhhh this is where the linking is done
        top = addedNode; // this updates the private Node top variable specified before
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int removedPlate;
        removedPlate = top.plate;
        top = top.next;
        return removedPlate;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int counter = 0;
        for (Node node = top; node != null; node = node.next) {
            counter++;
        }
        return counter; // this runs once node != null
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.plate;
    }
}