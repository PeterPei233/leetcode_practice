class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int l = nums.length;
        // exception:too large or too small
        if(l<4||nums[0]*4>target||nums[l-1]*4<target) return res;
        // no duplication
        for(int i = 0; i<l-3;i++){
            // target too small
            if(nums[i]*4>target) break;
            // target too large
            if(nums[i]+nums[l-1]*3<target) continue;
            // find the only solution in this case
            if(nums[i]*4==target&&i+3<l&&nums[i+3]==nums[i]){
                res.add(new LinkedList<Integer>(
                        Arrays.asList(nums[i],nums[i],nums[i],nums[i])));
                break;
            }
            //based on the 3sum problem
            if(i==0||nums[i]!=nums[i-1]){
                // no duplication
                for(int j = i+1;j<l-2;j++){
                    //target too small
                    if(nums[j]*3+nums[i]>target) break;
                    //target too large
                    if(nums[i]+nums[j]+nums[l-1]*2<target) continue;
                    // find the only solution in this case
                    if(nums[j]*3+nums[i]==target&&j+2<l&&nums[j+2]==nums[j]){
                       res.add(new LinkedList<Integer>(
                           Arrays.asList(nums[i],nums[j],nums[j],nums[j])));
                        break;
                    }
                    if(j==i+1||nums[j]!=nums[j-1]){
                        int m = j+1, n = l-1, sum = target-nums[i]-nums[j];
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