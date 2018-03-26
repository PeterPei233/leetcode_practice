class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // when the length of the array is 3, return the sum
        if(nums.length ==3) return nums[0]+nums[1]+nums[2];
        int min = Integer.MAX_VALUE, res = 0;
        for(int i =0;i<nums.length-2;i++){
            int j = i+1, k=nums.length-1, sum = target - nums[i];
            // when finding the closest, return the target
            while(j<k){
                if(nums[j]+nums[k]==sum) return target;
                else if(nums[j]+nums[k]<sum){
                    if(sum-nums[j]-nums[k]<min){
                        min = sum-nums[j]-nums[k];
                        res = target -min;
                    }
                    while(j<k&&nums[j]==nums[j+1]) j++;
                    j++;
                }
                else{
                    if(nums[j]+nums[k]-sum<min){
                        min = nums[j]+nums[k]-sum;
                        res = target +min;
                    }
                    while(j<k&&nums[k]==nums[k-1]) k--;
                    k--;
                }
            }
        }
        return res;
    }
}