

public class BinaryTreeTest {

    public static void main(String[] args) {
        int[] in = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
        int[] pre = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
        int len = in.length;

        Node root = BinaryTree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        BinaryTree.inOrder(root);
        System.out.println();
        System.out.println("Pre order traversal of constructed tree is : ");
        BinaryTree.preOrder(root);

        System.out.print("\n============Case second===================\n");

        //'D', 'B', 'E', 'A', 'F', 'C'
         in = new int[] { 4, 2, 5, 1, 6, 3};
         pre = new int[] { 1, 2, 3, 4, 5, 6};
         len = in.length;
         BinaryTree.index = 0;

         root = BinaryTree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        BinaryTree.inOrder(root);
        System.out.println();
        System.out.println("Pre order traversal of constructed tree is : ");
        BinaryTree.preOrder(root);



    }
}

class BinaryTree {

    public static int index = 0;

    public static Node buildTree(int[] inOrder, int[] preOrder, int start, int end){

        if(start > end){
            return null;
        }

        if(index > preOrder.length-1){
            return null;
        }

        int data = preOrder[index++];
        Node root = new Node(data);
        if (start == end){
            return root;
        }

        int index = search(inOrder,start,end, data);
        root.left = buildTree(inOrder,preOrder,start,index-1);
        root.right = buildTree(inOrder,preOrder,index+1,end);
        return root;
    }

    public static  int search(int[] arr, int start, int end, int val){
        for (int i = start; i <= end; i++) {
            if (arr[i] == val ){
                return i;
            }
        }
        return -1;
    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if( root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if( root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
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