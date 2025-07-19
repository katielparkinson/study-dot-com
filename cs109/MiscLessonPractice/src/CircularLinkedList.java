package MiscLessonPractice.src;
public class CircularLinkedList {
    public int size = 0;
    public Node head = null;
    public Node tail = null;
    // print the list

    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();
        myList.addNodeToHead(75);
        myList.addNodeToHead(50);
        myList.addNodeToHead(25);
        myList.print();
    }

    class Node {
        int element;
        Node next;

        public Node(int element) {
            this.element = element;
        }
    }

    public void print() {
        System.out.print("The List So Far: ");
        Node temp = head;
        do {
            System.out.print(" " + temp.element);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // add a new node at the start of the linked list
    public void addNodeToHead(int element) {
        Node n = new Node(element);
        if (size == 0) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            Node temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
        size++;
    }
}
