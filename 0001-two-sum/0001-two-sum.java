class Solution {
    public int[] twoSum(int[] nums, int target) {
        

        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int currnum=nums[i];
            int require=target-currnum;
            if(map.containsKey(require)){

                return new int[]{map.get(require),i};
            }
            map.put(currnum,i);
        }
        return new int[]{};
        
    }
}