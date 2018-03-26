class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        if(nums.length==3&&nums[0]+nums[1]+nums[2]==0){
             result.add(new ArrayList<Integer>(Arrays.asList(nums[0],nums[1],nums[2])));
            return result;
        }
        for(int i =0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i==0||nums[i]!=nums[i-1]){
                int j = i+1,
                k = nums.length-1,
                sum = 0 - nums[i];
                while(j<k){
                    if(nums[j]+nums[k]==sum){
                        result.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                        while(j<k&&nums[j]==nums[j+1]) j++;
                        while(j<k&&nums[k]==nums[k-1]) k--;
                        j++;
                        k--;
                    }
                    else if(nums[j]+nums[k]<sum){
                       while(j<k&&nums[j]==nums[j+1]) j++;
                        j++;
                    }
                    else{
                        while(j<k&&nums[k]==nums[k-1]) k--;
                        k--;
                    }
                }
            }
        }
        return result;
    }   
}