class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int max =1;
        HashSet<Character> x = new HashSet<>();
        for(int i = 0;i<=s.length()-max;i++){
            x.add(s.charAt(i));
            for(int j = i+1;j<s.length();j++){
                if(x.contains(s.charAt(j))){
                    max = (max>=x.size())? max:x.size();
                    x.clear();
                    break;
                }
                else x.add(s.charAt(j));
            }
        }
        return (max>=x.size())?max:x.size();
    }
}