class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                if(str.length() <= i){
                    if(res[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            res[i] = true;
                            break;
                        }
                    }
                }
            }
           
        }
         return res[s.length()];
    }
}