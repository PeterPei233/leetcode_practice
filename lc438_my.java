class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(p.length()>s.length()) return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        //the shape of sliding window
        int i = 0,j=p.length();
        for(int k = 0;k<j;k++){
            char c = s.charAt(k);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) count--;
            }           
        }
        if(count==0) res.add(0);
        while(j<s.length()){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(map.containsKey(c1)){
                map.put(c1,map.get(c1)+1);
                if(map.get(c1)==1) count++;
            }
            if(map.containsKey(c2)){
                map.put(c2,map.get(c2)-1);
                if(map.get(c2)==0) count--;
            }
            if(count == 0) res.add(i+1);
            i++;j++;
        }
        return res;
    }
}