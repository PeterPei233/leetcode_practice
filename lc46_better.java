class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =new LinkedList<>();
        if(nums.length == 0) return res;
        res.add(new LinkedList<Integer>());
        // insert nums[i] based on all the lists with nums[0]-nums[i-1]
        // in different place
        for(int i = 0;i<nums.length;i++){
            while(res.get(0).size()==i){
                List<Integer> cur = res.remove(0);
                for(int j = 0;j<cur.size()+1;j++){
                    List<Integer> pcur= new LinkedList<>(cur);
                    pcur.add(j,nums[i]);
                    res.add(pcur);
                }
            }
        }
        return res;       
    }
}