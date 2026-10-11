class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        int left = 0;
        for(int right = 0 ; right<nums.length;right++){
    // STEP 4: Window ka size k se bada hone par 
    // leftmost element ko remove karo 

          if(right - left > k){
            set.remove(nums[left]);
            left++;
          }
         // check kro duplocate hai ya nhai
          if(set.contains(nums[right])){
            return true;
          }

          // STEP 6: Current element ko window mein add karo
           set.add(nums[right]);
        }

       
        // STEP 6: Koi valid duplicate nahi mila 
        return false;
        
    }
}