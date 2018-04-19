class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =new LinkedList<>();
        if(nums.length == 0) return res;
        res.add(new LinkedList<Integer>());
        while(res.get(0).size()!=nums.length){
            final List<Integer> cur = res.remove(0);
            // how to copy a new list instead of reference
            for(int i = 0;i<nums.length;i++){
                if(!cur.contains(nums[i])){
                    List<Integer> pcur = new LinkedList<>(cur);
                    pcur.add(nums[i]);
                    res.add(pcur);
                }
            }
        }
        return res;       
    }
}