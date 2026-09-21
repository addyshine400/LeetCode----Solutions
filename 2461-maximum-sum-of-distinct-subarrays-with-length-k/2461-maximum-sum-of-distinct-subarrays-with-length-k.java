class Solution {
    public long maximumSubarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        long n = nums.length;
        long window=0;
        long max=0;

        for(int i=0; i<k; i++){
            window+=nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if(map.size()==k){
            max=Math.max(max,window); 
        }

        for(int i=k; i<n; i++){
            window+=nums[i]-nums[i-k];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            map.put(nums[i-k], map.get(nums[i-k]) - 1);

            if (map.get(nums[i-k]) == 0) {
                map.remove(nums[i-k]);
            }

            if (map.size() == k) {
                max = Math.max(max, window);
            }
        }
        return max;
    }
}