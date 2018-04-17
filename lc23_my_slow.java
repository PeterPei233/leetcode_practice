
// Definition for singly-linked list.
//  public class ListNode {
//      int val;
//      ListNode next;
//     ListNode(int x) { val = x; }
//  }

class Solution {
    // the most important part of this ques is that how do you know
    // the smallest element belongs to which List
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<pair> res =new PriorityQueue<>((o1,o2)->
       {
    	   	return o1.val>o2.val?1:
    	   		o1.val<o2.val?-1:0; 	   	
       });
        for(int i =0;i<lists.length;i++){
            if(lists[i]!=null)res.add(new pair(lists[i].val,i));
        }
       if(res.isEmpty()) return null;
       int x = res.peek().belongs;
       ListNode first = lists[x];
       res.remove();
       if(lists[x].next!=null){
            res.add(new pair(lists[x].next.val,x));
            lists[x] = lists[x].next;
       }
       ListNode cur = first;
        while(!res.isEmpty()){
            int i = res.peek().belongs;
            res.remove();
            cur.next = lists[i];
            cur = cur.next;
            if(lists[i].next==null) continue;
            res.add(new pair(lists[i].next.val,i));
            lists[i] = lists[i].next;
        }
        return first;
    }
}
class pair{
    int val;
    int belongs;
    pair(int x,int y){
        val = x;
        belongs =y;
    }
}
