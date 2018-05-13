class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(p.length()>s.length()) return res;
        int[] map = new int[128];
        int count = 0;
        for(char c: p.toCharArray()){
            int i = (int)c;
            if(map[i]==0) count++;
            map[i]++;
        }
        //the shape of sliding window
        int i = 0,j=p.length();
        for(int k = 0;k<j;k++){
            int c = (int)s.charAt(k);
            map[c]--;
            if(map[c]==0) count--;
        }
        if(count==0) res.add(0);
        while(j<s.length()){
            int c1 = (int)s.charAt(i);
            int c2 = (int)s.charAt(j);
            map[c1]++;
            if(map[c1]==1) count++;
            map[c2]--;
            if(map[c2]==0) count--;
            if(count==0) res.add(i+1);
            i++;j++;
        }
        return res;
    }
}