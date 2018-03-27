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
        ListNode first = new ListNode((l1.val+l2.val)%10);
        int c = (l1.val+l2.val)>=10? 1:0;
        ListNode pre = first;
        while(l1.next!=null &&l2.next!=null){
            l1=l1.next; l2 = l2.next;
            ListNode x = new ListNode((l1.val+l2.val+c)%10);
            c = (l1.val+l2.val+c)>=10? 1:0;            
            pre.next = x;
            pre = x;
        }
        if(l1.next == null&&l2.next==null){
            if(c>0)  {
                ListNode x = new ListNode(1);
                pre.next = x;
            }
            return first;                     
        }
        else if(l1.next ==null){
            while(l2.next!=null){
                l2 = l2.next;
                ListNode x = new ListNode((l2.val+c)%10);
                c = (l2.val+c)>=10? 1:0;
                pre.next = x;
                pre = x;
            }
            if(c>0){
                ListNode x = new ListNode(1);
                pre.next = x;
            }
        }
        else{
            while(l1.next!=null){
                l1 = l1.next;
                ListNode x = new ListNode((l1.val+c)%10);
                c = (l1.val+c)>=10? 1:0;
                pre.next = x;
                pre = x;
            }
            if(c>0){
                ListNode x = new ListNode(1);
                pre.next = x;
            }
        }
        return first;
    }
}