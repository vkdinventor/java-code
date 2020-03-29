package linklist;

;
// Java program to detect and remove loop in linked list

class LinkListLoopTest {

    static Node head;

    static class Node {

        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }

        @Override
        public String toString() {
            return "tree.Node{" +
                    "data=" + data +
                    '}';
        }
    }

    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop
    static void removeLoop(Node loop, Node curr) {
        Node ptr1 = null, ptr2 = null;

		/* Set a pointer to the beging of the Linked List and
		move it one by one to find the first node which is
		part of the Linked List */
        ptr1 = curr;
        while (1 == 1) {

			/* Now start a pointer from loop_node and check if it ever
			reaches ptr2 */
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }

			/* If ptr2 reahced ptr1 then there is a loop. So break the
			loop */
            if (ptr2.next == ptr1) {
                break;
            }

            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next;
        }

		/* After the end of loop ptr2 is the last node of the loop. So
		make next of ptr2 as NULL */
        ptr2.next = null;
    }

    // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void removeTheLoop(Node head)
    {
        //Your code here
        if(head == null){
            return;
        }
        Node slow = head;
        Node fast = slow;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                System.out.println("Loop found at: "+slow.data);
                removeLoop2(head, slow);
                return;
            }
        }
    }

    public static void removeLoop2(Node head, Node loopNode){
        Node runner = head;
        while(runner != null){
            Node loopRunner = loopNode;
            while(loopRunner != null && loopRunner.next != loopNode){
                if (loopRunner.next == runner){
                    loopRunner.next = null;
                    runner = null;
                    return;
                }
                loopRunner = loopRunner.next;
            }
            runner = runner.next;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        long t = System.nanoTime();
        LinkListLoopTest list = new LinkListLoopTest();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);

        // Creating a loop for testing
        head.next.next.next.next.next.next.next.next = head.next.next;
        //list.detectAndRemoveLoop(head);
        LinkListLoopTest.optimizedLoopRemoval(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
        System.out.println("Total time in mili : "+(System.nanoTime()-t));
    }

    public static void optimizedLoopRemoval(Node head){

        Node slow = head, fast = head;
        while (slow != null && fast != null &&  fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }

        if (slow == null || fast == null || slow != fast){
            return;
        }

        slow = head;
        while (slow.next != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
}

// This code has been contributed by Mayank Jaiswal

