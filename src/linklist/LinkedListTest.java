package linklist;

;

import java.util.*;

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

    public static LLNode oddEvenList(LLNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        LLNode evenHead = new LLNode(-1);
        LLNode evenRunner = evenHead;
        LLNode curr = head;

        while (curr != null && curr.next != null) {
            LLNode nextOdd = curr.next.next;
            evenRunner.next = curr.next;
            evenRunner = evenRunner.next;
            curr.next = nextOdd;
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        if (evenRunner != null) {
            evenRunner.next = null;
        }
        curr.next = evenHead.next;
        return head;
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {


        //5 2 2 4
        //LinkedList
        MyLinkedList llist = new MyLinkedList();
        llist.addToTheLast(new LLNode(1));
        llist.addToTheLast(new LLNode(2));
        llist.addToTheLast(new LLNode(3));
        llist.addToTheLast(new LLNode(4));
        llist.addToTheLast(new LLNode(5));
        llist.addToTheLast(new LLNode(6));
        //llist.printList();
        //linklist.GfG g = new linklist.GfG();
        //llist.head = g.removeDuplicates(llist.head);
        //llist.head = llist.insertionSortList(llist.head);
        LLNode head = oddEvenList(llist.head);
        llist.printList();
    }
}


/*This is a function problem.You only need to complete the function given below*/
/* The structure of linked list is the following
class tree.Node
{
    int data;
    tree.Node next;
    tree.Node(int d) {
        data = d;
        next = null;
    }
}
*/
class GfG {

    LLNode removeDuplicates2(LLNode head) {
        Map<Integer, LLNode> map = new HashMap<>();
        LLNode curr = head;
        while (curr != null) {
            map.put(curr.data, curr);
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
