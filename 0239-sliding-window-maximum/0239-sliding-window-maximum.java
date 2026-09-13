class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices which are outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst(); // remove fisrt
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast(); // remove the last element
            }

            // Add current index
            dq.offerLast(i);   //add at last 

            // Window is complete
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()]; //  get macimum
            }
        }

        return ans;
    }
}