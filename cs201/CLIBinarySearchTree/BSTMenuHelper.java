public class BSTMenuHelper {
    Node root;

    /*
     * Methods I need to make
     * //method to print BST inorder
     * //method to print BST preorder
     * //method to print BST postorder
     */
    public static Node createDefaultBST() {
        Node root = null;
        for( int i = 1; i <=7; i++) {
            root = addNode(root, i);
        }
        System.out.println("A Binary Search Tree with values 1 through 7 has been created.");
        return root;
    }

    public static Node addNode(Node current, int value) {
        if (current == null) {
            current = new Node(value);
            return current;
        }
        if (value < current.value) {
            current.left = addNode(current.left, value);
        } else if (value > current.value) {
            current.right = addNode(current.right, value);
        } else {
            System.out.println("Sorry, duplicate values are not allowed.");
        }
        return current;
    }

    public static Node deleteNode(Node current, int value) {
        // tree is empty
        if (current == null) {
            System.out.println("Tree is empty. There are no nodes to delete.");
            return null;
        }
        // Traversal
        if (value < current.value) {
            current.left = deleteNode(current.left, value);
        } else if (value > current.value) {
            current.right = deleteNode(current.right, value);
        } else {
            // no children
            if (current.left == null && current.right == null) {
                return null;
            }
            // left child only
            if (current.right == null) {
                return current.left;
            }
            // right child only
            if (current.left == null) {
                return current.right;
            }
            // left and right child
            // Need to find the min of the right child and then replace the deleted node
            // with it.
            current.value = findMin(current.right);
            current.right = deleteNode(current.right, current.value);
        }
        return current;
    }

    // method to find min of right child
    private static int findMin(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }
    //Left, Root, Right
    public static void printInOrder() {
        
    }
    //Root, Left, Right
    public static void printPreOrder() {

    }
    // Left, Root, Right
    public static void printPostOrder() {

    }
}