/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode cur = first;
        int c = 0;
        while(l1!=null||l2!=null){
            int x = (l1==null)? 0:l1.val;
            int y = (l2==null)? 0:l2.val;
            cur.next = new ListNode((x+y+c)%10);
            cur = cur.next;
            c = (x+y+c)/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2= l2.next;
        }
        if(c>0) cur.next = new ListNode(1);
        return first.next;
    }   
}