class Solution {
    // runtime very long, only beat 20%
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            if(nums[i]>0) break;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int x = nums[i]+nums[j]+nums[k];
                if(x==0){
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while(j<nums.length-1&&nums[j]==nums[j+1]) j++;
                    while(k>0&&nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }
                else if(x<0){
                   while(j<nums.length-1&&nums[j]==nums[j+1]) j++;
                    j++;
                }
                else{
                    while(k>0&&nums[k]==nums[k-1]) k--;
                    k--;
                }
            }
        }
        return result;
    }
}