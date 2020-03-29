package linklist;

public class LLNode {
    public int data;
    public LLNode next;
    public LLNode prev;

    public LLNode(int d) {
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