class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        HashMap<Integer,Integer> res = new HashMap<>();
        int half = nums.length/2;
        for(int i = 0;i<nums.length;i++){
            if(res.containsKey(nums[i])){
                int value = res.get(nums[i]);
                if(value == half) return nums[i];
                res.put(nums[i],value+1);
            }
            else res.put(nums[i],1);
        }
        return -1;
    }
}