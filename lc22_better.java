class Solution {
    // char array left and right to show the situation
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] item = new char[2*n];
        generate(item,0,n,n,res);
        return res;
    }
    static void generate(char[] item,int index,int left,int right,List res){
        if(index==item.length) res.add(new String(item));
        if(left>0){
            item[index] = '(';
            generate(item,index+1,left-1,right,res);
        }
        if(right>left){
            item[index] = ')';
            generate(item,index+1,left,right-1,res);
        }
    }
}