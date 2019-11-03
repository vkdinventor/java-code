import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTreeTest {

    public static void main(String[] args) {
        int[] in = new int[]{9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7};
        int[] pre = new int[]{1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13};
        int len = in.length;

        Node root = BinaryTree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Height of tree is :" + BinaryTree.getHeight2(root));
        System.out.println("Spiral of tree is :");
        BinaryTree.spiralOrder(root);
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
        System.out.print("\nIn  order2  : ");
        BinaryTree.inOrder2(root);
        System.out.println();
        System.out.print("Pre order   : ");
        BinaryTree.preOrder(root);
        System.out.print("\nPre order2  : ");
        BinaryTree.preOrder2(root);
        System.out.print("\nPost order : ");
        BinaryTree.postOrder(root);
        System.out.print("\nPost order2: ");
        BinaryTree.postOrder2(root);
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
        System.out.print("\nVertical traversal: ");
        BinaryTree.printVertical(root);
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

    // iterative method for inorder
    public static void inOrder2(Node root) {

        Node current = root;
        Stack<Node> stack = new Stack<>();
        while ( current != null || stack.size() > 0){

            while (current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrder2(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data+" ");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void postOrder2(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            Node node = s1.pop();
            s2.push(node);
            if(node.left != null){
                s1.push(node.left);
            }
            if( node.right != null){
                s1.push(node.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
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

    public static void spiralOrder(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Integer> resultQueue = new ArrayDeque<>();
        Stack<Integer> resultStack = new Stack<>();

        queue.add(root);
        boolean isLtoR = false;
        while (!queue.isEmpty()){

            int count = queue.size();
            while (count > 0){
                Node node = queue.poll();
                if(isLtoR){
                    resultQueue.add(node.data);
                }else {
                    resultStack.add(node.data);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                count--;
            }
             isLtoR = !isLtoR;
            while (!resultQueue.isEmpty()){
                System.out.print(resultQueue.poll()+" ");
            }
            while (!resultStack.isEmpty()){
                System.out.print(resultStack.pop()+" ");
            }
        }
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

    static void leftView(Node node) {
        // Base Case
        if (node == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            // nodeCount (queue size) indicates number of nodes at current lelvel.
            int nodeCount = q.size();
            // Dequeue all nodes of current level and Enqueue all nodes of next level
            boolean isFirst = true;
            while (nodeCount > 0) {
                Node newNode = q.poll();
                if (isFirst) {
                    System.out.print(newNode.data+" ");
                    isFirst = false;
                }
                if (newNode.left != null)
                    q.add(newNode.left);
                if (newNode.right != null)
                    q.add(newNode.right);
                nodeCount--;
            }
        }
        return;
    }

    static void rightView(Node node) {
        // Base Case
        if (node == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            // nodeCount (queue size) indicates number of nodes at current lelvel.
            int nodeCount = q.size();
            // Dequeue all nodes of current level and Enqueue all nodes of next level
            while (nodeCount > 0) {
                Node newNode = q.poll();
                if (newNode.left != null)
                    q.add(newNode.left);
                if (newNode.right != null)
                    q.add(newNode.right);
                nodeCount--;
                if (nodeCount == 0) {
                    System.out.print(newNode.data+" ");
                }
            }
        }
    }

    public static void printVertical(Node node){
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalTraversal(node, 0, map);

        for(Map.Entry<Integer, List<Integer>> col : map.entrySet() ){
            System.out.println(Arrays.toString(col.getValue().toArray()));
        }
    }

    public static void verticalTraversal(Node node, int hd, Map<Integer, List<Integer>> map) {

        if (node == null) {
            return;
        }
        List<Integer> list;
        list = map.get(hd);
        if (list != null) {
            list.add(node.data);
        } else {
            list = new ArrayList<>();
            list.add(node.data);
        }
        map.put(hd,list);
        verticalTraversal(node.left, hd - 1, map);
        verticalTraversal(node.right, hd + 1, map);

    }

    public Node deletionBT(Node root, int key){
        //Write your code here and return the root of the changed tree
        if(root == null){
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        Node keyNode = new Node(0);
        Node node = new Node(0);
        Node parent = new Node(0);
        queue.add(root);
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.data == key){
                keyNode = node;
            }
            if(node.left != null){
                parent = node;
                queue.add(node.left);
            }
            if(node.right != null){
                parent = node;
                queue.add(node.right);
            }
        }
        keyNode.data = node.data;
        if(parent.left == node){
            parent.left = null;
        }

        if(parent.right == node){
            parent.right = null;
        }
        node =null;
        return root;
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