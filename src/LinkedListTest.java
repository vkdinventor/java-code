;

import java.util.*;

class LLNode {
    int data;
    LLNode next;
    LLNode prev;

    LLNode(int d) {
        data = d;
        next = null;
        prev = null;
    }

    public void printList() {
        LLNode temp = this;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }
}

 class MyLinkedList {
    LLNode head;

    public void addToTheLast(LLNode node) {
        if (head == null) {
            head = node;
        } else {
            LLNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void printList() {
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {


        //5 2 2 4
        //LinkedList
        MyLinkedList llist = new MyLinkedList();
        llist.addToTheLast(new LLNode(5));
        llist.addToTheLast(new LLNode(4));
        llist.addToTheLast(new LLNode(3));
        llist.addToTheLast(new LLNode(2));
        llist.addToTheLast(new LLNode(1));
        //llist.printList();
        //GfG g = new GfG();
        //llist.head = g.removeDuplicates(llist.head);
        //llist.head = llist.insertionSortList(llist.head);
        llist.printList();
    }
}


/*This is a function problem.You only need to complete the function given below*/
/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class GfG {

    LLNode removeDuplicates2(LLNode head) {
        Map<Integer, LLNode> map = new HashMap<>();
        LLNode curr = head;
        while (curr !=null){
            map.put(curr.data,curr);
        }
        return head;
    }
    // Function to remove duplicates from the given linked list
    LLNode removeDuplicates(LLNode head) {
        LLNode curr = head;
        while (curr != null) {
            LLNode runner = curr;
            while (runner.next != null) {
                if (runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
