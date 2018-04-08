class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.length()==0) return res;
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for(int i = 0;i<digits.length();i++){
            int x = (int)(digits.charAt(i)-'0'); 
            while(res.peek().length()==i){
                String top = res.remove();
                for(Character y: map[x].toCharArray()) res.add(top+y);
            }
        } 
        return res;
    }
}