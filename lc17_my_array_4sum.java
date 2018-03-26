class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i<nums.length-3;i++){
            if(i==0||nums[i]!=nums[i-1]){
                for(int j = i+1;j<nums.length-2;j++){
                    if(j==i+1||nums[j]!=nums[j-1]){
                        int m = j+1, n = nums.length-1, sum = target-nums[i]-nums[j];
                        while(m<n){
                            if(nums[m]+nums[n]==sum){
                                res.add(new LinkedList<Integer>(
                                    Arrays.asList(nums[i],nums[j],nums[m],nums[n])));
                                while(m<n&&nums[m]==nums[m+1]) m++;
                                while(m<n&&nums[n]==nums[n-1]) n--;
                                m++;n--;
                            }
                            else if(nums[m]+nums[n]<sum){
                                while(m<n&&nums[m]==nums[m+1]) m++;
                                m++;
                            }
                            else{
                                while(m<n&&nums[n]==nums[n-1]) n--;
                                n--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}