class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int[] ls = new int[nums.length];
        for(int i :nums) ls[i-1]++;
        for(int i = 0;i<nums.length;i++){
            if(ls[i]==0) res.add(i+1);
        }
        return res;
    }
}