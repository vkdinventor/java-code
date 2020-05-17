package tree;

import linklist.LLNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTreeTest {
    
    /*
Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

*/

    public static void main(String[] args) {

        /*
        * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
        (b) Preorder (Root, Left, Right) : 1 2 4 5 3
        (c) Postorder (Left, Right, Root) : 4 5 2 3 1
        *
        * */

        int[] in = new int[]{9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7};
        int[] pre = new int[]{1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13};
        int len = in.length;

        TreeNode root = BinaryTree.buildTree(in, pre, 0, len - 1);

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

    public static TreeNode buildTree(int[] inOrder, int[] preOrder, int start, int end) {

        if (start > end) {
            return null;
        }

        if (index > preOrder.length - 1) {
            return null;
        }

        int data = preOrder[index++];
        TreeNode root = new TreeNode(data);
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

    public static void printVerticalSum(TreeNode root) {
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

    public static void printVerticalSum(TreeNode root, LLNode llNode) {
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

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // iterative method for inorder
    public static void inOrder2(TreeNode root) {

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
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

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.data+" ");
            // because it is pop
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void postOrder2(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode treeNode = s1.pop();
            s2.push(treeNode);
            if(treeNode.left != null){
                s1.push(treeNode.left);
            }
            if( treeNode.right != null){
                s1.push(treeNode.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    //O(n) complexity
    public static void levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
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
    public static void levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        }
        levelOrder(root.left, level - 1);
        levelOrder(root.right, level - 1);
    }

    public static void spiralOrder(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> resultQueue = new ArrayDeque<>();
        Stack<Integer> resultStack = new Stack<>();

        queue.add(root);
        boolean isLtoR = false;
        while (!queue.isEmpty()){

            int count = queue.size();
            while (count > 0){
                TreeNode treeNode = queue.poll();
                if(isLtoR){
                    resultQueue.add(treeNode.data);
                }else {
                    resultStack.add(treeNode.data);
                }
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
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
    public static int getHeight(TreeNode head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(head.left), getHeight(head.right));
        }
    }

    // iterative method
    static int getHeight2(TreeNode treeNode) {
        // Base Case
        if (treeNode == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(treeNode);
        int height = 0;

        while (!q.isEmpty()) {
            // nodeCount (queue size) indicates number of nodes at current lelvel.
            height++;
            int nodeCount = q.size();
            // Dequeue all nodes of current level and Enqueue all nodes of next level
            while (nodeCount > 0) {
                TreeNode newTreeNode = q.poll();
                System.out.print(newTreeNode.data + " ");
                if (newTreeNode.left != null)
                    q.add(newTreeNode.left);
                if (newTreeNode.right != null)
                    q.add(newTreeNode.right);
                nodeCount--;
            }
            System.out.println();
        }
        return height;
    }

    static void leftView(TreeNode treeNode) {
        // Base Case
        if (treeNode == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(treeNode);

        while (!q.isEmpty()) {
            // nodeCount (queue size) indicates number of nodes at current lelvel.
            int nodeCount = q.size();
            // Dequeue all nodes of current level and Enqueue all nodes of next level
            boolean isFirst = true;
            while (nodeCount > 0) {
                TreeNode newTreeNode = q.poll();
                if (isFirst) {
                    System.out.print(newTreeNode.data+" ");
                    isFirst = false;
                }
                if (newTreeNode.left != null)
                    q.add(newTreeNode.left);
                if (newTreeNode.right != null)
                    q.add(newTreeNode.right);
                nodeCount--;
            }
        }
        return;
    }

    static void rightView(TreeNode treeNode) {
        // Base Case
        if (treeNode == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(treeNode);

        while (!q.isEmpty()) {
            // nodeCount (queue size) indicates number of nodes at current lelvel.
            int nodeCount = q.size();
            // Dequeue all nodes of current level and Enqueue all nodes of next level
            while (nodeCount > 0) {
                TreeNode newTreeNode = q.poll();
                if (newTreeNode.left != null)
                    q.add(newTreeNode.left);
                if (newTreeNode.right != null)
                    q.add(newTreeNode.right);
                nodeCount--;
                if (nodeCount == 0) {
                    System.out.print(newTreeNode.data+" ");
                }
            }
        }
    }

    public static int isBalanced(TreeNode root) {
        if (root == null) {
            return 1;
        }

        if (root.left == null && (root.right != null && (root.right.right != null || root.right.left != null))) {
            return 0;
        }

        if (root.right == null && (root.left != null && (root.left.right != null || root.left.left != null))) {
            return 0;
        }
        return Math.min(isBalanced(root.left), isBalanced(root.right));
    }



    public static void printVertical(TreeNode treeNode){
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalTraversal(treeNode, 0, map);

        for(Map.Entry<Integer, List<Integer>> col : map.entrySet() ){
            System.out.println(Arrays.toString(col.getValue().toArray()));
        }
    }

    public static void verticalTraversal(TreeNode treeNode, int hd, Map<Integer, List<Integer>> map) {

        if (treeNode == null) {
            return;
        }
        List<Integer> list;
        list = map.get(hd);
        if (list != null) {
            list.add(treeNode.data);
        } else {
            list = new ArrayList<>();
            list.add(treeNode.data);
        }
        map.put(hd,list);
        verticalTraversal(treeNode.left, hd - 1, map);
        verticalTraversal(treeNode.right, hd + 1, map);

    }

    public TreeNode flatten(TreeNode a) {

        Stack<TreeNode> stack  = new Stack<>();
        stack.push(a);
        TreeNode current = null;
        TreeNode head = null;
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(head == null){
                current = temp;
                head = current;
            }else {
                current.right = temp;
                current.left = null;
                current = current.right;
            }
            current = current.right;
            //System.out.print(temp.val+" ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
        return head;
    }

    public TreeNode deletionBT(TreeNode root, int key){
        //Write your code here and return the root of the changed tree
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode keyTreeNode = new TreeNode(0);
        TreeNode treeNode = new TreeNode(0);
        TreeNode parent = new TreeNode(0);
        queue.add(root);
        while(!queue.isEmpty()){
            treeNode = queue.poll();
            if(treeNode.data == key){
                keyTreeNode = treeNode;
            }
            if(treeNode.left != null){
                parent = treeNode;
                queue.add(treeNode.left);
            }
            if(treeNode.right != null){
                parent = treeNode;
                queue.add(treeNode.right);
            }
        }
        keyTreeNode.data = treeNode.data;
        if(parent.left == treeNode){
            parent.left = null;
        }

        if(parent.right == treeNode){
            parent.right = null;
        }
        treeNode =null;
        return root;
    }

    private TreeNode prev = null;

    public boolean isValidBST(TreeNode A) {
        prev = null;
        return isBST(A);
    }

    //Time Complexity: O(n)
    private boolean isBST(TreeNode node) {
        // traverse the tree in inorder fashion and keep a track of previous node
        if (node != null) {
            if (!isBST(node.left)) {
                return false;
            }
            // allows only distinct values node
            if (prev != null && node.data <= prev.data) {
                return false;
            }
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
}

