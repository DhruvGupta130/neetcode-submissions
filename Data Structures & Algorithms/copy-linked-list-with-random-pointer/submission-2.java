/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Node temp = head;
        while (head != null) {
            Node copy = new Node(head.val);
            copy.next = head.next;
            head.next = copy;
            head = copy.next;
        }

        head = temp;
        while (head != null && head.next != null) {
            Node next = head.next;
            next.random = (head.random != null) ? head.random.next : null;
            head = next.next;
        }

        head = temp;
        Node clone = temp.next;
        while (head != null && head.next != null) {
            Node copy = head.next;
            head.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            head = head.next;
        }

        return clone;
    }
}
