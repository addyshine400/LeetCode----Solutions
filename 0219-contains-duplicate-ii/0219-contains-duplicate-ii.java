class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length;i++){
            if( set.contains(nums[i])){
                return true;
            }

            else{
                   set.add(nums[i]);
            }
           
            // STEP 5: Agar window ka size k se bada ho gaya, 
           // toh sabse purana element remove karo

            if(set.size()>k){

                set.remove(nums[i-k]);

            }

        }
        // STEP 6: Koi valid duplicate nahi mila 
        return false;
        
    }
}