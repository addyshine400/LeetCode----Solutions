class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length -1;
        int ans = Integer.MAX_VALUE;
        while( low<= high){
            // checking entire range is sorted
            if(nums[low]<=nums[high]){
                ans = Math.min( ans , nums[low]);
                break;
            }
            
            int mid = low + (high - low)/2;
            // if left is sorted

            if(nums[low]<= nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid + 1;
            }
             // if right is sorted

            else{
                ans= Math.min(ans, nums[mid]);
                high = mid -1;
            } 
             
        }
        return ans;
        
    }
}