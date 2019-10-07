import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTest {

    public static void main(String[] args) {
        int[] in = new int[]{9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7};
        int[] pre = new int[]{1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13};
        int len = in.length;

        Node root = BinaryTree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Height of tree is :" + BinaryTree.getHeight2(root));
        System.out.print("In order    : ");
        BinaryTree.inOrder(root);
        System.out.println();
        System.out.print("Pre order   : ");
        BinaryTree.preOrder(root);
        System.out.println();
        System.out.print("Level order : ");
        for (int i = 1; i <= BinaryTree.getHeight(root); i++) {
            BinaryTree.levelOrder(root, i);
        }
        System.out.println();
        System.out.print("Level order2: ");
        BinaryTree.levelOrder2(root);
        System.out.print("\n============Case second===================\n");

        //'D', 'B', 'E', 'A', 'F', 'C'
        in = new int[]{4, 2, 5, 1, 6, 3};
        pre = new int[]{1, 2, 3, 4, 5, 6};
        len = in.length;
        BinaryTree.index = 0;

        root = BinaryTree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Height of tree is :" + BinaryTree.getHeight2(root));
        System.out.print("In  order   : ");
        BinaryTree.inOrder(root);
        System.out.println();
        System.out.print("Pre order   : ");
        BinaryTree.preOrder(root);
        System.out.println();
        System.out.print("Level order : ");
        for (int i = 1; i <= BinaryTree.getHeight(root); i++) {
            BinaryTree.levelOrder(root, i);
        }
        System.out.println();
        System.out.print("Level order2: ");
        BinaryTree.levelOrder2(root);
        System.out.print("\nVertical sum: ");
        BinaryTree.printVerticalSum(root);
    }
}

class BinaryTree {

    public static int index = 0;

    public static Node buildTree(int[] inOrder, int[] preOrder, int start, int end) {

        if (start > end) {
            return null;
        }

        if (index > preOrder.length - 1) {
            return null;
        }

        int data = preOrder[index++];
        Node root = new Node(data);
        if (start == end) {
            return root;
        }

        int index = search(inOrder, start, end, data);
        root.left = buildTree(inOrder, preOrder, start, index - 1);
        root.right = buildTree(inOrder, preOrder, index + 1, end);
        return root;
    }

    public static int search(int[] arr, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void printVerticalSum(Node root) {
        LLNode llNode = new LLNode(0);
        printVerticalSum(root, llNode);

        while (llNode.prev != null) {
            llNode = llNode.prev;
        }
        while (llNode != null) {
            System.out.print(llNode.data + " ");
            llNode = llNode.next;
        }
    }

    public static void printVerticalSum(Node root, LLNode llNode) {
        if (root == null || llNode == null) {
            return;
        }
        llNode.data = root.data + llNode.data;
        if (root.left != null) {
            if (llNode.prev == null) {
                llNode.prev = new LLNode(0);
                llNode.prev.next = llNode;
            }
            printVerticalSum(root.left, llNode.prev);
        }
        if (root.right != null) {
            if (llNode.next == null) {
                llNode.next = new LLNode(0);
                llNode.next.prev = llNode;
            }
            printVerticalSum(root.right, llNode.next);
        }
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //O(n) complexity
    public static void levelOrder2(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    // worst case O(n^2)
    public static void levelOrder(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        }
        levelOrder(root.left, level - 1);
        levelOrder(root.right, level - 1);
    }

    // recursion
    public static int getHeight(Node head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(head.left), getHeight(head.right));
        }
    }

    // iterative method
    static int getHeight2(Node node) {
        // Base Case
        if (node == null)
            return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int height = 0;

        while (!q.isEmpty()) {
            // nodeCount (queue size) indicates number of nodes at current lelvel.
            height++;
            int nodeCount = q.size();
            // Dequeue all nodes of current level and Enqueue all nodes of next level
            while (nodeCount > 0) {
                Node newNode = q.poll();
                System.out.print(newNode.data + " ");
                if (newNode.left != null)
                    q.add(newNode.left);
                if (newNode.right != null)
                    q.add(newNode.right);
                nodeCount--;
            }
            System.out.println();
        }
        return height;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this(data, null, null);
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}