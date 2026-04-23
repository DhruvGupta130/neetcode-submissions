/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode prev = null;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;

            if (l1 != null) {
                l1.val = sum % 10;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l1 = l2;
                l2 = null;
                continue;
            }

            if (l2 != null) l2 = l2.next;

            carry = sum / 10;
        }

        if (carry != 0) prev.next = new ListNode(carry);

        return head;
    }
}
