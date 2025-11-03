public class BSTMenuHelper {

    public static Node createDefaultBST() {
        // Can't use addNode method to produce a balanced BST
        int[] defaultBSTValues = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = createDefaultBSTHelper(defaultBSTValues, 0, defaultBSTValues.length - 1);
        System.out.println("A Binary Search Tree with values 1 through 7 has been created.");
        return root;
    }

    // helper method called by createDefaultBST to create a balanced BST
    private static Node createDefaultBSTHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createDefaultBSTHelper(arr, start, mid - 1);
        root.right = createDefaultBSTHelper(arr, mid + 1, end);
        return root;
    }

    public static Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
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
        if (current == null) {
            System.out.println("Sorry, that value is not in the tree.");
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

    // Left, Root, Right
    public static void printInOrder(Node current) {
        if (current == null)
            return;
        printInOrder(current.left);
        System.out.print(current.value + " ");
        printInOrder(current.right);
    }

    // Root, Left, Right
    public static void printPreOrder(Node current) {
        if (current == null)
            return;
        System.out.print(current.value + " ");
        printPreOrder(current.left);
        printPreOrder(current.right);
    }

    // Left, Right, Root
    public static void printPostOrder(Node current) {
        if (current == null)
            return;
        printPostOrder(current.left);
        printPostOrder(current.right);
        System.out.print(current.value + " ");
    }

    public static boolean treeHasNode(Node root) {
        if (root != null) {
            return true;
        }
        System.out.println("The tree is empty. Operation cannot be completed.");
        return false;
    }
}