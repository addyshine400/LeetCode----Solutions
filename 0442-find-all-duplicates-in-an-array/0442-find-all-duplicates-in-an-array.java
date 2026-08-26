class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // HashSet<Integer> seen = new HashSet<>();
        // List<Integer> ans = new ArrayList<>();
        // for(int num :nums){
        //     if(!seen.add(num)){
        //         ans.add(num);
        //     }

        // }
        // return ans;

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;

            if(nums[index]<0){
                ans.add(index +1);
            }

            else{
                nums[index] = -nums[index];
            }
        }

        return ans;
        
        
    }
}