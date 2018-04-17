class Solution {
    // the most important part of this ques is that how do you know
    // the smallest element belongs to which List
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> res =new PriorityQueue<>(new Comparator<ListNode>(){
           // @Override
            public int compare(ListNode o1,ListNode o2){
                return o1.val-o2.val;
            }
        });
      
        for(ListNode list:lists){
            if(list!=null)res.add(list);
        }
        ListNode first = new ListNode(0);
        ListNode cur = first;
        while(!res.isEmpty()){
            cur.next = res.poll();
            cur = cur.next;
            if(cur.next!=null) res.add(cur.next);
        }
        return first.next;
    }
}