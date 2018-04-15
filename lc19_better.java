public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // make a gap between fast pointer and slow pointer with n nodes.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // move gap to the end of the list.
        // pre: fast is not null.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}