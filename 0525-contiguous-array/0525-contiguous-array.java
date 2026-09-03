class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap <>();
         int maxLen = 0;
         int sum = 0;
         map.put(0,-1);
         for(int r =0; r< nums.length; r++){
            if (nums[r] == 0) {
                  sum = sum - 1;
            } else {
                     sum = sum + 1;
            }
            if(map.containsKey(sum)){
                int prevIndex = map.get(sum);
                maxLen =Math.max(maxLen,r-prevIndex);

            }
            else{
                map.put(sum,r);
            }
         }
        return maxLen;
    }
}