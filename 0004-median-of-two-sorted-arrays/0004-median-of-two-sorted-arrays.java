class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always perform binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        // Number of elements required on the left side
        int leftSize = (m + n + 1) / 2;

        while (low <= high) {

            // Partition of nums1
            int cut1 = (low + high) / 2;

            // Partition of nums2
            int cut2 = leftSize - cut1;

            int left1, right1, left2, right2;

            // Find left1
            if (cut1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[cut1 - 1];
            }

            // Find right1
            if (cut1 == m) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[cut1];
            }

            // Find left2
            if (cut2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[cut2 - 1];
            }

            // Find right2
            if (cut2 == n) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[cut2];
            }

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Total number of elements is odd
                if ((m + n) % 2 != 0) {
                    return Math.max(left1, left2);
                }

                // Total number of elements is even
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            // We have taken too many elements from nums1
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // We have taken too few elements from nums1
            else {
                low = cut1 + 1;
            }
        }

        return -1;
    }
}