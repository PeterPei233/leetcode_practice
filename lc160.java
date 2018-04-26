/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode curAend = null;
        ListNode curBend = null;
        while(curA!=curB){
            if(curA.next==null) {
                if(curBend!=null&&curA!=curBend) return null;
                curAend = curA;
                curA = headB;
            }
            else{
                curA = curA.next;
            }
             if(curB.next==null) {
                if(curAend!=null&&curB!=curAend) return null;
                curBend = curB;
                curB = headA;
                 
            }
            else{
                curB = curB.next;
            }
        }
        return curA;
    }
}