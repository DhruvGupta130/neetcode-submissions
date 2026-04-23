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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] l, int left, int right) {
        if (left == right) return l[left];

        int mid = left + (right - left) / 2;

        ListNode l1 = merge(l, left, mid);
        ListNode l2 = merge(l, mid + 1, right);

        return sortTwoLists(l1, l2);
    }

    private ListNode sortTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if (l1 != null) head.next = l1;
        else if (l2 != null) head.next = l2;

        return dummy.next;
    }
}
