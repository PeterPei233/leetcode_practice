class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res,new ArrayList(),candidates,target,0);
        return res;        
    }
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int begin){
        if(target<0) return;
        if(target == 0) res.add(new ArrayList(temp));
        else{
            for(int i = begin; i< nums.length;i++){
                temp.add(nums[i]);
                backtrack(res,temp,nums,target-nums[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
}