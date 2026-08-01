class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int cs =0;
        for (int i = 0 ; i <nums.length; i++){
            cs += nums[i];
            maxsum= Math.max(cs,maxsum);
            if( cs<0){
                cs=0;
            }
        }
        return maxsum;
        
        
    }
}