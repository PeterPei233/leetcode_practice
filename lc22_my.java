class Solution {
    // creat a similar int queue to document the situation of 
    // the parenthese queue, the value of the int queue is the 
    // number of the "(" for the related string
    public List<String> generateParenthesis(int n) {
        LinkedList<String> res= new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();
        res.add("(");
        num.add(1);
        for(int i = 1;i<n*2;i++){
            while(res.peek().length()==i){
                String cur = res.pop();
                int left = num.pop();
                if(left<n){
                    res.add(cur+"(");
                    num.add(left+1);
                }
                if(left>i/2){
                    res.add(cur+")");
                    num.add(left);
                }
            }
        }
        return res;
    }
}